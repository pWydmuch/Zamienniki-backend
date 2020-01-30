package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import wydmuch.patryk.zamienniki.dto.KursDto;
import wydmuch.patryk.zamienniki.dto.KursMapper;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;
import wydmuch.patryk.zamienniki.entities.Przedmiot;
import wydmuch.patryk.zamienniki.entities.enums.*;
import wydmuch.patryk.zamienniki.repositories.KursRepository;
import wydmuch.patryk.zamienniki.services.KursService;
import wydmuch.patryk.zamienniki.services.PlanStudiowService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Klasa służąca do pozyskiwaniu danych na temat kursów
 * @author Patryk Wydmuch
 * @version 1.1.1
 */
@Service
public class KursServiceImpl  implements KursService {


    final
    KursRepository kursRepository;

    final
    PlanStudiowService planStudiowService;

    @Autowired
    public KursServiceImpl(PlanStudiowService planStudiowService, KursRepository kursRepository) {
        this.planStudiowService = planStudiowService;
        this.kursRepository = kursRepository;
    }


    /**Metoda wyszukjąca dane na temat pojedynczego kursu oraz przedmiotu i
     * planu do którego należy na podstawie jego numeru id
     * @param id Przyjmuje jako parametr id kursu którego chcemy pozyskać
     * @return Zwraca obiekt KursDto zawierający informacje na temat kursu,
     * jego przedmiotu i planu studiów, którego dotyczą
     */

    @Override
    public KursDto getKurs(Long id){
        return KursMapper.mapKursToKursDto(kursRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie znaleziono kursu o takim id")));
    }


    /**Metoda wyszukująca listę obiektów KursuDto na podstawie okreslonych kryteriów. Jeśli jakiś parametr
     * ma wartość null, oznacza to, że jest opcjonalny i nie będzie brany pod uwagę podczas wyszukiwania
     * @param trybStudiow Tryb studiów w ramach którego mają być prowadzone szukane kursy np "Stacjonarne"
     * @param stopienStudiow Stopień studiów w ramach którego mają być prowadzone szukane kursy np "Pierwszy"
     * @param formaZaliczenia Forma w jakiej uzyskuje się zaliczenie szukanych kursów "Zaliczenie"/"Egzamin"
     * @param wydzial Wydział na jakim mają odbywać się zajęcia szukanych kursów np "W8"
     * @param jezykStudiow Język w jakim mają odbywać się zajęcia szukanych kursów  "Polski"/"Angielski"
     * @param formyZajec Formy zajęć jakie mają mieć szukane kursy np "Projekt", wystarczy by kurs miał tylko jedną z nich
     * @param ects Minimalna liczba punktów ECTS jaką mają posiadać szukane kursy np 4
     * @param kierunek Kierunek studiów w ramach którego są umieszczone szukane kursy
     * @param cyklKsztalcenia Pierwszy rok akademicki od którego został ustalony plan studiów szukanych kursów np "2017/20018"
     * @return Lista obiektów KursDto zawierających dane na temat kursu,
     *      jego przedmiotu i planu studiów, którego dotyczą, które spełniają kryteria
     */

    @Override
    public List<KursDto> getKursySearch(String trybStudiow,
                                        String stopienStudiow,
                                        String  formaZaliczenia,
                                        String wydzial,
                                        String jezykStudiow,
                                        String[] formyZajec,
                                        Integer ects,
                                        String kierunek,
                                        String cyklKsztalcenia) {

        List<PlanStudiow> plany = planStudiowService.getPlany(trybStudiow,stopienStudiow,wydzial,jezykStudiow,kierunek,cyklKsztalcenia);

        List<Przedmiot> przedmioty = plany.stream()
                .map(PlanStudiow::getPrzedmioty)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<Kurs> kursy = przedmioty.stream()
                .map(p->filterKursy(p.getKursy(),formaZaliczenia,formyZajec,ects))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return kursy.stream()
                .map(KursMapper::mapKursToKursDto)
                .collect(Collectors.toList());
    }


    /**Metoda która filtruje kursy wg określonych wartości formy zaliczenia, form zajęć i punktów ects
     * Jeśli któraś z wartość ma wartość null nie będzie brana pod uwagę przy filtrowaniu
     * @param kursy Kursy które filtrujemy
     * @param formaZaliczenia Forma w jakiej uzyskuje się zaliczenie szukanych kursów "Zaliczenie"/"Egzamin"
     * @param formyZajec Formy zajęć jakie mają mieć szukane kursy np "Projekt"
     * @param ects Minimalna liczba punktów ECTS jaką mają posiadać szukane kursy np 4
     * @return Lista kursów mająca podaną formę zaliczenia, posiadających co najmniej jedną z podanych form zajęć i mających co najmniej tyle
     * ects ile podane w parametrze
     */
    public static List<Kurs> filterKursy(List<Kurs> kursy, String formaZaliczenia,
                           String[] formyZajec, Integer ects){

        if(ects != null) {
            kursy = KursServiceImpl.filterKursyMinimalEcts(kursy, ects);
        }
        if(formaZaliczenia != null){
            kursy = KursServiceImpl.filterKursyByFormaZaliczenia(kursy, FormaZaliczenia.valueOf(formaZaliczenia.toUpperCase()));
        }
        if(formyZajec != null && formyZajec.length>0) {
            List<FormaZajec> formyList = Arrays.stream(formyZajec)
                    .map(formString -> FormaZajec.valueOf(formString))
                    .collect(Collectors.toList());
                kursy = KursServiceImpl.filterKursyByFormyZajec(kursy,formyList);
        }
        return kursy;
    }

    /**Metoda która filtruje kursy wg określonych wartości punktów ects
     * @param kursy Kursy które filtrujemy
     * @param ects Minimalna liczba punktów ECTS jaką mają posiadać szukane kursy np 4
     * @return Lista kursów, które mają co najmniej tyle punktów ects ile podane w parametrze
     */
    public static List<Kurs> filterKursyMinimalEcts(List<Kurs> kursy, Integer ects){
        return kursy.
                stream().
                filter(k -> k.getECTS() >= ects)
                .collect(Collectors.toList());
    }

    /**Metoda która filtruje kursy wg określonych wartości formy zaliczenia
     * @param kursy Kursy które filtrujemy
     * @param formaZaliczenia Forma w jakiej uzyskuje się zaliczenie szukanych kursów "Zaliczenie"/"Egzamin"
     * @return Lista kursów mających formę zaliczenia podaną w parametrze
     */
    public static List<Kurs> filterKursyByFormaZaliczenia(List<Kurs> kursy, FormaZaliczenia formaZaliczenia){
        return kursy.
                stream()
                .filter(k-> k.getFormaZaliczenia() == formaZaliczenia)
                .collect(Collectors.toList());
    }

    /**Metoda która filtruje kursy wg określonych wartości form zajeć
     * @param kursy Kursy które filtrujemy
     * @param formyZajec Formy zajęć jakie mają mieć szukane kursy np "Projekt"
     * @return Lista kursów mających co najmniej jedną z form zajęć podaną w parametrze
      */
    public static List<Kurs> filterKursyByFormyZajec(List<Kurs> kursy, List<FormaZajec> formyZajec){
        return kursy.
                stream()
                .filter(k -> KursServiceImpl.checkIfKursContainsFormaZajec(k,formyZajec))
                .collect(Collectors.toList());
    }

    /**Metoda sprawdzająca czy dany kurs zawiera chociaż jedną z podanych form zajęc
     * @param kurs Kurs, którego formy zajęc ustalamym
     * @param formy Lista form zajęć, które sprawdzamy
     * @return Wartość logiczna mówiąća o tym czy kurs zawiara jakąkolwiek z podanych form zajęć
     */
    public static boolean checkIfKursContainsFormaZajec(Kurs kurs, List<FormaZajec> formy){
        List<FormaZajec> kursFormy = kurs.getFormaZajec();
        boolean result = false;
        loop:
        for(FormaZajec formaKurs: kursFormy){
            for(FormaZajec formaUser: formy){
                if(formaKurs.equals(formaUser)){
                    result = true;
                    break loop;
                }
            }
        }
        return result;
    }
}
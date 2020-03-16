package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.dto.PlanInfoDto;
import wydmuch.patryk.zamienniki.dto.PlanInfoMapper;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;
import wydmuch.patryk.zamienniki.entities.enums.JezykStudiow;
import wydmuch.patryk.zamienniki.entities.enums.StopienStudiow;
import wydmuch.patryk.zamienniki.entities.enums.TrybStudiow;
import wydmuch.patryk.zamienniki.entities.enums.Wydzial;
import wydmuch.patryk.zamienniki.repositories.PlanStudiowRepository;
import wydmuch.patryk.zamienniki.services.PlanStudiowService;

import java.util.List;

/**
 * Klasa służąca do pozyskiwaniu informacji na temat planów studiów
 * @author Patryk Wydmuch
 * @version 1.1.1
 */

@Service
public class PlanStudiowServiceImpl implements PlanStudiowService {

    final
    PlanStudiowRepository planStudiowRepository;

    @Autowired
    public PlanStudiowServiceImpl(PlanStudiowRepository planStudiowRepository) {
        this.planStudiowRepository = planStudiowRepository;
    }

    /**Metoda wyszukująca listę planów studiów na podstawie okreslonych kryteriów. Jeśli jakiś parametr
     * ma wartość null, oznacza to, że jest opcjonalny i nie będzie brany pod uwagę podczas wyszukiwania
     * @param trybStudiow Tryb studiów w ramach którego mają być prowadzone szukane kursy np "Stacjonarne"
     * @param stopienStudiow Stopień studiów w ramach którego mają być prowadzone szukane kursy np "Pierwszy"
     * @param wydzial Wydział na jakim mają odbywać się zajęcia szukanych kursów np "W8"
     * @param jezykStudiow Język w jakim mają odbywać się zajęcia szukanych kursów  "Polski"/"Angielski"
     * @param kierunek Kierunek studiów w ramach którego są umieszczone szukane kursy
     * @param cyklKsztalcenia Pierwszy rok akademicki od którego został ustalony plan studiów szukanych kursów np "2017/20018"
     * @return Lista Planów studiów zawierająca dane, które spełniają kryteria
     */
    @Override
    public List<PlanStudiow> getPlany(String trybStudiow,
                                       String stopienStudiow,
                                       String wydzial,
                                       String jezykStudiow,
                                       String kierunek,
                                       String cyklKsztalcenia){

        PlanStudiow planStudiow = new PlanStudiow();
        List<PlanStudiow> plany = null;
        if(trybStudiow != null) planStudiow.setTrybStudiow(TrybStudiow.valueOf(trybStudiow.toUpperCase()));
        if(stopienStudiow != null) planStudiow.setStopienStudiow(StopienStudiow.valueOf(stopienStudiow.toUpperCase()));
        if(wydzial != null) planStudiow.setWydzial(Wydzial.valueOf(wydzial.toUpperCase()));
        if(jezykStudiow != null) planStudiow.setJezykStudiow(JezykStudiow.valueOf(jezykStudiow.toUpperCase()));
        if(kierunek!= null) planStudiow.setKierunek(kierunek);
        if(cyklKsztalcenia != null)  planStudiow.setCyklKsztalcenia(cyklKsztalcenia);
        plany =  planStudiowRepository.findAll(Example.of(planStudiow));
        return plany;
    }

    /** Metoda wyszukuje wszystkie cykle kształcenia, które nie zostały jeszcze ukończone oraz wszystkie obecnie prowadzone kierunki studiów
     * @return Obiekt PlanInfo zawierający cykle kształcenia i kierunki studiów, o ktorych mowa w opisie metody
     */
    @Override
    public PlanInfoDto getPlanInfo() {
        List<String> listaKierunkow = planStudiowRepository.findKierunki();
        List<String> listaCykli = planStudiowRepository.findCykle();
        PlanInfoDto planInfoDto = PlanInfoMapper.mapToPlanInfo(listaKierunkow,listaCykli);
        return planInfoDto;
    }
}

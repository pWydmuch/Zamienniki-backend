package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.dto.KursDto;
import wydmuch.patryk.zamienniki.dto.KursMapper;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;
import wydmuch.patryk.zamienniki.entities.Przedmiot;
import wydmuch.patryk.zamienniki.entities.kursEnums.*;
import wydmuch.patryk.zamienniki.repositories.KursRepository;
import wydmuch.patryk.zamienniki.services.KursService;
import wydmuch.patryk.zamienniki.services.PlanStudiowService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public List<Kurs> getKursy() {
        return kursRepository.findAll();
    }

    @Override
    public KursDto getKurs(Long id){
        return KursMapper.mapKursToKursDto(kursRepository.findById(id).get());
    }

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

        List<KursDto> kursDtos = kursy.stream()
                .map(KursMapper::mapKursToKursDto)
                .collect(Collectors.toList());

        return kursDtos;
    }


    List<Kurs> filterKursy(List<Kurs> kursy, String formaZaliczenia,
                           String[] formyZajec, Integer ects){

        if(ects != null) {
            kursy = KursServiceImpl.filterKursyMinimalEcts(kursy, ects);
        }
        if(formaZaliczenia != null){
            kursy = KursServiceImpl.filterKursyByFormaZaliczenia(kursy, FormaZaliczenia.valueOf(formaZaliczenia.toUpperCase()));
        }
        if(formyZajec != null && formyZajec.length>0) {
            List<FormaZajec> formyList = Arrays.asList(formyZajec)
                    .stream()
                    .map(formString -> FormaZajec.valueOf(formString))
                    .collect(Collectors.toList());
            kursy = KursServiceImpl.filterKursyByFormyZajec(kursy,formyList);
        }
        return kursy;
    }

    public static List<Kurs> filterKursyMinimalEcts(List<Kurs> kursy, Integer ects){
        return kursy.
                stream().
                filter(k -> k.getECTS() >= ects)
                .collect(Collectors.toList());
    }

    public static List<Kurs> filterKursyByFormaZaliczenia(List<Kurs> kursy, FormaZaliczenia formaZaliczenia){
        return kursy.
                stream()
                .filter(k-> k.getFormaZaliczenia() == formaZaliczenia)
                .collect(Collectors.toList());
    }

    public static List<Kurs> filterKursyByFormyZajec(List<Kurs> kursy, List<FormaZajec> formyZajec){
        return kursy.
                stream()
                .filter(k -> KursServiceImpl.checkIfKursContainsFormaZajec(k,formyZajec))
                .collect(Collectors.toList());
    }

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
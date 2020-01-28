package wydmuch.patryk.zamienniki.services.impl;

import jnr.ffi.Struct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;
import wydmuch.patryk.zamienniki.entities.Przedmiot;
import wydmuch.patryk.zamienniki.entities.kursEnums.*;
import wydmuch.patryk.zamienniki.repositories.KursRepository;
import wydmuch.patryk.zamienniki.repositories.PlanStudiowRepository;
import wydmuch.patryk.zamienniki.repositories.PrzedmiotRepository;
import wydmuch.patryk.zamienniki.services.KursService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KursServiceImpl  implements KursService {

    final
    KursRepository kursRepository;
    final
    PlanStudiowRepository planStudiowRepository;
    final
    PrzedmiotRepository przedmiotRepository;

    @Autowired
    public KursServiceImpl(KursRepository kursRepository, PlanStudiowRepository planStudiowRepository, PrzedmiotRepository przedmiotRepository) {
        this.kursRepository = kursRepository;
        this.planStudiowRepository = planStudiowRepository;
        this.przedmiotRepository = przedmiotRepository;
    }

    @Override
    public List<Kurs> getKursy() {
        return kursRepository.findAll();
    }

    @Override
    public Kurs getKurs(Long id){
        return kursRepository.findById(id).get();
    }

    @Override
    public List<Kurs> getKursySearch(String trybStudiow,
                                     String stopienStudiow,
                                     String  formaZaliczenia,
                                     String wydzial,
                                     String jezykStudiow,
                                     String[] formyZajec,
                                     Integer ects,
                                     String kierunek,
                                     String cyklKsztalcenia) {

        Kurs kurs = new Kurs();
        List<Kurs> kursy = null;
        if(formaZaliczenia != null) kurs.setFormaZaliczenia(FormaZaliczenia.valueOf(formaZaliczenia.toUpperCase()));


        PlanStudiow planStudiow = new PlanStudiow();
        List<PlanStudiow> plany = null;
        if(trybStudiow != null) planStudiow.setTrybStudiow(TrybStudiow.valueOf(trybStudiow.toUpperCase()));
        if(stopienStudiow != null) planStudiow.setStopienStudiow(StopienStudiow.valueOf(stopienStudiow.toUpperCase()));
        if(wydzial != null) planStudiow.setWydzial(Wydzial.valueOf(wydzial.toUpperCase()));
        if(jezykStudiow != null) planStudiow.setJezykStudiow(JezykStudiow.valueOf(jezykStudiow.toUpperCase()));
        if(kierunek!= null) planStudiow.setKierunek(kierunek);
        if(cyklKsztalcenia != null)  planStudiow.setCyklKsztalcenia(cyklKsztalcenia);
        plany =  planStudiowRepository.findAll(Example.of(planStudiow));

        List<List<Przedmiot>> przedmiotyListList = plany.stream().map(plan->plan.getPrzedmioty()).collect(Collectors.toList());



//        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("formaZajec").withIgnoreNullValues();
//        kursy =  kursRepository.findAll(Example.of(planStudiow,matcher));
//        if(ects != null) {
//            kursy = kursy.stream().filter(k -> k.getECTS() >= ects).collect(Collectors.toList());
//        }

        if(formyZajec != null && formyZajec.length>0) {
            List<String> formyList = Arrays.asList(formyZajec);
            kursy = kursy.
                    stream()
                    .filter(k -> KursServiceImpl.checkIfKursContainsFormaZajec(k,formyList))
                    .collect(Collectors.toList());
        }

        return null;
    }

    public List<List<Kurs>> doSth(List<Przedmiot> przedmioty, String  formaZaliczenia,
                      String[] formyZajec, Integer ects){

        List<List<Kurs>> kursListList = przedmioty.stream()
                .map(przedmiot -> doSth2(przedmiot,formaZaliczenia,formyZajec,ects))
                .collect(Collectors.toList());

        List<Kurs> kursy = null;
        Kurs kurs = null;
        if(formaZaliczenia != null) kurs.setFormaZaliczenia(FormaZaliczenia.valueOf(formaZaliczenia.toUpperCase()));
        return kursListList;
    }

    public List<Kurs> doSth2(Przedmiot przedmiot, String formaZaliczenia,
                       String[] formyZajec, Integer ects){

        List<Kurs> kursy = przedmiot.getKursy();
        if(ects != null) {
            kursy = kursy.stream().filter(k -> k.getECTS() >= ects).collect(Collectors.toList());
        }
        if(formyZajec != null && formyZajec.length>0) {
            List<String> formyList = Arrays.asList(formyZajec);
            kursy = kursy.
                    stream()
                    .filter(k -> KursServiceImpl.checkIfKursContainsFormaZajec(k,formyList))
                    .collect(Collectors.toList());
        }
        return kursy;
    }

    public static boolean checkIfKursContainsFormaZajec(Kurs kurs, List<String> formy){
        List<FormaZajec> kursFormy = kurs.getFormaZajec();
        boolean result = false;
        loop:
        for(FormaZajec formaKurs: kursFormy){
            for(String formaUser: formy){
                if(formaKurs.equals(FormaZajec.valueOf(formaUser))){
                    result = true;
                    break loop;
                }
            }
        }
        return result;
    }

    @Override
    public List<String> getKierunki() {
        return null;
//                kursRepository.findKierunki();
    }

    @Override
    public List<String> getCykle() {
        return  null;

//                kursRepository.findCykle();
    }
}
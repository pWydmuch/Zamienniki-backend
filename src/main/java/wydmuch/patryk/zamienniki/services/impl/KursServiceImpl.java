package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.kursEnums.*;
import wydmuch.patryk.zamienniki.repositories.KursRepository;
import wydmuch.patryk.zamienniki.services.KursService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KursServiceImpl  implements KursService {

    final
    KursRepository kursRepository;

    @Autowired
    public KursServiceImpl(KursRepository kursRepository) {
        this.kursRepository = kursRepository;
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
                                     String formaZaliczenia,
                                     String wydzial,
                                     String jezykStudiow,
                                     String formyZajec,
                                     Integer ects,
                                     String kierunek,
                                     String cyklKsztalcenia) {

        Kurs kurs = new Kurs();
        List<Kurs> kursy = null;
        if(trybStudiow != null) kurs.setTrybStudiow(TrybStudiow.valueOf(trybStudiow.toUpperCase()));
        if(stopienStudiow != null) kurs.setStopienStudiow(StopienStudiow.valueOf(stopienStudiow.toUpperCase()));
        if(wydzial != null) kurs.setWydzial(Wydzial.valueOf(wydzial.toUpperCase()));
        if(jezykStudiow != null) kurs.setJezykStudiow(JezykStudiow.valueOf(jezykStudiow.toUpperCase()));
        if(formaZaliczenia != null) kurs.setFormaZaliczenia(FormaZaliczenia.valueOf(formaZaliczenia.toUpperCase()));
        if(kierunek!= null) kurs.setKierunek(kierunek);
        if(cyklKsztalcenia != null)  kurs.setCyklKsztalcenia(cyklKsztalcenia);
        kursy =  kursRepository.findAll(Example.of(kurs));

        if(ects != null) {
            kursy = kursy.stream().filter(k -> k.getECTS() >= ects).collect(Collectors.toList());
        }

        return kursy;
    }


    @Override
    public List<String> getKierunki() {
        return kursRepository.findKierunki();
    }

    @Override
    public List<String> getCykle() {
        return kursRepository.findCykle();
    }
}
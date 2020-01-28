package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;
import wydmuch.patryk.zamienniki.entities.kursEnums.JezykStudiow;
import wydmuch.patryk.zamienniki.entities.kursEnums.StopienStudiow;
import wydmuch.patryk.zamienniki.entities.kursEnums.TrybStudiow;
import wydmuch.patryk.zamienniki.entities.kursEnums.Wydzial;
import wydmuch.patryk.zamienniki.repositories.PlanStudiowRepository;
import wydmuch.patryk.zamienniki.services.PlanStudiowService;

import java.util.List;

@Service
public class PlanStudiowServiceImpl implements PlanStudiowService {

    final
    PlanStudiowRepository planStudiowRepository;

    @Autowired
    public PlanStudiowServiceImpl(PlanStudiowRepository planStudiowRepository) {
        this.planStudiowRepository = planStudiowRepository;
    }

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

    @Override
    public List<String> getKierunki() {
        return planStudiowRepository.findKierunki();
    }

    @Override
    public List<String> getCykle() {
        return planStudiowRepository.findCykle();
    }
}

package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.entities.Podanie;
import wydmuch.patryk.zamienniki.entities.kursEnums.StatusOpinii;
import wydmuch.patryk.zamienniki.repositories.PodanieRepository;
import wydmuch.patryk.zamienniki.services.PodanieService;

import java.util.List;

@Service
public class PodanieServiceImpl implements PodanieService {

    final
    PodanieRepository podanieRepository;

    @Autowired
    public PodanieServiceImpl(PodanieRepository podanieRepository) {
        this.podanieRepository = podanieRepository;
    }


    @Override
    public List<Podanie> getPodania(){
        return podanieRepository.findByStatus(StatusOpinii.NIEROZPATRZONE);
    }

    @Override
    public Podanie getPodanie(Long id){
        return podanieRepository.findById(id).get();
    }

    @Override
    public Podanie getPodanieNie(Long id){
        return podanieRepository.findById(id).get();
    }

    @Override
    public Podanie updatePodanie(Long id, Podanie podanieDetails){
        Podanie oldPodanie = podanieRepository.findById(id).get();
        oldPodanie.setStatus(podanieDetails.getStatus());
        oldPodanie.setUzasadnienieOpinii(podanieDetails.getUzasadnienieOpinii());
        return podanieRepository.save(oldPodanie);
    }
}

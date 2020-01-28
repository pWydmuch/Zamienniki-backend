package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.dto.PodanieDto;
import wydmuch.patryk.zamienniki.dto.PodanieMapper;
import wydmuch.patryk.zamienniki.entities.Podanie;
import wydmuch.patryk.zamienniki.entities.kursEnums.StatusOpinii;
import wydmuch.patryk.zamienniki.repositories.PodanieRepository;
import wydmuch.patryk.zamienniki.services.PodanieService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PodanieServiceImpl implements PodanieService {

    final
    PodanieRepository podanieRepository;

    @Autowired
    public PodanieServiceImpl(PodanieRepository podanieRepository) {
        this.podanieRepository = podanieRepository;
    }


    @Override
    public List<PodanieDto> getPodania(){
        return podanieRepository.findByStatus(StatusOpinii.NIEROZPATRZONE)
                .stream()
                .map(PodanieMapper::mapPodanieToPodanieDto)
                .collect(Collectors.toList());
    }

    @Override
    public PodanieDto getPodanie(Long id){

        return PodanieMapper.mapPodanieToPodanieDto(podanieRepository.findById(id).get());
    }

    @Override
    public PodanieDto updatePodanie(Long id, PodanieDto podanieDetailsDto){
        Podanie podanieDetails = PodanieMapper.mapPodanieDtoToPodanie(podanieDetailsDto);
        Podanie oldPodanie = podanieRepository.findById(id).get();
        oldPodanie.setStatus(podanieDetails.getStatus());
        oldPodanie.setOpiniujacy(podanieDetails.getOpiniujacy());
        oldPodanie.setUzasadnienieOpinii(podanieDetails.getUzasadnienieOpinii());
        Podanie zapisanePodanie = podanieRepository.save(oldPodanie);
        return PodanieMapper.mapPodanieToPodanieDto(zapisanePodanie);
    }
}

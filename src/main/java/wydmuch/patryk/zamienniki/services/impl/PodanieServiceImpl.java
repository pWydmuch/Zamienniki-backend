package wydmuch.patryk.zamienniki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.dto.PodanieDto;
import wydmuch.patryk.zamienniki.dto.PodanieMapper;
import wydmuch.patryk.zamienniki.entities.Podanie;
import wydmuch.patryk.zamienniki.entities.enums.StatusOpinii;
import wydmuch.patryk.zamienniki.repositories.PodanieRepository;
import wydmuch.patryk.zamienniki.services.PodanieService;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa służąca do pozyskiwaniu informacji na temat podań
 * @author Patryk Wydmuch
 * @version 1.1.1
 */
@Service
public class PodanieServiceImpl implements PodanieService {

    final
    PodanieRepository podanieRepository;

    @Autowired
    public PodanieServiceImpl(PodanieRepository podanieRepository) {
        this.podanieRepository = podanieRepository;
    }


    /**Metoda wyszukująca wszystkie podania, które nie zostały jeszcze rozpaczone
     * @return Wszystkie podania, które nie zostały jeszcze rozpaczone
     */
    @Override
    public List<PodanieDto> getPodania(){
        return podanieRepository.findByStatus(StatusOpinii.NIEROZPATRZONE)
                .stream()
                .map(PodanieMapper::mapPodanieToPodanieDto)
                .collect(Collectors.toList());
    }

    /**Metoda wyszukująca dane na temat pojedynczego podania, na podstawie jego numeru id
     * @param id Numer id podania
     * @return Obiekt PodanieDto stworzony na podstawie danego id
     */
    @Override
    public PodanieDto getPodanie(Long id){

        return PodanieMapper.mapPodanieToPodanieDto(podanieRepository.findById(id).get());
    }

    /**Metoda aktualizujaca podanie o danym numerze id
     * @param id Numer id podania
     * @param podanieDetailsDto Obiekt PodanieDto posiadający dane na podstawie, których aktualizujemy
     *                     podanie
     * @return Obiekt PodanieDto stworzony na uaktualnionego podania o zadanym id
     */
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

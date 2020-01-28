package wydmuch.patryk.zamienniki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.dto.PodanieDto;
import wydmuch.patryk.zamienniki.entities.Podanie;
import wydmuch.patryk.zamienniki.entities.kursEnums.StatusOpinii;
import wydmuch.patryk.zamienniki.repositories.PodanieRepository;
import java.util.List;


public interface PodanieService {

   List<PodanieDto> getPodania();

   PodanieDto getPodanie(Long id);

   PodanieDto updatePodanie(Long id, PodanieDto podanieDetails);

}

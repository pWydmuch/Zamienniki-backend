package wydmuch.patryk.zamienniki.services;
import wydmuch.patryk.zamienniki.dto.PodanieDto;
import java.util.List;


public interface PodanieService {

   List<PodanieDto> getPodania();

   PodanieDto getPodanie(Long id);

   PodanieDto updatePodanie(Long id, PodanieDto podanieDetails);

}

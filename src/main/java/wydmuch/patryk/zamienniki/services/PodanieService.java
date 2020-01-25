package wydmuch.patryk.zamienniki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wydmuch.patryk.zamienniki.entities.Podanie;
import wydmuch.patryk.zamienniki.entities.kursEnums.StatusOpinii;
import wydmuch.patryk.zamienniki.repositories.PodanieRepository;
import java.util.List;


public interface PodanieService {

   List<Podanie> getPodania();

   Podanie getPodanie(Long id);

   Podanie getPodanieNie(Long id);

   Podanie updatePodanie(Long id, Podanie podanieDetails);

}

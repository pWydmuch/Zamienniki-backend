package wydmuch.patryk.zamienniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wydmuch.patryk.zamienniki.entities.Podanie;
import wydmuch.patryk.zamienniki.entities.kursEnums.StatusOpinii;

import java.util.List;


@Repository
public interface PodanieRepository extends JpaRepository<Podanie,Long> {

     List<Podanie> findByStatus(StatusOpinii status);
}

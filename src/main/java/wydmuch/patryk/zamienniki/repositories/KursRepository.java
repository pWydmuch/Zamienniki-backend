package wydmuch.patryk.zamienniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wydmuch.patryk.zamienniki.entities.Kurs;


@Repository
public interface KursRepository extends JpaRepository<Kurs,Long>{

}

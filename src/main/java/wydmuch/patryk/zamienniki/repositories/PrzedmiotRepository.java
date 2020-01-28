package wydmuch.patryk.zamienniki.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import wydmuch.patryk.zamienniki.entities.Przedmiot;

@Repository
public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Long>, QueryByExampleExecutor<Przedmiot>{
}

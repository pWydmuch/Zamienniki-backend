package wydmuch.patryk.zamienniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;

import java.util.List;

@Repository
public interface PlanStudiowRepository extends  JpaRepository <PlanStudiow, Long>, QueryByExampleExecutor<PlanStudiow> {

    @Query("SELECT DISTINCT p.kierunek FROM PlanStudiow p")
    List<String> findKierunki();

    @Query("SELECT DISTINCT p.cyklKsztalcenia FROM PlanStudiow p")
    List<String> findCykle();

}

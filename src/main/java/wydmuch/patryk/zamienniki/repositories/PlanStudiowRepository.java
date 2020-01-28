package wydmuch.patryk.zamienniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;

@Repository
public interface PlanStudiowRepository extends  JpaRepository <PlanStudiow, Long>, QueryByExampleExecutor<PlanStudiow> {
}

package wydmuch.patryk.zamienniki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.kursEnums.*;

import java.util.List;

@Repository
public interface KursRepository extends JpaRepository<Kurs,Long>, QueryByExampleExecutor<Kurs> {

//    @Query("SELECT  DISTINCT k.kierunek FROM Kurs k")
//     List<String> findKierunki();
//
//    @Query("SELECT DISTINCT k.cyklKsztalcenia FROM Kurs k")
//    List<String> findCykle();

//    @Query(value = "SELECT k FROM kursy k  k.trybStudiow = :tryb" +
//            " and k.stopienStudiow = :stopien " +
//            " and k.formaZaliczenia = :zalicz " +
//            " and  (:wydzial is null or k.wydzial = :wydzial)" +
//            " and  (:jezyk is null or k.jezykStudiow = :jezyk)" +
//            " and  (:ects is null or k.ECTS >= :ects)" +
//            " and  (:kierunek is null or k.kierunek = :kierunek)" +
//            " and  (:cykl is null or k.cyklKsztalcenia = :cykl) " +
//            " and  k.for  "
//    )
//    List<Kurs> findSearch(@Param("tryb") TrybStudiow trybStudiow,
//                          @Param("stopien") StopienStudiow stopienStudiow,
//                          @Param("zalicz")FormaZaliczenia formaZaliczenia,
//                          @Param("wydzial") Wydzial wydzial,
//                          @Param("jezyk")JezykStudiow jezykStudiow,
//                          @Param("zajecia")FormaZajec formaZajec,
//                          @Param("ects")Integer ects,
//                          @Param("kierunek")String kierunek,
//                          @Param("cykl")String cykl
//                          );

}

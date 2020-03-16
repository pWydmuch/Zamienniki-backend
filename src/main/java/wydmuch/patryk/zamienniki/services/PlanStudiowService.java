package wydmuch.patryk.zamienniki.services;

import wydmuch.patryk.zamienniki.dto.PlanInfoDto;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;

import java.util.List;

public interface PlanStudiowService {

    PlanInfoDto getPlanInfo();
    List<PlanStudiow> getPlany(String trybStudiow,
                               String stopienStudiow,
                               String wydzial,
                               String jezykStudiow,
                               String kierunek,
                               String cyklKsztalcenia);
}

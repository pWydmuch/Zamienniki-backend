package wydmuch.patryk.zamienniki.services;

import wydmuch.patryk.zamienniki.entities.PlanStudiow;

import java.util.List;

public interface PlanStudiowService {

    List<String> getKierunki();
    List<String> getCykle();
    public List<PlanStudiow> getPlany(String trybStudiow,
                                      String stopienStudiow,
                                      String wydzial,
                                      String jezykStudiow,
                                      String kierunek,
                                      String cyklKsztalcenia);
}

package wydmuch.patryk.zamienniki.dto;

import java.util.List;

public class PlanInfoDto {
    List<String> kierunki;
    List<String> cykle;

    public List<String> getKierunki() {
        return kierunki;
    }

    public void setKierunki(List<String> kierunki) {
        this.kierunki = kierunki;
    }

    public List<String> getCykle() {
        return cykle;
    }

    public void setCykle(List<String> cykle) {
        this.cykle = cykle;
    }
}

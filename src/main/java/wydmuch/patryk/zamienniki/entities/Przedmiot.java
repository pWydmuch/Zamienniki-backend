package wydmuch.patryk.zamienniki.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "przedmioty")
public class Przedmiot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nazwa;

    String linkKarty;

    @OneToMany(mappedBy = "przedmiot", cascade = CascadeType.REMOVE)
    List<Kurs> kursy;

    @ManyToOne
    PlanStudiow planStudiow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLinkKarty() {
        return linkKarty;
    }

    public void setLinkKarty(String linkKarty) {
        this.linkKarty = linkKarty;
    }

    public List<Kurs> getKursy() {
        return kursy;
    }

    public void setKursy(List<Kurs> kursy) {
        this.kursy = kursy;
    }

    public PlanStudiow getPlanStudiow() {
        return planStudiow;
    }

    public void setPlanStudiow(PlanStudiow planStudiow) {
        this.planStudiow = planStudiow;
    }
}

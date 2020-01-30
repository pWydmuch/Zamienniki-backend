package wydmuch.patryk.zamienniki.entities;

import wydmuch.patryk.zamienniki.entities.enums.JezykStudiow;
import wydmuch.patryk.zamienniki.entities.enums.StopienStudiow;
import wydmuch.patryk.zamienniki.entities.enums.TrybStudiow;
import wydmuch.patryk.zamienniki.entities.enums.Wydzial;

import javax.persistence.*;
import java.util.List;

@Table(name = "plany_studiow" )
@Entity
public class PlanStudiow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    TrybStudiow trybStudiow;

    @Enumerated(EnumType.STRING)
    StopienStudiow stopienStudiow;

    @Enumerated(EnumType.STRING)
    Wydzial wydzial;

    String kierunek;



    @Enumerated(EnumType.STRING)
    JezykStudiow jezykStudiow;

    String cyklKsztalcenia;

    @OneToMany(mappedBy = "planStudiow", cascade = CascadeType.REMOVE)
    List<Przedmiot> przedmioty;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCyklKsztalcenia() {
        return cyklKsztalcenia;
    }

    public void setCyklKsztalcenia(String cyklKsztalcenia) {
        this.cyklKsztalcenia = cyklKsztalcenia;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public TrybStudiow getTrybStudiow() {
        return trybStudiow;
    }

    public void setTrybStudiow(TrybStudiow trybStudiow) {
        this.trybStudiow = trybStudiow;
    }

    public StopienStudiow getStopienStudiow() {
        return stopienStudiow;
    }

    public void setStopienStudiow(StopienStudiow stopienStudiow) {
        this.stopienStudiow = stopienStudiow;
    }

    public Wydzial getWydzial() {
        return wydzial;
    }

    public void setWydzial(Wydzial wydzial) {
        this.wydzial = wydzial;
    }

    public JezykStudiow getJezykStudiow() {
        return jezykStudiow;
    }

    public void setJezykStudiow(JezykStudiow jezykStudiow) {
        this.jezykStudiow = jezykStudiow;
    }

    public List<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(List<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }


}

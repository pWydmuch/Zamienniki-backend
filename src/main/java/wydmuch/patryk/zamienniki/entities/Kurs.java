package wydmuch.patryk.zamienniki.entities;

import wydmuch.patryk.zamienniki.entities.kursEnums.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="kursy")
public class Kurs { //Moze lepiej nazwac to kurs

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true) // czy kod jest naprawde unikalny
    String kod;

    String nazwa;

    String linkKarty;

    Integer ECTS;

    String cyklKsztalcenia; // jako string? moze jako data, albo zrobic jakis regexp yyyy/yyyy

    String kierunek;

    Boolean czyWGrupie;

    @Enumerated(EnumType.STRING)
    TrybStudiow trybStudiow;

    @Enumerated(EnumType.STRING)
    StopienStudiow stopienStudiow;

    @Enumerated(EnumType.STRING)
    Wydzial wydzial;

    @Enumerated(EnumType.STRING)
    JezykStudiow jezykStudiow;


    @Enumerated(EnumType.STRING)
    FormaZajec formaZajec;

    @Enumerated(EnumType.STRING)
    FormaZaliczenia formaZaliczenia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
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

    public Integer getECTS() {
        return ECTS;
    }

    public void setECTS(Integer ECTS) {
        this.ECTS = ECTS;
    }

    public String getCyklKsztalcenia() {
        return cyklKsztalcenia;
    }

    public void setCyklKsztalcenia(String cyklKsztalcenia) {
        this.cyklKsztalcenia = cyklKsztalcenia;
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


    public FormaZaliczenia getFormaZaliczenia() {
        return formaZaliczenia;
    }

    public void setFormaZaliczenia(FormaZaliczenia formaZaliczenia) {
        this.formaZaliczenia = formaZaliczenia;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public Boolean getCzyWGrupie() {
        return czyWGrupie;
    }

    public void setCzyWGrupie(Boolean czyWGrupie) {
        this.czyWGrupie = czyWGrupie;
    }

    public FormaZajec getFormaZajec() {
        return formaZajec;
    }

    public void setFormaZajec(FormaZajec formaZajec) {
        this.formaZajec = formaZajec;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "id=" + id +
                ", kod='" + kod + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", linkKarty='" + linkKarty + '\'' +
                ", ECTS=" + ECTS +
                ", cyklKsztalcenia='" + cyklKsztalcenia + '\'' +
                ", kierunek='" + kierunek + '\'' +
                ", czyWGrupie=" + czyWGrupie +
                ", trybStudiow=" + trybStudiow +
                ", stopienStudiow=" + stopienStudiow +
                ", wydzial=" + wydzial +
                ", jezykStudiow=" + jezykStudiow +
                ", formaZajec=" + formaZajec +
                ", formaZaliczenia=" + formaZaliczenia +
                '}';
    }
}

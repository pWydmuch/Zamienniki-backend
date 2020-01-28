package wydmuch.patryk.zamienniki.dto;

import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;
import wydmuch.patryk.zamienniki.entities.Przedmiot;
import wydmuch.patryk.zamienniki.entities.kursEnums.*;

import java.util.Arrays;
import java.util.List;

public class KursDto {

    Long id;

    String kod;

    String nazwa;

    String linkKarty;

    String cyklKsztalcenia;

    String kierunek;

    TrybStudiow trybStudiow;

    StopienStudiow stopienStudiow;

    Wydzial wydzial;

    JezykStudiow jezykStudiow;

    Boolean czyGrupa;

    List<FormaZajec> formaZajec;

    FormaZaliczenia formaZaliczenia;

    Integer ects;


//    public KursDto(){};
//
//    public KursDto(Kurs kurs){
//        Przedmiot przedmiot = kurs.getPrzedmiot();
//        PlanStudiow planStudiow = przedmiot.getPlanStudiow();
//        id=kurs.getId();
//        kod=kurs.getKod();
//        nazwa= przedmiot.getNazwa();
//        linkKarty = przedmiot.getLinkKarty();
//        cyklKsztalcenia=planStudiow.getCyklKsztalcenia();
//        kierunek=planStudiow.getKierunek();
//        trybStudiow=planStudiow.getTrybStudiow();
//        stopienStudiow=planStudiow.getStopienStudiow();
//        wydzial=planStudiow.getWydzial();
//        jezykStudiow=planStudiow.getJezykStudiow();
//        czyGrupa=kurs.getCzyGrupa();
//        formaZajec=kurs.getFormaZajec();
//        formaZaliczenia=kurs.getFormaZaliczenia();
//        ects=kurs.getECTS();
//    }


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

    public Boolean getCzyGrupa() {
        return czyGrupa;
    }

    public void setCzyGrupa(Boolean czyGrupa) {
        this.czyGrupa = czyGrupa;
    }

    public FormaZaliczenia getFormaZaliczenia() {
        return formaZaliczenia;
    }

    public void setFormaZaliczenia(FormaZaliczenia formaZaliczenia) {
        this.formaZaliczenia = formaZaliczenia;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public List<FormaZajec> getFormaZajec() {
        return formaZajec;
    }

    public void setFormaZajec(List<FormaZajec> formaZajec) {
        this.formaZajec = formaZajec;
    }

    @Override
    public String toString() {
        return "KursDto{" +
                "id=" + id +
                ", kod='" + kod + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", linkKarty='" + linkKarty + '\'' +
                ", cyklKsztalcenia='" + cyklKsztalcenia + '\'' +
                ", kierunek='" + kierunek + '\'' +
                ", trybStudiow=" + trybStudiow +
                ", stopienStudiow=" + stopienStudiow +
                ", wydzial=" + wydzial +
                ", jezykStudiow=" + jezykStudiow +
                ", czyGrupa=" + czyGrupa +
                ", formaZajec=" + formaZajec +
                ", formaZaliczenia=" + formaZaliczenia +
                ", ects=" + ects +
                '}';
    }
}

package wydmuch.patryk.zamienniki.dto;

import wydmuch.patryk.zamienniki.entities.Opiniujacy;
import wydmuch.patryk.zamienniki.entities.Student;
import wydmuch.patryk.zamienniki.entities.enums.StatusOpinii;
import java.util.List;

public class PodanieDto {

    private Long id;

    private KursDto zamieniany;

    private List<KursDto> zamienniki;

    Opiniujacy opiniujacy;

    private StatusOpinii status;

    private String uzasadnieniePodania;

    private String uzasadnienieOpinii;

    private Student student;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KursDto getZamieniany() {
        return zamieniany;
    }

    public void setZamieniany(KursDto zamieniany) {
        this.zamieniany = zamieniany;
    }

    public List<KursDto> getZamienniki() {
        return zamienniki;
    }

    public void setZamienniki(List<KursDto> zamienniki) {
        this.zamienniki = zamienniki;
    }

    public Opiniujacy getOpiniujacy() {
        return opiniujacy;
    }

    public void setOpiniujacy(Opiniujacy opiniujacy) {
        this.opiniujacy = opiniujacy;
    }

    public StatusOpinii getStatus() {
        return status;
    }

    public void setStatus(StatusOpinii status) {
        this.status = status;
    }

    public String getUzasadnieniePodania() {
        return uzasadnieniePodania;
    }

    public void setUzasadnieniePodania(String uzasadnieniePodania) {
        this.uzasadnieniePodania = uzasadnieniePodania;
    }

    public String getUzasadnienieOpinii() {
        return uzasadnienieOpinii;
    }

    public void setUzasadnienieOpinii(String uzasadnienieOpinii) {
        this.uzasadnienieOpinii = uzasadnienieOpinii;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

package wydmuch.patryk.zamienniki.entities;

import wydmuch.patryk.zamienniki.entities.kursEnums.StatusOpinii;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "podania")
public class Podanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="zamiennik")
    private Kurs zamiennik;

    @OneToOne
    @JoinColumn(name ="zamieniany")
    private Kurs zamieniany;

    @Enumerated(EnumType.STRING)
    private StatusOpinii status;

    private String uzasadnieniePodania;

    private String uzasadnienieOpinii;

    @ManyToOne
    @JoinColumn(name="student")
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kurs getZamiennik() {
        return zamiennik;
    }

    public void setZamiennik(Kurs zamiennik) {
        this.zamiennik = zamiennik;
    }

    public Kurs getZamieniany() {
        return zamieniany;
    }

    public void setZamieniany(Kurs zamieniany) {
        this.zamieniany = zamieniany;
    }

    public StatusOpinii getStatus() {
        return status;
    }

    public void setStatus(StatusOpinii status) {
        this.status = status;
    }





    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
}

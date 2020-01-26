package wydmuch.patryk.zamienniki.entities;

import wydmuch.patryk.zamienniki.entities.kursEnums.StatusOpinii;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "podania")
public class Podanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name ="zamieniany")
    private Kurs zamieniany;

    @ManyToMany
    @JoinTable(name="podania_zamienniki",
            joinColumns = { @JoinColumn(name = "podanie_id") },
            inverseJoinColumns = { @JoinColumn(name = "zamiennik_id")}
    )
    private List<Kurs> zamienniki;


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

    public List<Kurs> getZamienniki() {
        return zamienniki;
    }

    public void setZamienniki(List<Kurs> zamienniki) {
        this.zamienniki = zamienniki;
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

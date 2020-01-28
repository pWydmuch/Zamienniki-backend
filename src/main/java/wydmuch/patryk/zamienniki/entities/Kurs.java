package wydmuch.patryk.zamienniki.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @JsonIgnore
    @ManyToOne
    Przedmiot przedmiot;

    Integer ECTS;


    Boolean czyGrupa;


    @ElementCollection(targetClass = FormaZajec.class)
    @JoinTable(
            name = "kursy_formy_zajec"
    )
    @Enumerated(EnumType.STRING)
    List<FormaZajec> formaZajec;

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


    public Integer getECTS() {
        return ECTS;
    }

    public void setECTS(Integer ECTS) {
        this.ECTS = ECTS;
    }


    public FormaZaliczenia getFormaZaliczenia() {
        return formaZaliczenia;
    }

    public void setFormaZaliczenia(FormaZaliczenia formaZaliczenia) {
        this.formaZaliczenia = formaZaliczenia;
    }

    public Boolean getCzyGrupa() {
        return czyGrupa;
    }

    public void setCzyGrupa(Boolean czyGrupa) {
        this.czyGrupa = czyGrupa;
    }

    public void setFormaZajec(List<FormaZajec> formaZajec) {
        this.formaZajec = formaZajec;
    }

    public List<FormaZajec> getFormaZajec() {
        return formaZajec;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "id=" + id +
                ", kod='" + kod + '\'' +
                ", ECTS=" + ECTS +
                ", formaZajec=" + formaZajec +
                ", formaZaliczenia=" + formaZaliczenia +
                '}';
    }
}

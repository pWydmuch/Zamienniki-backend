package wydmuch.patryk.zamienniki.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import wydmuch.patryk.zamienniki.entities.enums.TytulNaukowy;

import javax.persistence.*;
import java.util.List;

@Table(name = "opiniujacy")
@Entity
public class Opiniujacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;
    private String nazwisko;

    @Enumerated(EnumType.STRING)
    private TytulNaukowy tytulNaukowy;

    @JsonIgnore
    @OneToMany(mappedBy = "opiniujacy")
    List<Podanie> podania;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public TytulNaukowy getTytulNaukowy() {
        return tytulNaukowy;
    }

    public void setTytulNaukowy(TytulNaukowy tytulNaukowy) {
        this.tytulNaukowy = tytulNaukowy;
    }
}

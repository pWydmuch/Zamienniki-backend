package wydmuch.patryk.zamienniki.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "studenci")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nr_index;

    private String imie;
    private String nazwisko;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Podanie> podania;

    public Long getNr_index() {
        return nr_index;
    }

    public void setNr_index(Long nr_index) {
        this.nr_index = nr_index;
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

    public Set<Podanie> getPodania() {
        return podania;
    }

    public void setPodania(Set<Podanie> podania) {
        this.podania = podania;
    }
}

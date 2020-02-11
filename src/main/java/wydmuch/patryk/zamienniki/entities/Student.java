package wydmuch.patryk.zamienniki.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "studenci")
public class Student  extends Osoba{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nr_index;



    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Podanie> podania;

    public Long getNr_index() {
        return nr_index;
    }

    public void setNr_index(Long nr_index) {
        this.nr_index = nr_index;
    }


    public Set<Podanie> getPodania() {
        return podania;
    }

    public void setPodania(Set<Podanie> podania) {
        this.podania = podania;
    }
}

package wydmuch.patryk.zamienniki.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import wydmuch.patryk.zamienniki.entities.enums.TytulNaukowy;

import javax.persistence.*;
import java.util.List;

@Table(name = "opiniujacy")
@Entity
public class Opiniujacy extends Osoba{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public TytulNaukowy getTytulNaukowy() {
        return tytulNaukowy;
    }

    public void setTytulNaukowy(TytulNaukowy tytulNaukowy) {
        this.tytulNaukowy = tytulNaukowy;
    }
}

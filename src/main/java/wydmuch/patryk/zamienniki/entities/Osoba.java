package wydmuch.patryk.zamienniki.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class  Osoba {

    //TODO przerobić, zeby student też mial @Id id, a indeks unique
    private String imie;
    private String nazwisko;

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
}

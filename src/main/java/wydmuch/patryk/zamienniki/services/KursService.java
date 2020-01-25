package wydmuch.patryk.zamienniki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.kursEnums.*;
import wydmuch.patryk.zamienniki.repositories.KursRepository;

import java.util.List;


public interface KursService {


   List<Kurs> getKursy();
   Kurs getKurs(Long id);
   List<Kurs> getKursySearch(String trybStudiow,
                                     String stopienStudiow,
                                     String  formaZaliczenia,
                                     String wydzial,
                                     String jezykStudiow,
                                     String[]  formyZajec,
                                     Integer ects,
                                     String kierunek,
                                     String cyklKsztalcenia);

    List<String> getKierunki();
    List<String> getCykle();
}

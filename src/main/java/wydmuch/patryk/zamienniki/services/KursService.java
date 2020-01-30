package wydmuch.patryk.zamienniki.services;

import wydmuch.patryk.zamienniki.dto.KursDto;
import wydmuch.patryk.zamienniki.entities.Kurs;

import java.util.List;


public interface KursService {



   KursDto getKurs(Long id);
   List<KursDto> getKursySearch(String trybStudiow,
                                String stopienStudiow,
                                String  formaZaliczenia,
                                String wydzial,
                                String jezykStudiow,
                                String[]  formyZajec,
                                Integer ects,
                                String kierunek,
                                String cyklKsztalcenia);


}

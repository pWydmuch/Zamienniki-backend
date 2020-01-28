package wydmuch.patryk.zamienniki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wydmuch.patryk.zamienniki.dto.KursDto;
import wydmuch.patryk.zamienniki.services.KursService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KursController {

    final
    KursService kursService;

    @Autowired
    public KursController(KursService kursService) {
        this.kursService = kursService;
    }


    @GetMapping("kursy")
    List<KursDto> getKursySearch(@RequestParam(required = false) String  trybStudiow,
                                 @RequestParam(required = false) String  stopienStudiow,
                                 @RequestParam(required = false) String  wydzial,
                                 @RequestParam(required = false) String  jezykStudiow,
                                 @RequestParam(required = false, name = "formaZajec") String[]  formyZajec,
                                 @RequestParam(required = false) String  formaZaliczenia,
                                 @RequestParam(required = false) Integer ects,
                                 @RequestParam(required = false) String  kierunek,
                                 @RequestParam(required = false) String  cyklKsztalcenia
                              ){
        return kursService.getKursySearch(trybStudiow,stopienStudiow,formaZaliczenia,wydzial,jezykStudiow,formyZajec,ects,kierunek,cyklKsztalcenia);
    }

    @GetMapping("kursy/{id}")
    public KursDto getkurs(@PathVariable Long id){
        return kursService.getKurs(id);
    }


}

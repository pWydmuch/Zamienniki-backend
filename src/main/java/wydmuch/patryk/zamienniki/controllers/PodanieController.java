package wydmuch.patryk.zamienniki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wydmuch.patryk.zamienniki.dto.PodanieDto;
import wydmuch.patryk.zamienniki.services.PodanieService;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/podania")
public class PodanieController {

    final
    PodanieService podanieService;

    @Autowired
    public PodanieController(PodanieService podanieService) {
        this.podanieService = podanieService;
    }

    @GetMapping("")
    public List<PodanieDto> getPodania(){
        return  podanieService.getPodania();
    }

    @GetMapping("/{id}")
    public PodanieDto getPodanie(@PathVariable Long id){
        return podanieService.getPodanie(id);
    }

    @PutMapping("/{id}")
    public PodanieDto updatePodanie(@PathVariable Long id, @RequestBody PodanieDto podanieDetailsDto){
        return podanieService.updatePodanie(id,podanieDetailsDto);
    }

}

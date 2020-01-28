package wydmuch.patryk.zamienniki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wydmuch.patryk.zamienniki.services.PlanStudiowService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController("plany")
public class PlanStudiowController {

    final
    PlanStudiowService planStudiowService;

    @Autowired
    public PlanStudiowController(PlanStudiowService planStudiowService) {
        this.planStudiowService = planStudiowService;
    }

    @GetMapping("/kierunki")
    List<String> getKierunki() {return planStudiowService.getKierunki();}

    @GetMapping("/cykle")
    List<String> getCykle() {return planStudiowService.getCykle();}
}

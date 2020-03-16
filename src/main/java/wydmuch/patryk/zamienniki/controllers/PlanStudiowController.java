package wydmuch.patryk.zamienniki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wydmuch.patryk.zamienniki.dto.PlanInfoDto;
import wydmuch.patryk.zamienniki.services.PlanStudiowService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/plany")
public class PlanStudiowController {

    final
    PlanStudiowService planStudiowService;

    @Autowired
    public PlanStudiowController(PlanStudiowService planStudiowService) {
        this.planStudiowService = planStudiowService;
    }

    @GetMapping("/info")
    PlanInfoDto getPlanInfo(){
        return planStudiowService.getPlanInfo();
    }
}

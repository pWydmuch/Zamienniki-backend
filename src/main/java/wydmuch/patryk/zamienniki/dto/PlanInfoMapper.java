package wydmuch.patryk.zamienniki.dto;

import java.util.List;

public class PlanInfoMapper {

    public static PlanInfoDto mapToPlanInfo(List<String> listaKierunkow, List<String> listaCykli){
        PlanInfoDto planInfoDto = new PlanInfoDto();

        planInfoDto.setCykle(listaCykli);
        planInfoDto.setKierunki(listaKierunkow);
        return planInfoDto;
    }
}
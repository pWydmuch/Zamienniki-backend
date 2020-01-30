package wydmuch.patryk.zamienniki.dto;

import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.PlanStudiow;
import wydmuch.patryk.zamienniki.entities.Przedmiot;

/**
 * Klasa służąca do mapowania kursu na kursDto i odwrotnie
 * @author Patryk Wydmuch
 * @version 1.1.1
 */

public class KursMapper {


    /**Metoda mapująca podany kurs na kursDto
     * @param kurs Kurs który chcemy zmapować na KursDto
     * @return KursDto powstały na bazie podanego kursu
     */
    public static KursDto mapKursToKursDto(Kurs kurs){
        KursDto kursDto = new KursDto();
        Przedmiot przedmiot = kurs.getPrzedmiot();
        PlanStudiow planStudiow = przedmiot.getPlanStudiow();
        kursDto.setId(kurs.getId());
        kursDto.setKod(kurs.getKod());
        kursDto.setNazwa(przedmiot.getNazwa());
        kursDto.setLinkKarty(przedmiot.getLinkKarty());
        kursDto.setCyklKsztalcenia(planStudiow.getCyklKsztalcenia());
        kursDto.setKierunek(planStudiow.getKierunek());
        kursDto.setTrybStudiow(planStudiow.getTrybStudiow());
        kursDto.setStopienStudiow(planStudiow.getStopienStudiow());
        kursDto.setWydzial(planStudiow.getWydzial());
        kursDto.setJezykStudiow(planStudiow.getJezykStudiow());
        kursDto.setCzyGrupa(kurs.getCzyGrupa());
        kursDto.setFormaZajec(kurs.getFormaZajec());
        kursDto.setFormaZaliczenia(kurs.getFormaZaliczenia());
        kursDto.setEcts(kurs.getECTS());

        return kursDto;
    }

    /**Metoda mapująca podany kursDto na kurs
     * @param kursDto KursDto który chcemy zmapować na Kurs
     * @return Kurs powstały na bazie podanego kursuDto
     */
    public static Kurs mapKursDtoToKurs(KursDto kursDto){
        Kurs kurs = new Kurs();
        kurs.setId(kursDto.getId());
        kurs.setKod(kursDto.getKod());
        kurs.setECTS(kursDto.getEcts());
        kurs.setFormaZajec(kursDto.getFormaZajec());
        kurs.setFormaZaliczenia(kursDto.getFormaZaliczenia());
        kurs.setCzyGrupa(kursDto.getCzyGrupa());
        return kurs;
    }


}

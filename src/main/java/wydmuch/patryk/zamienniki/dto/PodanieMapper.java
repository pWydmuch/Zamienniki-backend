package wydmuch.patryk.zamienniki.dto;

import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.Podanie;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Klasa służąca do mapowania podania na podanieDto i odwrotnie
 * @author Patryk Wydmuch
 * @version 1.1.1
 */

public class PodanieMapper {


    /**Metoda mapująca dane podanie na podanieDto
     * @param podanie Podanie które chcemy zmapować na podanieDto
     * @return PodanieDto powstałe na bazie podanego podania
     */
    public static PodanieDto mapPodanieToPodanieDto(Podanie podanie){
        PodanieDto podanieDto = new PodanieDto();
        podanieDto.setId(podanie.getId());
        podanieDto.setZamieniany(KursMapper.mapKursToKursDto(podanie.getZamieniany()));
        List<KursDto> zamienniki = podanie.getZamienniki()
                .stream()
                .map(KursMapper::mapKursToKursDto)
                .collect(Collectors.toList());
        podanieDto.setZamienniki(zamienniki);
        podanieDto.setOpiniujacy(podanie.getOpiniujacy());
        podanieDto.setStatus(podanie.getStatus());
        podanieDto.setUzasadnienieOpinii(podanie.getUzasadnienieOpinii());
        podanieDto.setUzasadnieniePodania(podanie.getUzasadnieniePodania());
        podanieDto.setStudent(podanie.getStudent());
        return podanieDto;
    }

    /**Metoda mapująca dane podanieDto na podanie
     * @param podanieDto PodanieDto które chcemy zmapować na podanie
     * @return Podanie powstałe na bazie podanego podaniaDto
     */
    public static Podanie mapPodanieDtoToPodanie(PodanieDto podanieDto){
        Podanie podanie = new Podanie();
        podanie.setId(podanieDto.getId());
        podanie.setZamieniany(KursMapper.mapKursDtoToKurs(podanieDto.getZamieniany()));
        List<Kurs> zamienniki = podanieDto.getZamienniki()
                .stream()
                .map(KursMapper::mapKursDtoToKurs)
                .collect(Collectors.toList());
        podanie.setZamienniki(zamienniki);
        podanie.setOpiniujacy(podanieDto.getOpiniujacy());
        podanie.setStatus(podanieDto.getStatus());
        podanie.setUzasadnienieOpinii(podanieDto.getUzasadnienieOpinii());
        podanie.setUzasadnieniePodania(podanieDto.getUzasadnieniePodania());
        podanie.setStudent(podanieDto.getStudent());
        return podanie;
    }
}

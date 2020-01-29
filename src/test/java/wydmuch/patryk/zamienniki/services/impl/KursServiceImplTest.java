package wydmuch.patryk.zamienniki.services.impl;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.SmartNullPointerException;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.kursEnums.FormaZajec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KursServiceImplTest {

    @Test
    void filterKursy() {
    }

    @Test
    void doesEmptyKursContainFormaZajec() {
        Kurs kurs = new Kurs();
        List<FormaZajec> formyZajec = new ArrayList<>(
                Arrays.asList(FormaZajec.WYKLAD));
        assertThrows(NullPointerException.class, () -> {
            KursServiceImpl.checkIfKursContainsFormaZajec(kurs,formyZajec);
        });
    }

    @Test
    void doesKursWithNoFormaZajecContainsFormaZajec(){
        Kurs kurs = new Kurs();
        kurs.setFormaZajec(Arrays.asList());
        List<FormaZajec> formyZajec = new ArrayList<>(
                Arrays.asList(FormaZajec.WYKLAD));
        boolean result = KursServiceImpl.checkIfKursContainsFormaZajec(kurs,formyZajec);
        assertFalse(result);
    }

    @Test
    void doesKursWithOneFormaZajecContainsThatFormaZajec(){
        Kurs kurs = new Kurs();
        kurs.setFormaZajec(Arrays.asList(FormaZajec.WYKLAD));
        List<FormaZajec> formyZajec = new ArrayList<>(
                Arrays.asList(FormaZajec.WYKLAD));
        boolean result = KursServiceImpl.checkIfKursContainsFormaZajec(kurs,formyZajec);
        assertTrue(result);
    }

    @Test
    void doesKursWithEveryFormaZajecButOneContainsAllFormaZajec(){
        List<FormaZajec> allFormy = Arrays.asList(FormaZajec.WYKLAD,
                FormaZajec.CWICZENIA,
                FormaZajec.LABORATORIUM,
//                FormaZajec.SEMINARIUM,
                FormaZajec.PROJEKT);
        Kurs kurs = new Kurs();
        kurs.setFormaZajec(allFormy);
        List<FormaZajec> formyZajec = new ArrayList<>(allFormy);
//        boolean result = KursServiceImpl.checkIfKursContainsFormaZajec(kurs,formyZajec);
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.WYKLAD)));
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.CWICZENIA)));
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.LABORATORIUM)));
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.PROJEKT)));
        assertFalse(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.SEMINARIUM)));
    }
    @Test
    void doesKursWithEveryFormaZajecContainsAllFormaZajec(){
        List<FormaZajec> allFormy = Arrays.asList(FormaZajec.WYKLAD,
                FormaZajec.CWICZENIA,
                FormaZajec.LABORATORIUM,
                FormaZajec.SEMINARIUM,
                FormaZajec.PROJEKT);
        Kurs kurs = new Kurs();
        kurs.setFormaZajec(allFormy);
        List<FormaZajec> formyZajec = new ArrayList<>(allFormy);
//        boolean result = KursServiceImpl.checkIfKursContainsFormaZajec(kurs,formyZajec);
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.WYKLAD)));
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.CWICZENIA)));
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.LABORATORIUM)));
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.PROJEKT)));
        assertTrue(KursServiceImpl.checkIfKursContainsFormaZajec(kurs,Arrays.asList(FormaZajec.SEMINARIUM)));
    }



}
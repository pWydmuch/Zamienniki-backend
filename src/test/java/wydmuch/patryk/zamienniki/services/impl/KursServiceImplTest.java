package wydmuch.patryk.zamienniki.services.impl;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.SmartNullPointerException;
import wydmuch.patryk.zamienniki.entities.Kurs;
import wydmuch.patryk.zamienniki.entities.kursEnums.FormaZajec;
import wydmuch.patryk.zamienniki.entities.kursEnums.FormaZaliczenia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KursServiceImplTest {



    //DLA checkIfKursContainsFormaZajec()

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

    // dla filterKursyMinimalEcts()
    @Test
    void doesFilteredKursyContainOnlyKursyWitmMaxEctsBeforeFiltrationWhenEctsMax(){
        List<Kurs> kursyBefore = new ArrayList<>();
        Kurs kurs1 = new Kurs();
        kurs1.setECTS(5);
        kursyBefore.add(kurs1) ;
        Kurs kurs2 = new Kurs();
        kurs2.setECTS(30);
        kursyBefore.add(kurs2);
        Kurs kurs3 = new Kurs();
        kurs3.setECTS(0);
        kursyBefore.add(kurs3);
        List<Kurs> kursyAfter = KursServiceImpl.filterKursyMinimalEcts(kursyBefore,30);
        assertEquals(kursyAfter.size(),1);
    }
    @Test
    void doesFilteredKursyContainAllKursyWhenEctsSmallerOrEqualThanAny(){
        List<Kurs> kursyBefore = new ArrayList<>();
        Kurs kurs1 = new Kurs();
        kurs1.setECTS(5);
        kursyBefore.add(kurs1) ;
        Kurs kurs2 = new Kurs();
        kurs2.setECTS(7);
        kursyBefore.add(kurs2);
        Kurs kurs3 = new Kurs();
        kurs3.setECTS(9);
        kursyBefore.add(kurs3);
        List<Kurs> kursyAfter = KursServiceImpl.filterKursyMinimalEcts(kursyBefore,5);
        assertEquals(kursyAfter.size(),kursyBefore.size());
    }
    @Test
    void doesFilteredKursyAreEmptyWhenEctsGreaterThanAny(){
        List<Kurs> kursyBefore = new ArrayList<>();
        Kurs kurs1 = new Kurs();
        kurs1.setECTS(5);
        kursyBefore.add(kurs1) ;
        Kurs kurs2 = new Kurs();
        kurs2.setECTS(7);
        kursyBefore.add(kurs2);
        Kurs kurs3 = new Kurs();
        kurs3.setECTS(9);
        kursyBefore.add(kurs3);
        List<Kurs> kursyAfter = KursServiceImpl.filterKursyMinimalEcts(kursyBefore,12);
        assertEquals(kursyAfter.size(),0);
    }

    //Dla filterKursyByFormaZaliczenia()

    @Test
    void doesFilteredKursyContainAllKursyWhenKursyWithSameFormaZaliczenia(){
        List<Kurs> kursyBefore = new ArrayList<>();
        Kurs kurs1 = new Kurs();
        kurs1.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs1) ;
        Kurs kurs2 = new Kurs();
        kurs2.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs2);
        Kurs kurs3 = new Kurs();
        kurs3.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs3);
        List<Kurs> kursyAfter = KursServiceImpl.filterKursyByFormaZaliczenia(kursyBefore,FormaZaliczenia.EGZAMIN);
        assertEquals(kursyAfter.size(),kursyBefore.size());
    }
    @Test
    void doesFilteredKursyContainOnlyKursyWithSameFormaZaliczenia(){
        List<Kurs> kursyBefore = new ArrayList<>();
        Kurs kurs1 = new Kurs();
        kurs1.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs1) ;
        Kurs kurs2 = new Kurs();
        kurs2.setFormaZaliczenia(FormaZaliczenia.ZALICZENIE);
        kursyBefore.add(kurs2);
        Kurs kurs3 = new Kurs();
        kurs3.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs3);
        List<Kurs> kursyAfter = KursServiceImpl.filterKursyByFormaZaliczenia(kursyBefore,FormaZaliczenia.ZALICZENIE);
        assertEquals(kursyAfter.size(),1);
    }
    @Test
    void doesFilteredKursyEmptyWhenDifferentFormaZaliczenia(){
        List<Kurs> kursyBefore = new ArrayList<>();
        Kurs kurs1 = new Kurs();
        kurs1.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs1) ;
        Kurs kurs2 = new Kurs();
        kurs2.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs2);
        Kurs kurs3 = new Kurs();
        kurs3.setFormaZaliczenia(FormaZaliczenia.EGZAMIN);
        kursyBefore.add(kurs3);
        List<Kurs> kursyAfter = KursServiceImpl.filterKursyByFormaZaliczenia(kursyBefore,FormaZaliczenia.ZALICZENIE);
        assertEquals(kursyAfter.size(),0);
    }
}
package no.hvl.dat102.Oppg3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Oppgave3Test {

    /*
    Vi lager testtabeller for tilfellene usortert, sortert, tom og null.
     */
    private final Integer[] tab1 = {24,3,14,1,17};
    private final Integer[] tab2 = {4,5,10};
    private final Integer[] tab3 = {};
    private final Integer[] tab4 = null;


    /*
    Lager en test som skal sjekke om tabellen er tom
     */
    @Test
    public void TestTomTabell (){

        Oppgave3<Integer> testTom = new Oppgave3<>(5);
        assertTrue(testTom.erTom());

        testTom.leggTil(3);
        assertFalse(testTom.erTom());
    }

    /*
    Tester om søk finner element i usortert
     */
    @Test
    public void TestSearchUnsorted(){
        Oppgave3<Integer> usortert = new Oppgave3<>(3);
        usortert.leggTil(2);
        usortert.leggTil(1);
        usortert.leggTil(3);

        assertTrue(usortert.inneholder(1));
        assertFalse(usortert.inneholder(4));

    }

    /*
    Tester om søk finner element i sortert
     */
    @Test
    public void TestSearchSorted(){
        Oppgave3<Integer> sortert = new Oppgave3<Integer>(3);

        sortert.leggTil(2);
        sortert.leggTil(3);
        sortert.leggTil(4);

        assertTrue(sortert.inneholder(3));
        assertFalse(sortert.inneholder(5));

    }

    /*
    Tester etter null tabell
     */
    @Test
    public void TestNull(){
        assertThrows(NullPointerException.class, () -> Oppgave3.sok(tab4, 0, tab1.length - 1, 1));
    }
}

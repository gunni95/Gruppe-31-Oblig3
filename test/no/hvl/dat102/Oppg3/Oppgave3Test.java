package no.hvl.dat102.Oppg3;

import no.hvl.dat102.Oppg3.Oppgave3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class Oppgave3Test {

    /*
    Vi lager testtabeller for tilfellene usortert, sortert, tom og null.
     */
    private int[] tab1 = {24,3,14,1,17};
    private int[] tab2 = {4,5,10};
    private int[] tab3 = {};
    private int[] tab4 = null;


    /*
    Lager en test som skal sjekke om tabellen er tom
     */
    @Test
    public void TestTomTabell (){

        Oppgave3 testTom = new Oppgave3(5);

        assertTrue(testTom.erTom());

        testTom.leggTil(3);
        assertFalse(testTom.erTom());
    }

    @Test
    public void TestSearch(){
        Oppgave3 usortert = new Oppgave3<>(3);
        usortert.leggTil(2);
        usortert.leggTil(1);
        usortert.leggTil(3);

        assertTrue(usortert.inneholder(1));
        assertFalse(usortert.inneholder(4));

    }

    @Test
    public void TestNull(){
        assertThrows(NullPointerException.class, () -> Oppgave3.sok(tab1, 0, tab1.length - 1, 1));
    }
}

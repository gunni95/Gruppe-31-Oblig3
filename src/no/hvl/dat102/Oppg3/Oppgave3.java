package no.hvl.dat102.Oppg3;

public class Oppgave3 {

    private Object[] tabell;
    private int antall;


    public Oppgave3 (int start){
        this.tabell = new Object[start];
        this.antall = 0;
    }

    public static <T extends Comparable<T>> T sok(T[] data, int min, int maks, T el) {
        int indeks = min;
        boolean funnet = false;
        T resultat = null;

        while (indeks <= maks && !funnet) {
            if (data[indeks].compareTo(el) == 0) {
                funnet = true;
                resultat = data[indeks];
            }
            indeks++;
        }
        return resultat;
    }

    public boolean erTom() {
        return (antall == 0);
    }
}

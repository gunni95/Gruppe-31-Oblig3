package no.hvl.dat102.Oppg3;

public class Oppgave3<T> {

    private T[] tabell;
    private int antall;


    public Oppgave3(int start) {
        this.tabell = (T[])(new Object[start]);
        this.antall = 0;
    }

    public  void leggTil(T element) {
        if (!inneholder(element)) {
            if (antall == tabell.length) {
                utvidKapasitet();
            }
            tabell[antall] = element;
            antall++;
        }
    }

    public boolean inneholder(T element) {
        boolean funnet = false;
        for (int i = 0; i < antall; i++) {
            if (tabell[i].equals(element)) {
                funnet = true;
                break;
            }
        }
        return (funnet);
    }

    private void utvidKapasitet() {
        T[] hjelpetabell = (T[]) (new Object[2 * tabell.length]);
        System.arraycopy(tabell, 0, hjelpetabell, 0, tabell.length);
        tabell = hjelpetabell;
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

    public static <T extends Comparable<T>> T binarySok(T[] data, int min, int maks, T el) {
        int mid = (min - maks) / 2;

        if (data[mid].compareTo(el) < 0) {
            return binarySok(data, 0, mid-1, el);
        } else if (data[mid].compareTo(el) == 0) {
            return data[mid];
        } else {
            return binarySok(data, mid+1, maks, el);
        }
    }

    public boolean erTom() {
        return (antall == 0);
    }
}
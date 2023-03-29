package no.hvl.dat102.Oppg6;

public class Oppgave6 {
    public void reparerOpp() {
        T hjelp = data[0];

        boolean ferdig = false;
        int forelder = 0;
        int vbarn = forelder * 2 + 1;

        while ((vbarn < antall) && !ferdig) {
            int maksbarn;
            maksbarn = vbarn;
            int hbarn = vbarn + 1;

            if ((hbarn < antall) && ((data[hbarn]).compareTo(data[maksbarn]) > 0))
                maksbarn = hbarn;


            if ((data[forelder]).compareTo(data[maksbarn]) < 0) {
                data[forelder] = data[maksbarn];
                forelder = maksbarn;
                vbarn = forelder * 2 + 1;
            }
            else {
                ferdig = true;
            }
            data[forelder] = hjelp;
        }

    }


    public int getAntall() {
        return this.antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public void setData(int i, int j) {
        T temp = data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }
}

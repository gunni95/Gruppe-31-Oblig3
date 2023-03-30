package no.hvl.dat102.Oppg2;
import no.hvl.dat102.Oppg1.SorterTabell;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random tall = new Random();
        Integer[] tallsamling = new Integer[64000];
        int repetisjoner = 10;
        long tidtotal = 0;

        for(int j=0;j<repetisjoner;j++){

            for (int i = 0; i < tallsamling.length; i++) {
                tallsamling[i] = 2;
                //tallsamling[i] = tall.nextInt(1000000);
                //System.out.print(tallsamling[i] + " ");
            }
            long tid = System.currentTimeMillis();

            //SorterTabell.utvalgssortering(tallsamling, tallsamling.length);
            //SorterTabell.sorteringVedInssetting(tallsamling, tallsamling.length);
            //Oppgave2.mergeSort(tallsamling, 0, tallsamling.length - 1);
            Oppgave2.quickSort(tallsamling, 0, tallsamling.length - 1);

            tidtotal += (System.currentTimeMillis() - tid);

            /*System.out.println();
        for(int i=0;i<tallsamling.length;i++){
            System.out.print(tallsamling[i] + " ");
        }*/
        }
        System.out.println("Snitt i ms: " + (tidtotal/repetisjoner));
    }
}

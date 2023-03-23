package no.hvl.dat102.Oppg2;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random tall = new Random();
        Integer[] tallsamling = new Integer[10];

        for(int i=0;i<tallsamling.length;i++){
            tallsamling[i] = tall.nextInt(100);
        }

        long tid = System.currentTimeMillis();

        Oppgave2.mergeSort(tallsamling, 0, 9);

        System.out.println((System.currentTimeMillis() - tid) / 1000);
        System.out.println();
        for(int i=0;i<tallsamling.length;i++){
            System.out.print(tallsamling[i] + " ");
        }
    }
}

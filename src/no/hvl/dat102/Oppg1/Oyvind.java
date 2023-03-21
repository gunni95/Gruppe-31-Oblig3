package no.hvl.dat102.Oppg1;

import java.util.Arrays;
import java.util.Random;

public class Oyvind {

    public static void main(String[] args){

        Random random = new Random();
        int n = 5000;
        int[] tabell = new int[n];


        for (int i = 0; i<n; i++){
            tabell[i] = random.nextInt();
        }

        boolean ferdig = false;
        int[] oppgA = Arrays.copyOf(tabell, n);

        long start = System.nanoTime();

        while (!ferdig && n > 1){
            int a = oppgA[n-1];
            int b = oppgA[n-2];

            if (a < b) {
                oppgA[n-1] = b;
                oppgA[n-2] = a;
            }
            n--;
        }
        long finish = System.nanoTime();
        long timeLapsed = finish - start;
        System.out.println(timeLapsed);

    }

}

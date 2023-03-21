package no.hvl.dat102.Oppg1;


import java.util.Arrays;
import java.util.Random;

public class Oppgave1 {
    public static void main(String[] args){
        Random random = new Random();

        boolean funnet = false;
        int j = 99999;
        int[] ints = random.ints(100000, 10,100000).toArray();

        int[] oppgA = Arrays.copyOf(ints, j);

        while (!funnet && j > 1){
            int a = oppgA[j-1];
            int b = oppgA[j-2];

            if (a > b) {
                oppgA[j-1] = b;
                oppgA[j-2] = a;
            }
            j--;
        }

        for (int i : oppgA) {
            System.out.println(i);
        }
    }

}
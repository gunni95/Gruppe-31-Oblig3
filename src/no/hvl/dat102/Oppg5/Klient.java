package no.hvl.dat102.Oppg5;

import java.util.Random;

public class Klient {

    public static void main(String[] args){

        /*  Oppgave a)
        nyttTre.leggTil(3);
        nyttTre.leggTil(5);
        nyttTre.leggTil(2);
        nyttTre.leggTil(6);
        nyttTre.leggTil(10);
        nyttTre.leggTil(1);
        nyttTre.leggTil(8);

        System.out.println("Høyde er nå: " + nyttTre.hoyde(nyttTre.getRot()));
         */

        int antallNoder = 0;
        int minHoyde = 100000000;
        int maxHoyde = 0;
        int sumHoyde = 0;
        int repitisjoner = 100;
        Random random = new Random();

        for(int i=0;i<repitisjoner;i++) {

            BS_Tre nyttTre = new BS_Tre();

            for(int j=0;j<1023;j++){
                nyttTre.leggTil(random.nextInt(5000));
                antallNoder++;
            }
            int tempHoyde = nyttTre.hoyde(nyttTre.getRot());
            sumHoyde += tempHoyde;
            if(tempHoyde<minHoyde){
                minHoyde=tempHoyde;
            }
            if (tempHoyde>maxHoyde){
                maxHoyde=tempHoyde;
            }
        }

        System.out.println("Antall noder: " + antallNoder + ". Minimale teoretiske hoyde: [insert formel]. " + "Maximale teoretiske hoyde: [insert formel]. " + "Minste hoyde: " + minHoyde + ". Storste hoyde: " + maxHoyde + ". Snitthoyde: " + sumHoyde / repitisjoner);
    }

}
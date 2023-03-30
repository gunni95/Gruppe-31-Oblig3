package no.hvl.dat102.Oppg1;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] tab = new Integer[50000];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = random.nextInt(10000);
		}

		long startTime = System.currentTimeMillis();
		
		// SorterTabell.utvalgssortering(tab, tab.length);
		SorterTabell.sorteringVedInssetting(tab, tab.length);
		
		for (Integer e : tab) {
			System.out.print(e + " ");
		}
		System.out.println();
		double seconds = (System.currentTimeMillis() - startTime) / 1000.0;
		System.out.println("Tid brukt: " + (seconds) + " sekunder");

	}
}

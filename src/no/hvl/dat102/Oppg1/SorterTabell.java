package no.hvl.dat102.Oppg1;

public class SorterTabell {
	// Byter om a[i] og a[j]. Antar at både i og j er lovlege indeksar i tabellen.
		private static void swap(Object[] a, int i, int j) {
			Object temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

		// Utvalgssortering / Plukksortering (DAT100) (Selction sort)
		// Sorterer dei første n elmementa i tabellen. Kanskje litt uvanlig
		// Kunne også utelatt n og sortert heile tabellen.

		public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
			for (int i = 0; i < n - 1; i++) {
				int minstePos = i;
				for (int j = i + 1; j < n; j++) {
					if (a[j].compareTo(a[minstePos]) < 0) {
						minstePos = j;
					}
				}
				
				swap(a, i , minstePos);
			}
		}

		// Sortering ved innsetting (Insertion sort)
		public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int n) {
			sorteringVedInssetting(a, 0, n - 1);
		}

		// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
		public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
			int minste = slutt;
			for (int i = slutt - 1; i >= 0; i--) {
				if (a[minste].compareTo(a[i]) > 0) {
					minste = i;
				}
			}

			swap(a, 0, minste);


			for (int i = start + 1; i < slutt; i+=2) {
				T insert1 = a[i];
				T insert2 = a[i+1];
				int j = i - 1;  // siste i sortert del
				boolean ferdig1 = false;
				boolean ferdig2 = false;

				while ((!ferdig1 || !ferdig2) && j > 0) {
					if (!ferdig1 && insert1.compareTo(a[j]) < 0) {
						a[j + 1] = a[j];
						j--;
					} else {
						ferdig1 = true;
					}

					if (!ferdig2 && insert2.compareTo(a[j+1]) < 0) {
						a[j + 2] = a[j];
						j--;
					} else {
						ferdig2 = true;
					}
				}
				
				a[j + 1] = insert1;
				a[i + 2] = insert2;
			}
		} 
}
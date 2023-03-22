package no.hvl.dat102.Oppg2;

public class Oppgave2 {
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static <T extends Comparable<? super T>> void sorterStartMidSlutt(T[] a, int start, int mid, int slutt){
        T temp = a[start];
        T temp2 = a[slutt];
        T temp3 = a[mid];
        if(a[start].compareTo(a[slutt]) < 0){
            temp = a[slutt];
            temp2 = a[start];
        }
        if(a[mid].compareTo(temp2) > 0) {
            temp3 = temp2;
            temp2 = a[mid];
        } else if(a[mid].compareTo(temp) < 0){
            temp3 = temp;
            temp = a[mid];
        }
        a[start] = temp;
        a[slutt] = temp2;
        a[mid] = temp3;
    }
    public static <T extends Comparable<? super T>> int partition(T[] a, int start, int slutt){
        int mid = slutt / 2;
        sorterStartMidSlutt(a, start, mid, slutt);
        T temp = a[slutt - 1];
        a[slutt - 1] = a[mid];
        a[mid] = temp;
        int pivotIndex = slutt - 1;
        T pivotValue = a[pivotIndex];
        int indexFromLeft = start + 1;
        int indexFromRight = slutt - 2;
        boolean done = false;
        while(!done){
            while(a[indexFromLeft].compareTo(pivotValue) > 0){
                indexFromLeft++;
            }
            while(a[indexFromRight].compareTo(pivotValue) < 0){
                indexFromRight--;
            }
            if(indexFromLeft < indexFromRight){
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            } else{
                done = true;
            }
        }
        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;
        return pivotIndex;
    }
    public static <T extends Comparable<? super T>> void quickSort(T[] a, int start, int slutt){
        if(slutt - start + 1 < 5000){
            insertionSort(a, start, slutt);
        } else{
            int pivotIndex = partition(a, start, slutt);
            quickSort(a, start, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, slutt);
        }
    }
}

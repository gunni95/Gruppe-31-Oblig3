package no.hvl.dat102.Oppg2;

import no.hvl.dat102.Oppg1.SorterTabell;

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
        if(a[start].compareTo(a[slutt]) > 0){
            temp = a[slutt];
            temp2 = a[start];
        }
        if(a[mid].compareTo(temp2) < 0) {
            temp3 = temp2;
            temp2 = a[mid];
        } else if(a[mid].compareTo(temp) > 0){
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
            while(a[indexFromLeft].compareTo(pivotValue) < 0){
                indexFromLeft++;
            }
            while(a[indexFromRight].compareTo(pivotValue) > 0){
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
            SorterTabell.sorteringVedInssetting(a, start, slutt);
        } else{
            int pivotIndex = partition(a, start, slutt);
            quickSort(a, start, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, slutt);
        }
    }
    public static <T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int start, int mid, int slutt){
        int startHalvdel1 = start;
        int sluttHalvdel1 = mid;
        int startHalvdel2 = mid + 1;
        int sluttHalvdel2 = slutt;
        int index = start;
        while((startHalvdel1 <= sluttHalvdel1) && (startHalvdel2 <= sluttHalvdel2)){
            if(a[startHalvdel1].compareTo(a[startHalvdel2]) <= 0){
                tempArray[index] = a[startHalvdel1];
                startHalvdel1++;
            } else{
                tempArray[index] = a[startHalvdel2];
                startHalvdel2++;
            }
            index++;
        }
        if(startHalvdel1 > sluttHalvdel1){
            while(startHalvdel2 <= sluttHalvdel2){
                tempArray[index] = a[startHalvdel2];
                index++;
                startHalvdel2++;
            }
        } else if(startHalvdel2 > sluttHalvdel2){
            while(startHalvdel1 <= sluttHalvdel1){
                tempArray[index] = a[startHalvdel1];
                index++;
                startHalvdel1++;
            }
        }
        for(int i=start;i<=slutt && tempArray[i] != null;i++){
                a[i] = tempArray[i];
        }
    }
    public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempArray, int start, int slutt){
        if(start < slutt){
            int mid = (start + slutt)/2;
            mergeSort(a, tempArray, start, mid);
            mergeSort(a, tempArray, mid + 1, slutt);
            merge(a, tempArray, start, mid, slutt);
        }
    }
    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int start, int slutt){
        T[] tempArray = (T[])new Comparable<?>[a.length];
        mergeSort(a, tempArray, start, slutt);
    }
    public static <T extends Comparable<? super T>> void aToString(T[] a){
        System.out.println();
        System.out.print("( ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.print(")");
    }
}

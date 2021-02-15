package Mod3GAB.Problem2;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date:
 *
 * MergeSort.java
 */
public class MergeSort {

    public static void main(String[] args) {

        //Main method that accepts three numbers N, A, B
        int N = Integer.parseInt(args[0]);
        int A = Integer.parseInt(args[1]);
        int B = Integer.parseInt(args[2]);

        //Create an N-element int array
        int[] numberArray = new int[N];
        for (int i = 0; i < N; i++) {
            //Assign random numbers between [A,  B] to each of the N elements of the array
            numberArray[i] = (int) (Math.random() * (B - A + 1) + A);
        }

        //Call mergeSort method to sort the array
        //record the time spent on sorting
        long start = System.nanoTime();
        mergeSort(numberArray);
        long end = System.nanoTime();
        long time = end - start;

        System.out.println("Number of elements: " + N);
        System.out.println("Sort Time: "  + time + " Nanoseconds");
        System.out.println();

    }
    public static void mergeSort(int[] arr){
        mergeSortRec(arr, 0, arr.length-1);
    }
    private static void mergeSortRec(int[] arr, int first, int last){
        if(first<last){
            int mid=(first+last)/2;
            mergeSortRec(arr, first, mid);
            mergeSortRec(arr, mid+1,last);
            merge(arr, first, mid, mid+1, last);
        }
    }
    private static void merge(int[] arr, int leftFirst, int leftLast, int rightFirst, int rightLast){
        int[] aux=new int[arr.length];
        //extra space, this is downside of this algorithm
        int index=leftFirst;
        int saveFirst=leftFirst;
        while(leftFirst<=leftLast && rightFirst <=rightLast){
            if(arr[leftFirst]<=arr[rightFirst]){
                aux[index++]=arr[leftFirst++];
            }else{
                aux[index++]=arr[rightFirst++];
            }
        }
        while(leftFirst<=leftLast){
            aux[index++]=arr[leftFirst++];
        }
        while(rightFirst<=rightLast)
            aux[index++]=arr[rightFirst++];
        for(index=saveFirst; index<=rightLast; index++)
            arr[index]=aux[index];
    }
}

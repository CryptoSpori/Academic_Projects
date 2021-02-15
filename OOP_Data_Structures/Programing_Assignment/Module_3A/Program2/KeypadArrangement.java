package Mod3BPA.Program2;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/25/2020
 *
 * KeypadArrangement.java
 */
import java.util.ArrayList;
import java.util.HashSet;

public class KeypadArrangement {

    private static int[][] master;
    private static int count = 0;

    public static void main(String[] args) {
        int[] fre = {5, 2, 20, 9, 90};
        int[] keys = {2,3};
        char[] letters = {'A', 'B', 'C', 'D', 'E'};

        master = new int[numberPermutations(fre, fre.length)][fre.length];

        int minKey = minimalKeyStroke(fre, keys);
        System.out.println("Minimum key stokes: " + minKey);

        String temp = keyPadArrangement(fre, keys, letters, minKey);
        System.out.println(temp);
    }

    public static String keyPadArrangement(int[] frequencies, int[] keyLimits, char[] letters, int minStrokes) {

        //minimalKeyStroke(frequencies, keyLimits);
        int[] leftSide = new int[keyLimits[0]];
        int[] rightSide = new int[keyLimits[1]];
        HashSet<String> minKeys = new HashSet<>();
        ArrayList<int[]> finalList = new ArrayList<>();

        for (int i = 0; i < master.length; i++) {
            //Load temp side arrays for each permutation
            for (int j = 0; j < leftSide.length; j++) {
                leftSide[j] = master[i][j];
            }
            for (int j = 0; j < rightSide.length; j++) {
                rightSide[j] = master[i][j + keyLimits[0]];
            }

            //Sort side arrays from largest to smallest order
            selectionSort(leftSide);
            selectionSort(rightSide);

            //Merge (Sorted) Array back
            int length = leftSide.length + rightSide.length;
            int[] sortedMergedArray = new int[length];

            for (int j = 0; j < leftSide.length; j++) {
                sortedMergedArray[j] = leftSide[j];
            }
            for (int j = 0; j < rightSide.length; j++) {
                sortedMergedArray[j + leftSide.length] = rightSide[j];
            }
            String temp = "";
            for (int j = 0; j < sortedMergedArray.length; j++) {
                temp = temp + sortedMergedArray[j] + " ";
                //System.out.print(sortedMergedArray[j]);
            }
            //System.out.println(temp);
            //Sum arrays based on key value
            int leftSum = weightedSumArray(leftSide);
            int rightSum = weightedSumArray(rightSide);

            //Then sum side arrays together
            int totalSum = leftSum + rightSum;

           if (totalSum == minStrokes)
               minKeys.add(temp);
        }

        for (String s : minKeys) {
            //System.out.println(s);
            String[] newArray = s.split(" ");

            int[] intTemp = new int[newArray.length];
            for (int i = 0; i < newArray.length; i++) {
                intTemp[i] = Integer.parseInt(newArray[i]);

            }
            finalList.add(intTemp);
        }
        //PRINT OUT KEY ARRANGEMENTS
        System.out.println("\nMost Efficient Key Arrangements: ");
        for (int[] s : finalList) {
            System.out.print("[");
            for (int i = 0; i < leftSide.length; i++) {
                //System.out.print(s[i]);
                for (int j = 0; j < frequencies.length; j++) {
                    if (frequencies[j] == s[i])
                        System.out.print(letters[j]);
                }
            }
            System.out.print("][");
            for (int i = 0; i < rightSide.length; i++) {
               // System.out.print(s[i + leftSide.length]);
                for (int j = 0; j < frequencies.length; j++) {
                    if (frequencies[j] == s[i + leftSide.length])
                        System.out.print(letters[j]);
                }
            }
                System.out.print("]");
                System.out.println();
        }
        return "";
    }


    public static int minimalKeyStroke(int[] frequencies, int[] keyLimits) {

       int[] leftSide = new int[keyLimits[0]];
       int[] rightSide = new int[keyLimits[1]];
       int[] allSums;

       permutations(frequencies, 0, frequencies.length);

       allSums = new int[master.length];

        for (int i = 0; i < master.length; i++) {

            //Load temp side arrays for each permutation
            for (int j = 0; j < leftSide.length; j++) {
                leftSide[j] = master[i][j];
            }
            for (int j = 0; j < rightSide.length; j++) {
                rightSide[j] = master[i][j + keyLimits[0]];
            }

            //Sort side arrays from largest to smallest order
            selectionSort(leftSide);
            selectionSort(rightSide);

            //Sum arrays based on key value
            int leftSum = weightedSumArray(leftSide);
            int rightSum = weightedSumArray(rightSide);

            //Then sum side arrays together
            int totalSum = leftSum + rightSum;

            //Load sums in to sum array.
            allSums[i] = totalSum;
        }

        //find smallest sum
        int min = allSums[0];
        for (int i = 1; i < allSums.length; i++) {
            if (min > allSums[i]) {
                min = allSums[i];
            }
        }
        //return smallest sum
        return min;
    }

    public static int weightedSumArray(int[] someArray) {
        int sum = 0;
        for (int i = 0; i < someArray.length; i++) {
            sum = sum + ((i + 1) * someArray[i]);
        }
        return  sum;
    }

    public static void permutations(int[] array, int start, int end) {

        if (start == end - 1) {


            //printArray(array);
            for (int i = 0; i < array.length; i++) {

                int temp = array[i];

                master[count][i] = temp;
            }
            count++;


        }
        else {
            for (int i = start; i < end; i++) {
                //swap(array, start, i);
                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;
                permutations(array, start + 1, end);
                int temp2 = array[start];
                array[start] = array[i];
                array[i] = temp2;
                //swap(array, start, i);
            }
        }
    }

    public static int numberPermutations ( int[] array, int n){
        if (n == 0)
            return 1;
        else
            return n * numberPermutations(array, n - 1);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int max = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] > array[max]) {
                    max = j;
                }
            }
            if (max != i) {
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j);
        }
        System.out.println("");
    }


}

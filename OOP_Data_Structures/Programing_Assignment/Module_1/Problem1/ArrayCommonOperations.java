
import java.util.Scanner;

/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John C Stelly
 * Completion date: 09/24/2020
 *
 * ArrayCommonOperations.txt - template file. Save as ArrayCommonOperations.java
 */

public class ArrayCommonOperations
{
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        int elements, min, max, sum, peakCount, secondMax, secondMin;
        double average;
        int[] squareArray;

        //Read the following data from the user

        //Number of elements in the array
        System.out.print("Enter array size:");
        elements = kb.nextInt();

        //The range in which the random numbers would be generated
        System.out.print("Enter lower limit of the range: ");
        min = kb.nextInt();
        System.out.print("Enter upper limit of the range: ");
        max = kb.nextInt();
        System.out.println("");

        //Define and instantiate an array of integers, with the number of elements you read from user
        //Fill in the array with integers in the range given by the user
        int[] newArray = createRandomArray(elements, min, max);

        //Display the one dimensional array, with two spaces between values
        displayArray(newArray);

        //Calculate the average of numbers in the array
        average = arrayAverage(newArray);
        System.out.println("The average value of the array is: " + average);

        //Calculate the sum of odd values in the array
        sum = numOddValues(newArray);
        System.out.println("\nThe number of odd values are: " +sum);

        //Count the number of peaks in the array.
        peakCount = arrayPeakCount(newArray);
        System.out.println("\nNumber of Array peaks: " + peakCount);

        //Calculate the second maximum value in the array
        secondMax = secondMaxValue(newArray);
        System.out.println("\nSecond Maximum Number: " + secondMax);

        //Build an array filled with the squares of the elements in a given array
        System.out.println("\nArray containing squares:");
        squareArray = arraySquared(newArray);
        displayArray(squareArray);
    }
    public static int[] createRandomArray(int numOfElements, int minRange, int maxRange){
        //Fill in the array with integers in the range given by the user
        System.out.println("Original array is:");
        int[] newArray = new int[numOfElements];
        int temp;
        boolean check = true;
        for (int i = 0; i < newArray.length; i++) {
            do {
                temp = (int) (Math.random() * 100);
                if (temp >= minRange && temp <= maxRange ) {
                    newArray[i] = temp;
                    check = false;
                } else {
                    check = true;
                }
            } while (check);
        }
        return newArray;
    }
    public static void displayArray(int[] someArray){
        //Display the one dimensional array, with two spaces between values
        for (int i = 0; i < someArray.length; i++) {
            System.out.print(someArray[i] + "  ");
        }
        System.out.println("\n");
    }
    public  static double arrayAverage(int[] someArray) {
        int num;
        int sum = 0;
        double average;
        for (int j : someArray) {
            num = j;
            sum = sum + num;
        }
        average = sum / someArray.length;
        return average;
    }
    public  static int numOddValues(int[] someArray) {
        int num;
        int count = 0;
        for (int j : someArray) {
            num = j;
            int temp = num % 2;
            if (temp != 0) {
                count++;
            }
        }
        return count;
    }
    public  static int secondMaxValue(int[] someArray) {
        int maxNumber = someArray[0];
        int secondMaxNumber = maxNumber;
        for (int i = 1; i < someArray.length; i++) {
            int test = someArray[i];
            if (test > maxNumber) {
                maxNumber = test;
            }
        }
        for (int i = 1; i < someArray.length; i++) {
            int test = someArray[i];
            if (test > secondMaxNumber && test != maxNumber) {
                secondMaxNumber = test;
            }
        }
        return secondMaxNumber;
    }
    public static int[] arraySquared(int[] someArray) {
        int[] newArray = new int[someArray.length];
        int temp, solution;
        for (int i = 0; i < someArray.length; i++) {
            temp = someArray[i];
            solution = temp * temp;
            newArray[i] = solution;
        }
        return newArray;
    }
    public  static int arrayPeakCount(int[] someArray) {
        //Count the number of peaks in the array.
        int count=0;
        int num, left, right;
        int first = someArray[0];
        int last = someArray[someArray.length - 1];
        if(first > someArray[1]){
            count++;
        }
        if (last > someArray[someArray.length - 2]){
            count++;
        }
        for (int i = 1; i < someArray.length - 1; i++) {
            num = someArray[i];
            left = someArray[i - 1];
            right = someArray[i + 1];
            if ((num > left) && (num > right)) {
                count++;
            }
        }
        return count;
    }
}
package Mod1GA;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John C Stelly
 * Completion date: 09/24/2020
 *
 * ArrayCommonOperations.txt - template file. Save as ArrayCommonOperations.java
 *
 * This program performs common operations on the elements of an one-dimensional array
 * The elemenst of the array are random numbers of type integer, with values between 1 and 100.
 * The calculated values are stored, and displayed at the end of the program
 *
 * Student tasks: complete tasks specified in the file
 */

public class ArrayCommonOperations
{
    public static void main(String [] args)
    {
        int maxNumber;
        int minNumber;
        int sum = 0;
        int num;
        int evenCheck;
        int evenCount = 0;
        int threeDivCheck;
        int newThreeNumber;

        //*** Task #1: Define and instantiate an array of integer numbers, with 10 elements
        int[] someArray = new int[10];

        //*** Task #2: Fill in the array with integer numbers from 1 to 100
        for (int i = 0; i < someArray.length; i++) {
            num = (int) (Math.random() * 101);
            someArray[i] = num;
        }

        //*** Task #3: 	define another array, named temp, and copy the initial array in it.
        //*				This allows to preserve the original array
        int[] temp = new int[10];

        //*** Task #4:  Define the variables you need to calculate the following values,
        //*				and initialize them with appropriate values.
        //SEE ABOVE

        System.out.print("Original Array:       [");
        for (int i = 0; i < someArray.length; i++) {
            num = someArray[i];
            //*** Task #5: 	Print the original array
            System.out.print(num + " ");
            //*** Task #6: 	Calculate the sum of all values
            sum = sum + num;
            //*** Task #7: 	Count the number of even values
            evenCheck = num % 2;
            if (evenCheck == 0) {
                evenCount++;
            }
        }
        System.out.println("]");

        //*** Task #8: 	Calculate the minimum value in the array
        minNumber = someArray[0];
        for (int i = 1; i < someArray.length; i++) {
            int test = someArray[i];
            if (test < minNumber) {
                minNumber = test;
            }
        }

        //*** Task #9: 	Calculate the maximum value in the array
        maxNumber = someArray[0];
        for (int i = 1; i < someArray.length; i++) {
            int test = someArray[i];
            if (test > maxNumber) {
                maxNumber = test;
            }
        }

        //*** Task #10: Replace the elements that are divisible by 3, with their value plus 2
        for (int i = 0; i < someArray.length; i++) {
            num = someArray[i];
            threeDivCheck = num % 3;
            if (threeDivCheck == 0) {
                newThreeNumber = num + 2;
                temp[i] = newThreeNumber;
            }
            else {
                temp[i] = num;
            }
        }

        //*** Task #11: Display the new array after replacement
        System.out.print("Divisible by 3 Array: [");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println("]");

        //*** Task #12: Display the calculated values.
        System.out.println("Sum of array values in array: " + sum);
        System.out.println("Number of even values in array: " + evenCount);
        System.out.println("Minimum value in array: " + minNumber);
        System.out.println("Maximum value in array: " + maxNumber);
    }
}
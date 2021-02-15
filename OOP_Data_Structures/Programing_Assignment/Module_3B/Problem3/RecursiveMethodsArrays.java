package Mod3APA.Problem3;

import Mod2GA.Program2.StackUnderflowException;

/**
 * @author YINGJIN CUI
 * @version 1.0
 * since   2020-02
 *
 * Student name:  John Stelly
 * Completion date:
 *
 * RecursiveMethodsArrays.txt: the template file of RecursiveMethodsArrays.java
 * Student tasks: implement tasks #1, #2 and #3 as specified in this file
 */

public class RecursiveMethodsArrays{

    public static void main(String[] args){
        int[] arr={2,4,3,89,0, -9};
        System.out.println(smallest(arr, arr.length , arr[arr.length - 1]));
        int[][] ar={{1,2,3,4,1,0},{0,-8,-90}};
        System.out.println(smallest(ar, ar.length-1, ar[ar.length-1].length-1, ar[ar.length-1][ar[ar.length-1].length-1]));
        //System.out.println(smallest(ar));
        System.out.println(repeat(args[0], Integer.parseInt(args[1])));
    }

    public static int smallest(int[] arr, int start, int hold){
        // *** Student task #1 ***
        /*
        Requirements:
        This method finds and returns the smallest value in an int array.
        To get credit, it MUST be implemented as a recursive method. N
        No credit if implemented with loop.

       *** Enter your code below ***
       */

        if (start == 0) {
            //System.out.println(arr[start]);
            return hold;
        }

        else {

            hold = smallest(arr, start - 1, hold);

            if (hold > arr[start - 1]) {

                hold = arr[start - 1];

            }
            return hold;
        }
    }

    public static int smallest(int[][] arr, int row, int column, int hold) {

        if (column == 0 && row == 0) {
            return hold;
        }
        if (column == 0) {
            return smallest(arr, row - 1, arr[row - 1].length, hold);
        }
        else {
            if (arr[row][column - 1] < hold)
                hold = arr[row][column - 1];
            return smallest(arr, row, column - 1, hold);
        }
    }

    public static String repeat(String s, int n){
        // *** Student task #3 ***
      /*
      Requirements:
      It accepts a string s and an integer n as parameters and
      that returns a String consisting of n copies of s.
      For example:

      Call                       Value Returned
      repeat("hello", 3)    	   "hellohellohello"
      repeat("this is fun", 1)   "this is fun"
      repeat("wow", 0)           ""
      repeat("hi ho! ", 5)       "hi ho! hi ho! hi ho! hi ho! hi ho! "


       *** Enter your code below ***
     */
        try {
            if (n < 0)  throw  new IllegalArgumentException("Negative number is not valid");
            else if (n == 0)
                return "";
            else {
                s = s + repeat(s, n - 1);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return s;
    }
}

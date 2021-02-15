package Mod4PA.Program3;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/31/2020
 *
 * CipherQueue.java
 */

public class HighestPalindromeProduct {

    public static void main(String[] args) {

        //Palindrome queue for holding numeric palindrome objects
        PalindromeQueue<NumericPalindrome> someQueue = new PalindromeQueue<>(10);

        //Number of Digits (2 x 2), etc.
        int numDigits = 3;
        int maxNumCalculations = (int) (Math.pow(10,numDigits));
        int minRange = (int) (Math.pow(10, numDigits - 1));

        //Load numeric palindrome objects into PalindromeQueue
        for (int i = minRange; i < maxNumCalculations; i++) {
            for (int j = minRange; j < maxNumCalculations; j++) {
                NumericPalindrome temp = new NumericPalindrome(i,j);
                temp.getPalindrome();
                if(temp.hasAPalindrome()) {
                    someQueue.enqueue(temp);
                    System.out.println(temp.getPalindrome());
                }
            }
        }

        //Pull highest which will be last item in queue
        NumericPalindrome temp = someQueue.peekRear();
        System.out.println("The maximum palindrome of " +numDigits + "-digit number is: ");
        System.out.print(temp.getNumA());
        System.out.print(" * ");
        System.out.print(temp.getNumB());
        System.out.print(" = ");
        System.out.println(temp.getPalindrome());


















    }
}

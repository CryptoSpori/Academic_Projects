package Mod4PA.Program3;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/31/2020
 *
 * NumericPalindrome.java
 */

public class NumericPalindrome {

    private final int numA;
    private final int numB;
    private int product;
    private int palindrome;

    //Constructors
    public NumericPalindrome() {
        this.numA = 0;
        this.numB = 0;
    }

    public NumericPalindrome(int a, int b) {
        this.numA = a;
        this.numB = b;
    }

    //Getter Methods
    public int getPalindrome() {
        calculatePalindrome();
        return palindrome;
    }

    public int getNumA() {
        return numA;
    }

    public int getNumB () {
        return numB;
    }

    //Method to test if number is a valid palindrome
    public boolean hasAPalindrome() {
        if (palindrome != 0)
            return true;
        else
            return false;
    }

    //Assistance Method for multiplying two numbers
    private void multiply() {
        this.product = numA * numB;
    }

    //Assistance Method for reverse a number for testing with hasAPalindrome()
    private void calculatePalindrome() {
        multiply();
        String temp = "" + product;
        String reverse = "";
        if (temp.length() != 1) {
            for (int i = temp.length() - 1; i > -1; i--) {

                reverse = reverse + temp.charAt(i);
            }
        }
        int newNum = Integer.parseInt(reverse);
        if (newNum == product)
            palindrome = newNum;
    }
}



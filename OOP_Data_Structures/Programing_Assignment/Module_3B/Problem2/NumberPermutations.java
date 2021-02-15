package Mod3APA.Problem2;

import java.util.Scanner;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/24/2020
 *
 * NumberPermutations.java
 */
public class NumberPermutations {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = input.nextInt();

        getOddPermutations("",num);
    }
    public static void getOddPermutations(String str, int remaining) {

        if(remaining==1){
            System.out.println(str+"1");
            System.out.println(str+"3");
            System.out.println(str+"5");
            System.out.println(str+"7");
            System.out.println(str+"9");
        }else{
            getOddPermutations(str+"1",remaining-1);
            getOddPermutations(str+"3",remaining-1);
            getOddPermutations(str+"5",remaining-1);
            getOddPermutations(str+"7",remaining-1);
            getOddPermutations(str+"9",remaining-1);
        }
    }
}

package Mod3APA.Problem1;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/24/2020
 *
 * Multiply.java
 */

public class Multiply {

    public static void main(String[] args) {

        //Accept two operands a and b from the CLI
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        //Print result
        System.out.print(a + " x " + b + " = ");
        System.out.println(multiply(a,b));

    }
    public static int multiply(int a,int b) {
        // Method for multiply(a, b), where a and b are both positive integers,

        int solution = 0;

        if (a == 0 || b == 0)
            solution = 0;
        else {
            solution = multiply(a, b - 1) + a;

        }
        return solution;
    }
}


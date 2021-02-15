package Mod1PA.Problem2;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John C Stelly
 * Completion date: 09/24/2020
 *
 * PolynomialDriver.java
 *
 */
public class PolynomialDriver {

    public static void main(String[]args){

        //Define a polynomial zero, with value zero
        Polynomial p0 = new Polynomial(0, null);
        System.out.println("zero = p(x) = p0 = " + p0);

        //Define and instantiate a Polynomial object p1 with degree 4, and random coefficients between 0 and 10
        Polynomial p1 = new Polynomial(4, createRandomArray(4));
        System.out.println("p(x) = p1 = " + p1);

        //Define and instantiate another Polynomial object p2 with degree 3, and random coefficients between 0 and 10.
        Polynomial p2 = new Polynomial(4, createRandomArray(4));
        System.out.println("p(x) = p2 = "+ p2);

        //Add polynomials p1 and p2 and display the result.
        System.out.println("p1 + p2 = " + p1.addPoly(p2));

        //Subtract polynomial p1 from polynomial zero, and display the result.
        System.out.println("p1 - p0 = " + p1.subtractPoly(p0));

        //Subtract polynomial  p1 and p2 and display the result.
        System.out.println("p1 - p2 = " + p1.subtractPoly(p2));



        //Evaluate p1 for x=2 and display the result
        System.out.println("x=3 and p1 = p(3)=" + p1.evaluate( 2));

        //Check if p1 and p2 are equal.
        System.out.println("Is p1 and p2 equal? " + p1.equals(p2));

        //Calculate the derivative of polynomial p1 and display the result.
        System.out.println("d/dx = " + p1.derivative());

    }
    //Create random array between 0 and 10
    public static int[] createRandomArray(int degree) {
        int[] newArray = new int[degree + 1];
        int temp;
        boolean check = true;
        for (int i = 0; i < newArray.length; i++) {
            do {
                temp = (int) (Math.random() * 100);
                if (temp >= 0 && temp <= 10) {
                    newArray[i] = temp;
                    check = false;
                } else {
                    check = true;
                }
            } while (check);
        }
        return newArray;
    }
}

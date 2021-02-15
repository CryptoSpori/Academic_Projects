package Mod1PA.Problem2;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John C Stelly
 * Completion date: 09/24/2020
 *
 * Polynomial.java
 */

import java.util.Arrays;

public class Polynomial {

    private int degree;
    private int[] coefficients;

    //constructor with arguments for both attributes
    public Polynomial(int degree, int[] coefficients) {
        if (coefficients == null) {
            this.coefficients = new int[1];
            this.degree = -1;
        }
        else {
            setDegree(degree);
            this.coefficients = coefficients;
        }
    }

    //method that adjusts the degree of the Polynomial if the value of the coefficients of the highest degree is zero
    public void adjustPoly(){
        if (coefficients[coefficients.length - 1] == 0) degree = degree - 1;

    }

    //accessor methods for degree and coefficients
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        if(degree < 0)
            this.degree = degree * -1;
        else
            this.degree = degree;
    }

    public int[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(int[] coefficients) {
        this.coefficients = coefficients;
    }

    public int evaluate(int x) {
        int[] tempArray = new int[coefficients.length];
        double temp = 0;

        for (int i = 0; i < coefficients.length; i++) {
            temp = temp + (coefficients[i] * Math.pow( x, i));
        }
        return (int) temp;
    }

    //Method that adds the current Polynomial object with a Polynomial p, and returns the sum of the two polynomials, as a Polynomial object
    public Polynomial addPoly(Polynomial p) {
        int[] tempArray;

        if (p.degree == -1)
            return this;
        else {
            if (degree > p.degree) {
                tempArray = new int[degree + 1];
                for (int i = 0; i < degree + 1; i++) {
                    if (i > p.degree)
                        tempArray[i] = p.coefficients[i];
                    if (i <= p.degree)
                        tempArray[i] = coefficients[i] + p.coefficients[i];
                }
                p = new Polynomial(p.degree, tempArray);
            }
            else if (degree < p.degree) {
                tempArray = new int[p.degree + 1];
                for (int i = 0; i < p.degree + 1; i++) {
                    if (i > degree)
                        tempArray[i] = p.coefficients[i];
                    if (i <= degree)
                        tempArray[i] = coefficients[i] + p.coefficients[i];
                }
                p = new Polynomial(degree, tempArray);
            }
            else {
                tempArray = new int[degree + 1];
                for (int i = 0; i < degree + 1; i++) {
                    tempArray[i] = coefficients[i] + p.coefficients[i];
                }
                p = new Polynomial(degree, tempArray);
            }
        }
        return p;
    }

    // Method that subtracts Polynomial p from the current object of type Polynomial
    public Polynomial subtractPoly(Polynomial p) {
        int[] tempArray;
        if (p.getDegree() <= 0)
            return this;
        else {
            if (degree > p.degree) {
                tempArray = new int[degree + 1];
                for (int i = 0; i < degree + 1; i++) {
                    if (i > p.degree)
                        tempArray[i] = p.coefficients[i];
                    if (i <= p.degree)
                        tempArray[i] = coefficients[i] - p.coefficients[i];
                }
                p = new Polynomial(p.degree, tempArray);
            }
            else if (degree < p.degree) {
                tempArray = new int[p.degree + 1];
                for (int i = 0; i < p.degree + 1; i++) {
                    if (i > degree)
                        tempArray[i] = p.coefficients[i];
                    if (i <= degree)
                        tempArray[i] = coefficients[i] - p.coefficients[i];
                }
                p = new Polynomial(degree, tempArray);
            }
            else {
                tempArray = new int[degree + 1];
                for (int i = 0; i < degree + 1; i++) {
                    tempArray[i] = coefficients[i] - p.coefficients[i];
                }
                p = new Polynomial(degree, tempArray);
            }
        }
        return p;
    }

    //Method that calculates the derivative of the current object of type Polynomial
    public Polynomial derivative() {
        int[] tempArray = new int[degree];
        for (int i = 1; i < degree + 1; i++) {
            int temp = coefficients[i] * i;
            tempArray[i - 1] = temp;
        }
        this.degree = degree - 1;
        Polynomial p = new Polynomial(degree, tempArray);
        return p;
    }

    //EQUALS METHOD
    public boolean equals(Polynomial p) {
        return  (Arrays.equals(this.coefficients, p.coefficients)) &&
                (this.degree == p.getDegree());
    }
    //TO STRING
    @Override
    public String toString() {
        String polyString = "";

        if (degree == -1)
            polyString = "" + coefficients[0];
        else
            adjustPoly();
        {
            for (int i = coefficients.length; i > 0; i--) {

                if (i ==  degree + 1) {
                    if (coefficients[i - 1] == 0)
                        polyString = polyString + "";
                    else
                        polyString = polyString + coefficients[i - 1]  + "x^" + degree;
                }
                else if (i < degree + 1 && i != 1){
                    if (coefficients[i-1] == 0)
                        polyString = polyString + "";
                    else if (coefficients[i-1] < 0)
                        polyString = polyString + coefficients[i - 1] + "x^" + (i-1);
                    else
                        polyString = polyString + "+" +coefficients[i - 1] + "x^" + (i-1);
                }
                else if (i == 1) {
                    if (coefficients[i-1] == 0)
                        polyString = polyString + "";
                    else if (coefficients[i-1] < 0)
                        polyString = polyString + coefficients[i - 1];
                    else
                        polyString = polyString + "+" + coefficients[i - 1];
                }
            }
        }
        return polyString;
    }
}

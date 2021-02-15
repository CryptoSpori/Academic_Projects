package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * AdjunctFaculty.java
 *
 * Driver for the inheritance application testing the inheritance, and
 * showing how polymorphism and dynamic binding works.
 *
 * Students have to run the program after building all classes
 *
 */
public class AdjunctFaculty extends Faculty {

    private double perCreditRate;
    private int noCredits;

    //Constructor Method
    public AdjunctFaculty(String name, int empID, String rank, int noCredits, double perCreditRate) {
        super(name, empID, rank);
        setNoCredits(noCredits);
        setPerCreditRate(perCreditRate);
    }

    //Accessor and mutator methods for perCreditRate
    public double getPerCreditRate() {
        return perCreditRate;
    }

    public void setPerCreditRate(double perCreditRate) {
        this.perCreditRate = perCreditRate;
    }

    //Accessor and mutator methods for noCredits
    public int getNoCredits() {
        return noCredits;
    }

    public void setNoCredits(int noCredits) {
        this.noCredits = noCredits;
    }

    //Implementation of both methods in the Payroll interface
    public double calculateMonthlyGrossPay()  {
        return  getNoCredits() * getPerCreditRate() / 2;
    }
    public void displayPayInfo() {
        System.out.println("Pay is done twice per semester");
        System.out.println("Pay per credit: " + getPerCreditRate());
        System.out.println("Period pay: " + calculateMonthlyGrossPay());
    }
}

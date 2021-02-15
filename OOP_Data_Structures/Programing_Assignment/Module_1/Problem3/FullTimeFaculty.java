package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * FullTimeFaculty.java
 *
 *
 */
public class FullTimeFaculty extends Faculty {

    private double salary;

    public FullTimeFaculty(String name, int empID, String rank, double salary) {
        super(name, empID, rank);
        setSalary(salary);
    }

    //Accessor and mutator methods for salary
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //implementation of both methods in the Payroll interface
    public double calculateMonthlyGrossPay()  {
        return getSalary() / 12;
    }

    public void displayPayInfo() {
        System.out.println("Pay is done on a yearly bases");
        System.out.println("Salary: " + getSalary());
        System.out.println("Period pay: " + calculateMonthlyGrossPay());
    }
}

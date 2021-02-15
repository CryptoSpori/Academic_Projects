package Mod1GA;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/26/2020
 *
 * Employee.java
 *
 * Driver for the inheritance application testing the inheritance, and
 * showing how polymorphism and dynamic binding works.
 *
 * Students have to run the program after building all classes
 *
 */

public class Employee extends Person {
    private int empID;
    public Employee() {
    }
    public Employee(String name, int empID) {
        super(name);
        this.empID = empID;
    }
    public int getEmpID() {
        return empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + "\nEmployee ID: " + empID + " ";
    }
}

package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * Employee.java
 *
 *
 */
public abstract class Employee extends Person {
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

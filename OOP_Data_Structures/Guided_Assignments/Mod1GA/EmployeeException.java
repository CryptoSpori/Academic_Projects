package Mod1GA;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/26/2020
 *
 * EmployeeException.txt - save as EmployeeException.java
 *
 * This class represents the blueprint for instantiating EmployeeException objects,
 * with the following attributes:
name: String
ssn: String
salary: double
 * and methos:
A constructor with no arguments that sets the attributes at default values
A constructor that passes values for all attributes
Accessor, mutator and display methods for each attribute
An equals method that has an object of type Employee as argument, and returns true if two employees have the same name, salary and sSN
 *
 * Students have to build the file from scratch
 */
public class EmployeeException
{
    //*** Task #1: define the instance variables
    private String name;
    private String ssn;
    private double salary;
    //*** Task #2: define constructor with no arguments
    public EmployeeException() {
        //this.name = "";
        //this.ssn = "";
        //this.salary = 0.00;
    }
    //*** Task #3: define constructor passing values for all arguments
    public  EmployeeException(String name, String ssn, double salary) {
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }
    //*** Tasks #4: define accessor, mutator, and write out methods for name attribute
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void showName  () {
        System.out.println("Name: " + name);
    }
    //*** Tasks #5: define accessor, mutator, and write out methods for sSN attribute
    //    Display the SSN as ddd-dd-dddd
    public  String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public void showSsn  () {
        System.out.println("SSN: " + ssn.substring(0,3) + "-" + ssn.substring(3,5) + "-" + ssn.substring(5,9));
    }
    //*** Tasks #6: define accessor, mutator, and write out methods for salary attribute
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void showSalary  () {
        System.out.println("Salary: $" + salary);
    }
    //*** Tasks #7: Define method writeOutput() that display all information about the employee.
    public void writeOutput() {
        showName();
        showSsn();
        showSalary();
    }
    //*** Tasks #8: Define equals method, having argument of type EmployeeException
    public boolean equals(EmployeeException testObject){
        return  (this.name.equalsIgnoreCase(testObject.name)) &&
                (this.ssn.equals(testObject.ssn)) &&
                (this.salary == testObject.salary);

    }
}
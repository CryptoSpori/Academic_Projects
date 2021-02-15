package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * Person.java
 *
 * Driver for the inheritance application testing the inheritance, and
 * showing how polymorphism and dynamic binding works.
 *
 * Students have to run the program after building all classes
 *
 */
public abstract class Person implements Payroll {
    private String name;
    public Person() {
        this.name = "";
    }
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "Name: " + name;
    }



}

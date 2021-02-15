package Mod1GA;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/26/2020
 *
 * Student.java
 *
 * Driver for the inheritance application testing the inheritance, and
 * showing how polymorphism and dynamic binding works.
 *
 * Students have to run the program after building all classes
 *
 */
public class Student extends Person {
    private int studentNumber;
    public Student(){
        super("");
        this.studentNumber = 0;

    }
    public  Student(String name, int studentNumber) {
        super(name);
        this.studentNumber = studentNumber;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + " \nStudentNumber: " + studentNumber;
    }
}

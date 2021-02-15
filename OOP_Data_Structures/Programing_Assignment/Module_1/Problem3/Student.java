package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * Student.java
 *
 *
 */
public abstract class Student extends Person {
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
        return "Name: " + super.getName() + " \nStudentNumber: " + getStudentNumber();
    }
}

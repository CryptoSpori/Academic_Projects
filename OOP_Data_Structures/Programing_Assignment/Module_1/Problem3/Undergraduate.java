package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * Undergraduate.java
 *
 *
 */
public abstract class Undergraduate extends Student {
    private String major;
    public Undergraduate() {
        super("",0);
        major = "";
    }
    public  Undergraduate(String name, int studentNumber, String major) {
        super(name, studentNumber);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString() {
        return "Name: " + super.getName() + "\nStudentNumber: " + super.getStudentNumber()  + "\nUndergraduate Major: " + major ;
    }
}

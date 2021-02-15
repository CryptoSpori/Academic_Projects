package Mod1GA;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/26/2020
 *
 * Faculty.java
 *
 * Driver for the inheritance application testing the inheritance, and
 * showing how polymorphism and dynamic binding works.
 *
 * Students have to run the program after building all classes
 *
 */
public class Faculty extends Employee{
    private  String rank;
    public Faculty() {
        this.rank = "";
    }
    public Faculty(String name, int empID, String rank) {
        super(name, empID);
        this.rank = rank;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    @Override
    public String toString() {
        return "Name: " + super.getName() + "\nEmployee ID: " + super.getEmpID() + "\nFaculty Rankrank: " + rank ;
    }
}

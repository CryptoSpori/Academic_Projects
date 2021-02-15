package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * Faculty.java
 *
 *
 */
public abstract class Faculty extends Employee {

    private  String rank;


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
        return "Name: " + super.getName() + "\nEmployee ID: " + super.getEmpID() + "\nFaculty Rank: " + getRank() ;
    }
}

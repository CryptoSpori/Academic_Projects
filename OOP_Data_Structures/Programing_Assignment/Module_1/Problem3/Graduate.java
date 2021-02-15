package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * Graduate.java
 *
 *
 */
public abstract class Graduate extends Student{

    private String department;

    public Graduate(String name, int studentNumber, String department) {
        super(name, studentNumber);
        setDepartment(department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + "\nStudentNumber: " + super.getStudentNumber()  + "\nDepartment: " + getDepartment()  ;
    }
}

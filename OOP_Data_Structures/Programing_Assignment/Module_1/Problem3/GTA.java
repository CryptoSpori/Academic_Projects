package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * GTA.java
 *
 */
public class GTA extends Graduate {

    //hourlySalary: double - holding the GTA salary position
    private double hourlySalary;
    private int weeklyHours;

    public GTA(String name, int studentNumber, String department, int weeklyHours, double hourlySalary) {
        super(name, studentNumber, department);
        setWeeklyHours(weeklyHours);
        setHourlySalary(hourlySalary);
    }

    //Accessor and mutator methods for hourlySalary
    public double getHourlySalary() {
        return hourlySalary;
    }
    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    //Accessor and mutator methods for weeklyHours
    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    //calculateMonthlyGrossPay(int weeklyHours): double
    public double calculateMonthlyGrossPay() {
        return getHourlySalary() * getWeeklyHours() * 4;
    }

    //displayPayInfo(): void
    public void displayPayInfo() {
        System.out.println("Pay is done on an hourly basis");
        System.out.println("Number of hours: " + getWeeklyHours());
        System.out.println("Pay per hour: " + getHourlySalary());
        System.out.println("Monthly salary: "  + calculateMonthlyGrossPay());
    }
}

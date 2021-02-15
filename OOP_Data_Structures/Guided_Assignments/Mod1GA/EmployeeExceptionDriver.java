package Mod1GA;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/26/2020
 *
 * EmployeeExceptionDriver.java
 *
 * This class represents the driver for the EmployeeException class.
 * The driver program uses an array that can hold up to 100 employees (
 * the array will be of EmployeeException type).
 * The user should be free to enter as many employees as needed.
 * The driver class should use two exception classes to signal the user that the SSN entered is not correct. * SSN needs to be entered as a  9-digit string without separators.
 */
import java.util.Scanner;
public class EmployeeExceptionDriver
{
    public static void main(String [] args)
    {
        //*** Task #1: define the variables required for the program
        EmployeeException[] employee = new EmployeeException[100];
        boolean enterEmployee = true;
        String enterEmployeeAnswer;
        int elementCount = 0;
        String name, ssn;
        double salary;
        //*** Task #2: define and instantiate variable of type Scanner to be able to read from
        Scanner kb1 = new Scanner(System.in);
        Scanner kb2 = new Scanner(System.in);
        Scanner kb3 = new Scanner(System.in);
        //*** Task #3: create a loop in which you enter the data for employee.
        try {
            while(enterEmployee) {
                System.out.println("[ENTER EMPLOYEE DATA]");
                //*** Task #5: read the name of the employee
                System.out.print("Enter employee name: ");
                name = kb1.nextLine();
                //*** Task #6: read the salary of the employee
                System.out.print("Enter employee salary: ");
                salary = kb2.nextDouble();
                //*** Task #7: read SSN using the exceptions blocks
                System.out.print("Enter employee SSN: ");
                ssn = kb1.nextLine();
                if (ssn.length() != 9)
                    throw new SSNLengthException();
                for (int i = 0; i < ssn.length(); i++) {
                    int temp = ssn.charAt(i);
                    if (temp < 48 || temp > 57)
                        throw new SSNStructureException();
                }
                //*** Task #4: inside the loop, instantiate each element of the array with the constructor
                employee[elementCount] = new EmployeeException(name, ssn, salary);
                elementCount++;
                System.out.println("Continue entering employees? (Y for Yes, or N for No)");
                //*** Task #8: ask the user if there are more employees to enter
                enterEmployeeAnswer = kb3.next();
                if(enterEmployeeAnswer.equalsIgnoreCase("y")) {
                    enterEmployee = true;
                }
                else {
                    enterEmployee = false;
                }
            }
        } catch(SSNLengthException e) {
            System.out.println(e);
        } catch(SSNStructureException e) {
            System.out.println(e);
        }
        //*** Task #9: calculate the average salary
        double average = averageSalary(employee, elementCount);
        //System.out.println(average);
        //*** Task #10: display the information about all employees with a note if their salary
        // is above average, under average or average.
        System.out.println("\n");
        for (int i = 0; i < elementCount; i++) {
            System.out.println("Employee #" + (i + 1));
            employee[i].writeOutput();
            if (employee[i].getSalary() == average) {
                System.out.println("Average");
            } else if (employee[i].getSalary() > average) {
                System.out.println("Above average");
            } else if (employee[i].getSalary() < average) {
                System.out.println("Below average");
            }
            System.out.println();
        }
        System.out.println("No more employees.");
    }
    public static double averageSalary(EmployeeException[] employee, int elementCount) {
        double average;
        double sum = 0;
        int count = 0;
        for (int i = 0; i < elementCount; i++) {
            sum = sum + employee[i].getSalary();
            count++;
            }
        average = sum / count;
        return average;
    }
}



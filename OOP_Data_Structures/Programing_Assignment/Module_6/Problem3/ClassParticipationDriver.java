package Mod6PA.Problem3;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/15/2020
 *
 * .java
 */
import java.util.Scanner;

public class ClassParticipationDriver {

    public static void main(String [] args)
    {
        ClassParticipation studentList = new ClassParticipation();
        Scanner kb = new Scanner(System.in);
        String studentName = "";
        System.out.println("Enter Student name. Type done when finished: ");
        while (!studentName.equalsIgnoreCase("done")) {
            studentName = kb.nextLine();
            if (!studentName.equalsIgnoreCase("done"))
                studentList.add(studentName);
        }

        System.out.println("Students seen on list:");
        System.out.println(studentList.toString());
    }
}

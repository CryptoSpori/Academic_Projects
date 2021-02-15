package Mod1PA.Problem3;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 10/01/2020
 *
 * Personnel.java
 *
 *
 */
public class Personnel
{
    //Create  a driver program similar to the one given in the guided assignment 3, named Personnel.java
    public static void main(String[] args)
    {

        //Define and instantiate three objects as follows:
        Payroll p1 = new GTA("Anna Smiley", 23234, "Science", 40, 20);
        Payroll p2 = new FullTimeFaculty("Jane Dane", 2343, "Lecturer", 49000);
        Payroll p3 = new AdjunctFaculty("Edward Stone", 121, "AssistantProfessor", 12, 950);

        //Display information about all object declared.
        System.out.println("Graduate Teaching Assistant Information \n");
        System.out.println(p1);
        p1.displayPayInfo();
        System.out.println("\nFull time faculty information:\n");
        System.out.println(p2);
        p2.displayPayInfo();
        System.out.println("\nAdjunct Faculty Information:\n");
        System.out.println(p3);
        p3.displayPayInfo();
    }
}


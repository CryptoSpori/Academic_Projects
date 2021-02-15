package Mod2GA.Program1;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-05
 *
 * Student name:   John Stelly
 * Completion date: 10/07/2020
 *
 * ValetParking.txt: template file of ValetParking.java
 *
 * The application will solve the valet parking into a narrow driveway.
 * Cars are parked as they come, and they will be released in the reverse order,
 * with last car in going out first.
 *
 * Student tasks: complete tasks specified in the file
 */

//*** Task #1: import the classes you need to solve this problem

import java.util.Scanner;
import java.util.Stack;

public class ValetParking
{
    public static void main(String [] args)
    {
        //*** Task #2: define and instantiate object you need to read from keyboard

        Scanner num = new Scanner(System.in);
        Scanner txt = new Scanner(System.in);

        //*** Task #3: 	ask the host how many cars can be parked in the driveway,
        //*				and save the value. Make the stack of reasonable size (less than 10)

        int numCars;

        do {
            System.out.print("Enter number parking spot available: ");
            numCars = num.nextInt();


            if (numCars > 10) System.out.println("Enter number less the 10!!");

        } while (numCars > 10);

        //*** Task #4: define a Stack object with elements of type String for the names of drivers
        //*				along with a String variable to hold the element of the stack

        Stack<String> carStack = new Stack<String>();

        //*** Task #5: 	create a loop in which you read the name of the driver
        //*   			and push the names into the stack

        String ownerNames;

        for (int i = 0; i < numCars; i++) {
            System.out.print("Enter name name for key tag : ");
            ownerNames = txt.nextLine();
            carStack.push(ownerNames);
        }

        //*** Task #6: 	display a message to signal that all cars are parked
        System.out.println("All cars are parked!");

        //*** Task #7:	as the party ends, display the name of the guest that has to exit
        //*				by taking the names out of the stack, until it is empty
        System.out.println("\nPlease come to pick up your car in the order displayed: \n\n");
        for (int i = 0; i < numCars; i++) {
            System.out.println("Hello, " + carStack.pop() + " please come to your car.\n");
        }
    }
}
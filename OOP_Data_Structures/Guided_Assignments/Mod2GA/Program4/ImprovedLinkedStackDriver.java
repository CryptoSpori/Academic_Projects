package Mod2GA.Program4;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-05
 *
 * Student name:   John Stelly
 * Completion date: 10/07/2020
 *
 *	ImprovedLinkedStackDriver.java: demonstrates the use of the new methods
 * 	from ImprovedLinkedStack class
 *
 * Student tasks: complete tasks specified in the file
 */

import java.util.Scanner;
public class ImprovedLinkedStackDriver
{
    public static void main(String[] args)
    {

        ImprovedLinkedStack<String> myStack;

        myStack = new ImprovedLinkedStack<String>();

        // prepare the Scanner object to enter data from the user
        Scanner input = new Scanner(System.in);
        String word="";

        // read words in a loop,

        while(!word.equalsIgnoreCase("end"))
        {
            System.out.print("Enter a fruit, or type end, if you want to stop: ");
            word=input.next();
            if(!word.equalsIgnoreCase("end"))
                myStack.push(word);
        }

        //*** Task #1: test method toString()

        System.out.println(myStack);


        //*** Task #2: test method toString()

        //*** Task #3: test method popSome(int count)
        //* pop three elements from the top of the stack
        //* display the resulting stack

        myStack.popSome(3);
        System.out.println("Remaining elements are: ");
        System.out.println(myStack);

        //*** Task #4: test method swapStart()
        //* and display the resulting stack

        myStack.swapStart();
        System.out.println("The stack after reversing the order of the top two elements is: ");
        System.out.println(myStack);

        //*** Task #5: test method poptop()

        System.out.println("Top element of the stack is: "+ myStack.poptop());
    }
}
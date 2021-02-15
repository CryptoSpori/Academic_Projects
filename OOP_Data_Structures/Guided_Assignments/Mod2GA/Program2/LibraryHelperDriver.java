package Mod2GA.Program2;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-05
 *
 * Student name:   John Stelly
 * Completion date: 10/07/2020
 *
 *	LibraryHelperDriver.java: demonstrates the use of LibraryHelper class
 *
 * Creates and pushes elements of type String in a stack,
 * Retrieves the elements, and counts the ones that have code starting with R or F
 *
 * Student tasks: complete tasks specified in the file
 */

import java.util.Scanner;

public class LibraryHelperDriver
{
    public static void main(String[] args)
    {
        //*** Task #1: define a libraryStack variable of type StackInterface with element type String
        //*** Task #2: instantiate the libraryStack of LibraryHelper type with 10 elements cap

        StackInterface<String> libraryStack = new LibraryHelper<String>(10);

        // prepare the Scanner object to enter data from the user
        Scanner input = new Scanner(System.in);
        String bookCode = "";

        //*** Task #3: in a create a loop in which you read book codes until user enters "end"

        boolean addCode = true;

        do {

            System.out.print("Enter the book code, or type end, if you want to stop: ");
            bookCode = input.nextLine();
            if (bookCode.equalsIgnoreCase("end"))
                addCode = false;
            else {
                libraryStack.push(bookCode);
            }

        } while (addCode);

        System.out.println("Retrieve the books, identify type, and put them in shelves.");

        //*** Task #4: define and initialize variables to count reference and fiction books

        int fictionCount = 0;
        int referenceCount = 0;

        //*** Task #5: pop the elements of the stack
        //			count the elements that start with 'r' and elements that start with 'f'
        // 			if the code starts with other letter, display a message announcing that
        //			the code is not classified
        String temp;
        while (!libraryStack.isEmpty()) {
            temp = libraryStack.top();
            System.out.println("Book code is: " + temp);
            if (temp.substring(0,1).equalsIgnoreCase("f"))
                fictionCount++;
            if (temp.substring(0,1).equalsIgnoreCase("r"))
                referenceCount++;
            if (temp.substring(0,1).equalsIgnoreCase("e"))
                System.out.println("Book code " + libraryStack.top() + "is not classified");
            libraryStack.pop();
        }
        //*** Task #6: display the number of refence book, and the number of fiction books

        System.out.println("We received " + referenceCount + " reference books!");
        System.out.println("We received " + fictionCount + " fiction books!");
    }
}
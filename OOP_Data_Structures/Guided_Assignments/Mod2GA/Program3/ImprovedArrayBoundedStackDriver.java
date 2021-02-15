package Mod2GA.Program3; /**
* @author EMILIA BUTU
* version 1.0
* since   2020-05
*
 * Student name:   John Stelly
 * Completion date: 10/07/2020
*
*	ImprovedArrayBoundedStackDriver.java: demonstrates the use of the new methods
* 	from ImprovedArrayBoundedStack class
*
* Student tasks: complete tasks specified in the file
*/

import java.util.Scanner;
public class ImprovedArrayBoundedStackDriver
{
	public static void main(String[] args)
	{

		ImprovedArrayBoundedStack<String> myStack;

		myStack = new ImprovedArrayBoundedStack<String>(10);

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
		int stackSize=myStack.size();
		System.out.println("The size of the stack is: " + stackSize);

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
		String topFruit=myStack.poptop();
		System.out.println("Top element of the stack is: "+topFruit);


	}
}
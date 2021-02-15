package Mod4GA.Problem4;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* CircularQueueDriver.: template file for CircularQueueDriver.java
* Implements the application for CircularQueueDriver class.
*
*/

import java.util.Scanner;

public class CircularQueueDriver
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		//*** Task #1: defime a queue with elements of type String using QueueInterface
		CircularQueue<String> fruitQueue;

		//*** Task #2: instantiate the queue using the constructor that provides the size, using a smaller number for test
		fruitQueue = new CircularQueue<>(3);

		//*** Task #3: enter the names of fruits that you like.
		//* allow the user to terminate the entry
		String fruit = "";
		while (!fruit.equalsIgnoreCase("done")) {
				System.out.print("Enter fruit name. Type done when finished: ");
				fruit = scan.nextLine();
				if (!fruit.equalsIgnoreCase("done"))
					fruitQueue.enqueue(fruit);

		}

		//*** Task #4: identify the number of elements in the queue and display it
		System.out.println("Number of elements in the queue: " + fruitQueue.size());

		//*** Task #5: display the list of students presents in the advising queue
		System.out.println("\nQueue content is: ");

		if (fruitQueue.isEmpty())
			System.out.println("No fruit here!!!!");
		else
			System.out.println(fruitQueue.toString());
	}
}


package Mod4GA.Problem1;
/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  John Stelly
* Completion date: 10/27/2020
*
* AdvisingSchedule_ArrayDriver.txt: template file of AdvisingSchedule_Array.java
* Implements the application for AdvisingSchedule_Array class, using queue.
* Outputs strings in same order of entry.
*/

import java.util.Scanner;

public class AdvisingSchedule_ArrayDriver
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		//*** Task #1: define a queue with elements of type String using QueueInterface
		AdvisingSchedule_Array<String> studentQueue;

		//*** Task #2: instantiate the queue using the constructor that provides the size, using a smaller number for test
		studentQueue = new AdvisingSchedule_Array<>(3);

		//*** Task #3: enter the names of students that ask for advising.
		//* allow the user to terminate the entry
		//* terminate the loop when the queue is full, and display appropriate message to signal it

		String studentName = "";

		while (!studentName.equalsIgnoreCase("done")) {
			if (studentQueue.isFull()) {
				System.out.println("There is no more spots available for advising!");
				studentName = "done";
			}
			else {
				System.out.print("Enter Student name. Type done when finished: ");
				studentName = scan.nextLine();
				if (!studentName.equalsIgnoreCase("done"))
					studentQueue.enqueue(studentName);
			}
		}

		//*** Task #4: identify the number of students in the advising queue and display it
		System.out.println("Number of students asking for advising: " + studentQueue.size());

		//*** Task #5: display the list of students presents in the advising queue

		System.out.println("Schedule students:");
		while (!studentQueue.isEmpty()) {
			studentQueue. displayQueue();
			studentQueue.dequeue();
		}
	}
}


package Mod4GA.Problem3;
/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* DequeueDriver.txt: template file for DequeueDriver.java
* Implements the application for Dequeue class.
*  
* Students need to complete the tasks as marked
*
*/
public class DequeueDriver
{
	public static void main(String[] args)
	{
		//*** Task #1: object of type Dequeue and instantiate it with integers
		// work with random numbers between 1 to 100
		// perform a number of dequeue operations

		Dequeue<Integer> numberQueue = new Dequeue<>();
		int numbers;

		//*** Task #2: perform insert at front followed by insert at rear three times
		for (int i = 0; i < 3; i++) {
			numbers = (int) (Math.random() * 100) + 1;
			numberQueue.enqueueFront(numbers);
		}
		for (int i = 0; i < 3; i++) {
			numbers = (int) (Math.random() * 100) + 1;
			numberQueue.enqueueRear(numbers);
		}
		System.out.println("Dequeue after inserting elements at front and at rear three times is: ");
		//*** Task #2: display dequeue
		numberQueue.display();

		//*** Task #3: delete at front
		int frontNumber = numberQueue.dequeueFront();
		System.out.println(frontNumber + " removed from front of queue.");

		//*** Task #4: display dequeue
		numberQueue.display();

		//*** Task #5: delete at rear
		int rearNumber = numberQueue.dequeueRear();
		System.out.println(rearNumber + " removed from rear of queue.");

		//*** Task #6: display dequeue
		numberQueue.display();


		//*** Task #7: display value at front
		System.out.println("Front element is: " + numberQueue.peekAtFront());

		//*** Task #8: display value at rear
		System.out.println("Rear element is " + numberQueue.peekAtRear());

		//*** Task #9: display size
		System.out.println("Dequeue size is: " + numberQueue.size());

		//*** Task #10: check if queue is empty
		System.out.println("Dequeue is an empty queue is " + numberQueue.isEmpty() + " statement.");

		//*** Task #11: clear dequeue and display message to announcing the operation
		numberQueue.clear();
		System.out.println("Dequeue has been cleared!");

		//*** Task #12: display resulting dequeue
		numberQueue.display();
	}
}
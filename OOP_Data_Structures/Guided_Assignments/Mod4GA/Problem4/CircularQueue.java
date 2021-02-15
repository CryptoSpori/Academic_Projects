package Mod4GA.Problem4;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* CircularQueue.txt: template file for CircularQueue.java
*
* Implements QueueInterface with an array to hold a circular queue elements .
*
* the circular queue is extending the capacity as needed
*/

public class CircularQueue<T> implements QueueInterface<T>
{
	protected final int DEFCAP = 100; 	// default capacity
	protected int oldMax;
	protected T[] queue;   	        	// array that holds queue elements
	protected int numElements = 0; 	   		// number of elements in this queue
	protected int front = 0;          		// index of front of queue
	protected int rear;               	// index of rear of queue

	public CircularQueue(int maxSize)
	{
			//*** Task #1: modify the constructor given above to reflect the use of argument for queue size
		queue = (T[]) new Object[maxSize];
		rear = maxSize - 1;
		this.oldMax = maxSize;
	}

	public void enqueue(T element)
	// adds the given element at the rear of the queue, which expands the queue capacity
	{
			//*** Task #2: implement the methods
		if (numElements == queue.length)
			expandCapacity();
		rear = (rear + 1) % queue.length;
		queue[rear] = element;
		numElements = numElements + 1;
	}

	private void expandCapacity()
	{
		// expand capacity to double the initial one
			//*** Task #3: implement the methods
		T[] larger = (T[]) new Object[queue.length + oldMax];
		int currSmaller = front;
		for (int currLarger = 0; currLarger < numElements; currLarger++) {
			larger[currLarger] = queue[currSmaller];
			currSmaller = (currSmaller + 1) % queue.length;
		}

		queue = larger;
		front = 0;
		rear = numElements - 1;


	}

	public T dequeue() throws QueueUnderflowException
	// throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	{
			//*** Task #4: add code here, taking into consideration the exception thrown
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue on empty queue!!");
		else {
			T toReturn = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			numElements = numElements - 1;
			return toReturn;
		}
	}

	public T first() throws QueueUnderflowException
	// throws QueueUnderflowException if this queue is empty;
	{
			//*** Task #5: add code here, taking into consideration the exception thrown
		return queue[front];
	}

	public boolean isEmpty()
	// Returns true if this queue is empty; otherwise, returns false.
	{
			//*** Task #6: implement the method
		return (numElements == 0);
	}

	public boolean isFull()
	// Returns true if this queue is full; otherwise, returns false.
	{
			//*** Task #7: implement the method
		return false;
	}

	public int size()
	// Returns the number of elements in this queue.
	{
			//*** Task #8: implement the method
		return numElements;
	}

	public String toString()
	{
		String result = "";
		int index = front;
		for (int scan = 0; scan < numElements; scan++)
		{
		    result = result+"\n"+queue[index];
		    index = (index + 1) % queue.length;
		}
		return result;
	}

}
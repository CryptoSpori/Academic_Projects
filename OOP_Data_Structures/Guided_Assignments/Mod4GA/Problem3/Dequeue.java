package Mod4GA.Problem3;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* Dequeue.txt: template file for Dequeue.java
* Implements DequeInterface using a linked list.
*  
* Students need to complete the tasks as marked
*
*/

public class Dequeue<T> implements DequeInterface<T>
{
	protected LLNode<T> front;     // reference to the front of this queue
	protected LLNode<T> rear;      // reference to the rear of this queue
	protected int size = 0; 	// number of elements in this queue

	// constructor
	public Dequeue()
	{
		//*** Task #1: implement default constructor
		front = null;
		rear = null;
	}

	public boolean isEmpty()
	// Returns true if this queue is empty; otherwise, returns false.
	{
		//*** Task #2: implement method
		if (size == 0)
			return true;
		else
			return false;
	}

	public boolean isFull()
	// Returns false - a linked queue is never full.
	{
		//*** Task #3: implement method
		return false;
	}

	public int size()
	// Returns the number of elements in this queue.
	{
		//*** Task #4: implement method
		return size;
	}

	public void clear()
	{
		//*** Task #5: implement method
		while (front != null) {
			if (isEmpty())
				throw  new QueueUnderflowException("");
			else {
				front = front.getLink();
				if (front == null)
					rear = null;
				size--;
			}
		}
	}

	// insert an element in the beginning
	public void enqueueFront(T element)
	// Adds element to the rear of this queue.
	{
		//*** Task #6: implement method
		LLNode<T> newNode = new LLNode<>(element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		size++;
	}

	// insert an element at the end

	public void enqueueRear(T element)
	// throws QueueOverflowException;
	// Throws QueueOverflowException if this queue is full;
	// otherwise, adds element to the rear of this queue.
	{
		//*** Task #7: implement method
		LLNode<T> newNode = new LLNode<>(element);
		if (front == null)
			rear = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		size++;
	}

	public T dequeueFront() throws QueueUnderflowException
	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	{
		//*** Task #8: implement method
		if (isEmpty())
			throw new QueueUnderflowException("");
		else
		{
			if (isEmpty())
				throw  new QueueUnderflowException("");
			else
			{
				T element = front.getData();
				front = front.getLink();
				if (front == null)
					rear = null;
				size--;
				return  element;
			}
		}
	}

	public T dequeueRear() throws QueueUnderflowException
	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes rear element from this queue and returns it.
	{
		//*** Task #9: implement method
		int tempSize = size;
		T element = rear.getData();
		int count = 0;
		if (isEmpty())
			throw new QueueUnderflowException("");
		else {
			while (count != tempSize) {
				if (count == tempSize - 1) {
					front = front.getLink();
					count++;
				}
				else if (count < tempSize - 1) {
					T temp = front.getData();
					front = front.getLink();
					count++;
					enqueueRear(temp);
				}
			}
			size = tempSize - 1;
		}
		return  element;
	}


	// method to check the front element of the queue
	public T peekAtFront()
	{
		//*** Task #10: implement method
		if(isEmpty())
			return null;
		else
			return front.getData();
	}

	// method to check the end element of the queue
	public T peekAtRear()
	{
		//*** Task #11: implement method
		if (isEmpty())
			return null;
		else
			return rear.getData();
	}

	// method to display the queue, giving a specific message if the queue is empty
	public void display()
	{
		//*** Task #12: implement method
		LLNode<T> currentFront = front;

		if (isEmpty()) {
			System.out.println("Queue is empty!!!");
		}
		else {
			while (currentFront != null){
				System.out.println(currentFront.getData());
				currentFront = currentFront.getLink();
			}
			System.out.println("Something here");
		}





	}





}



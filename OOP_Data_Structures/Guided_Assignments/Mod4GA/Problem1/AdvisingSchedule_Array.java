package Mod4GA.Problem1;
/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* AdvisingSchedule_Array.java
*
* Implements QueueInterface with an array to hold the queue elements.
*
* Two constructors are provided: one that creates a queue of a default
* capacity and one that allows the calling program to specify the capacity.
*/

public class AdvisingSchedule_Array<T> implements QueueInterface<T>
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array that holds queue elements
  protected int numElements = 0;    // number of elements in this queue
  protected int front = 0;          // index of front of queue
  protected int rear;               // index of rear of queue

  public AdvisingSchedule_Array()
  {
    elements = (T[]) new Object[DEFCAP];
    rear = DEFCAP - 1;
  }

  public AdvisingSchedule_Array(int maxSize)
  {
 		//*** Task #1: modify the constructor given above to reflect the use of argument for queue size
    elements = (T[]) new Object[maxSize];
    rear = maxSize - 1;
  }

  public void enqueue(T element)
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.
  {
		//*** Task #2: add code here, taking into consideration the exception thrown
    if (isFull())
      throw new QueueOverflowException("Enqueue on full queue!!");
    else {
      rear = (rear + 1) % elements.length;
      elements[rear] = element;
      numElements = numElements + 1;
    }
  }

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
		//*** Task #3: add code here, taking into consideration the exception thrown
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue on empty queue!!");
    else {
      T toReturn = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      numElements = numElements - 1;
      return toReturn;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {
		//*** Task #3: add code here
    return (numElements == 0);
  }

  public boolean isFull()
  // Returns true if this queue is full; otherwise, returns false.
  {
		//*** Task #4: add code here
    return (numElements == elements.length);
  }

  public int size()
  // Returns the number of elements in this queue.
  {
		//*** Task #4: add code here
    return numElements;
  }
  public void displayQueue() {
    System.out.println(elements[front]);
  }
}
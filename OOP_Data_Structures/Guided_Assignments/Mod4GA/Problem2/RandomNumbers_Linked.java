package Mod4GA.Problem2;

import Mod4PA.Program1.LLNode;
import Mod4PA.Program1.QueueInterface;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* RandomNumbers_LinkedDriver.txt: template file of RandomNumbers_.java
* Implements QueueInterface using a linked list.
*
* Students need to complete the tasks as marked
*/
//
//---------------------------------------------------------------------------

public class RandomNumbers_Linked<T> implements QueueInterface<T>
{
  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue

  public RandomNumbers_Linked()
  {
    front = null;
    rear = null;
  }

  public void enqueue(T element)
  // Adds element to the rear of this queue.
  {
		//*** Task #1: implement the method, using LLNode type objects defined with LLNode class, which is given
    LLNode<T> newNode = new LLNode<>(element);
    if (rear == null)
      front = newNode;
    else
      rear.setLink(newNode);
    rear = newNode;
    numElements++;
  }

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
 		//*** Task #2: implement the method, using LLNode type objects defined with LLNode class
 		//*   if the queue is empty, throw the appropriate exception
        if (isEmpty())
          throw  new QueueUnderflowException("");
        else
        {
          T element;
          element = front.getInfo();
          front = front.getLink();
          if (front == null)
            rear = null;
          numElements--;
          return  element;
        }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {
 		//*** Task #3: implement the method
       return (numElements == 0);

  }

  public boolean isFull()
  // Returns false - a linked queue is never full.
  {
 		//*** Task #4: implement the method
        return false;

  }

  public int size()
  // Returns the number of elements in this queue.
  {
 		//*** Task #5: implement the method
        return numElements;

  }
}


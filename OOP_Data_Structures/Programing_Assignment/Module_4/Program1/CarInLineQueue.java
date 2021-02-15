package Mod4PA.Program1;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/01/2020
 *
 * CarInLineQueue.java
 */
public class CarInLineQueue<T>  implements QueueInterface<T>  {

    protected LLNode<T> front;
    protected LLNode<T> rear;
    protected int numElements = 0;

    public CarInLineQueue() {
        front = null;
        rear = null;
    }


    @Override
    public void enqueue(T element) throws QueueOverflowException {
        LLNode<T> newNode = new LLNode<>(element);
        if (rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        numElements++;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty())
            throw  new QueueUnderflowException("");
        else {
            T element;
            element = front.getInfo();
            front = front.getLink();
            if (front == null)
                rear = null;
            numElements--;
            return  element;
        }
    }

    public T peekAtFront()
    {
        if(isEmpty())
            return null;
        else
            return front.getInfo();
    }

    public T peekAtRear()
    {

        if (isEmpty())
            return null;
        else
            return rear.getInfo();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    @Override
    public int size() {
        return numElements;
    }

    public void setSize(int num) {
        numElements = num;

    }


}

package Mod4PA.Program3;

public class PalindromeQueue<T> implements QueueInterface<T>{

    protected final int DEFCAP = 100;
    protected T[] elements;
    protected int numElements = 0;
    protected int oldNumElements = 0;
    protected int front = 0;
    protected int rear;

    public PalindromeQueue() {
        elements = (T[]) new Object[DEFCAP];
        rear = DEFCAP - 1;
        this.oldNumElements = DEFCAP;
    }

    public PalindromeQueue(int maxSize) {
        elements = (T[]) new Object[maxSize];
        rear = maxSize - 1;
        this.oldNumElements = maxSize;
    }

    private void expandCapacity()
    {
        T[] larger = (T[]) new Object[elements.length + oldNumElements];
        int currSmaller = front;
        for (int currLarger = 0; currLarger < numElements; currLarger++) {
            larger[currLarger] = elements[currSmaller];
            currSmaller = (currSmaller + 1) % elements.length;
        }
        elements = larger;
        front = 0;
        rear = numElements - 1;
    }

    @Override
    public void enqueue(T element)  {
        if (numElements == elements.length)
            expandCapacity();
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        numElements = numElements + 1;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
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

    public T peekFront() {
        if (isEmpty())
            throw new QueueUnderflowException("Peek on empty queue!!");
        else {
            T toReturn = elements[front];
            return toReturn;
        }
    }

    public T peekRear() {
        if (isEmpty())
            throw new QueueUnderflowException("Peek on empty queue!!");
        else {
            T toReturn = elements[rear];
            return toReturn;
        }
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
}
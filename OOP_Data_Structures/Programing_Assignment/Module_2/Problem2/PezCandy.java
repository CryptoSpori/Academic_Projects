package Mod2PA.Problem2;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date 10/11/2020:
 *
 * PezCandy.java
 */
public class PezCandy<T> implements StackInterface<T> {

    protected final int DEFCAP = 12;  // default capacity
    protected T[] elements;           // holds stack elements
    protected int topIndex = -1;      // index of top element in stack

    public PezCandy()
    {
        elements = (T[]) new Object[DEFCAP];
    }

    public PezCandy(int maxSize)
    {
        elements = (T[]) new Object[maxSize];
    }

    @Override
    // Throws StackOverflowException if this stack is full,
    // otherwise places element in to this stack.
    public void push(T element) throws StackOverflowException {
        if (isFull())
            throw new StackOverflowException("Push attempted on full stack");
        else {
            topIndex++;
            elements[topIndex] = element;
        }
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    @Override
    public void pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackOverflowException("Pop attempted on empty stack");
        else {
            elements[topIndex] = null;
            topIndex--;
        }
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    @Override
    public T top() throws StackUnderflowException {
        T topOfStack = null;
        if (isEmpty())
            throw  new StackUnderflowException("Top attempt on empty stack");
        else
            topOfStack = elements[topIndex];
        return topOfStack;
    }

    // Returns true if this stack is empty, otherwise returns false.
    @Override
    public boolean isEmpty() {
        return (topIndex == -1);
    }

    // Returns true if this stack is empty, otherwise returns false.
    @Override
    public boolean isFull() {
        return (topIndex == (elements.length - 1));
    }

    // Returns size of this stack.
    public int size() {
        return elements.length;
    }

    //TOSTRING method output data in stack
    public String toString() {
        System.out.println("Candy stack:");
        for (int i = 0; i < topIndex + 1; i++) {
            System.out.println(elements[i]);
        }
        return "";
    }
}

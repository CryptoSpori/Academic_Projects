package Mod2GA.Program2;

/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-05
 *
 * Student name:   John Stelly
 * Completion date: 10/07/2020
 *
 *	LibraryHelper.txt: save it as LibraryHelper.java
 * 	Implements StackInterface using an array to hold the stack elements.
 *
 *	Two constructors are provided: one that creates an array of a
 *	default size and one that allows the calling program to
 *	specify the size.
 *
 * 	Student tasks: complete tasks specified in the file
 */

public class LibraryHelper<T> implements StackInterface<T>
{
    protected final int DEFCAP = 100; // default capacity
    protected T[] elements;           // holds stack elements
    protected int topIndex = -1;      // index of top element in stack

    public LibraryHelper()
    {
        elements = (T[]) new Object[DEFCAP];
    }

    public LibraryHelper(int maxSize)
    {
        //*** Task #1: implement this constructor
        elements = (T[]) new Object[maxSize];
    }

    public void push(T element)
    // Throws StackOverflowException if this stack is full,
    // otherwise places element at the top of this stack.
    {
        //*** Task #2: implement this method throwing the right exception if necessary
        if (isFull())
            throw new StackOverflowException("Push attempted on full stack");
        else {
            topIndex++;
            elements[topIndex] = element;
        }
    }

    public void pop()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    {
        if (isEmpty())
            throw new StackOverflowException("Push attempted on empty stack");
        else {
            elements[topIndex] = null;
            topIndex--;
        }
    }

    public T top()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    {
        //*** Task #4: implement this method throwing the right exception if necessary
        T topOfStack = null;
        if (isEmpty())
            throw  new StackUnderflowException("Top attempt on empty stack");
        else
            topOfStack = elements[topIndex];
        return topOfStack;
    }

    public boolean isEmpty()
    // Returns true if this stack is empty, otherwise returns false.
    {
        //*** Task #5: implement this method
        return (topIndex == -1);
    }

    public boolean isFull()
    // Returns true if this stack is full, otherwise returns false.
    {
        //*** Task #6: implement this method
        return (topIndex == (elements.length - 1));
    }
}
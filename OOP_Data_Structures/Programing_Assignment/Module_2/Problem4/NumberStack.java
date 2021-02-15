package Mod2PA.Problem4;

import Mod2PA.Problem3.LLNode;

/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date 10/11/2020:
 *
 * ReverseCharacters.java
 */

public class NumberStack<T> implements StackInterface<T> {

    protected final int DEFCAP = 100; // default capacity
    protected T[] elements;           // holds stack elements
    protected int topIndex = -1;      // index of top element in stack

    public NumberStack()
    {
        elements = (T[]) new Object[DEFCAP];
    }

    public NumberStack(int maxSize)
    {

        elements = (T[]) new Object[maxSize];
    }

    @Override
    public void push(T element)  {
        if (isFull())
            throw new StackOverflowException("Push attempted on full stack");
        else {
            topIndex++;
            elements[topIndex] = element;
        }
    }

    @Override
    public void pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackOverflowException("Pop attempted on empty stack");
        else {
            elements[topIndex] = null;
            topIndex--;
        }
    }

    @Override
    public T top() throws StackUnderflowException {
        T topOfStack = null;
        if (isEmpty())
            throw  new StackUnderflowException("Top attempt on empty stack");
        else
            topOfStack = elements[topIndex];
        return topOfStack;
    }

    @Override
    public boolean isEmpty() {
        return (topIndex == -1);
    }

    @Override
    public boolean isFull() {
        return (topIndex == (elements.length - 1));
    }

    public String toString() {
        //String s;
        {
            System.out.println("The stack contains");
            System.out.print("[");
            for (int i = topIndex; i >= 0; i--) {
                System.out.print(elements[i] + ", ");
            }
            System.out.print("]");
        }
        return "";
    }
}

package Mod2GA.Program4;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-03
 *
 * Student name:   John Stelly
 * Completion date: 10/07/2020
 *
 *	ImprovedLinkedStack.txt: download and save as ImprovedLinkedStack.java
 * 	Tasks are marked throughout the file
 *
 * 	Student tasks: complete tasks specified in the file
 *
 */

public class ImprovedLinkedStack<T> implements StackInterface<T>
{
    protected LLNode<T> top;   // reference to the top of this stack

    public ImprovedLinkedStack()
    {
        top = null;
    }

    public void push(T element)
    // Places element at the top of this stack.
    {
        LLNode<T> newNode = new LLNode<T>(element);
        newNode.setLink(top);
        top = newNode;
    }

    public void pop()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    {
        if (isEmpty())
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        else
            top = top.getLink();
    }

    public T top()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    {
        if (isEmpty())
            throw new StackUnderflowException("Top attempted on an empty stack.");
        else
            return top.getData();
    }

    public boolean isEmpty()
    // Returns true if this stack is empty, otherwise returns false.
    {
        return (top == null);
    }

    public boolean isFull()
    // Returns false - a linked stack is never full
    {
        return false;
    }

    //*** Task #1: define method toString(): String
    //*	creates and returns a string that correctly represents the current stack.

    public String toString()
    {
        String s;
        if (top == null)
            s = "stack is empty";
        else {
            s = "stack contains: ";
            LLNode<T> temp = top;
            while (temp != null) {
                s = s + "\n\t" + temp.getData();
                temp = temp.getLink();
            }
        }
        return s;
    }

    //*** Task #2: define method size(): int
    //*	returns a count of how many items are currently on the stack.

    public int size()
    // returns a count of how many elements are on the stack
    {
        int i = 0;
        LLNode<T> temp = top;
        while (temp != null) {
            i++;
            temp = temp.getLink();
        }
        return i;
    }

    //*** Task #3: define method  popSome(int count): void
    //*	removes the top count elements from the stack

    public void popSome(int count)
    // if possible, removes top count elements from stack;
    // otherwise throws StackUnderflowException
    {
        if (isEmpty())
            throw new Mod2GA.Program3.StackUnderflowException("Pop attempted on empty stack");
        else {
            for (int i = 0; i < count; i++)
                pop();
        }
    }

    //*** Task #4: define method  swapStart(): boolean
    //*	 if there are less than two elements on the stack returns false;
    //*	 otherwise it reverses the order of the top two elements on the stack and returns true

    public boolean swapStart()
    // if possible, reverses order of top 2 elements and returns true;
    // otherwise returns false
    {
        if (top == null)
            return false;
        else
        {
            T temp1 = top();
            pop();
            T temp2 = top();
            pop();
            push(temp1);
            push(temp2);
        }
        return true;
    }
    //*** Task #5: define method poptop( ): T
    //*	 the “classic” pop operation, if the stack is empty it throws StackUnderflowException;
    //*	 otherwise it both removes and returns the top element of the stack.


    public T poptop()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes and returns top element from this stack.
    {
        T temp;
        if (isEmpty())
            throw new StackUnderflowException("Pop attempted on empty stack");
        else {
            temp = top();
            pop();
        }
        return  temp;
    }
}


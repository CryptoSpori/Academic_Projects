package Mod2PA.Problem3;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/10/2020
 *
 * ExamPaperStack.java
 */
public class ExamPaperStack<T> implements StackInterface<T>{

    protected LLNode<T> top;   // reference to the top of this stack

    //Constructor
    public ExamPaperStack()
    {
        top = null;
    }

    // Places element at the top of this stack.
    public void push(T element)
    {
        LLNode<T> newNode = new LLNode<T>(element);
        newNode.setLink(top);
        top = newNode;
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    public void pop()
    {
        if (isEmpty())
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        else
            top = top.getLink();
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    public T top()
    {
        if (isEmpty())
            throw new StackUnderflowException("Top attempted on an empty stack.");
        else
            return top.getData();
    }

    // Returns true if this stack is empty, otherwise returns false.
    public boolean isEmpty()

    {
        return (top == null);
    }

    // Returns false - a linked stack is never full
    public boolean isFull()

    {
        return false;
    }

    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes and returns top element from this stack.
    public T poptop()
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

    //Returns size of stack
    public int size() {
        int i = 0;
        LLNode<T> temp = top;
        while (temp != null) {
            i++;
            temp = temp.getLink();
        }
        return i;
    }

    //To Sting Method for printing classes
    public String toString() {
        String s;
        if (top == null)
            s = "stack is empty";
        else {
            s = "Stack contains: ";
            LLNode<T> temp = top;
            while (temp != null) {
                s = s + "\n\t" + temp.getData();
                temp = temp.getLink();
            }
        }
        return s;
    }
}

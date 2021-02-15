package Mod4PA.Program2;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/31/2020
 *
 * CipherQueue.java
 */

public class CipherQueue<T> implements QueueInterface<T>{

    protected LLNode<T> front;
    protected LLNode<T> rear;
    protected int numElements = 0;
    protected int cipherCount = 0;

    int[] cipherKey;

    public CipherQueue() {
        front = null;
        rear = null;
    }

    @Override
    public void enqueue(T element)  {
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
            throw  new QueueUnderflowException("Dequeue from empty queue !!!");
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

    public void loadKey(int[] cipherKey) {
        this.cipherKey = cipherKey;
    }

    //Special enqueue method that encodes message and passes new message to normal  enqueue()
    public void cipherEnqueue(T element)  {
       if (cipherCount > 6)
           cipherCount = 0;
       int keyValue = cipherKey[cipherCount];
        int temp =  (int) Character.valueOf((char) element);
        int conversion = temp + keyValue;
        char returnChar = (char) conversion;
        element = (T) Character.valueOf(returnChar);
        enqueue(element);
        cipherCount++;
    }

    //Special dequeue method that dequeues encoded message stored linked-list and decodes before returning stored values
    public T cipherDequeue() {
        T element;
        element = dequeue();
        if (cipherCount > 6)
            cipherCount = 0;
        int keyValue = cipherKey[cipherCount];

        int temp =  (int) Character.valueOf((char) element);
        int conversion = temp - keyValue;
        char returnChar = (char) conversion;
        element = (T) Character.valueOf(returnChar);
        //int num = (int) element;

        cipherCount++;
        return  element;
    }

    public void display()
    {
        LLNode<T> currentFront = front;
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
        }
        else {
            while (currentFront != null){
                char temp = (Character) currentFront.getInfo();
                //int temp = (Integer) currentFront.getInfo();
                System.out.print((char) temp);
                currentFront = currentFront.getLink();
            }
            System.out.println();
        }
    }
}

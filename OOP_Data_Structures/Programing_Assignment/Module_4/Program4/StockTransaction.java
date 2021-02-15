package Mod4PA.Program4;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/01/2020
 *
 * StockTransaction.java
 */
public class StockTransaction<T> implements QueueInterface<T> {

    protected LLNode<T> front;
    protected LLNode<T> rear;
    protected int numElements = 0;

    private int shares;

    public StockTransaction() {
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
    public T dequeue() {
        if (isEmpty())
            throw new QueueUnderflowException("Dequeue from empty queue !!!");
        else {
            T element;
            element = front.getData();
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

    public void buy(Stock s) {
        this.shares = shares +  s.getShares();
        System.out.println("You bought " + s.getShares() + " shares at $" + s.getCost() + " each.");
        enqueue((T) s);
    }

    public void sell(Stock s) {
        if (shares == 0)
            System.out.println("You have no shares to sell!");
        else {
            Stock pulled = (Stock) dequeue();

            double change = (s.getCost() - pulled.getCost());
            this.shares = shares +  (- pulled.getShares());
            System.out.print("You sold " + s.getShares() + " shares at $" + s.getCost() + " each ");
            System.out.printf(" at a gain/loss of $ %5.2f",  (change * s.getShares()));
            System.out.println();
        }
    }


    public void display()
    {
        LLNode<T> currentFront = front;
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
        }
        else {
            while (currentFront != null){
                System.out.println(currentFront.getData());
                currentFront = currentFront.getLink();
            }
        }
    }
}

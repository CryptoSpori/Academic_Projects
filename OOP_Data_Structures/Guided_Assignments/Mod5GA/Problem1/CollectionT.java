package Mod5GA.Problem1;
/**
 * @author Yingjin Cui
 * version 1.0
 * since   2020-03-30
 *
 * Student name:  xxxxx
 * Completion date: xxxx
 *
 * CollectionT.txt: the template file of CollectionT.java
 * Student tasks: implement tasks #1, #2 and #3 as specified in this file
 */

public class CollectionT<T> implements CollectionInterface<T>{
    private int SIZE = 10;
    private T[] data;
    private int count = 0;
    protected boolean found;
    protected int location;

    public CollectionT(){
        data = (T[])new Object[SIZE];
    }

    public CollectionT(int size){
        data = (T[])new Object[size];
    }

    public void add(T elements){
        // *** Student task #1 ***
      /*
      Requirements: if the collection is full then double the array size before adding operation
       *** Enter your code below ***
     */
        if (isFull())
            expandCapacity();
        data[count] = elements;
        count++;
    }

    public void add(T elements, int index) {
        if (index > count) {
            if (isFull())
                expandCapacity();
            data[index] = elements;
        }
    }

    public T get(T elements){
        find(elements);
        if (found)
            return data[location];
        else
            return null;
    }

    public T get(int index) {
       if (index < 0 || index >= count)
           return null;
       else
           return data[index];
    }

    public boolean contains(T elements){
        return indexOf(elements) != -1;
    }

    public int remove(T elements){
        // *** Student task #3 ***
      /*
      Requirements:
      Removes all elements from this collection such that each of them equals to ele [equals(ele) returns true]
      and returns the number of elements being removed.

       *** Enter your code below ***
     */
        find(elements);
        if (found) {
            data[location] = data[count - 1];
            data[count - 1] = null;
            count--;
            return 1;
        }
        return  0;
    }

    public boolean remove(int index){

        // *** Student task #2 ***
      /*
      Requirements: Removes the element at index position, if index<size() returns true after removing, otherwise, returns false

       *** Enter your code below ***
     */
        if (count > index) {
            data[index] = data[count - 1];
            data[count - 1] = null;
            count--;
            return true;
        }
        else
            return false;
    }

    public int indexOf(T elements){
        for(int i=0; i<count; i++){
            if(data[i].equals(elements)){
                return i;
            }
        }
        return -1;
    }

    public boolean isFull(){
        return count == data.length;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int size(){
        return count;
    }

    public void print(){
        String tmp="";
        for(int i=0; i<count; i++){
            tmp += data[i].toString()+", ";
        }
        if(tmp.length()>0){
            tmp = tmp.substring(0, tmp.length() -2);
        }
        System.out.println("["+tmp+"]");
    }

    //HELPER METHODS
    private void find(T elements) {
        location = 0;
        found = false;
        while (location < count) {
            if (data[location].equals(elements)) {
                found = true;
                return;
            }
            else {
                location++;
            }
        }
    }

    private void expandCapacity() {
        // expand capacity to double the initial one
        //*** Task #3: implement the methods
        T[] larger = (T[]) new Object[SIZE * 2];
        int currSmaller = 0;
        for (int currLarger = 0; currLarger < count; currLarger++) {
            larger[currLarger] = data[currSmaller];
            currSmaller = (currSmaller + 1) % data.length;
        }
        data = larger;
    }
}


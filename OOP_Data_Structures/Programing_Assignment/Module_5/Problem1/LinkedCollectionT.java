package Mod5PA.Problem1;

import java.nio.channels.WritePendingException;

/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* LinkedCollectionT.txt: the template file of LinkedCollectionT.java
* Student tasks: implement tasks #1-#6 as specified in this file
*
* Note: A link-based implementation of our unsorted Collection ADT
* In this implementation, duplicate elements are allowed
*/

public class LinkedCollectionT<T> implements CollectionInterface<T>{

   //You are NOT allowed to add other instance variables for this class!
   private LLNode<T> head;
   private int numElements ;

   public LinkedCollectionT(){
      head=null;
      numElements = 0;
   }
   
   public void add(T ele){
      // *** Student task #1 ***
      /* 
      Requirements: 
      Theoretically, a linked list node implementation has no capacy limit.
      Because it is unsorted, you may simply append a new element to the end of the collection
 
       *** Enter your code below *** 
     */
      LLNode<T> newNode = new LLNode<T>(ele);
      T target = find(ele);
      if (target == null) {
         newNode.setNext(head);
         head = newNode;
         numElements++;
      }
  }

   public int remove(T ele){
      // *** Student task #2 ***
      /* 
      Requirements: 
      Removes all elements from this collection such that each of them equals to ele [equals(ele) returns true]
      and returns the number of elements being removed.
       *** Enter your code below *** 
     */
       T temp = find(ele);

       if (temp == null) {
          return 0;
       }
       else {
          head = head.getNext();
          numElements--;
          return 1;
       }
   }
   
   public boolean isFull(){
      // *** Student task #3 ***
      /* 
      Note: Theoretically, a linked list node implementation has no capacy limit

       *** Enter your code below *** 
     */
      return false;
   }

   public boolean isEmpty(){

      // *** Student task #4 ***  

      /* 
      Requirements: 
      To check if the collection list is empty

       *** Enter your code below *** 
     */
      return (numElements == 0);
   }

   public int size(){
 
      // *** Student task #5 ***  

      /* 
      Requirements: 
      To return the number of items in the collection list

       *** Enter your code below *** 
     */

      return numElements;
   }

   public T find(T ele){
        LLNode<T> tmp=head;
        while(tmp != null){
            if(tmp.getData().equals(ele)) {
                Word tempWord = (Word) tmp.getData();
                tempWord.increaseFrequency();
                tmp.setData((T) tempWord);
                return tmp.getData();
            }

            tmp = tmp.getNext();
        }
        return null;
   }

   public void sort(){
      //Use quick sort to sort the lememnts
      //get all elements in the collection and put them into an array,
      //then call quick sort to sort the array. After sorintg restore the collection
      T[] arr=(T[])new Object[size()];
      LLNode<T> tmp=head;
      for(int i=0; i<arr.length; i++){
         arr[i]=tmp.getData();
         tmp=tmp.getNext();
      }
      new QuickSort<T>().quickSort(arr);
      //restore the collection;
      head=null;

       for(int i=arr.length - 1; i>-1; i--){
           add(arr[i]);
       }
   }

   public void print(){
      String res="";
      LLNode<T> tmp=head;
      while(tmp!=null){
         res += tmp.getData().toString()+", ";
         tmp = tmp.getNext();
      }
      if(res.length()>0){
         res = res.substring(0, res.length() -2);
      }
      System.out.println("["+res+"]");
   }
}























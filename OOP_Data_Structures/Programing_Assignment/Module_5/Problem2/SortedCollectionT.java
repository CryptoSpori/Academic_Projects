package Mod5PA.Problem2;

import Mod5PA.Problem1.QuickSort;
import Mod5PA.Problem1.Word;

/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* SortedCollectionT.txt: the template file of SortedCollectionT.java
* Student tasks: implement tasks #1 and #2 as specified in this file
*
* A link-based implementation of our sorted Collection ADT
* In this implementation, duplicate elements are not allowed
*/

public class SortedCollectionT<T> implements SortedCollectionInterface<T>{

   private LLNode<T> head;
   private int numElements = 0;

   public SortedCollectionT(){
      head=null;
   }
   
   public void add(T ele){
      // *** Student task #1 ***
      /* 
      Requirements: 
      If the collection is full then double the array size before adding
      However, theoretically, a linked list node implementation has no capacy limit.
      In this implementation, duplicate elements are not allowed

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
   
   public void remove(T ele){
      // *** Student task #2 ***  

      /* 
      Requirements: 
      Removes the element e from this collection such that e.equals(ele)

       *** Enter your code below *** 
     */
      T temp = find(ele);
      if (temp != null) {
         head = head.getNext();
         numElements--;
      }
   }
   
   public boolean isFull(){
      return false;
   }

   public boolean isEmpty(){
      return head==null;
   }

   public int size(){
      LLNode<T> tmp=head;
      int count=0;
      while(tmp !=null){
         tmp=tmp.getNext();
         count++;
      }
      return count;
   }
   
   public T find(T ele){
      LLNode<T> tmp=head;
      while(tmp != null){
         if(tmp.getData().equals(ele))
            return tmp.getData();
         tmp = tmp.getNext();
      }
      return null;
   }

   public void sort(){
      T[] arr=(T[])new Object[size()];
      LLNode<T> tmp=head;
      for(int i=0; i<arr.length; i++){
         Word tempWord = (Word) tmp.getData();
         tempWord.increaseFrequency();
         tmp.setData((T) tempWord);
         arr[i]=tmp.getData();
         tmp=tmp.getNext();
      }
      new MergeSort<T>().mergeSort(arr);
      head=null;
//      for(int i=0; i<arr.length; i++){
//         add(arr[i]);
//      }
      for(int i=arr.length - 1; i>0; i--){
         add(arr[i]);
      }
   }

   public void clear(){
      while(head!=null){
         head = head.getNext();
         numElements--;
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

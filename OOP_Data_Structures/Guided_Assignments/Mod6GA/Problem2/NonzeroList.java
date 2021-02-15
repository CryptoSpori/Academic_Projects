package Mod6GA.Problem2;

import javax.xml.crypto.Data;

/**
* @author YINGJIN CUI
* version 1.0
* since   2020-03 
*
* Student name:  John Stelly
* Completion date: 11/11/2020
*
* NonzeroList.txt: the template file of NonzeroList.java
* Student task: complete tasks #1 and #2 as specified in this file
*/

public class NonzeroList{
   private int[] data;
   private int index;   //the location where new data will be added to the array.
   private int numberOfElements;
   
   public NonzeroList(int cap){
      data = new int[cap];
      index=numberOfElements=0;
   }
   
   public void add(int num){
      	// *** Student task #1 ***
      	/*
	Requirements:
        -if num is zero, print message saying that zero is not allowed in a nonzerolist
        -if it is full, display message "The NonzeroList is full."

        *** Enter your code below *** 
	*/
      if (num == 0) {
         System.out.println("Zero is not allowed in a nonzerolist");
      }
      else if (isFull()){
         System.out.println("The NonzeroList is full");
      }
      else {
         data[index] = num;
         index++;
         numberOfElements++;
      }
   }
   
   public void removeData(int target){

      // *** Student task #2 ***  

      	/* 
	Requirements: 
      	-Remove the first occurrence of the target value in the NonzeroList
      	-Move the last item in the NonzeroList to the above position. 
	-You may shift after the removed item but it's not sufficient. The big-O of Moving the last item to the
      	  removed target location if O(1), while complexity of shifting algorithm is O(N)-
      	  Can you figure out why?
      	-If the target value does not exist, print message: "Target value does not exist."

       	*** Enter your code below *** 
     	*/

      int indexFound = indexOf(target);

      if (indexFound == -1){
         System.out.println("Target value does not exist");
      }
      else if (indexFound < index){
         int level = indexFound;
         while (level < numberOfElements) {
            data[indexFound] = data[indexFound + 1];
            level++;


         }
         numberOfElements--;
         index--;
      }
      else {
         data[indexFound] = 0;
         numberOfElements--;
      }
   }
   
   public int indexOf(int target){ // return the index of the first occurrence of target in the data array
      for(int i=0; i<numberOfElements; i++){
         if(data[i]==target)
            return i;
      }
      return -1; // not found
   }

   public boolean isFull(){
      return numberOfElements==data.length;
   }

   public boolean isEmpty(){
      return numberOfElements==0;
   }

   public int size(){
      return numberOfElements;
   }

   public void print(){
      System.out.print("[");
      for(int i=0; i<numberOfElements; i++){
         System.out.print(data[i]);
         if(i<numberOfElements-1)
            System.out.print(", ");
      }
      System.out.println("]");
   }

}

package Mod6GA.Problem3;
/**
* @author YINGJIN CUI
* version 1.0
* since   2020-03-23 15:01
*
* Student name:  John Stelly
* Completion date: 11/11/2020
*
* NonzeroList.txt: the template file of NonzeroList.java
* Student task:  implement tasks #1, #2 and #3 as specified in this file
*/

public class NonzeroList{
   private int[] data;
   private int index; //the location where new data will be added to the array.
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
      	-if the number is duplicate, display message "This number is in the list. A duplicated number can't be added to the list."
      	-num is inserted into the list so that the list is sorted in ascending order
       *** Enter your code below *** 
      */
      int indexFound = indexOf(num);
      if (num == 0) {
         System.out.println("Zero is not allowed in a nonzerolist");
      }
      else if (isFull()){
         System.out.println("The NonzeroList is full");
      }
      else if (indexFound != -1) {
         System.out.println("A duplicated number can't be added to the list");
      }
      else if (numberOfElements == 0){
         data[0] = num;
         numberOfElements++;
      }
      else {
         int level = 0;
         boolean keepGoing = true;

         while (keepGoing ) {

            if (data[level] == 0 ) {
               data[level] = num;
               keepGoing = false;
               numberOfElements++;
            }
            else if (num > data[level]){

               level++;

            }
            else if (num < data[level]) {
               for (int i = numberOfElements; i > level; i--) {
                  data[i] = data[i - 1];
               }
               data[level] = num;
               keepGoing = false;
               numberOfElements++;
               level++;
            }
         }
      }
   }
   
   public void remove(int target){
     // *** Student task #2 ***
      /* 
	Requirements:
      	-If the target value does not exist, print message: "Target value does not exist."
      	-Remove the target value in the NonzeroList if the value exists
      	-Shift all items after the removed one so the order is maintained.

       *** Enter your code below *** 
     */
      int indexFound = indexOf(target);

      if (indexFound == -1){
         System.out.println("Target value does not exist");
      }
      else if (indexFound < size()){
         int level = indexFound;
         while (level < numberOfElements - 1) {
            data[indexFound] = data[indexFound + 1];
            indexFound = indexFound + 1;
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
   
   public void removeAll(){

     // *** Student task #3 ***  

      /* 
	Requirements:
        -remove all data from the list. The list will be empty 

        *** Enter your code below *** 
     */
       while (!isEmpty()) {
          data[numberOfElements - 1] = 0;
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

package Mod6PA.Problem1;

/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
* Student name:  John Stelly
* Completion date: 11/15/2020
*
* ShoppingList.txt: the template file of ShoppingList.java
* Student tasks: implement tasks #1, #2 and #3 as specified in this file
*/

public class ShoppingList{
   private Item[] list;
   private int numberOfItems;
   
   public ShoppingList(int initialSize){
      list=new Item[initialSize];
   }

   public void insert(Item item){
      if (isFull()) doubling();
      if (item == null) ;
      else {
         int check = indexOf(item.getName());
         if (check == -1 && numberOfItems == 0) {  //Empty list
            list[0] = item;
            numberOfItems++;
         }
         else if(check == -1 && numberOfItems > 0) { //Non-Empty List && Item not already in list.
            int targetIndex = 0;
            int orderCheck = 0;
            //Find input index
            for (int i = 0; i < numberOfItems; i++) {
               orderCheck = list[i].getName().compareTo(item.getName());
               if (orderCheck > 0 && targetIndex == 0) {
                  targetIndex = i;
               }
            }
            if (orderCheck > 0){
               for (int i = numberOfItems - 1; i >= targetIndex; i--) {
                  list[i + 1] = list[i];
               }
               list[targetIndex] = item;
               numberOfItems++;
            }
            else if (targetIndex == 0) {
               list[numberOfItems] = item;
               numberOfItems++;
            }
         }
         else { //Item already in list
            int newQuantity = list[check].getQuantity() + item.getQuantity();
            list[check].setQuantity(newQuantity);
         }
      }
   }
   
   public void remove(Item item){

      // *** Student task #2 ***  

      /* 
	Requirements: 
  
      	1. If item not found(item name), display the item does not exists in the list
      	   otherwise, remove the item from the list.
      	2. Hint: You do need to shift all items after removed one.

        *** Enter your code below *** 
     */
      int index = -1;
      int found = 0;
      for (int i = 0; i < numberOfItems; i++) {
         found = list[i].compareTo(item);
         if (found == 0)
            index = i;
      }

      if (found != 0) {

         System.out.println("Item does not exist!");

      } else {

         list[index] = null;
         numberOfItems--;

         for (int i = index; i < numberOfItems; i++) {
            list[i] = list[i + 1];
         }
      }


   }
   
   public void remove(String name){		// remove item by its name
      // *** Student task #3 ***
      /* 
	Requirements:
      	1. If item not found(item name), display the item does not exists in the list
      	   otherwise, remove the item from the list.
      	2. Hint: You do need to shift all items after removed one.

        *** Enter your code below *** 
     */

      int index = -1;
      boolean found = false;
      for (int i = 0; i < numberOfItems; i++) {
         found = list[i].getName().equalsIgnoreCase(name);
         if (found)
            index = i;
      }

      if (index == -1) {

         System.out.println("Item does not exist!");

      } else {

         list[index] = null;
         numberOfItems--;

         for (int i = index; i < numberOfItems; i++) {
            list[i] = list[i + 1];
         }
      }
   }
   
   private void doubling(){
      //Double the list size but keep all items in the list.
      Item[] tmp=new Item[list.length*2];
      for(int i=0; i<list.length; i++){
         tmp[i]=list[i];
      }
      list=tmp;
   }
   
   public int indexOf(Item item){
      // return the index of the item that has the same item name in the list array, return -1 if not found
      for(int i=0; i<numberOfItems; i++){
         if(list[i].compareTo(item)==0)
            return i;
      }
      return -1; // not found
   }

   public int indexOf(String name){
      // return the index of the item that has the same item name in the list array, return -1 if not found
      name=name.toLowerCase();
      for(int i=0; i<numberOfItems; i++){
         if(list[i].getName().toLowerCase().compareTo(name)==0)
            return i;
      }
      return -1; // not found
   }

   public boolean isFull(){
      return numberOfItems==list.length;
   }

   public boolean isEmpty(){
      return numberOfItems==0;
   }

   public int size(){
      return numberOfItems;
   }

   public void printNames(){
      System.out.print("[");
      for(int i=0; i<numberOfItems; i++){
         System.out.print(list[i].getName());
         if(i<numberOfItems-1)
            System.out.print(", ");
      }
      System.out.println("]");
   }
   
   public void print(){
      for(int i=0; i<numberOfItems; i++){
         System.out.println((i+1)+". "+list[i].toString());
      }
   }
}

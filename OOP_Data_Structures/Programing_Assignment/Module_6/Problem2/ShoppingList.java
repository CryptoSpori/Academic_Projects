package Mod6PA.Problem2;
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

public class ShoppingList {
   private Item[] list;
   private int numberOfItems;
   private int numberOfCategory;
   private String[] category = new String[10];
   
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
      int index = -1;
      int found = 0;
      for (int i = 0; i < numberOfItems; i++) {
         found = list[i].compareTo(item);
         if (found == 0)
            index = i;
      }
      if (found == 0) {
         System.out.println("Item does not exist!");
      } else {
         list[index] = null;
         numberOfItems--;
         for (int i = index; i < numberOfItems; i++) {
            list[i] = list[i + 1];
         }
      }
   }

   // /////////////////////////////////////////////////////////////////

   private void doubling(){
      Item[] tmp=new Item[list.length*2];
      for(int i=0; i<list.length; i++){
         tmp[i]=list[i];
      }
      list=tmp;
   }
   
   public int indexOf(Item item){
      // return the index of the item that has the same item name in the list array, return -1 if not found
      for(int i=0; i<numberOfItems; i++){
         if(list[i].getName().compareTo(item.getName())==0)
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

   public int getNumberOfCategory(){
      return numberOfCategory;
   }

   public void getCategory() {

      boolean inList = false;

      String value = "";

      for (int i = 0; i < numberOfItems; i++) {

         value = list[i].getCategory();
         if (value == null) {


         }
         else if (numberOfCategory == 0) {
            category[0] = list[0].getCategory();
            numberOfCategory = 1;
         }
         else {
            for (int j = 0; j < numberOfCategory; j++) {
               if (category[j] != null) {
                  inList = value.equalsIgnoreCase(category[j]);
                  break;
               }
            }
            if (!inList) {
               category[numberOfCategory] = value;
               numberOfCategory++;
            }

         }

      }
   }

   public int totalItems() {
      int total = 0;
      for (int i = 0; i < size(); i++) {
         total = total + list[i].getQuantity();
      }
      return total;
   }

   public double grandTotal() {
      double total = 0;
      for (int i = 0; i < size(); i++) {
         total = total + (list[i].getUnitPrice() * list[i].getQuantity());
      }
      return total;
   }

   public void printNames(){
      System.out.print("\n[");
      for(int i=0; i<numberOfItems; i++){
         System.out.print(list[i].getName());
         if(i<numberOfItems-1)
            System.out.print(", ");
      }
      System.out.println("]");
   }

   public void print(){
      System.out.println("\nName                                             Oty/Subtotal");
      System.out.println("---------------------------------------------------------------");
      for(int i=0; i<numberOfItems; i++){
         System.out.println((i+1)+". "+list[i].toString());
      }
      System.out.println("===============================================================");
      System.out.print("  Number of Items: " + totalItems());
      System.out.print("                 Grand Total: $");
      System.out.printf("%.2f", grandTotal());
      System.out.println("");
   }

   public void receipt(){


      getCategory();
      System.out.println("\nName                                             Oty/Subtotal");
      System.out.println("---------------------------------------------------------------");
      for (int i = 0; i < numberOfCategory; i++) {
         System.out.println("CATEGORY: " + category[i]);
         for (int j = 0; j < numberOfItems; j++) {
            if (list[j].getCategory().equalsIgnoreCase(category[i]))
               System.out.println((j+1)+". "+list[j].toString());
         }
      }
      System.out.println("===============================================================");
      System.out.print("  Number of Items: " + totalItems());
      System.out.print("                 Grand Total: $");
      System.out.printf("%.2f", grandTotal());
      System.out.println("");

   }
}

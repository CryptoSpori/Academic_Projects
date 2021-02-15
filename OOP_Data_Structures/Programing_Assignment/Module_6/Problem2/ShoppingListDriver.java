package Mod6PA.Problem2;
/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
* ShoppingListDriver.java: the driver program for ShoppingList class in Advanced Shopping List Receipt
*/

public class ShoppingListDriver{

   public static void main(String[] args){
      
      ShoppingList sl=new ShoppingList(3);
      sl.insert(null);
      sl.insert(new Item("Bread", "Carb Food", 2, 2.99));
      sl.insert(new Item("Seafood","Sea Food", -1, 10.99));
      sl.insert(new Item("Rice", "Carb Food",2, 19.99));
      sl.insert(new Item("Salad Dressings","Dressing", 2, 19.99));
      sl.insert(new Item("Eggs", "Protein",2, 3.99));
      sl.insert(new Item("Cheese","Protein", 2, 1.59));
      sl.insert(new Item("Eggs", "Protein",3, 3.99));
      sl.printNames();
      sl.receipt();
      
      System.out.println("\nAfter removing Eggs:");
      sl.remove(new Item("Eggs","Protein",0,0));
      sl.printNames();
      sl.receipt();

      
   }
}

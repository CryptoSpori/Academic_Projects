package Mod6PA.Problem2;

/**
* @author Yingjin Cui
* version 1.0
* since   2020-03
*
* Item.java: Item class represents grocery items to be added to the shopping list
*/

public class Item implements Comparable<Item>{
   private String name;
   private String category;
   private int quantity;
   private double unitPrice;

   public Item(String name, String category, int quantity, double unitPrice){
      setName(name);
      setCategory(category);
      setQuantity(quantity); 
      setUnitPrice(unitPrice); 
   }

   public String getName(){
      return name;
   }

   public String getCategory(){
      return category;
   }

   public int getQuantity(){
      return quantity;
   }

   public double getUnitPrice(){
      return unitPrice;
   }

   public void setName(String name){
      // The length of product name is limited to [1,50], if more than 50 characters, use the first 50 chars 
      // must neigher be a null value nor an empty String (throw runtime exception)
      if(name ==null || name.length()==0){
         throw new RuntimeException("null or empty String value is not allowed");
      }
      if(name.length()>50){
         name=name.substring(0, 50);
      }
      this.name = name;
   }

   public void setCategory(String category){

      if(category == null || category.length()==0){
         throw new RuntimeException("null or empty String value is not allowed");
      }
      if(name.length()>50){
         name=name.substring(0, 50);
      }
      this.category = category;
   }

   public void setQuantity(int quantity){
      if(quantity<1 || quantity>100){
         quantity=1;
      }
      this.quantity = quantity;
   }

   public void setUnitPrice(double unitPrice){
      if(unitPrice<=0 || unitPrice>1000){
         unitPrice=0.99;
      }
      this.unitPrice = unitPrice;
   }

   public int compareTo(Item item){
      int result;
      if(category.toLowerCase().compareTo(item.getCategory().toLowerCase()) == 0 &&
              name.toLowerCase().compareTo(item.getName().toLowerCase()) == 0) {
         result = 0;
      }
      else {
         result = -1;
      }
      return result;
   }

   public double subtotal(){
      return quantity*unitPrice;
   }

   public String toString(){
      return String.format("%-50s%-5d$%.2f",name, quantity, quantity*unitPrice);
   }
}

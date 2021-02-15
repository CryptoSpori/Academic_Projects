package Mod6GA.Problem3;

/**
* @author YINGJIN CUI
* version 1.0
* since   2020-03
*
* NonzeroSortedListDriver.java: The driver program for NonzeroList.java
*/

public class NonzeroSortedListDriver{

   public static void main(String[] args){
      
      NonzeroList list=new NonzeroList(5);
      System.out.println("Before adding any data, call list.isEmpty() retrurns: "+list.isEmpty()+ " list.size() returns: "+ list.size());
      list.add(2);
      list.add(12);
      list.add(5);
      list.add(15);
      list.add(9);
      list.print();
      System.out.println("The list is full: "+ list.isFull());
      System.out.println("Try to add more data to the list:");
      list.add(7);
      list.add(200);
      list.remove(89);
      list.remove(5);
      System.out.println("After removing 5.");
      list.print();
      System.out.println("size = "+list.size());
      System.out.println("Try to add 0");
      list.add(0);
      list.print();
      System.out.println("Remove all data from the list");
      list.removeAll();
      list.print();
   }
}

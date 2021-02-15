package Mod6_Project_2;

/*
 * Node class represents a line to in the document(LineList)
 * Don't modify anything in this file
 *
 */

public class Node{

   // Don't modify anything in this file

   private String line;
   private Node next;

   public Node(String line){
      setLine(line); 
      next=null;
   }

   public String getLine(){
      return line;
   }

   public void setLine(String line){
      // null is not allowed and set to an empty String
      if(line == null){
         line ="";
      }
      this.line = line;
   }

   public Node getNext(){
      return next;
   }

   public void setNext(Node node){
      next=node;
   }
   
   public void replace(String s1, String s2){
      line = line.replace(s1, s2);
   }
}

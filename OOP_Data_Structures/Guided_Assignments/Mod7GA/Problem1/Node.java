package Mod7GA.Problem1;

/**
* @author Yingjing Cui
* version 1.0
* since   2020-05-24 16:24
*
* Node.java: Node class
*/

public class Node{

   private int data;
   private Node left;
   private Node right;

   public Node(int data){
      this.data =data; 
      left=right=null;
   }

   public int getData(){
      return data;
   }
   public Node getLeft(){
      return left;
   }
   public Node getRight(){
      return right;
   }

   public void setLeft(Node node){
      this.left = node;
   }
   public void setRight(Node node){
      this.right = node;
   }
}

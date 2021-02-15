package Mod7GA.Problem1;
/**
* @author Yingjin Cui
* version 1.0
* since   2020-05-24 16:55
*
* Student name:  John Stelly
* Completion date: 11/27/2020
*
* MyIntBSTTree.txt: the template file of MyIntBSTTree.java
* Student tasks: implement tasks #1 and #2 as specified in this file 
*/

import java.util.*;

public class MyIntBSTTree{

   private Node root;

   public MyIntBSTTree(){
      root=null;
   }
   
   public int size(){
      Queue<Node> queue = new LinkedList<>();
      // *** Student task #1 ***
      /*
      Requirements:
      - Implement this method with a queue.
      - This method returns the number of elements in the tree

       *** Enter your code below ***
     */
       Node tempList = root;
       queue = treeCrawler(tempList, queue);
       return queue.size();
   }

    private Queue<Node> treeCrawler(Node someNode, Queue<Node> queue) {
       if (someNode.getLeft() != null && someNode.getRight() != null ){
           treeCrawler(someNode.getLeft(), queue);
           queue.add(someNode);
           treeCrawler(someNode.getRight(), queue);
       }
       if (someNode.getLeft() != null && someNode.getRight() == null) {
           treeCrawler(someNode.getLeft(), queue);
           queue.add(someNode);
       }
       if (someNode.getLeft() == null && someNode.getRight() != null){
           queue.add(someNode);
           treeCrawler(someNode.getRight(), queue);
       }
       if (someNode.getLeft() == null && someNode.getRight() == null){
           queue.add(someNode);
       }
        return queue;
    }

   public void add(int data) {
       root = addHelper(root, data);
   }

   private Node addHelper(Node node, int data) {//add node helper
       if (node == null){
          node = new Node(data);
       }else if (data <= node.getData()){
           node.setLeft(addHelper(node.getLeft(), data));
       }else{
           node.setRight(addHelper(node.getRight(), data)); //System.out.println(data);
       }
       return node;
   }

   public void printInOrder(){
      // *** Student task #2 ***
      /* 
      Requirements: 
      - Print all elements in the tree in ascending order. 
      - For example, if the tree contains nodes with values 5, 2, 8, 
        then calling printInOrder() should print as follows:
        [5, 2, 8]
      - You may implement this method either recursively or iteratively.
       *** Enter your code below *** 
     */
       Queue<Node> queue = new LinkedList<>();
       Node tempList = root;
       queue = treeCrawler(tempList, queue);
       System.out.print("[");
       while ( queue.iterator().hasNext() && queue.peek() != null) {
           System.out.print(queue.peek().getData() + " ");
           queue.remove();
       }
       System.out.println("]");
   }
}

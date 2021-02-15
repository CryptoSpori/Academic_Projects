package Mod7GA.Problem2;

/**
* @author Yingjin Cui
* version 1.0
* since   2020-05-24 16:55
*
* Student name:  xxxxx
* Completion date: xxxx
*
* MyIntBSTTree.txt: the template file of MyIntBSTTree.java
* Student tasks: implement tasks #1-#3 as specified in this file 
*/

public class MyIntBSTTree{

   private Node root;

   public MyIntBSTTree(){
      root=null;
   }
   
   public int height(){
      // *** Student task #1 ***
      /* Requirements: 
         The height of a binary tree is the largest number of edges in a path from the root node to a leaf node. 
         Essentially, it is the height of the root node. Note that if a tree has only one node, then that node 
         is at the same time the root node and the only leaf node, so the height of the tree is 0, similary, 
         the height of a tree with only two nodes is 1. 
         - Implement this method to return height of the tree
       
       *** Enter your code below *** 
     */
      return heightHelper(root);
   }

   private int heightHelper(Node someNode) {
      if (someNode == null)
         return -1;
      return Math.max(heightHelper(someNode.getLeft()),heightHelper(someNode.getRight())) + 1;
   }

   public Node[] inOrderArray(){
      // *** Student task #2 ***
      /* Requirements: 
         This method get all elements in the tree and return them as sorted Node array
       
       *** Enter your code below *** 
     */
      Node[] nodeArray = new Node[size()];
      int count = 1;
      nodeArray[0] = root;
      nodeArray = orderArrayHelper(nodeArray, root, count);
      return nodeArray;
   }

   private Node[] orderArrayHelper(Node[] array, Node mainNode, int count) {
      if (mainNode != null) {
         if (mainNode.getLeft() != null && mainNode.getRight() != null) {
            orderArrayHelper(array, mainNode.getLeft(), count);
            orderArrayHelper(array, mainNode.getRight(), count);
         }
         else {
            if (mainNode.getLeft() != null){
               array[count] = mainNode.getLeft();
               count++;
               orderArrayHelper(array, mainNode.getLeft(), count);
            }

            if (mainNode.getRight() != null){
               array[count] = mainNode.getRight();
               count++;
               orderArrayHelper(array, mainNode.getRight(), count);
            }
         }
      }
      return array;
   }

   public MyIntBSTTree balance(){
      // *** Student task #3 ***  
      /* Requirements: 
         This method rebuilds three to minimize the level (height) of the tree.
         To do so, you are going to rebuild a new tree from the ordered node elements array.
         To minimize the height of the tree, for any node, you try to keep balanced numbers 
         of it's left and right subtrees. Please following the steps to achieve this goal:
         1. select and add the middle element of the array,the middle element divides the
            array into two parts: part1-(before middle one) and part2-(after the middle one)
         2. For part1 and part2, go to step 1. Repeat the process until all elements are added.
            For example, for an array {1,3,6,8,9,12,20}, add 8 to tree, the middle value 8 divides
            the array into two parts: Part 1: {1,3,6} and Part 2: {9,12,20}, for part 1, add 3, 
            for part 2, add 12, repeat the process until all elements are added.
         3. Return the newly builded tree.
       
       *** Enter your code below *** 
     */
      Node[] tempArray = inOrderArray();
      MyIntBSTTree newTree = new MyIntBSTTree();
      MyIntBSTTree returnTree = divider(tempArray, newTree);
      return returnTree;
   }

   private MyIntBSTTree divider(Node[] someArray, MyIntBSTTree someTree ){
      int splitSize;
      if (someArray.length == 1) {
         someTree.add(someArray[0].getData());
         return someTree;
      }
      else {
         int count = 0;
         if ((someArray.length % 2)  != 0 ) {
            splitSize = (someArray.length - 1) / 2;
            someTree.add(someArray[splitSize].getData());
         }
         else {
            splitSize = someArray.length / 2;
         }
         Node[] partOne = new Node[splitSize];
         for (int i = 0; i < splitSize; i++) {
            Node temp = someArray[i];
            partOne[i] = temp;
            count++;
         }
         count++;
         Node[] partTwo = new Node[splitSize];
         for (int i = 0; i < splitSize; i++) {
            Node temp = someArray[count];
            partTwo[i] = temp;
            count++;
         }
         divider(partOne, someTree);
         divider(partTwo, someTree);
      }
      return someTree;
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
           node.setRight(addHelper(node.getRight(), data));//System.out.println(data);
       }
       return node;
   }
   
   public void display(){
      //print tree structure
      displayHelper(root, 0);
   }

   private void displayHelper(Node t, int level){
      if(t==null) return ;
      displayHelper(t.getRight(), level + 1);
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getData());
      displayHelper(t.getLeft(), level + 1); //recurse left
   } 

   public int size(){
      return sizeHelper(root);
   }

   private int sizeHelper(Node node){
      if(node==null) return 0;
      else return 1+sizeHelper(node.getLeft())+sizeHelper(node.getRight());
   }
   
}

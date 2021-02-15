package Mod7PA.Program2;

/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-05-24 16:50
*
* Student name:  John Stelly
* Completion date: 11/29/2020
*
* MyIntBSTTree.txt: the template file of MyIntBSTTree.java
* Student tasks: implement tasks #1 and #2 as specified in this file
*/

public class MyIntBSTTree{  
   private Node root;
   public MyIntBSTTree(){
      root=null;
   }
   
   public int height(){
      // *** Student task ***  
      /* Requirements: 
        The height of a binary tree is the largest number of edges in a path from the root node to a leaf node. 
        Essentially, it is the height of the root node. Note that if a tree has only one node, then that node 
        is at the same time the root node and the only leaf node, so the height of the tree is 0, similary, 
        the height of a tree with only two nodes is 1. Implement this method to return height of the tree

       *** Enter your code below *** 
     */
      return heightHelper(root);
   }
   private int heightHelper(Node someNode) {
      if (someNode == null)
         return -1;
      return Math.max(heightHelper(someNode.getLeft()),heightHelper(someNode.getRight())) + 1;
   }
  
   public int comparisons(Node node){
      // *** Student task ***  
      /* Requirements: 
        Count and return how many comparisons performed to search for the argument node

       *** Enter your code below *** 
     */
      return comparisons(node.getData());
   }
   public int comparisons(int val){
      // *** Student task ***  
      /* Requirements: 
       Overloaded method - Count and return how many comparisons performed to search for the node whose data equals the argument val.

       *** Enter your code below *** 
     */
      Node testNode = root;
      return compareStuff(testNode, val, 0);
   }

   public int compareStuff(Node node, int val, int count) {

      if (node == null) {
         return count;
      }
      else if (val == node.getData()){
         //
         return count;
      }
      else if (val > node.getData()) {
         count++;
         count = compareStuff(node.getRight(), val, count);
      }
      else if (val < node.getData()) {
         count++;
         count = compareStuff(node.getLeft(), val, count);
      }
      return count;
   }

   public MyIntBSTTree buildBalancedTree(int[] arr){
     // *** Student task ***  
      /* Requirements: 
         This method builds a balanced tree with values from the int arr and returns the tree.

       *** Enter your code below *** 
     */
      MyIntBSTTree newTree = new MyIntBSTTree();
      int[] newArray = selectionSort(arr);
      return divider(newArray, newTree);
   }

   private MyIntBSTTree divider(int[] someArray, MyIntBSTTree someTree ){
      int splitSize;
      if (someArray.length == 1) {
         someTree.add(someArray[0]);
         return someTree;
      }
      else {
         int count = 0;
         if ((someArray.length % 2)  != 0 ) {
            splitSize = (someArray.length - 1)  / 2;
            someTree.add(someArray[splitSize]  );
         }
         else {
            splitSize = someArray.length / 2;
         }
         int[] partOne = new int[splitSize];
         for (int i = 0; i < splitSize; i++) {
            int temp = someArray[i];
            partOne[i] = temp;
            count++;
         }
         count++;
         int[] partTwo = new int[splitSize];
         for (int i = 0; i < splitSize; i++) {
            int temp = someArray[count];
            partTwo[i] = temp;
            count++;
         }
         divider(partOne, someTree);
         divider(partTwo, someTree);
      }
      return someTree;
   }

   public MyIntBSTTree buildWorstTree(int[] arr){
     
     // *** Student task ***  
      /* Requirements: 
         Build and return a tree whose height is arr.length - 1

       *** Enter your code below *** 
     */
      int[] tempArray = selectionSort(arr);
      return buildTree(tempArray);
   }

   public MyIntBSTTree buildTree(int[] arr){

     // *** Student task ***  
      /* Requirements: 
         This method builds a tree with values from the int arr and returns the tree.
         You may simply add all values to the tree in the same sequence as in the int arr.

       *** Enter your code below *** 
     */

      MyIntBSTTree newTree = new MyIntBSTTree();

      for (int j : arr) {
         newTree.add(j);
      }
      return newTree;
   }

   public int[] selectionSort(int[] array) {
      System.out.println("");
      for (int i = 0; i < array.length; i++) {
         int small = i;

         for (int j = i + 1; j < array.length; j++) {

            if (array[j] < array[small]) {
               small = j;
            }
         }
         if (small != i) {
            int temp = array[i];
            array[i] = array[small];
            array[small] = temp;
         }
      }
      return array;
   }

   // **** DO NOT MODIFY CODE BEYOND THIS POINT ***
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
}

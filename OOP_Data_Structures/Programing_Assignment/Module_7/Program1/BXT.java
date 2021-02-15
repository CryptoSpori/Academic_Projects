package Mod7PA.Program1;

import Mod7GA.Problem1.Node;

import java.util.*;

/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-05
*
* Student name:  John Stelly
* Completion date: 11/29/2020
*
* BXT.txt: the template file of BXT.java
* Student tasks: implement tasks as specified in this file
*
* Note: BXT Represents a binary expression tree.
* BXT can build itself from a postorder expression.  
* It can evaluate and print itself. It also prints an inorder string and a preorder string.  
*/

class BXT {

   private TreeNode root;

   public BXT() {
      root = null;
   }

   public void buildTree(String str) {
      // *** Student task ***  
      /* 
	The argument string is in postfix notation. 
        Build the tree as specified in the document 
        *** Enter your code below ***
     */
      String[] someArray = str.split(" ");
      for (int i = someArray.length - 1; i > -1; i--) {
         System.out.print(someArray[i] + " ");
         root = treeLoader(root, someArray[i]);
      }
      System.out.println("");
   }

   private TreeNode treeLoader(TreeNode node, String data) {
      if (node == null) {
         node = new TreeNode(data);
      } else if (node.getLeft() != null && isLeftAnOperator(node))
         node.setLeft(treeLoader(node.getLeft(), data));
      else if (node.getRight() == null) {
         node.setRight(new TreeNode(data));
      } else if (node.getRight().getLeft() != null) {
         node.setLeft(new TreeNode(data));
      } else if (isRightAnOperator(node)) {
         node.setRight(treeLoader(node.getRight(), data));
      } else if (node.getLeft() == null)
         node.setLeft(new TreeNode(data));
      return node;
   }

   public boolean isRightAnOperator(TreeNode node) {
      return (node.getRight().getValue().equals("+") || node.getRight().getValue().equals("-") ||
              node.getRight().getValue().equals("*") || node.getRight().getValue().equals("/"));
   }

   public boolean isLeftAnOperator(TreeNode node) {
      return (node.getLeft().getValue().equals("+") || node.getLeft().getValue().equals("-") ||
              node.getLeft().getValue().equals("*") || node.getLeft().getValue().equals("/"));
   }

   public double evaluateTree() {
      // *** Student task ***  
      /* 
	Do this recursively.  If the node is an operator, recursively evaluate the left child 
        and the right child, and return the result.  Else the node is a number, so it can 
        be converted into a double, and returned. 
        *** Enter your code below ***
     */

      Deque<String> queue = new LinkedList<>();
      queue = calculationAssistance(root, queue);
      double solution = 0;
      solution = Double.parseDouble(queue.removeLast());
      while (!queue.isEmpty()) {
         solution = calculate(solution, queue.removeLast(),
                 Double.parseDouble(queue.removeLast()));
      }

      return solution;
   }

   public Deque<String> calculationAssistance(TreeNode node, Deque<String> queue) {
      if (node.getRight() != null && node.getLeft() != null) {
         calculationAssistance(node.getRight(), queue);
         queue.add((String) node.getValue());
         calculationAssistance(node.getLeft(), queue);
      }
      if (node.getRight() != null && node.getLeft() == null) {
         calculationAssistance(node.getRight(), queue);
         queue.add((String) node.getValue());
      }
      if (node.getRight() == null && node.getLeft() != null) {
         queue.add((String) node.getValue());
         calculationAssistance(node.getLeft(), queue);
      }
      if (node.getRight() == null && node.getLeft() == null) {
         queue.add((String) node.getValue());
      }
      return queue;
   }

   public double calculate(double x, String s, double y) {
      switch (s) {
         case "+":
            return x + y;
         case "-":
            return x - y;
         case "*":
            return x * y;
         case "/":
            return x / y;
      }
      return 0;
   }

   public String display() {
      // *** Student task ***  
      /* 
	Display tree structure. Plese refer to GA2 if you need to refresh your knowledge
        *** Enter your code below ***
     */
      displayHelper(root, 0);
      return "";
   }

   private void displayHelper(TreeNode t, int level) {
      if (t == null) return;
      displayHelper(t.getRight(), level + 1);
      for (int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
      displayHelper(t.getLeft(), level + 1); //recurse left
   }

   public String infix() {
      // *** Student task ***  
      /* 
	Infix is characterized by the placement of operators between operands; 
        *** Enter your code below ***
     */
      infixAid(root, "");
      return "";
   }

   public void infixAid(TreeNode node, String txtLine) {
      if (node.getRight() != null && node.getLeft() != null) {
         infixAid(node.getRight(), txtLine);
         System.out.print(node.getValue()  + " ");
         infixAid(node.getLeft(), txtLine);
      }
      if (node.getRight() != null && node.getLeft() == null) {
         infixAid(node.getRight(), txtLine);
         System.out.print(node.getValue()  + " ");
      }
      if (node.getRight() == null && node.getLeft() != null) {
         System.out.print(node.getValue()  + " ");
         infixAid(node.getLeft(), txtLine);
      }
      if (node.getRight() == null && node.getLeft() == null) {
         System.out.print(node.getValue()  + " ");
      }
   }

   public String prefix() {
      // *** Student task ***  
      /* 
	Prefix expression notation requires that all operators precede the two operands that they work on; 
        *** Enter your code below ***
     */

      prefixAid(root, "");
      return "";
   }

   public void prefixAid(TreeNode node, String txtLine) {
      if (node.getRight() != null && node.getLeft() != null) {
         System.out.print(node.getValue() + " ");
         prefixAid(node.getRight(), txtLine);
         infixAid(node.getLeft(), txtLine);
      }
      if (node.getRight() != null && node.getLeft() == null) {
         prefixAid(node.getRight(), txtLine);
         System.out.print(node.getValue()  + " ");
      }
      if (node.getRight() == null && node.getLeft() != null) {
         System.out.print(node.getValue()  + " ");
         prefixAid(node.getLeft(), txtLine);
      }
      if (node.getRight() == null && node.getLeft() == null) {
         System.out.print(node.getValue()  + " ");
      }
   }


   public String postfix() {
      // *** Student task ***  
      /* 
	Postfix requires that its operators come after the corresponding operands
        *** Enter your code below ***
     */
      postfixAid(root, "");

      return "";
   }

   public void postfixAid(TreeNode node, String txtLine) {
      if (node.getRight() != null && node.getLeft() != null) {
         postfixAid(node.getRight(), txtLine);
         infixAid(node.getLeft(), txtLine);
         System.out.print(node.getValue()  + " ");
      }
      if (node.getRight() != null && node.getLeft() == null) {
         postfixAid(node.getRight(), txtLine);
         System.out.print(node.getValue()  + " ");
      }
      if (node.getRight() == null && node.getLeft() != null) {
         System.out.print(node.getValue()  + " ");
         postfixAid(node.getLeft(), txtLine);
      }
      if (node.getRight() == null && node.getLeft() == null) {
         System.out.print(node.getValue()  + " ");
      }
   }

}
package Mod7PA.Program1;

/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-05
*
* TreeNode.java: TreeNode class.
*/

public class TreeNode
   {
      private Object value; 
      private TreeNode left, right;
   
      public TreeNode(Object initValue)
      { 
         value = initValue; 
         left = null; 
         right = null; 
      }
   
      public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
      { 
         value = initValue; 
         left = initLeft; 
         right = initRight; 
      }
   
      public Object getValue()
      { 
         return value; 
      }
   
      public TreeNode getLeft() 
      { 
         return left; 
      }
   
      public TreeNode getRight() 
      { 
         return right; 
      }
   
      public void setValue(Object theNewValue) 
      { 
         value = theNewValue; 
      }
   
      public void setLeft(TreeNode theNewLeft) 
      { 
         left = theNewLeft;
      }
   
      public void setRight(TreeNode theNewRight)
      { 
         right = theNewRight;
      }
   }

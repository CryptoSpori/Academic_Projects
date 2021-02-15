package Mod7PA.Program1;
/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-05
*
* BXTDriver.java: the driver program for BXT class.
* Input: a postfix string, each token separated by a space.
*/

import java.util.*;

public class BXTDriver
{
   public static void main(String[] args)
   {
      ArrayList<String> postExp = new ArrayList<String>();
      postExp.add("14 -5 / ");
      postExp.add("20 3 -4 + * ");
      postExp.add("2 3 + 5 / 4 5 - *");

      for( String postfix : postExp )
      {
         System.out.println("Postfix Exp: "  + postfix);
         BXT tree = new BXT();
         tree.buildTree( postfix );
         System.out.println("BXT: ");
         System.out.println( tree.display() );
         System.out.print("Infix order:  ");
         System.out.println( tree.infix() );
         System.out.print("Prefix order:  ");
         System.out.println( tree.prefix() );
         System.out.print("Postfix order:  ");
         System.out.println( tree.postfix() );
         System.out.print("Evaluates to " + tree.evaluateTree());
         System.out.println("\n------------------------");
      }
   }
}

package Mod3GAA.Problem2;

/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-02
*
* LetterPermutation.java
*/

public class LetterPermutation{

   public static void main(String[] args){
      
      //int num=Integer.parseInt(args[0]);
      int num = 3;
      permutation("",num);
   }
   public static void permutation(String str, int remaining){
      if(remaining==1){
        System.out.println(str+"L");
        System.out.println(str+"R");
      }else{
         permutation(str+"L",remaining-1);
         permutation(str+"R",remaining-1);
      }
   }
}

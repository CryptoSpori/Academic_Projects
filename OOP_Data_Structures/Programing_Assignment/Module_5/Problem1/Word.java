package Mod5PA.Problem1;
/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
*  Word.java:  Word class
*/


public class Word implements Comparable<Word>{

   private String word;
   private int frequency;

   public Word(String word){
      this.word = word; 
      frequency=1; 
   }

   public String getWord(){
      return word;
   }
   public int getFrequency(){
      return frequency;
   }
   public void increaseFrequency(){
      frequency++;
   }
   public int compareTo(Word w){
      //sort object based on frequency but in descending order;
      return w.getFrequency() - frequency;
   }
   
   public boolean equals(Object w){
      return word.equalsIgnoreCase(((Word)w).getWord());
   }
   public String toString(){
      return String.format("%s[%d]",word, frequency);
   }
}

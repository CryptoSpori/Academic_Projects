package Mod5PA.Problem1;
/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
* LLNode.java: LLNode class 
*/

public class LLNode<T>{

   private T data;
   private LLNode<T> next;

   public LLNode(T data){
      setData(data);
      next=null;
   }
   public LLNode(T data, LLNode<T> next){
      setData(data); 
      setNext(next); 
   }

   public T getData(){
      return data;
   }
   public LLNode<T> getNext(){
      return next;
   }
   public void setData(T data){
      this.data = data;
   }
   public void setNext(LLNode<T> next){
      this.next = next;
   }


}

package Mod4PA.Program4;
/**----------------------------------------------------------------------------
*
* Implements <T> nodes for a Linked List.
*
*/

public class LLNode<T>
{
  protected LLNode<T> link;

  protected T data;

  public LLNode(T info)
  {
    this.data = info;
    link = null;
  }

  public void setInfo(T data){ this.data = data;}
  public T getData(){ return data; }
  public void setLink(LLNode<T> link){this.link = link;}
  public LLNode<T> getLink(){ return link;}
}


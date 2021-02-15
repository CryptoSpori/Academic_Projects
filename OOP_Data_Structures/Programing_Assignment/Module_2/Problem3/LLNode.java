package Mod2PA.Problem3;

public class LLNode<T> {

    protected T info;
    protected LLNode<T> link;

    public LLNode(T info) {
        this.info = info;
        link = null;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public T getData() {
        return info;
    }

    public void setLink(LLNode<T> link) {
        this.link = link;
    }

    public void getLink (LLNode<T> link) {
        this.link = link;
    }

    public LLNode<T> getLink() {
        return link;
    }
}

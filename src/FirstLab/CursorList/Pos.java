package FirstLab.CursorList;

import FirstLab.IPos;
import FirstLab.Node;

public class Pos implements IPos {
    private Node element;
    private int  pos;
    private Pos  next;

    public Pos() {
        element = null;
        pos = -1;
        next = null;
    }

    public Pos(Node element) {
        this.element = element;
        pos = 0;
    }

    public Pos(int pos) {
        this.pos = pos;
        element = null;
    }

    public Node getElement() {
        return element;
    }

    public void setElement(Node element) {
        this.element = element;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Pos getNext() {
        return next;
    }

    public void setNext(Pos next) {
        this.next = next;
    }

    @Override public String toString() {
        return "Pos{" + "element=" + element + ", pos=" + pos + ", next=" + next + '}';
    }
}


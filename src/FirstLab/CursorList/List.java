package FirstLab.CursorList;

import FirstLab.IList;
import FirstLab.IPos;
import FirstLab.Node;
import FirstLab.NullPosException;

import java.util.Arrays;

public class List implements IList {
    private static final Node[] nodes = new Node[10];
    private static Pos SPACE = new Pos();
    private final Pos head;

    static {
        Pos s = SPACE;
        for (int i = 0; i < nodes.length; i++) {
            s.setPos(i);
            s.setNext(new Pos(i + 1));
            s = s.getNext();
        }
        s.setPos(-1);
    }

    public List() {
        head = new Pos();
    }

    @Override public void insert(IPos pos, char[] name, char[] address) {
        if (SPACE.getPos() == -1) throw new NullPosException("Array overflow, there's not enough space!");
        Node node = new Node(name, address);
        if (head.getElement() == null) {
            head.setPos(SPACE.getNext().getPos());
            head.setElement(node);
            head.setNext(new Pos());
            nodes[SPACE.getNext().getPos()] = node;
        } else if (((Pos) pos).getElement() == null) {

        }
        else if (pos == head) {

        }
        else {

        }
    }

    private void removeSpace() {
        SPACE.setPos(SPACE.getNext().getPos());
        SPACE.setNext(SPACE.getNext());
    }

    private void freeSpace(int pos) {
        Pos newSpace = new Pos(pos);
        newSpace.setNext(SPACE);
        SPACE = newSpace;
    }

    private Node getPrev(Node node) {
        Node h = head.getElement();
        while (h.hasNext() && h.getNext() != node) h = h.getNext();
        return h;
    }

    private Node getLast() {
        Node node = head.getElement();
        while (node.hasNext()) node = node.getNext();
        return node;
    }

    @Override public Pos first() {
        return head;
    }

    @Override public Pos end() {
        return new Pos(null);
    }

    @Override public Pos locate(Node node) {
        return null;
    }

    @Override public Node retrieve(IPos pos) {
        return null;
    }

    @Override public void delete(IPos pos) {

    }

    @Override public Pos next(IPos pos) {
        return null;
    }

    @Override public Pos previous(IPos pos) {
        return null;
    }

    @Override public void makeNull() {
        Arrays.fill(nodes, null);
        SPACE = new Pos();
    }

    @Override public void printList() {

    }
}

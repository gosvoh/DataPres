package FirstLab.LinkedList;

import FirstLab.IList;
import FirstLab.IPos;
import FirstLab.Node;
import FirstLab.NullPosException;

public class List implements IList {
    private final Pos head;

    public List() {
        head = new Pos(null);
    }

    @Override public void insert(IPos pos, char[] name, char[] address) {
        Node node = new Node(name, address);
        if (head.getPos() == null) head.setPos(node);
        else if (((Pos) pos).getPos() == null) getLast().setNext(node);
        else if (pos == head) head.getPos().setNext(node);
        else {
            Node prev = getPrev(((Pos) pos).getPos());
            Node next = prev.getNext();
            prev.setNext(node);
            node.setNext(next);
        }
    }

    private Node getPrev(Node node) {
        Node h = head.getPos();
        while (h.hasNext() && h.getNext() != node) h = h.getNext();
        return h;
    }

    private Node getLast() {
        Node node = head.getPos();
        while (node.hasNext()) node = node.getNext();
        return node;
    }

    @Override public Pos first() {
        return head;
    }

    @Override public Pos end() {
        return new Pos(null);
    }

    @Override public void delete(IPos pos) {
        if (head.getPos() == null || ((Pos) pos).getPos() == null) return;
        Node node = ((Pos) pos).getPos() == head.getPos() ? head.getPos() : getPrev(((Pos) pos).getPos());
        node.setNext(node.getNext().getNext());
        ((Pos) pos).setPos(node);
    }

    @Override public Node retrieve(IPos pos) {
        if (head.getPos() == null || ((Pos) pos).getPos() == null)
            throw new NullPosException("List is empty or wrong position!");
        Node node = head.getPos();
        while (node != ((Pos) pos).getPos())
            node = node.getNext();
        return node;
    }

    @Override public Pos previous(IPos pos) {
        if (head.getPos() == null || ((Pos) pos).getPos() == null || ((Pos) pos).getPos() == head.getPos())
            throw new NullPosException("List is empty or wrong position!");
        return new Pos(getPrev(((Pos) pos).getPos()));
    }

    @Override public Pos locate(Node node) {
        if (head.getPos() == null || node == null) throw new NullPosException("List is empty or wrong element!");
        Node h = head.getPos();
        while (!h.equals(node)) h = h.getNext();
        return new Pos(h);
    }

    @Override public Pos next(IPos pos) {
        if (head.getPos() == null || ((Pos) pos).getPos() == null)
            throw new NullPosException("List is empty or wrong position!");
        return new Pos(((Pos) pos).getPos().getNext());
    }

    @Override public void makeNull() {
        head.setPos(null);
    }

    @Override public void printList() {
        System.out.println(this);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName()).append(":").append(System.lineSeparator());
        Node node = head.getPos();
        if (node == null) sb.append("List is empty!");
        while (node != null) {
            sb.append(node);
            if (node.hasNext()) sb.append(",").append(System.lineSeparator());
            node = node.getNext();
        }
        return sb.toString();
    }
}
package FirstLab.LinkedList;

import FirstLab.IList;
import FirstLab.INode;
import FirstLab.IPos;
import FirstLab.NullPosException;

public class List implements IList {
    private Node head;

    public List() {
        head = null;
    }

    private void checkPos(Pos pos) {
        if (pos == null || pos.getPos() == null)
            throw new NullPosException("It's impossible to get object in empty position!");
    }

    @Override public void insert(IPos pos, char[] name, char[] address) {
        Node node = new Node(name, address);
        if (((Pos) pos).getPos() == null) head = node;
        else {
            Node prev = previous(pos).getPos();
            Node next = next(pos).getPos();
            prev.setNext(node);
            node.setNext(next);
        }
    }

    @Override public Pos first() {
        return new Pos(head);
    }

    @Override public Pos end() {
        Node node = head;
        while (node != null && node.getNext() != null) node = node.getNext();
        return new Pos(node);
    }

    @Override public Pos locate(INode node) {
        Node n = head;
        while (!n.equals(node)) n = n.getNext();
        return new Pos(n);
    }

    @Override public Node retrieve(IPos pos) {
        checkPos((Pos) pos);
        Node node = head;
        while (!node.equals(((Pos) pos).getPos())) node = node.getNext();
        return node;
    }

    @Override public void delete(IPos pos) {
        checkPos((Pos) pos);
        Node node = previous(pos).getPos();
        node.setNext(node.getNext().getNext());
    }

    @Override public Pos next(IPos pos) {
        checkPos((Pos) pos);
        return new Pos(((Pos) pos).getPos().getNext());
    }

    @Override public Pos previous(IPos pos) {
        checkPos((Pos) pos);
        Node node = head;
        while (node.hasNext() && node.getNext().equals(((Pos) pos).getPos())) node = node.getNext();
        return new Pos(node);
    }

    @Override public void makeNull() {
        head = null;
    }

    @Override public void printList() {
        System.out.println(this);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName()).append(":").append(System.lineSeparator());
        Node node = head;
        if (node == null) sb.append("List is empty!");
        while (node != null) {
            sb.append(node);
            if (node.hasNext()) sb.append(",").append(System.lineSeparator());
            node = node.getNext();
        }
        return sb.toString();
    }
}
package FirstLab.DoublyLinkedList;

import FirstLab.*;

public class List implements IList {
    private Node head, tail;

    public List() {
        head = null;
        tail = null;
    }

    @Override public void insert(IPos pos, ListData listData) {
        if (head == null) {
            if (((Pos) pos).getPos() == null) head = tail = new Node(listData);
            return;
        }
        if (((Pos) pos).getPos() == null) {
            tail.setNext(new Node(listData));
            tail = tail.getNext();
        } else {
            if (!contains(((Pos) pos).getPos())) return;
            Node newNode = new Node(listData);
            newNode.setNext(((Pos) pos).getPos());
            ((Pos) pos).getPos().setNext(newNode);
            if (tail.hasNext()) tail = newNode;
        }
    }

    private boolean contains(Node node) {
        Node h = head;
        while (h != null) {
            if (h == node) return true;
            h = h.getNext();
        }
        return false;
    }

    @Override public Pos first() {
        return new Pos(head);
    }

    /** @return позиция после последнего элемента */
    @Override public Pos end() {
        return new Pos(null);
    }

    @Override public void delete(IPos pos) {
        if (head == null || ((Pos) pos).getPos() == null) return;
        if (!contains(((Pos) pos).getPos())) return;
        Node prev = ((Pos) pos).getPos().getPrev();
        Node curr = ((Pos) pos).getPos();
        Node next = ((Pos) pos).getPos().getNext();
        if (prev == null || next == null) {
            if (curr == head) head = next;
            if (curr == tail) tail = prev;
        } else {
            prev.setNext(next);
            ((Pos) pos).setPos(next);
        }
    }

    @Override public ListData retrieve(IPos pos) {
        if (head == null || ((Pos) pos).getPos() == null || !contains(((Pos) pos).getPos()))
            throw new NullPosException("List is empty or wrong position!");
        return ((Pos) pos).getPos().getListObj();
    }

    @Override public Pos previous(IPos pos) {
        if (head == null || ((Pos) pos).getPos() == null || ((Pos) pos).getPos() == head ||
            !contains(((Pos) pos).getPos()))
            throw new NullPosException("List is empty or wrong position!");
        return new Pos(((Pos) pos).getPos().getPrev());
    }

    @Override public Pos locate(ListData data) {
        if (head == null || data == null) return null;
        Node h = head;
        while (h != null) {
            if (h.getListObj().equals(data)) return new Pos(h);
            h = h.getNext();
        }
        return new Pos(h);
    }

    @Override public Pos next(IPos pos) {
        if (head == null || ((Pos) pos).getPos() == null || !contains(((Pos) pos).getPos()))
            throw new NullPosException("List is empty or wrong position!");
        return new Pos(((Pos) pos).getPos().getNext());
    }

    @Override public void makeNull() {
        head = null;
        tail = null;
    }

    @Override public void printList() {
        System.out.println(this);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName()).append(":").append(System.lineSeparator());
        Node node = head;
        if (node == null) return sb.append("List is empty!").toString();
        while (node != null) {
            sb.append(node);
            if (node.hasNext()) sb.append(",").append(System.lineSeparator());
            node = node.getNext();
        }
        return sb.toString();
    }
}
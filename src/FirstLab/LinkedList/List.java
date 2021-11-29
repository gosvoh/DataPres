package FirstLab.LinkedList;

import FirstLab.*;

public class List implements IList {
    private Node head;
    private Pos  end, first;

    public List() {
        head = null;
    }

    /**
     * Вставить элемент в список.<br>
     * Если голова списка пустая и позиция тоже, то вставляем элемент в голову<br>
     * Иначе возвращаем управление
     *
     * @param pos позиция для вставки
     * @param listData информация для вставки
     */
    @Override public void insert(IPos pos, ListData listData) {
        if (head == null) {
            if (((Pos) pos).getPos() == null) head = new Node(listData);
            return;
        }
        if (((Pos) pos).getPos() == null) getLast().setNext(new Node(listData));
        else {
            Node prev = getPrev(((Pos) pos).getPos());
            if (((Pos) pos).getPos() == head) prev = head;
            else if (prev == null) return;
            Node next = prev.getNext();
            Node node = new Node(listData);
            prev.setNext(node);
            node.setNext(next);
        }
    }

    /**
     * @return элемент перед указанным node
     */
    private Node getPrev(Node node) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr == node) return prev;
            prev = curr;
            curr = curr.getNext();
        }
        return curr;
    }

    private Node contains(Node node) {
        Node curr = head;
        while (curr != null) {
            if (curr == node) return curr;
            curr = curr.getNext();
        }
        return curr;
    }

    /**
     * @return последний элемент
     */
    private Node getLast() {
        Node node = head;
        Node prev = node;
        while (node != null) {
            prev = node;
            node = node.getNext();
        }

        return prev;
    }

    @Override public Pos first() {
        if (first == null) first = new Pos(head);
        else first.setPos(head);
        return head == null ? end : first;
    }

    /** @return позиция после последнего элемента */
    @Override public Pos end() {
        /*if (end == null) end = new Pos(null);
        return end;*/
        return new Pos(null);
    }

    @Override public void delete(IPos pos) {
        if (head == null || ((Pos) pos).getPos() == null) return;
        Node prev = getPrev(((Pos) pos).getPos());
        Node curr = ((Pos) pos).getPos();
        Node next = ((Pos) pos).getPos().getNext();
        if (prev == null) { if (curr == head) head = next; }
        else {
            prev.setNext(next);
            ((Pos) pos).setPos(next);
        }
    }

    @Override public ListData retrieve(IPos pos) {
        if (head == null || ((Pos) pos).getPos() == null)
            throw new NullPosException("List is empty or wrong position!");
        Node node = ((Pos) pos).getPos() == head ? head : contains(((Pos) pos).getPos());
        if (node == null) throw new NullPosException("No such element!");
        return node.getListObj();
    }

    @Override public Pos previous(IPos pos) {
        if (head == null || ((Pos) pos).getPos() == null || ((Pos) pos).getPos() == head)
            throw new NullPosException("List is empty or wrong position!");
        Node node = getPrev(((Pos) pos).getPos());
        if (node == null) throw new NullPosException("");
        else return new Pos(getPrev(((Pos) pos).getPos()));
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
        if (head == null || ((Pos) pos).getPos() == null)
            throw new NullPosException("List is empty or wrong position!");
        Node node;
        if (((Pos) pos).getPos() == head) node = head;
        else node = contains(((Pos) pos).getPos());
        if (node == null) throw new NullPosException("");
        else return node.getNext() == null ? end : new Pos(node.getNext());
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
        if (node == null) return sb.append("List is empty!").toString();
        while (node != null) {
            sb.append(node);
            if (node.hasNext()) sb.append(",").append(System.lineSeparator());
            node = node.getNext();
        }
        return sb.toString();
    }

    public boolean empty() {
        return head == null;
    }
}
package FirstLab;

import java.util.Objects;

public class Node {
    private ListData listData;
    /** Позиция следующего элемента (только для связного списка) */
    private Node     next;
    /** Позиция предыдущего элемента (только для двусвязного списка) */
    private       Node   prev;

    public Node(ListData listData) {
        this.listData = new ListData(listData);
        next = null;
        prev = null;
    }

    /*public Node(Node node) {
        if (node == null) throw new NullPosException("Empty object!");
        listData = new ListData(node.listData);
        next = null;
    }*/

    public Node(ListData data, Node next) {
        this.listData = data;
        this.next = next;
        this.prev = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        next = node;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public ListData getListObj() {
        return listData;
    }

    public void setListObj(ListData listData) {
        this.listData = listData;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrev() { return prev != null; }

    @Override public String toString() {
        return listData.toString();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return this.listData.equals(node.listData);
    }

    @Override public int hashCode() {
        return Objects.hash(listData, next, prev);
    }
}
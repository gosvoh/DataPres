package FirstLab.DoublyLinkedList;

import FirstLab.IPos;
import FirstLab.Node;

import java.util.Objects;

public class Pos implements IPos {
    private Node node;

    public Pos(Node node) {
        this.node = node;
    }

    public Node getPos() {
        return node;
    }

    public void setPos(Node pos) {
        this.node = pos;
    }

    @Override public String toString() {
        return node.toString();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FirstLab.LinkedList.Pos)) return false;
        return node == ((FirstLab.LinkedList.Pos) o).getPos();
    }

    @Override public int hashCode() {
        return Objects.hash(node);
    }
}
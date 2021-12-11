package SecondLab.LinkedList;

import SecondLab.AMap;

public class Map extends AMap {
    Node head;

    public Map() {
        Node node = head = new Node(0, RangeType.NODEF);
        for (int i = RangeType.FIRST + 1; i <= RangeType.LAST; i++) {
            node.next = new Node(i, RangeType.NODEF);
            node = node.next;
        }
    }

    private Node getNode(int key) {
        Node node = head;
        while (node != null) {
            if (node.key == key) return node;
            node = node.next;
        }
        return null;
    }

    @Override public void makeNull() {
        Node node = head;
        while (node != null) {
            node.data = RangeType.NODEF;
            node = node.next;
        }
    }

    @Override public void assign(int key, char value) {
        Node node = getNode(key);
        if (node != null) node.data = value;
    }

    @Override public boolean compute(int key, RangeType r) {
        Node node = getNode(key);
        if (node == null || node.data == RangeType.NODEF) return false;
        r.setC(node.data);
        return true;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(String.format("%3d", node.key));
            node = node.next;
        }
        sb.append("\n");
        node = head;
        while (node != null) {
            sb.append(String.format("%3c", node.data));
            node = node.next;
        }
        return sb.toString();
    }
}

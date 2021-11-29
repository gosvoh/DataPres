package SecondLab.LinkedList;

import FirstLab.LinkedList.Pos;
import FirstLab.ListData;
import SecondLab.AMap;

public class Map extends AMap {
    Node head;

    public Map() {
        Node node = new Node(RangeType.NODEF);
        head = node;
        for (int i = RangeType.FIRST + 1; i <= RangeType.LAST; i++) {
            node.next = new Node(RangeType.NODEF);
            node = node.next;
        }
    }

    @Override public void makeNull() {
        Node node = head;
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++) {
            node.data = RangeType.NODEF;
            node = node.next;
        }
    }

    @Override public void assign(int key, char value) {
        Node node = head;
        for (int i = 0; i < key; i++) node = node.next;
        node.data = value;
    }

    @Override public boolean compute(int key, RangeType r) {
        Node node = head;
        for (int i = 0; i < key; i++) node = node.next;
        if (node.data == RangeType.NODEF) return false;
        r.setC(node.data);
        return true;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = RangeType.LAST - RangeType.FIRST + 1;
        for (int i = 0; i < size; i++) sb.append(String.format("%3d", i));
        sb.append("\n");
        Node node = head;
        while (node != null) {
            sb.append(String.format("%3c", node.data));
            node = node.next;
        }
        return sb.toString();
    }
}

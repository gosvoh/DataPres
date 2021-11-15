package SecondLab.LinkedList;

public class Node {
    Node next;
    char data;

    Node() {
        this(null, (char) 0);
    }

    Node(Node next) {
        this(next, (char) 0);
    }

    Node(char data) {
        this(null, data);
    }

    Node(Node next, char data) {
        this.next = next;
        this.data = data;
    }
}

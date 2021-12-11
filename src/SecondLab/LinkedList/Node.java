package SecondLab.LinkedList;

public class Node {
    Node next;
    int key;
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

    Node(int key, char data) {
        this(null, key, data);
    }

    Node(Node next, char data) {
        this.next = next;
        this.data = data;
    }

    Node(Node next, int key, char data) {
        this.next = next;
        this.key = key;
        this.data = data;
    }
}

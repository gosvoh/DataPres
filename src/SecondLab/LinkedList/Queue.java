package SecondLab.LinkedList;

import SecondLab.IQueue;

public class Queue implements IQueue {

    private Node tail;

    public Queue() {
        tail = null;
    }

    @Override public void enqueue(char data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
            return;
        }
        Node node = tail.next;
        while (node.next != tail) node = node.next;
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    @Override public char dequeue() {
        if (tail == null) throw new NullPointerException();
        char data = tail.next.data;
        if (tail == tail.next) tail = null;
        else tail.next = tail.next.next;
        return data;
    }

    @Override public char front() {
        if (tail == null) throw new NullPointerException();
        return tail.next.data;
    }

    @Override public void makeNull() {
        tail = null;
    }

    @Override public boolean full() {
        return false;
    }

    @Override public boolean empty() {
        return tail == null;
    }

    @Override public String toString() {
        if (tail == null) return "Queue is empty!";
        Node node = tail.next;
        StringBuilder sb = new StringBuilder();
        while (node != tail) {
            sb.append(node.data).append(" ");
            node = node.next;
        }
        sb.append(node.data);
        return sb.toString();
    }
}

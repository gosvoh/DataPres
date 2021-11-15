package SecondLab.LinkedList;

import SecondLab.IStack;

public class Stack implements IStack {

    Node tail;

    public Stack() {
        tail = null;
    }

    @Override public void push(char data) {
        if (tail == null) tail = new Node(data);
        else tail = new Node(tail, data);
    }

    @Override public char pop() {
        if (tail == null) throw new NullPointerException();
        char data = tail.data;
        tail = tail.next;
        return data;
    }

    @Override public char peek() {
        if (tail == null) throw new NullPointerException();
        return tail.data;
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
        if (empty()) return "Stack is empty!";
        Node node = tail;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.data).append(" ");
            node = node.next;
        }
        return sb.toString();
    }
}

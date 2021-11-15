package SecondLab.Array;

import SecondLab.IQueue;

public class Queue implements IQueue {

    private final char[] array;
    private final int MAX_SIZE = 10;
    private int head, tail;

    public Queue() {
        array = new char[MAX_SIZE];
        head = 0;
        tail = MAX_SIZE - 1;
    }

    @Override public void enqueue(char data) {
        if (full()) return;
        tail = next(tail);
        array[tail] = data;
    }

    @Override public char dequeue() {
        if (empty()) throw new NullPointerException();
        char data = array[head];
        head = next(head);
        return data;
    }

    @Override public char front() {
        if (empty()) throw new NullPointerException();
        return array[head];
    }

    @Override public void makeNull() {
        head = tail = -1;
    }

    @Override public boolean full() {
        return next(next(tail)) == head;
    }

    @Override public boolean empty() {
        return next(tail) == head;
    }

    private int next(int pos) {
        return (pos + 1) % MAX_SIZE;
    }

    @Override public String toString() {
        if (empty())
            return "Queue is empty!";
        StringBuilder stringBuilder = new StringBuilder();

        int i;
        for (i = head; i != tail; i = next(i))
            stringBuilder.append(array[i]).append(" ");
        stringBuilder.append(array[i]);

        return stringBuilder.toString();
    }
}

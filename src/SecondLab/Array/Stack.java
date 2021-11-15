package SecondLab.Array;

import SecondLab.IStack;

public class Stack implements IStack {

    private final char[] array;
    private final int    MAX_SIZE = 10;
    private       int    pointer;

    public Stack() {
        array = new char[MAX_SIZE];
        pointer = -1;
    }

    @Override public void push(char data) {
        if (pointer == MAX_SIZE - 1) return;
        array[++pointer] = data;
    }

    @Override public char pop() {
        if (pointer == -1) throw new NullPointerException();
        return array[pointer--];
    }

    @Override public char peek() {
        if (pointer == -1) throw new NullPointerException();
        return array[0];
    }

    @Override public void makeNull() {
        pointer = -1;
    }

    @Override public boolean full() {
        return pointer == MAX_SIZE - 1;
    }

    @Override public boolean empty() {
        return pointer == -1;
    }

    @Override public String toString() {
        if (empty()) return "Stack is empty!";
        StringBuilder sb = new StringBuilder();
        int pointer = this.pointer;
        while (pointer != -1) {
            sb.append(array[pointer]).append(" ");
            pointer--;
        }
        return sb.toString();
    }
}

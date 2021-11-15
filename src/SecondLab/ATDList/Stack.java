package SecondLab.ATDList;

import FirstLab.IPos;
import FirstLab.LinkedList.List;
import FirstLab.ListData;
import SecondLab.IStack;

public class Stack implements IStack {

    List list;

    public Stack() {
        list = new List();
    }

    @Override public void push(char data) {
        if (list == null) list = new List();
        list.insert(list.end(), new ListData(new char[]{data}, new char[0]));
    }

    @Override public char pop() {
        if (empty()) throw new NullPointerException();
        IPos pos = list.first();
        while (list.next(pos) != null && !list.next(pos).equals(list.end()))
            pos = list.next(pos);
        char data = list.retrieve(pos).getName()[0];
        list.delete(pos);
        return data;
    }

    @Override public char peek() {
        if (empty()) throw new NullPointerException();
        return list.retrieve(list.end()).getName()[0];
    }

    @Override public void makeNull() {
        list.makeNull();
    }

    @Override public boolean full() {
        return false;
    }

    @Override public boolean empty() {
        return list.empty();
    }

    @Override public String toString() {
        if (empty()) return "Stack is empty!";
        StringBuilder sb = new StringBuilder();
        IPos pos = list.first();
        while (list.next(pos) != null && !list.next(pos).equals(list.end()))
            pos = list.next(pos);
        while (!pos.equals(list.first())) {
            sb.append(list.retrieve(pos).getName()[0]).append(" ");
            pos = list.previous(pos);
        }
        sb.append(list.retrieve(pos).getName()[0]);
        return sb.toString();
    }
}

package SecondLab.ATDList;

import FirstLab.IPos;
import FirstLab.LinkedList.List;
import FirstLab.ListData;
import SecondLab.IQueue;

public class Queue implements IQueue {

    List list;

    public Queue() {
        list = new List();
    }

    @Override public void enqueue(char data) {
        list.insert(list.end(), new ListData(new char[]{data}, new char[0]));
    }

    @Override public char dequeue() {
        if (empty()) throw new NullPointerException();
        char data = list.retrieve(list.first()).getName()[0];
        list.delete(list.first());
        return data;
    }

    @Override public char front() {
        if (empty()) throw new NullPointerException();
        return list.retrieve(list.first()).getName()[0];
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
        if (empty()) return "Queue is empty!";
        StringBuilder sb = new StringBuilder();
        IPos pos = list.first();
        while (list.next(pos) != null && pos != list.end()) {
            sb.append(list.retrieve(pos).getName()[0]).append(" ");
            pos = list.next(pos);
        }
        sb.append(list.retrieve(pos).getName()[0]);
        return sb.toString();
    }
}

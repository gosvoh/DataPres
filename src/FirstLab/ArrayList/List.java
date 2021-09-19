package FirstLab.ArrayList;

import FirstLab.IList;
import FirstLab.INode;
import FirstLab.IPos;
import FirstLab.NullPosException;

public class List implements IList {
    private final int    maxLength = 10;
    private final Node[] array;
    private final Pos    tail;

    public List() {
        this.array = new Node[maxLength];
        this.tail = new Pos(-1);
    }

    private void checkPos(Pos pos) {
        if (pos.getPos() < 0 || pos.getPos() >= maxLength)
            throw new NullPosException("It's impossible to get object in empty position!");
    }

    @Override public void insert(IPos pos, char[] name, char[] address) {
        checkPos((Pos) pos);
        for (int i = end().getPos(), curP = ((Pos) pos).getPos(); i > curP; i--)
            array[i] = array[i - 1];
        array[((Pos) pos).getPos()] = new Node(name, address);
        this.tail.setPos(this.tail.getPos() + 1);
    }

    @Override public Pos first() {
        if (this.tail.getPos() == -1) return end();
        else return new Pos(0);
    }

    @Override public Pos end() {
        return new Pos(this.tail.getPos() + 1);
    }

    @Override public Pos locate(INode node) {
        Pos p = new Pos(0);
        for (int i = 0, last = this.tail.getPos(); i < last; i++)
            if (node.equals(array[i])) {
                p.setPos(i);
                break;
            }
        return p;
    }

    @Override public Node retrieve(IPos pos) {
        checkPos((Pos) pos);
        return array[((Pos) pos).getPos()];
    }

    @Override public void delete(IPos pos) {
        checkPos((Pos) pos);
        for (int i = ((Pos) pos).getPos(), last = this.tail.getPos(); i < last; i++) {
            array[i].setName(array[i + 1].getName());
            array[i].setAddress(array[i + 1].getAddress());
        }
        this.tail.setPos(this.tail.getPos() - 1);
    }

    @Override public Pos next(IPos pos) {
        checkPos((Pos) pos);
        return new Pos(((Pos) pos).getPos() + 1);
    }

    @Override public Pos previous(IPos pos) {
        checkPos((Pos) pos);
        return new Pos(((Pos) pos).getPos() - 1);
    }

    @Override public void makeNull() {
        tail.setPos(-1);
    }

    @Override public void printList() {
        System.out.println(this);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName()).append(":").append(System.lineSeparator());
        if (this.tail.getPos() == -1) sb.append("List is empty!");
        for (int i = 0, last = end().getPos(); i < last; i++)
            if (array[i].getName()[0] != 0 && array[i].getName()[0] != 0) {
                sb.append(array[i]);
                if (i + 1 != last) sb.append(",").append(System.lineSeparator());
            }
        return sb.toString();
    }
}

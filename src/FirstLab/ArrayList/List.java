package FirstLab.ArrayList;

import FirstLab.IList;
import FirstLab.IPos;
import FirstLab.Node;
import FirstLab.NullPosException;

public class List implements IList {
    private static final int    MAX_LENGTH = 10;
    private final        Node[] array;
    /**
     * Последний занятый
     */
    private final        Pos    tail;

    public List() {
        this.array = new Node[MAX_LENGTH];
        this.tail = new Pos(-1);
    }

    @Override public void insert(IPos pos, char[] name, char[] address) {
        if (((Pos) pos).getPos() < 0 || ((Pos) pos).getPos() >= MAX_LENGTH) return;
        for (int i = tail.getPos(), curP = ((Pos) pos).getPos(); i > curP; i--)
            array[i + 1] = array[i];
        array[((Pos) pos).getPos()] = new Node(name, address);
        this.tail.setPos(this.tail.getPos() + 1);
    }

    @Override public Pos first() {
        return new Pos(0);
    }

    /**
     * @return Позиция после последнего
     */
    @Override public Pos end() {
        return new Pos(this.tail.getPos() + 1);
    }

    @Override public Pos locate(Node node) {
        if (tail.getPos() == -1 || node == null) throw new NullPosException("List is empty or wrong element!");
        for (int i = 0, last = this.tail.getPos(); i < last; i++)
            if (node.equals(array[i])) return new Pos(i);

        return new Pos(this.tail.getPos() + 1);
    }

    @Override public Node retrieve(IPos pos) {
        if (tail.getPos() == -1 || ((Pos) pos).getPos() < 0 || ((Pos) pos).getPos() > tail.getPos())
            throw new NullPosException("List is empty or wrong position!");
        return array[((Pos) pos).getPos()];
    }

    @Override public void delete(IPos pos) {
        if (tail.getPos() == -1 || ((Pos) pos).getPos() < 0 || ((Pos) pos).getPos() > tail.getPos()) return;
        for (int i = ((Pos) pos).getPos(), last = this.tail.getPos(); i < last; i++) array[i] = array[i + 1];
        array[this.tail.getPos()] = null;
        this.tail.setPos(this.tail.getPos() - 1);
    }

    @Override public Pos next(IPos pos) {
        if (tail.getPos() == -1 || ((Pos) pos).getPos() < 0 || ((Pos) pos).getPos() > tail.getPos())
            throw new NullPosException("List is empty or wrong position!");
        return new Pos(((Pos) pos).getPos() + 1);
    }

    @Override public Pos previous(IPos pos) {
        if (tail.getPos() == -1 || ((Pos) pos).getPos() <= 0 || ((Pos) pos).getPos() > tail.getPos())
            throw new NullPosException("List is empty or wrong position!");
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

package FirstLab.CursorList;

import FirstLab.IPos;
import FirstLab.ListData;

import java.util.Objects;

class Pos implements IPos {
    private ListData listData;
    private int      next;

    public Pos() {
        this.listData = null;
        this.next = -1;
    }

    public ListData getListObj() {
        return listData;
    }

    public void setListObj(ListData listData) {
        this.listData = listData;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    @Override public String toString() {
        if (listData == null) return "Empty element!";
        else return listData.toString();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pos)) return false;
        return next == ((Pos) o).getNext();
    }

    @Override public int hashCode() {
        return Objects.hash(listData);
    }
}
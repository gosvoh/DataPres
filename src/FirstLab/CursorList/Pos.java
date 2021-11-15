package FirstLab.CursorList;

import FirstLab.IPos;

import java.util.Objects;

class Pos implements IPos {
    public MemoryCell cell;

    public Pos() {
        cell = null;
    }

    public Pos(MemoryCell cell) {
        this.cell = cell;
    }

    @Override public String toString() {
        if (cell == null || cell.listData == null) return "Empty element!";
        else return cell.listData.toString();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pos)) return false;
        return cell == ((Pos) o).cell;
    }

    @Override public int hashCode() {
        return Objects.hash(cell);
    }
}
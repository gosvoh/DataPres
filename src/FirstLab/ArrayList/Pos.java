package FirstLab.ArrayList;

import FirstLab.IPos;

import java.util.Objects;

public class Pos implements IPos {
    private int pos;

    public Pos(int pos) {
        this.pos = pos;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @Override public String toString() {
        return String.valueOf(pos);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pos)) return false;
        Pos pos1 = (Pos) o;
        return pos == pos1.pos;
    }

    @Override public int hashCode() {
        return Objects.hash(pos);
    }
}

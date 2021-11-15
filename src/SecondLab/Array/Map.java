package SecondLab.Array;

import SecondLab.AMap;

public class Map extends AMap {

    private final RangeType[] array;

    public Map() {
        array = new RangeType[RangeType.LAST - RangeType.FIRST + 1];
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++)
            array[i - RangeType.FIRST] = new RangeType(RangeType.NODEF);
    }

    public void makeNull() {
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++) array[i - RangeType.FIRST].setC(RangeType.NODEF);
    }

    public void assign(int d, char r) {
        array[d].setC(r);
    }

    public boolean compute(int d, RangeType r) {
        if (array[d].getC() == RangeType.NODEF) return false;
        r.setC(array[d].getC());
        return true;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) sb.append(String.format("%3d", i));
        sb.append("\n");
        for (RangeType r : array) sb.append(r);
        return sb.toString();
    }
}

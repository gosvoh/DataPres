package SecondLab;

public class Map implements IMap {

    public static class RangeType {
        private char             c;
        public final static char NODEF = '?';
        public final static char FIRST = 'A';
        public final static char LAST = 'Z';

        public RangeType(char x) {
            c = x;
        }

        @Override public String toString() {
            return String.format("%3c", c);
        }
    }

    private final RangeType[] array;

    public Map() {
        array = new RangeType[RangeType.LAST - RangeType.FIRST + 1];
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++)
            array[i - RangeType.FIRST] = new RangeType(RangeType.NODEF);
    }

    @Override public void makeNull() {
        for (int i = RangeType.FIRST; i <= RangeType.LAST; i++) array[i - RangeType.FIRST].c = RangeType.NODEF;
    }

    @Override public void assign(int d, char r) {
        array[d].c = r;
    }

    @Override public boolean compute(int d, RangeType r) {
        if (array[d].c == RangeType.NODEF) return false;
        r.c = array[d].c;
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

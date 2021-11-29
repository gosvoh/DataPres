package SecondLab;

public abstract class AMap {

    public abstract void makeNull();

    public abstract void assign(int key, char value);

    public abstract boolean compute(int key, RangeType r);

    protected static class RangeType {
        public final static char NODEF = '?';
        public final static char FIRST = 'A';
        public final static char LAST  = 'Z';
        private             char c;

        public RangeType(char x) {
            c = x;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        @Override public String toString() {
            return String.format("%3c", c);
        }
    }
}

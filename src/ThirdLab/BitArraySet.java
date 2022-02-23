package ThirdLab;

public class BitArraySet implements Set {

    private int[] array;
    private int[] bitarray;
    private final int min, max;
    private int zero;
    private int minInt;

    public static void main(String[] args) {

    }

    public BitArraySet(int min, int max) {
        this.min = min;
        this.max = max;
//        minInt = -1 >>> 1;
//        minInt = ~minInt;
        minInt = Integer.MIN_VALUE;
    }

    @Override public Set union(Set otherSet) {
        return null;
    }

    @Override public Set intersection(Set otherSet) {
        return null;
    }

    @Override public Set difference(Set otherSet) {
        return null;
    }

    @Override public void insert(int element) {
        if (element < min || element > max) return;
    }

    @Override public void delete(int element) {
        if (element < min || element > max) return;
    }

    @Override public void assign(Set otherSet) {

    }

    @Override public int min() {
        return min;
    }

    @Override public int max() {
        return max;
    }

    @Override public void makeNull() {

    }

    @Override public boolean contains(int element) {
        if (element < min || element > max) return false;
        return false;
    }

    @Override public Set merge(Set otherSet) {
        return null;
    }

    @Override public Set find(Set otherSet, int element) {
        return null;
    }
}

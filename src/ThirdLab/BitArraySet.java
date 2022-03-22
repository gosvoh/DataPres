package ThirdLab;

import java.util.Arrays;

public class BitArraySet implements Set {

    private final int[] array;
    private final int   offset;
    private final int   min, max;

    // minInt = -1 >>> 1;
    // minInt = ~minInt;
    private final int minInt = Integer.MIN_VALUE;

    public BitArraySet(int min, int max) {
        this.min = min;
        this.max = max;

        offset = min / 32 - (min < 0 ? (min % 32 == 0 ? 0 : 1) : 0);

        int arraySize = (max / 32 - min / 32) + (min < 0 ? (min % 32 == 0 ? 1 : 2) : 1) - (max < 0 ? 1 : 0);

        array = new int[arraySize];
    }

    public static void main(String[] args) {

    }

    public int size() {
        return array.length;
    }

    public int offset() {return offset;}

    public int[] getArray() {
        return array;
    }

    @Override public Set union(Set otherSet) {
        BitArraySet ret = new BitArraySet(Math.min(min, otherSet.getMinRange()),
                Math.max(max, otherSet.getMaxRange()));



        return ret;
    }

    @Override public Set intersection(Set otherSet) {
        return null;
    }

    @Override public Set difference(Set otherSet) {
        return null;
    }

    @Override public void insert(int element) {
        if (element < min || element > max) return;
        Position pos = findPosition(element);
        array[pos.cell] |= minInt >>> pos.pos;
    }

    @Override public void delete(int element) {
        if (element < min || element > max) return;
        Position pos = findPosition(element);
        array[pos.cell] ^= minInt >>> pos.pos;
    }

    @Override public void assign(Set otherSet) {

    }

    @Override public int min() {
        for (int i = 0; i < array.length; i++) {
            int arrayElement = array[i];
            if (arrayElement == 0) continue;
            for (int j = 0, localOffset = 0, mask = minInt; j < 32; j++, localOffset++, mask >>= 1)
                if ((arrayElement & mask) != 0) return (offset + i) * 32 + localOffset;
        }
        throw new NullPointerException();
    }

    @Override public int getMinRange() {
        return min;
    }

    @Override public int max() {
        for (int i = array.length - 1; i >= 0; i--) {
            int arrayElement = array[i];
            if (arrayElement == 0) continue;
            for (int j = 0, localOffset = 31, mask = 1; j < 32; j++, localOffset--, mask <<= 1)
                if ((arrayElement & mask) != 0) return (offset + i) * 32 + localOffset;
        }
        throw new NullPointerException();
    }

    @Override public int getMaxRange() {
        return max;
    }

    @Override public void makeNull() {
        Arrays.fill(array, 0);
    }

    @Override public boolean contains(int element) {
        if (element < min || element > max) return false;
        Position pos = findPosition(element);
        int mask = minInt >>> pos.pos;
        return (array[pos.cell] & mask) != 0;
    }

    @Override public Set merge(Set otherSet) {
        return null;
    }

    @Override public Set find(Set otherSet, int element) {
        return null;
    }

    @Override public String toString() {
        String ret = "BitArraySet{array=" + Arrays.toString(array) + ",set=\"";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            int mask = minInt;
            int localOffset = 0;
            while (mask != 0) {
                if ((j & mask) != 0) sb.append((offset + i) * 32 + localOffset).append(",");
                mask = mask >>> 1;
                localOffset++;
            }
        }
        if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);

        ret += sb + "\"}";
        return ret;
    }

    private Position findPosition(int element) {
        int d = element - min;
        return new Position(d / 32, d % 32);
    }

    private static class Position {
        int cell;
        int pos;

        Position(int cell, int pos) {
            this.cell = cell;
            this.pos = pos;
        }
    }
}

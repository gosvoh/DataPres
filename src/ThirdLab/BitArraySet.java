package ThirdLab;

import FirstLab.LinkedList.Pos;

import java.util.Arrays;

public class BitArraySet implements Set {

    private final  int[] array;
    private final int   offset;
    private final int   min, max;
    private final int minInt = Integer.MIN_VALUE;

    public BitArraySet(int min, int max) {
        this.min = min;
        this.max = max;
        //        minInt = -1 >>> 1;
        //        minInt = ~minInt;
        offset = min / 32 - (min < 0 ? (min % 32 == 0 ? 0 : 1) : 0);

        int arraySize = (max / 32 - min / 32) + (min < 0 ? (min % 32 == 0 ? 1 : 2) : 1) - (max < 0 ? 1 : 0);

        array = new int[arraySize];
    }

    public static void main(String[] args) {
        BitArraySet arraySet = new BitArraySet(-65, 31);
        arraySet.insert(0);
        System.out.println(arraySet);
        arraySet.insert(6);
        arraySet.insert(31);
        System.out.println(arraySet);
        System.out.println(arraySet.min());
        arraySet.delete(0);
        System.out.println(arraySet);
        System.out.println(arraySet.min());
    }

    public int size() {
        return array.length;
    }

    public int offset() {return offset;}

    public int[] getArray() {
        return array;
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

    private void insDelOperation(int element, char operation) {
        int exponent = getExponent(element);
        int val = exponent * 32;
        int mask = minInt;
        while (val != element) {
            val++;
            mask = mask >>> 1;
        }
        int cell = array.length - 1 + exponent;
        if (operation == 'i') array[cell] = array[cell] | mask;
        if (operation == 'd') array[cell] = array[cell] ^ mask;
    }

    private int getExponent(int element) {
        return element / 32 - (element < 0 ? (element % 32 == 0 ? 0 : 1) : 0);
    }

    @Override public void insert(int element) {
        if (element < min || element > max) return;
        Position pos = findPosition(element);
        array[pos.cell] |= minInt >>> pos.pos;
    }

    @Override public void delete(int element) {
        if (element < min || element > max) return;
        insDelOperation(element, 'd');
    }

    @Override public void assign(Set otherSet) {

    }

    @Override public int min() {
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            if (j == 0) continue;
            int mask = minInt;
            int localOffset = 0;
            while ((j & mask) == 0 && mask != 0) {
                mask = mask >>> 1;
                localOffset++;
            }
            if (mask != 0)
                return (offset + i) * 32 + localOffset;
        }
        return Integer.MAX_VALUE;
    }

    @Override public int max() {
        for (int i = array.length - 1; i >= 0; i--) {
            int j = array[i];
            if (j == 0) continue;
            int mask = minInt;
            int max = mask;
            int localOffset = 0;
            while (mask != 0) {
                mask = mask >>> 1;
                localOffset++;
                if ((j & mask) == 0)
                    max = mask;
            }
            if (mask != 0) return (offset + i) * 32 + localOffset;
        }
        return minInt;
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
        if (min < 0) {
//            if (element < 0)
//                return new Position(-element / 32, -element % 32);
            return new Position((-min + element) / 32, (-min + element) % 32);
        }
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

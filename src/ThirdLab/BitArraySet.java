package ThirdLab;

import java.util.Arrays;

public class BitArraySet implements Set {

    private       int[] array;
    private       int[] bitarray;
    private final int   offset;
    private final int   min, max;
    private final int minInt = Integer.MIN_VALUE;

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

    public BitArraySet(int min, int max) {
        this.min = min;
        this.max = max;
        //        minInt = -1 >>> 1;
        //        minInt = ~minInt;
        offset = min / 32 - (min < 0 ? (min % 32 == 0 ? 0 : 1) : 0);

        int arraySize = (max / 32 - min / 32) + (min < 0 ? (min % 32 == 0 ? 1 : 2) : 1) - (max < 0 ? 1 : 0);

        array = new int[arraySize];
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

    private void insDelOperation(int element, boolean isInsert) {
        int zeroOffset = element / 32 - (element < 0 ? (element % 32 == 0 ? 0 : 1) : 0);
        int val = zeroOffset * 32;
        int mask = minInt;
        while (val != element) {
            val++;
            mask = mask >>> 1;
        }
        int cell = array.length - 1 + zeroOffset;
        if (isInsert) array[cell] = array[cell] | mask;
        else array[cell] = array[cell] ^ mask;
    }

    @Override public void insert(int element) {
        if (element < min || element > max) return;
        insDelOperation(element, true);
    }

    @Override public void delete(int element) {
        if (element < min || element > max) return;
        insDelOperation(element, false);
    }

    @Override public void assign(Set otherSet) {

    }

    @Override public int min() {
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            int mask = minInt;
            int localOffset = 0;
            while ((j & mask) == 0 && mask != 0) {
                mask = mask >>> 1;
                localOffset++;
            }
            if (mask != 0) return (offset + i) * 32 + localOffset;
        }
        return minInt;
    }

    @Override public int max() {
        return max;
    }

    @Override public void makeNull() {
        Arrays.fill(array, 0);
    }

    @Override public boolean contains(int element) {
        if (element < min || element > max) return false;
        int zeroOffset = element / 32 - (element < 0 ? (element % 32 == 0 ? 0 : 1) : 0);
        int val = zeroOffset * 32;
        int mask = minInt;
        while (val != element) {
            val++;
            mask = mask >>> 1;
        }
        return (array[array.length - 1 + zeroOffset] & mask) == 0;
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
}

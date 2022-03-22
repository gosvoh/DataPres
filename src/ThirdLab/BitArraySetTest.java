package ThirdLab;

import org.junit.Assert;
import org.junit.Test;

public class BitArraySetTest {

    @Test public void ZeroThirtyOne() {
        BitArraySet arraySet = new BitArraySet(0, 31);
        Assert.assertEquals(0, arraySet.offset());
        Assert.assertEquals(1, arraySet.size());
    }

    @Test public void ZeroThirtyTwo() {
        BitArraySet arraySet = new BitArraySet(0, 32);
        Assert.assertEquals(0, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void ZeroSixtyThree() {
        BitArraySet arraySet = new BitArraySet(0, 63);
        Assert.assertEquals(0, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void ZeroSixtyFour() {
        BitArraySet arraySet = new BitArraySet(0, 64);
        Assert.assertEquals(0, arraySet.offset());
        Assert.assertEquals(3, arraySet.size());
    }

    @Test public void MinusOneThirtyOne() {
        BitArraySet arraySet = new BitArraySet(-1, 31);
        Assert.assertEquals(-1, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void MinusOneThirtyTwo() {
        BitArraySet arraySet = new BitArraySet(-1, 32);
        Assert.assertEquals(-1, arraySet.offset());
        Assert.assertEquals(3, arraySet.size());
    }

    @Test public void MinusOneZero() {
        BitArraySet arraySet = new BitArraySet(-1, 0);
        Assert.assertEquals(-1, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void MinusThirtyTwoThirtyTwo() {
        BitArraySet arraySet = new BitArraySet(-32, 32);
        Assert.assertEquals(-1, arraySet.offset());
        Assert.assertEquals(3, arraySet.size());
    }

    @Test public void TwoThirty() {
        BitArraySet arraySet = new BitArraySet(2, 30);
        Assert.assertEquals(0, arraySet.offset());
        Assert.assertEquals(1, arraySet.size());
    }

    @Test public void TwoSixtyThree() {
        BitArraySet arraySet = new BitArraySet(2, 63);
        Assert.assertEquals(0, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void ThirtyTwoSixtyThree() {
        BitArraySet arraySet = new BitArraySet(32, 63);
        Assert.assertEquals(1, arraySet.offset());
        Assert.assertEquals(1, arraySet.size());
    }

    @Test public void MinusTwoThirty() {
        BitArraySet arraySet = new BitArraySet(-2, 30);
        Assert.assertEquals(-1, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void MinusThirtyThreeMinusOne() {
        BitArraySet arraySet = new BitArraySet(-33, -1);
        Assert.assertEquals(-2, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void MinusSixtyFiveMinusOne() {
        BitArraySet arraySet = new BitArraySet(-65, -1);
        Assert.assertEquals(-3, arraySet.offset());
        Assert.assertEquals(3, arraySet.size());
    }

    @Test public void MinusSixtyFiveMinusThirtyThree() {
        BitArraySet arraySet = new BitArraySet(-65, -33);
        Assert.assertEquals(-3, arraySet.offset());
        Assert.assertEquals(2, arraySet.size());
    }

    @Test public void Contains() {
        BitArraySet arraySet = new BitArraySet(-128, 127);
        Assert.assertEquals(8, arraySet.size());
        arraySet.insert(0);
        arraySet.insert(-5);
        arraySet.insert(5);
        Assert.assertTrue(arraySet.contains(-5));
        Assert.assertTrue(arraySet.contains(0));
        Assert.assertTrue(arraySet.contains(5));
        Assert.assertFalse(arraySet.contains(1));
    }

    @Test public void Insert() {
        BitArraySet arraySet = new BitArraySet(-128, 127);
        arraySet.insert(0);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, Integer.MIN_VALUE, 0, 0, 0}, arraySet.getArray());
        arraySet.insert(-5);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 16, Integer.MIN_VALUE, 0, 0, 0}, arraySet.getArray());
        arraySet.insert(5);
        int min = Integer.MIN_VALUE | Integer.MIN_VALUE >>> 5;
        Assert.assertArrayEquals(new int[]{0, 0, 0, 16, min, 0, 0, 0}, arraySet.getArray());
    }

    @Test public void Min() {
        BitArraySet arraySet = new BitArraySet(-128, 127);
        arraySet.insert(127);
        Assert.assertEquals(127, arraySet.min());
        arraySet.insert(64);
        Assert.assertEquals(64, arraySet.min());
        arraySet.insert(32);
        Assert.assertEquals(32, arraySet.min());
        arraySet.insert(5);
        Assert.assertEquals(5, arraySet.min());
        arraySet.insert(0);
        Assert.assertEquals(0, arraySet.min());
        arraySet.insert(-5);
        Assert.assertEquals(-5, arraySet.min());
        arraySet.insert(-32);
        Assert.assertEquals(-32, arraySet.min());
        arraySet.insert(-64);
        Assert.assertEquals(-64, arraySet.min());
        arraySet.insert(-128);
        Assert.assertEquals(-128, arraySet.min());

    }

    @Test public void Max() {
        BitArraySet arraySet = new BitArraySet(-128, 127);
        arraySet.insert(-128);
        Assert.assertEquals(-128, arraySet.max());
        arraySet.insert(-64);
        Assert.assertEquals(-64, arraySet.max());
        arraySet.insert(-32);
        Assert.assertEquals(-32, arraySet.max());
        arraySet.insert(-5);
        Assert.assertEquals(-5, arraySet.max());
        arraySet.insert(0);
        Assert.assertEquals(0, arraySet.max());
        arraySet.insert(5);
        Assert.assertEquals(5, arraySet.max());
        arraySet.insert(32);
        Assert.assertEquals(32, arraySet.max());
        arraySet.insert(64);
        Assert.assertEquals(64, arraySet.max());
        arraySet.insert(127);
        Assert.assertEquals(127, arraySet.max());
    }

    @Test public void Union() {
        BitArraySet arraySet1 = new BitArraySet(-128, 127);
        arraySet1.insert(0);
        arraySet1.insert(5);

        BitArraySet arraySet2 = new BitArraySet(-128, 127);
        arraySet2.insert(-5);
        arraySet2.insert(-32);

        arraySet1.union(arraySet2);
    }

}

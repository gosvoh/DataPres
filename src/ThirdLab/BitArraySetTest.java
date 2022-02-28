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

    @Test public void Insert() {
        BitArraySet arraySet = new BitArraySet(-128, 127);
        Assert.assertEquals(8, arraySet.size());
        arraySet.insert(0);
        Assert.assertTrue(arraySet.contains(0));
    }

}

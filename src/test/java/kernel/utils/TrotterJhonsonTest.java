package kernel.utils;


import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;
import it.unimi.dsi.fastutil.ints.IntArrayList;


public class TrotterJhonsonTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorWith0() {
        new TrotterJhonson(0);
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithNegative() {
        new TrotterJhonson(-1);
    }

    @Test
    public void constructorTest() {
        final TrotterJhonson tj = new TrotterJhonson(11);
        final int[] array = {1,2,3,4,5,6,7,8,9,10,11};
        Assert.assertEquals(tj.getCurrentPermutation(), new IntArrayList(array));
        Assert.assertEquals(tj.getCurrentRanking(), 0);
        Assert.assertEquals(tj.getMaxPerm(), BigInteger.valueOf(39916800));
        Assert.assertEquals(tj.getRank(), BigInteger.valueOf(0));
        Assert.assertEquals(tj.getTam(), 11);
        final int[] nextPerm = {1,2,3,4,5,6,7,8,9,11,10};
        tj.nextPermutation();
        Assert.assertEquals(tj.getCurrentPermutation(), new IntArrayList(nextPerm));
        Assert.assertEquals(new IntArrayList(nextPerm), tj.unrankPermutation(BigInteger.valueOf(tj.getCurrentRanking())));
    }

}
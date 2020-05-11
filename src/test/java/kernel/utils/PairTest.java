package kernel.utils;

import org.junit.Assert;
import org.junit.Test;

import utils.Pair;

public class PairTest {

	@Test
	public void test() {
		final Pair<String, Double> x = new Pair<>("teste", 10.1);
		final Pair<String, Double> y = new Pair<>("teste", 10.1);

		Assert.assertEquals(x, y);

		Assert.assertEquals("teste", x.getKey());

		Assert.assertEquals(10.1, x.getValue(), 0);

		x.setKey("teste2");

		Assert.assertEquals("teste2", x.getKey());

		x.setValue(10.2);

		Assert.assertEquals(10.2, x.getValue(), 0);
	}

}

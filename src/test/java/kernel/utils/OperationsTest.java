package kernel.utils;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class OperationsTest {

	@Test
	public void testFactorial() {
		final BigInteger resultadoEsperado = new BigInteger("87178291200");
		final BigInteger resultadoObtido = Operations.factorial(BigInteger.valueOf(14));
		Assert.assertEquals(resultadoEsperado, resultadoObtido);
	}
}

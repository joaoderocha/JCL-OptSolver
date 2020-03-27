package kernel.utils;

import java.math.BigInteger;

/**
 * Operations.test
 */
public class Operations {
	public BigInteger factorial(BigInteger i) {
		if (i == BigInteger.ZERO || i == BigInteger.ONE) {
			return BigInteger.ONE;
		} else {
			return i.multiply(factorial(i.subtract(BigInteger.ONE)));
		}
	}
}
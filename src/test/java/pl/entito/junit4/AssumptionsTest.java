package pl.entito.junit4;

import static org.junit.Assume.assumeNoException;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;

public class AssumptionsTest {

	@Test
	public void testAssumeThat() {
		assumeNoException(new Exception());
	}

	@Test
	public void testAssumeTrue() {
		assumeTrue(true);
	}

}

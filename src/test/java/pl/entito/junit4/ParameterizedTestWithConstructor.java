package pl.entito.junit4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestWithConstructor {
	@Parameters(name = "test {0} -> {1} and {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, 2, 4 }, { 2, 4, 8 }, { 4, 8, 16 } });
	}

	private int input;

	private int expected;

	private int anotherExpected;

	public ParameterizedTestWithConstructor(int input, int expected, int anotherExpected) {
		this.input = input;
		this.expected = expected;
		this.anotherExpected = anotherExpected;
	}

	@Test
	public void test() {

		assertEquals(input * 2, expected);
		assertEquals(input * 2 * 2, anotherExpected);
	}

}
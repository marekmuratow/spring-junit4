package pl.entito.junit4;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testExceptionMessageWithRule() {
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage(equalTo("Index 0 out-of-bounds for length 0"));
		new ArrayList<Integer>().get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testException() {
		new ArrayList<Integer>().get(0);
	}

	@Test()
	public void testExceptionMessageWithTryCatchBlock() {
		try {
			new ArrayList<Integer>().get(0);
			fail("should not be here");
		} catch (IndexOutOfBoundsException e) {
			assertThat(e.getMessage(), equalTo("Index 0 out-of-bounds for length 0"));
			assertThat(e.getMessage(), containsString("Index 0"));
		}
	}

	@Ignore
	@Test()
	public void testExceptionIgnored() {
		fail("should be ignored");
	}

}

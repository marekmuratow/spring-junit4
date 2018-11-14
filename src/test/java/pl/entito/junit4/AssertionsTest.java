package pl.entito.junit4;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

public class AssertionsTest {

	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		assertArrayEquals("arrays are no the same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		assertEquals("failure - strings differ", "text", "text");
	}

	@Test
	public void testAssertFalse() {
		assertFalse("failure should be false", false);
	}

	@Test
	public void testAssertNotNull() {
		assertNotNull("failure, Object should not be null", new Object());
	}

	@Test
	public void testAssertNoSame() {
		assertNotSame("failure - object should not be the same", new Object(), new Object());
	}

	@Test
	public void testAssertNull() {
		assertNull("failure - should be null", null);
	}

	@Test
	public void testAssertSame() {
		Object obj = new Object();
		assertSame("failure should be same", obj, obj);
	}

	@Test
	public void testAssertThatBohContainsString() {
		assertThat("someText", both(containsString("some")).and(containsString("Text")));
	}

	@Test
	public void testAssertThatHasItems() {
		assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "two"));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		assertThat(Arrays.asList("one", "two", "othree"), everyItem(containsString("o")));
	}

	@Test
	public void assertThatHamcrestCoreMatchers() {
		assertThat("good", allOf(equalTo("good"), startsWith("g")));
		assertThat("good", not(allOf(equalTo("good"), equalTo("bad"))));
		assertThat("good", anyOf(equalTo("good"), equalTo("bad")));
		assertThat(7, not(CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4))));
		assertThat(4, CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4)));
		assertThat(new Object(), not(sameInstance(new Object())));
		assertThat(4, CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4)));
	}

}

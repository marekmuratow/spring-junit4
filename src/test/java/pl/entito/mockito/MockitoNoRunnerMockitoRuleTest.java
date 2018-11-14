package pl.entito.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import pl.entito.demo.beans.Greeter;

public class MockitoNoRunnerMockitoRuleTest {

	@Mock
	Greeter mockGreeter;

	// @RunWith(MockitoJUnitRunner.class) preferred, because adds mock framework
	// validation
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void test() {
		Mockito.when(mockGreeter.greet()).thenReturn("someString");
		System.out.println(mockGreeter.greet());
		System.out.println(mockGreeter.greet());
		Mockito.verify(mockGreeter, Mockito.atLeast(1)).greet();
		Mockito.verify(mockGreeter, Mockito.times(2)).greet();
		assertEquals("someString", mockGreeter.greet());
		Mockito.verify(mockGreeter, Mockito.times(3)).greet();
		Mockito.verify(mockGreeter, Mockito.atMost(3)).greet();
	}
}

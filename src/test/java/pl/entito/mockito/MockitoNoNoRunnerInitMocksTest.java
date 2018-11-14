package pl.entito.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pl.entito.demo.beans.Greeter;

public class MockitoNoNoRunnerInitMocksTest {

	@Mock
	Greeter mockGreeter;

	@Before
	public void before() {
		// @RunWith(MockitoJUnitRunner.class) preferred, because adds mock framework
		// validation
		MockitoAnnotations.initMocks(this);
	}

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

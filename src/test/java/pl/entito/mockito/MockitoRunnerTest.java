package pl.entito.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pl.entito.demo.beans.Greeter;

@RunWith(MockitoJUnitRunner.class)
public class MockitoRunnerTest {

	@Mock
	Greeter mockGreeter;

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

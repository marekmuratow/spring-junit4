package pl.entito.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import pl.entito.demo.beans.Greeter;
import pl.entito.demo.config.ApplicationConfiguration;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
public class MockitoRunnerWithSpringRuleTest {

	@Mock
	Greeter mockGreeter;

	@ClassRule
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();

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

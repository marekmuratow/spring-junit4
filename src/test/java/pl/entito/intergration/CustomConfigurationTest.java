package pl.entito.intergration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.entito.demo.beans.Greeter;
import pl.entito.demo.beans.SomeClass;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomConfigurationTest {

	@Configuration
	static class TestConfig {

		@Bean
		SomeClass someClass() {
			return new SomeClass();
		}

		@Bean
		Greeter greeter() {
			return new Greeter();
		}
	}

	@Autowired
	Greeter greeter;

	@Autowired
	SomeClass someClass;

	@Test
	public void notNull() {
		assertNotNull(someClass);
		assertNotNull(greeter);
	}

	@Test
	public void isEquals() {
		assertEquals("hi", someClass.sayHi());
		assertEquals("greetings", greeter.greet());
	}

}

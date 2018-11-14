package pl.entito.intergration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.entito.demo.Application;
import pl.entito.demo.beans.Greeter;
import pl.entito.demo.config.ApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ApplicationIntegrationTest {

	@Autowired
	Greeter greeter;

	@Autowired
	@Qualifier("greeter")
	Greeter anotherGreeter;

	@BeforeClass
	public static void beforeAll() {
		// do sth once before all tests
	}

	@Before
	public void beforeEach() {
		// do sth once before each test
	}

	@Test
	public void greeterNotNull() {
		assertNotNull(greeter);
	}

	@Test
	public void isSingleton() {
		assertSame(greeter, anotherGreeter);
	}

	@Test
	public void testGreet2() {
		assertEquals("greetings", greeter.greet());
	}

	@Test
	public void testMainApp() {
		// make a coverage tool happy ;)
		Application app = new Application();
		assertNotNull(app);
		Application.main(new String[] {});
	}

}

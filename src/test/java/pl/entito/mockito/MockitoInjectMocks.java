package pl.entito.mockito;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.entito.demo.beans.Composite;
import pl.entito.demo.beans.Part;

@RunWith(MockitoJUnitRunner.class)
public class MockitoInjectMocks {

	@Mock
	Part part;

	@InjectMocks // inject the part mock into the composite
	Composite composite;

	@Test
	public void notNull() {
		assertNotNull(part);
		assertNotNull(composite);
		assertNotNull(composite.getPart());
	}

}

package pl.entito.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoMockVsSpy {

	@Mock // can mock List interface
	private ArrayList<String> mockList;

	@Spy // cannot mock List interface, must be concrete
	private ArrayList<String> spyList;

	@Test
	public void mockSizeListTest() {

		mockList.add("one");
		assertEquals(0, mockList.size()); // IMPORTANT
	}

	@Test
	public void spySizeListTest() {

		spyList.add("one");
		assertEquals(1, spyList.size());
	}

	@Test
	public void mockDoReturnSizeListTest() {

		when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());
	}

	@Test
	public void spyDoReturnSizeListTest() {

		when(spyList.size()).thenReturn(100);
		assertEquals(100, spyList.size());
	}

}

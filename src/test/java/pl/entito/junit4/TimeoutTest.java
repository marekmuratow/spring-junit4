package pl.entito.junit4;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	@Test
	public void testTimeout() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
	}

}

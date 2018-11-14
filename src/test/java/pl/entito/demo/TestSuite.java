package pl.entito.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pl.entito.intergration.ApplicationIntegrationTest;
import pl.entito.intergration.CustomConfigurationTest;
import pl.entito.mockito.MockitoNoNoRunnerInitMocksTest;
import pl.entito.mockito.MockitoNoRunnerMockitoRuleTest;
import pl.entito.mockito.MockitoRunnerTest;
import pl.entito.mockito.MockitoRunnerWithSpringRuleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
		ApplicationIntegrationTest.class,
		CustomConfigurationTest.class,
		MockitoNoNoRunnerInitMocksTest.class, 
		MockitoNoRunnerMockitoRuleTest.class, 
		MockitoRunnerTest.class,
		MockitoRunnerWithSpringRuleTest.class })
public class TestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
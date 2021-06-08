package br.gov.bnb.s095.lib.javatopython.lmconfig;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for br.gov.bnb.s095.lib.javatopython.lmconfig");
		//$JUnit-BEGIN$
		suite.addTestSuite(DataSourceConfigImplTest.class);
		suite.addTestSuite(DeployConfigImplTest.class);
		suite.addTestSuite(JMSActAspectConfigImplTest.class);
		suite.addTestSuite(JMSQueueConfigImplTest.class);
		suite.addTestSuite(SegurancaJ2CConfigImplTest.class);
		suite.addTestSuite(SegurancaLoginAplicativoConfigImplTest.class);
		suite.addTestSuite(URLConfigImplTest.class);
		//$JUnit-END$
		return suite;
	}

}

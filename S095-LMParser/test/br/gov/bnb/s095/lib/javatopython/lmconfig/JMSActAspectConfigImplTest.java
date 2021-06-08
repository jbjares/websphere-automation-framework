package br.gov.bnb.s095.lib.javatopython.lmconfig;

import org.junit.Assert;
import org.python.core.PyList;

import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyJMSActAspectTO;


public class JMSActAspectConfigImplTest extends AutoDeployTest{

	@Override
	public void testExecutar() {
		Config jmsActAspectConfigImpl = new JMSActAspectConfigImpl();
		PyList result = jmsActAspectConfigImpl.getConfig(FILE_NAME);
		PyJMSActAspectTO i1 = (PyJMSActAspectTO) result.__getitem__(0);
		Assert.assertEquals("/Node:M1072317Node02",i1.getEscopo().toString());
		Assert.assertEquals("['-name', 'M1072317-AUTODEPLOY-AS', '-jndiName', 'jms/M1072317-AUTODEPLOY-AS', " +
				"'-destinationJndiName', 'jms/F095ENT.BNBAUTODEPLOY', '-destinationType', 'javax.jms.Queue', " +
				"'-qmgrName', 'CSQ1', '-qmgrHostname', 'D001MFD1', '-qmgrPortNumber', '1414', '-qmgrSvrconnChannel', " +
				"'SYSTEM.DEF.SVRCONN']",i1.getAtributos().toString());
	}

}

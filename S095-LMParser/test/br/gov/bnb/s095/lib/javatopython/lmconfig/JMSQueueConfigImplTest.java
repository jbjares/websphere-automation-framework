package br.gov.bnb.s095.lib.javatopython.lmconfig;

import org.junit.Assert;
import org.python.core.PyList;

import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyJMSQueueTO;


public class JMSQueueConfigImplTest extends AutoDeployTest{

	@Override
	public void testExecutar() {
		Config jmsActAspectConfigImpl = new JMSQueueConfigImpl();
		PyList result = jmsActAspectConfigImpl.getConfig(FILE_NAME);
		PyJMSQueueTO i1 = (PyJMSQueueTO) result.__getitem__(0);
		Assert.assertEquals("/Node:M1072317Node02",i1.getEscopo().toString());
		Assert.assertEquals("['-name', 'F095ENT.BNBAUTODEPLOY', '-jndiName', 'jms/F095ENT.BNBAUTODEPLOY', " +
				"'-queueName', 'F095ENT.BNBAUTODEPLOY']",i1.getAtributos().toString());
		Assert.assertEquals("QUEUE",i1.getTipo().toString());
	}
		
}

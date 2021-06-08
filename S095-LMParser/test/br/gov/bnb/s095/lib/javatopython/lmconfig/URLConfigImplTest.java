package br.gov.bnb.s095.lib.javatopython.lmconfig;

import junit.framework.Assert;

import org.python.core.PyList;

import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyRecursoURLTO;


public class URLConfigImplTest extends AutoDeployTest{

	@Override
	public void testExecutar() {
		Config jmsActAspectConfigImpl = new URLConfigImpl();
		PyList result = jmsActAspectConfigImpl.getConfig(FILE_NAME);
		PyRecursoURLTO i1 = (PyRecursoURLTO) result.__getitem__(0);
		PyRecursoURLTO i2 = (PyRecursoURLTO) result.__getitem__(1);
		Assert.assertEquals("/Cell:M1072317Node02Cell/URLProvider:Default URL Provider/",i1.getProvedorAtributo().toString());
		Assert.assertEquals("[['name', 'S033-Autodeploy-paginaAcessoNegado'], ['jndiName', 'url/paginaAcessoNegado'], " +
				"['spec', 'http://localhost:9080/S095-AutoDeployWEB/faces/acessonegado.jsp']]",i1.getUrlAtributos().toString());
		Assert.assertEquals("/Cell:M1072317Node02Cell/URLProvider:Default URL Provider/",i2.getProvedorAtributo().toString());
		Assert.assertEquals("[['name', 'servico'], ['jndiName', 'url/servico'], " +
				"['spec', 'http://d001mfd1.capgv.intra.bnb:9082/S095-AutoDeploySupportEJB_HTTPRouter/ExecutaService']]",i2.getUrlAtributos().toString());

	}
		
}

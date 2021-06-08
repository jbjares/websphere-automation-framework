package br.gov.bnb.s095.lib.javatopython.lmconfig;

import junit.framework.Assert;

import org.python.core.PyList;

import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PySegurancaLoginAplicativoTO;


public class SegurancaLoginAplicativoConfigImplTest extends AutoDeployTest{

	@Override
	public void testExecutar() {
		PyList result = new SegurancaLoginAplicativoConfigImpl().getConfig(FILE_NAME);
		PySegurancaLoginAplicativoTO itemZero = (PySegurancaLoginAplicativoTO) result.__getitem__(0);
		Assert.assertEquals("['-loginType', 'application', '-loginEntryAlias', 'S095-AutoDeployISKEY4', " +
				"'-loginModules', 'br.gov.bnb.seguranca.login.IsKeyLoginModule', " +
				"'-authStrategies', 'REQUIRED']", itemZero.getAtributosLoginEntry().toString());
		Assert.assertEquals("['-loginType', 'application', '-loginModule', 'br.gov.bnb.seguranca.login.IsKeyLoginModule'," +
				" '-loginEntryAlias', 'S095-AutoDeployISKEY4', '-customProperties [\"acao=autorizarUsuario\", \"aplicacao=S033ORC\", " +
				"\"endereco=http://d001wwd01/ISKEY/WSISKey.asmx\", \"nivel.log=ALL\", \"nome.espaco=http://tempuri.org/\", \"tipo=web.service\"]']", 
				itemZero.getAtributosLoginModule().toString());

	}
	
	

	
}

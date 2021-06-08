package br.gov.bnb.s095.lib.javatopython.lmconfig;

import org.junit.Assert;
import org.python.core.PyList;

import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PySegurancaJ2CTO;


public class SegurancaJ2CConfigImplTest  extends AutoDeployTest{

	@Override
	public void testExecutar() {
		PyList result = new SegurancaJ2CConfigImpl().getConfig(FILE_NAME);
		PySegurancaJ2CTO itemZero = (PySegurancaJ2CTO) result.__getitem__(0);
		Assert.assertEquals("[['alias', 'S533_DB2_JAAS_1'], ['userId', 'U533DES'], " +
				"['password', '46TQ3653'], ['description', " +
				"'Autenticacao com o banco DB2 do S533']]",itemZero.getAtributos().toString());
		
		PySegurancaJ2CTO itemUm = (PySegurancaJ2CTO) result.__getitem__(1);
		
		Assert.assertEquals("[['alias', 'S234_SQLSERVER_JAAS_2'], ['userId', 's234con']," +
				" ['password', 's234cons'], ['description', 'Autenticacao com o banco" +
				" SQL Server do S234']]",itemUm.getAtributos().toString());
	}
	
		
}

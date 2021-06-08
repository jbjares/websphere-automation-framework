package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.python.core.PyList;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.RecursoDataSource;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyRecursoDataSourceTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;



public class DataSourceConfigImplTest extends AutoDeployTest{

	@Test
	public void testExecutar(){
		
		List<RecursoDataSource> origemDadosList = ODMFactory.getODMEntity(RecursoDataSource.class,FILE_NAME);
		Assert.assertEquals("","");
		
		PyList result = new DataSourceConfigImpl().getConfig(FILE_NAME);
		PyRecursoDataSourceTO to0 = (PyRecursoDataSourceTO) result.__finditem__(0);
		Assert.assertEquals("/Server:server1/JDBCProvider:DB2 Universal JDBC Driver Provider (XA)/",to0.getEscopoProvedor().toString());
		Assert.assertEquals("/Server:server1/DB2 Universal JDBC Driver Provider (XA)/DataSource:/S533DS",to0.getEscopoDataSource().toString());
		Assert.assertEquals("['-name', 'S533DS', '-jndiName', 'jdbc/S533DS', " +
				"'-dataStoreHelperClassName', 'com.ibm.websphere.rsadapter.DB2UniversalDataStoreHelper', " +
				"'-containerManagedPersistence', 'true', '-componentManagedAuthenticationAlias', 'S533_DB2_JAAS_1', " +
				"'-xaRecoveryAuthAlias', 'S533_DB2_JAAS_1', '-configureResourceProperties', " +
				"[['databaseName', 'java.lang.String', 'DB2T'], ['serverName', 'java.lang.String', 'd001mfd1'], " +
				"['portNumber', 'java.lang.Integer', '5021']]]",to0.getAtributos().toString());
		
		
		PyRecursoDataSourceTO to1 = (PyRecursoDataSourceTO) result.__finditem__(1);
		Assert.assertEquals("/Server:server1/JDBCProvider:Microsoft SQL Server JDBC Driver/",to1.getEscopoProvedor().toString());
		Assert.assertEquals("/Server:server1/Microsoft SQL Server JDBC Driver/DataSource:/DS234_SQLServer",to1.getEscopoDataSource().toString());
		Assert.assertEquals("['-name', 'DS234_SQLServer', '-jndiName', 'jdbc/DS234_SQLServer', " +
				"'-dataStoreHelperClassName', 'com.ibm.websphere.rsadapter.MicrosoftSQLServerDataStoreHelper', " +
				"'-containerManagedPersistence', 'true', '-componentManagedAuthenticationAlias', 'S234_SQLSERVER_JAAS_2', " +
				"'-xaRecoveryAuthAlias', 'S234_SQLSERVER_JAAS_2', '-configureResourceProperties', " +
				"[['databaseName', 'java.lang.String', 'DAPO234_CQU'], ['serverName', 'java.lang.String', 'D001SRP02'], " +
				"['portNumber', 'java.lang.Integer', '1433']]]",to1.getAtributos().toString());
		
	}

}

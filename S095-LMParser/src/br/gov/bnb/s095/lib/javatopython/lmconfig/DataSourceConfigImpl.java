package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.RecursoDataSource;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyRecursoDataSourceTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;

public class DataSourceConfigImpl implements Config{
	
	public PyList getConfig(String filename) {
		List<RecursoDataSource> origemDadosList = ODMFactory.getODMEntity(RecursoDataSource.class,filename);
		new PythonInterpreter();
		PyList pyList = new PyList();
		for(RecursoDataSource origem:origemDadosList){
			PyList outerList = new PyList();
			PyRecursoDataSourceTO pyOrigemDadosTO = new PyRecursoDataSourceTO();
			String escopoProvedor = origem.getEscopoProvedor();
			if(!escopoProvedor.startsWith("/")){
				if(escopoProvedor.startsWith("WebSphere:")){
					escopoProvedor = escopoProvedor.substring(10,escopoProvedor.length());
				}
				escopoProvedor = escopoProvedor.replaceAll("=",":");
				escopoProvedor = escopoProvedor.replaceAll(",","/");
				escopoProvedor = "/"+escopoProvedor+"/".trim();
				escopoProvedor = escopoProvedor.replace(" ","");				
			}
			
			String nomeDS = origem.getNomeOrigem();
			String nomeProvedor = origem.getNomeProvedor(); 
			pyOrigemDadosTO.setEscopoProvedor(new PyString(escopoProvedor+"JDBCProvider:"+nomeProvedor.trim()+"/"));
			pyOrigemDadosTO.setEscopoDataSource(new PyString(escopoProvedor+nomeProvedor.trim()+"/DataSource:/"+nomeDS));
			
			outerList.append(new PyString("-name"));
			outerList.append(new PyString(nomeDS));
			outerList.append(new PyString("-jndiName"));
			outerList.append(new PyString(origem.getNomeJNDI()));
			
			//TODO  Implementar Helper class baseado no tipo de banco de dados
			outerList.append(new PyString("-dataStoreHelperClassName"));
			outerList.append(new PyString(origem.getDataStoreHelperClassName()));
			
			outerList.append(new PyString("-containerManagedPersistence"));
			outerList.append(new PyString(origem.getUtilizarCMP().toString()));
			
			//TODO Implementar containerManagedAuthenticationAlias
			String alias = origem.getAliasAutenticacao();
			outerList.append(new PyString("-componentManagedAuthenticationAlias"));
			outerList.append(new PyString(alias));
			outerList.append(new PyString("-xaRecoveryAuthAlias"));
			outerList.append(new PyString(alias));
						
			outerList.append(new PyString("-configureResourceProperties"));
			PyList pyListResourcePropertiesOuter = new PyList();
			PyList pyListResourceNomeBancoInner = new PyList();
			PyList pyListResourceNomeServidorInner = new PyList();
			PyList pyListResourcePortaServidorInner = new PyList();
			
			pyListResourceNomeBancoInner.append(new PyString("databaseName"));
			pyListResourceNomeBancoInner.append(new PyString("java.lang.String"));
			pyListResourceNomeBancoInner.append(new PyString(origem.getNomeBancoDados()));
			
			pyListResourceNomeServidorInner.append(new PyString("serverName"));
			pyListResourceNomeServidorInner.append(new PyString("java.lang.String"));
			pyListResourceNomeServidorInner.append(new PyString(origem.getNomeServidor()));

			pyListResourcePortaServidorInner.append(new PyString("portNumber"));
			pyListResourcePortaServidorInner.append(new PyString("java.lang.Integer"));
			pyListResourcePortaServidorInner.append(new PyString(origem.getNumeroPorta()));
			
			pyListResourcePropertiesOuter.append(pyListResourceNomeBancoInner);
			pyListResourcePropertiesOuter.append(pyListResourceNomeServidorInner);
			pyListResourcePropertiesOuter.append(pyListResourcePortaServidorInner);
			
			outerList.append(pyListResourcePropertiesOuter);
			
			pyOrigemDadosTO.setAtributos(outerList);
			pyList.append(pyOrigemDadosTO);
		}
		return pyList;
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		PyList result = new DataSourceConfigImpl().getConfig("C:\\BNB\\AutoDeploy\\conf\\s095-lista-materiais.xml");
		PyRecursoDataSourceTO to0 = (PyRecursoDataSourceTO) result.__finditem__(0);
		System.out.println(to0.getEscopoProvedor());
		System.out.println(to0.getEscopoDataSource());
		System.out.println(to0.getAtributos());
		
		PyRecursoDataSourceTO to1 = (PyRecursoDataSourceTO) result.__finditem__(1);
		System.out.println(to1.getEscopoProvedor());
		System.out.println(to1.getEscopoDataSource());
		System.out.println(to1.getAtributos());

	}


}

package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.SegurancaLoginAplicativo;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PySegurancaLoginAplicativoTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;

public class SegurancaLoginAplicativoConfigImpl implements Config{
	
	
	@Override
	public PyList getConfig(String fileName) {
		List<SegurancaLoginAplicativo> segurancaList = ODMFactory.getODMEntity(SegurancaLoginAplicativo.class,fileName);
		new PythonInterpreter();
		PyList attrLoginEntryList = new PyList();
		PyList attrLoginModuleList = new PyList();
		PyList pyList = new PyList();
		
		for(SegurancaLoginAplicativo seguranca:segurancaList){
			PySegurancaLoginAplicativoTO pySegurancaTO = new PySegurancaLoginAplicativoTO();
			
			attrLoginEntryList.append(new PyString("-loginType"));
			attrLoginEntryList.append(new PyString("application"));
			
			attrLoginEntryList.append(new PyString("-loginEntryAlias"));
			attrLoginEntryList.append(new PyString(seguranca.getAlias()));
			
			attrLoginEntryList.append(new PyString("-loginModules"));
			attrLoginEntryList.append(new PyString(seguranca.getNomeClasseModulo()));
			
			attrLoginEntryList.append(new PyString("-authStrategies"));
			attrLoginEntryList.append(new PyString(seguranca.getEstrategiaAutenticacao()));
			
			pySegurancaTO.setAtributosLoginEntry(attrLoginEntryList);
			
			attrLoginModuleList.append(new PyString("-loginType"));
			attrLoginModuleList.append(new PyString("application"));
			
			attrLoginModuleList.append(new PyString("-loginModule"));
			attrLoginModuleList.append(new PyString(seguranca.getNomeClasseModulo()));
			
			attrLoginModuleList.append(new PyString("-loginEntryAlias"));
			attrLoginModuleList.append(new PyString(seguranca.getAlias()));
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			int size = seguranca.getPropriedadesPersonalizadas().size();
			int count = 1;
			for(String props:seguranca.getPropriedadesPersonalizadas()){
				sb.append("\"");
				sb.append(props);
				sb.append("\"");
				if(count<size){
					sb.append(", ");	
				}
				count++;
			}
			sb.append("]");
			//attrLoginModuleList.append(new PyString("-customProperties "+"[\"aplicacao=S033ORC\",\"acao=autorizarUsuario\"]"));
			attrLoginModuleList.append(new PyString("-customProperties "+sb.toString()));
			pySegurancaTO.setAtributosLoginModule(attrLoginModuleList);
			pyList.append(pySegurancaTO);
		}
		return pyList;
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		PyList result = new SegurancaLoginAplicativoConfigImpl().getConfig("C:\\BNB\\AutoDeploy\\conf\\s095-lista-materiais.xml");
		PySegurancaLoginAplicativoTO itemZero = (PySegurancaLoginAplicativoTO) result.__getitem__(0);
		System.out.println(itemZero.getAtributosLoginEntry());
		System.out.println(itemZero.getAtributosLoginModule());
	}


	
}

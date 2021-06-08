package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.SegurancaJ2C;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PySegurancaJ2CTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;

public class SegurancaJ2CConfigImpl implements Config{
	
	
	@Override
	public PyList getConfig(String fileName) {
		List<SegurancaJ2C> segurancaList = ODMFactory.getODMEntity(SegurancaJ2C.class,fileName);
		new PythonInterpreter();
		PyList pyList = new PyList();
		
		for(SegurancaJ2C seguranca:segurancaList){
			PySegurancaJ2CTO pySegurancaTO = new PySegurancaJ2CTO();
			PyList tmpList = new PyList();
			
			PyList aliasList = new PyList();
			aliasList.append(new PyString("alias"));
			aliasList.append(new PyString(seguranca.getAlias()));
			tmpList.append(aliasList);
			
			PyList userList = new PyList();
			userList.append(new PyString("userId"));
			userList.append(new PyString(seguranca.getUsuario()));
			tmpList.append(userList);
			
			PyList passList = new PyList();
			passList.append(new PyString("password"));
			passList.append(new PyString(seguranca.getSenha()));
			tmpList.append(passList);
			
			PyList descList = new PyList();
			descList.append(new PyString("description"));
			descList.append(new PyString(seguranca.getDescricao()));
			tmpList.append(descList);
			
			pySegurancaTO.setAtributos(tmpList);
			pyList.append(pySegurancaTO);
		}
		return pyList;
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		PyList result = new SegurancaJ2CConfigImpl().getConfig("C:\\BNB\\AutoDeploy\\conf\\s095-lista-materiais.xml");
		PySegurancaJ2CTO itemZero = (PySegurancaJ2CTO) result.__getitem__(0);
		System.out.println(itemZero.getAtributos());
		
		PySegurancaJ2CTO itemUm = (PySegurancaJ2CTO) result.__getitem__(1);
		System.out.println(itemUm.getAtributos());
	}


	
}

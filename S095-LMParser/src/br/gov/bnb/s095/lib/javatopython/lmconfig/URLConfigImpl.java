package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.RecursoURL;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyRecursoURLTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;

public class URLConfigImpl implements Config{
	
	
	@Override
	public PyList getConfig(String fileName){
		List<RecursoURL> urls = ODMFactory.getODMEntity(RecursoURL.class,fileName);
		new PythonInterpreter();
		PyList pyList = new PyList();
		
		for(RecursoURL url:urls){
			PyList atributosList = new PyList();
			PyRecursoURLTO pyRecursoURLTO = new PyRecursoURLTO();
			
			PyList nomeList = new PyList();
			nomeList.append(new PyString("name"));
			nomeList.append(new PyString(url.getNome()));
			atributosList.append(nomeList);
			
			PyList jndiList = new PyList();
			jndiList.append(new PyString("jndiName"));
			jndiList.append(new PyString(url.getNomeJndi()));
			atributosList.append(jndiList);
			
			PyList specList = new PyList();
			specList.append(new PyString("spec"));
			specList.append(new PyString(url.getSpec()));
			atributosList.append(specList);
			pyRecursoURLTO.setUrlAtributos(atributosList);
			
			String escopo = url.getEscopoProvedor();
			String nomeProvedor = url.getNomeProvedor();
			if(escopo!=null && !"".equals(escopo) && nomeProvedor!=null && !"".equals(nomeProvedor)){
				
				if(escopo.startsWith("WebSphere:")){
					escopo = escopo.substring(10,escopo.length());
				}
				if(escopo.contains(",")){
					escopo = escopo.replaceAll(",","/");				
				}
				if(escopo.contains("=")){
					escopo = escopo.replaceAll("=",":");				
				}
				String escopoTairbuto = "";
				if(escopo==null || "".equals(escopo) || "/".equals(escopo)){
					escopoTairbuto="/URLProvider:"+url.getNomeProvedor()+"/";
				}else{
					escopoTairbuto="/"+escopo+"/URLProvider:"+url.getNomeProvedor()+"/";
				}
				pyRecursoURLTO.setProvedorAtributo(escopoTairbuto);
			}else{
				throw new RuntimeException("A Lista de materiais parece estar incompleta! " +
						"Verifique os campos relacionados ao escopo e nome do provedor do recurso URL");
			}
			pyList.append(pyRecursoURLTO);
		}
		
		return pyList;
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		Config jmsActAspectConfigImpl = new URLConfigImpl();
		PyList result = jmsActAspectConfigImpl.getConfig("C:\\BNB\\AutoDeploy\\conf\\s095-lista-materiais.xml");
		PyRecursoURLTO i1 = (PyRecursoURLTO) result.__getitem__(0);
		PyRecursoURLTO i2 = (PyRecursoURLTO) result.__getitem__(1);
		System.out.println(i1.getProvedorAtributo());
		System.out.println(i1.getUrlAtributos());
		System.out.println("===");
		System.out.println(i2.getProvedorAtributo());
		System.out.println(i2.getUrlAtributos());

	}



	
}

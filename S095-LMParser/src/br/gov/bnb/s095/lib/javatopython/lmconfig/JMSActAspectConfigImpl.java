package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.RecursoJMSActSpect;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyJMSActAspectTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;

public class JMSActAspectConfigImpl implements Config{
	
	
	@Override
	public PyList getConfig(String fileName){
		List<RecursoJMSActSpect> actAspectList = ODMFactory.getODMEntity(RecursoJMSActSpect.class,fileName);
		new PythonInterpreter();
		PyList pyList = new PyList();
		
		for(RecursoJMSActSpect actAspect:actAspectList){
			PyList atributosList = new PyList();
			PyJMSActAspectTO pyJMSActAspectTO = new PyJMSActAspectTO();
			
			atributosList.append(new PyString("-name"));
			atributosList.append(new PyString(actAspect.getNomeActSpec()));

			atributosList.append(new PyString("-jndiName"));
			atributosList.append(new PyString(actAspect.getNomeJndi()));
			
			atributosList.append(new PyString("-destinationJndiName"));
			atributosList.append(new PyString(actAspect.getNomeJndiDestino()));

			atributosList.append(new PyString("-destinationType"));
			atributosList.append(new PyString(actAspect.getTipoDestino()));
			
			atributosList.append(new PyString("-qmgrName"));
			atributosList.append(new PyString(actAspect.getNomeQueueManager()));
			
			atributosList.append(new PyString("-qmgrHostname"));
			atributosList.append(new PyString(actAspect.getHostQueueManager()));
			
			atributosList.append(new PyString("-qmgrPortNumber"));
			atributosList.append(new PyString(actAspect.getPortaQueueManager()));
			
			atributosList.append(new PyString("-qmgrSvrconnChannel"));
			atributosList.append(new PyString(actAspect.getCanalConexaoQueueManager()));
			
			pyJMSActAspectTO.setAtributos(atributosList);
			
			String escopo = actAspect.getEscopo();
			if(escopo!=null && !"".equals(escopo)){
				
				if(escopo.startsWith("WebSphere:")){
					escopo = escopo.substring(10,escopo.length());
				}
				if(escopo.contains(",")){
					escopo = escopo.replaceAll(",","/");				
				}
				if(escopo.contains("=")){
					escopo = escopo.replaceAll("=",":");				
				}
				pyJMSActAspectTO.setEscopo(new PyString("/"+escopo));
			}else{
				throw new RuntimeException("Lista incompleta!");
			}
			pyList.append(pyJMSActAspectTO);
		}
		
		return pyList;
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		Config jmsActAspectConfigImpl = new JMSActAspectConfigImpl();
		PyList result = jmsActAspectConfigImpl.getConfig("C:\\BNB\\AutoDeploy\\conf\\s095-lista-materiais.xml");
		PyJMSActAspectTO i1 = (PyJMSActAspectTO) result.__getitem__(0);
		System.out.println(i1.getEscopo());
		System.out.println(i1.getAtributos());


		
	}


	
}

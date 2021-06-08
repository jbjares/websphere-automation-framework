package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.RecursoJMSQueue;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyJMSQueueTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;

public class JMSQueueConfigImpl implements Config{
	
	
	@Override
	public PyList getConfig(String fileName){
		List<RecursoJMSQueue> recursoJMSQueueList = ODMFactory.getODMEntity(RecursoJMSQueue.class,fileName);
		new PythonInterpreter();
		PyList pyList = new PyList();
		
		for(RecursoJMSQueue recursoJMSQueue:recursoJMSQueueList){
			PyList atributosList = new PyList();
			PyJMSQueueTO pyJMSQueueTO = new PyJMSQueueTO();
			
			atributosList.append(new PyString("-name"));
			atributosList.append(new PyString(recursoJMSQueue.getNomeQueue()));

			atributosList.append(new PyString("-jndiName"));
			atributosList.append(new PyString(recursoJMSQueue.getNomeJNDI()));
			
			if("TOPIC".equals(recursoJMSQueue.getTipo())){
				atributosList.append(new PyString("-topicName"));
			}else{
				atributosList.append(new PyString("-queueName"));
			}
			atributosList.append(new PyString(recursoJMSQueue.getNomeQueueMQ()));

			
			pyJMSQueueTO.setAtributos(atributosList);
			
			String escopo = recursoJMSQueue.getEscopo();
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
				pyJMSQueueTO.setEscopo(new PyString("/"+escopo));
			}else{
				throw new RuntimeException("Lista incompleta!");
			}
			pyJMSQueueTO.setTipo(new PyString(recursoJMSQueue.getTipo()));
			pyList.append(pyJMSQueueTO);
		}
		
		return pyList;
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		Config jmsActAspectConfigImpl = new JMSQueueConfigImpl();
		PyList result = jmsActAspectConfigImpl.getConfig("C:\\BNB\\AutoDeploy\\conf\\s095-lista-materiais.xml");
		PyJMSQueueTO i1 = (PyJMSQueueTO) result.__getitem__(0);
		System.out.println(i1.getEscopo());
		System.out.println(i1.getAtributos());
		System.out.println(i1.getTipo());



		
	}


	
}

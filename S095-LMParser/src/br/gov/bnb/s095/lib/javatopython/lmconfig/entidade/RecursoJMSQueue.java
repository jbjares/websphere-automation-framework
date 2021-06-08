package br.gov.bnb.s095.lib.javatopython.lmconfig.entidade;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;

@ODMEntity
public class RecursoJMSQueue {

	@ODMColumn(name="JMS Escopo Fila")
	private String escopo;
	
	@ODMColumn(name="JMS Nome Fila")
	private String nomeQueue;
	
	@ODMColumn(name="JMS Nome JNDI Fila")
	private String nomeJNDI;
	
	@ODMColumn(name="JMS Nome da Fila no MQ")
	private String nomeQueueMQ;

	@ODMColumn(name="JMS Tipo de Fila")
	private String tipo;


	public String getEscopo() {
		return escopo;
	}

	public void setEscopo(String escopo) {
		this.escopo = escopo;
	}

	public String getNomeJNDI() {
		return nomeJNDI;
	}

	public void setNomeJNDI(String nomeJNDI) {
		this.nomeJNDI = nomeJNDI;
	}

	public String getNomeQueue() {
		return nomeQueue;
	}

	public void setNomeQueue(String nomeQueue) {
		this.nomeQueue = nomeQueue;
	}

	public String getNomeQueueMQ() {
		return nomeQueueMQ;
	}

	public void setNomeQueueMQ(String nomeQueueMQ) {
		this.nomeQueueMQ = nomeQueueMQ;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	
}

package br.gov.bnb.s095.lib.javatopython.lmconfig.entidade;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;

@ODMEntity
public class RecursoJMSActSpect {

	@ODMColumn(name="JMS Escopo Actvation Specfification")
	private String escopo;
	
	@ODMColumn(name="JMS Nome Actvation Specfification")
	private String nomeActSpec;
	
	@ODMColumn(name="JMS Nome JNDI Actvation Specfification")
	private String nomeJndi;
	
	@ODMColumn(name="JMS Nome JNDI Destino")
	private String nomeJndiDestino;
	
	@ODMColumn(name="JMS Tipo Destino")
	private String tipoDestino;
	
	@ODMColumn(name="JMS Descricao")
	private String descricao;
	
	@ODMColumn(name="JMS Nome do Queue Manager")
	private String nomeQueueManager;
	
	@ODMColumn(name="JMS Host do Queue Manager")
	private String hostQueueManager;
	
	@ODMColumn(name="JMS Porta do Queue Manager")
	private String portaQueueManager;
	
	@ODMColumn(name="JMS Canal de Conexao do Queue Manager")
	private String canalConexaoQueueManager;

	
		
	public String getPortaQueueManager() {
		return portaQueueManager;
	}

	public void setPortaQueueManager(String portaQueueManager) {
		this.portaQueueManager = portaQueueManager;
	}

	public String getEscopo() {
		return escopo;
	}

	public void setEscopo(String escopo) {
		this.escopo = escopo;
	}

	public String getNomeActSpec() {
		return nomeActSpec;
	}

	public void setNomeActSpec(String nomeActSpec) {
		this.nomeActSpec = nomeActSpec;
	}

	public String getNomeJndi() {
		return nomeJndi;
	}

	public void setNomeJndi(String nomeJndi) {
		this.nomeJndi = nomeJndi;
	}

	public String getNomeJndiDestino() {
		return nomeJndiDestino;
	}

	public void setNomeJndiDestino(String nomeJndiDestino) {
		this.nomeJndiDestino = nomeJndiDestino;
	}

	public String getTipoDestino() {
		return tipoDestino;
	}

	public void setTipoDestino(String tipoDestino) {
		this.tipoDestino = tipoDestino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeQueueManager() {
		return nomeQueueManager;
	}

	public void setNomeQueueManager(String nomeQueueManager) {
		this.nomeQueueManager = nomeQueueManager;
	}

	public String getHostQueueManager() {
		return hostQueueManager;
	}

	public void setHostQueueManager(String hostQueueManager) {
		this.hostQueueManager = hostQueueManager;
	}

	public String getCanalConexaoQueueManager() {
		return canalConexaoQueueManager;
	}

	public void setCanalConexaoQueueManager(String canalConexaoQueueManager) {
		this.canalConexaoQueueManager = canalConexaoQueueManager;
	}

	
}

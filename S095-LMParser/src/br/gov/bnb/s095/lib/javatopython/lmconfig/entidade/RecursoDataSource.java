package br.gov.bnb.s095.lib.javatopython.lmconfig.entidade;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;

@ODMEntity
public class RecursoDataSource {

	@ODMColumn(name="DS Nome da origem de dados")
	private String nomeOrigem;
	
	@ODMColumn(name="DS Nome JNDI")
	private String nomeJNDI;
	
	@ODMColumn(name="DS Alias de autenticacao")
	private String aliasAutenticacao;
	
	@ODMColumn(name="DS Nome do banco de dados")
	private String nomeBancoDados;
	
	@ODMColumn(name="DS Nome do servidor")
	private String nomeServidor;
	
	@ODMColumn(name="DS Numero da porta")
	private String numeroPorta;
	
	@ODMColumn(name="DS Utilizar a origem no CMP")
	private Boolean utilizarCMP;
	
	@ODMColumn(name="DS Escopo do Provedor")
	private String escopoProvedor;
	
	@ODMColumn(name="DS Nome do Provedor")
	private String nomeProvedor;
	
	@ODMColumn(name="DS Nome da Classe Helper")
	private String dataStoreHelperClassName;
	

	public String getNomeProvedor() {
		return nomeProvedor;
	}

	public void setNomeProvedor(String nomeProvedor) {
		this.nomeProvedor = nomeProvedor;
	}

	public String getEscopoProvedor() {
		return escopoProvedor;
	}

	public void setEscopoProvedor(String escopoProvedor) {
		this.escopoProvedor = escopoProvedor;
	}

	public String getNomeOrigem() {
		return nomeOrigem;
	}

	public void setNomeOrigem(String nomeOrigem) {
		this.nomeOrigem = nomeOrigem;
	}

	public String getNomeJNDI() {
		return nomeJNDI;
	}

	public void setNomeJNDI(String nomeJNDI) {
		this.nomeJNDI = nomeJNDI;
	}

	public String getAliasAutenticacao() {
		return aliasAutenticacao;
	}

	public void setAliasAutenticacao(String aliasAutenticacao) {
		this.aliasAutenticacao = aliasAutenticacao;
	}


	public String getNomeBancoDados() {
		return nomeBancoDados;
	}

	public void setNomeBancoDados(String nomeBancoDados) {
		this.nomeBancoDados = nomeBancoDados;
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public String getNumeroPorta() {
		return numeroPorta;
	}

	public void setNumeroPorta(String numeroPorta) {
		this.numeroPorta = numeroPorta;
	}

	public Boolean getUtilizarCMP() {
		return utilizarCMP;
	}

	public void setUtilizarCMP(Boolean utilizarCMP) {
		this.utilizarCMP = utilizarCMP;
	}

	public String getDataStoreHelperClassName() {
		return dataStoreHelperClassName;
	}

	public void setDataStoreHelperClassName(String dataStoreHelperClassName) {
		this.dataStoreHelperClassName = dataStoreHelperClassName;
	}

	
	
	
}

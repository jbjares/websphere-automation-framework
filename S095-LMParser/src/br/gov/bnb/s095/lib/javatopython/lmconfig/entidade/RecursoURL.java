package br.gov.bnb.s095.lib.javatopython.lmconfig.entidade;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;

@ODMEntity
public class RecursoURL {

	@ODMColumn(name="URL Nome")
	private String nome;
	
	@ODMColumn(name="URL Nome JNDI")
	private String nomeJndi;
	
	@ODMColumn(name="URL SPEC")
	private String spec;
	
	@ODMColumn(name="URL Escopo Provedor")
	private String escopoProvedor;
	
	@ODMColumn(name="URL Nome Provedor")
	private String nomeProvedor;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeJndi() {
		return nomeJndi;
	}

	public void setNomeJndi(String nomeJndi) {
		this.nomeJndi = nomeJndi;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getEscopoProvedor() {
		return escopoProvedor;
	}

	public void setEscopoProvedor(String escopoProvedor) {
		this.escopoProvedor = escopoProvedor;
	}

	public String getNomeProvedor() {
		return nomeProvedor;
	}

	public void setNomeProvedor(String nomeProvedor) {
		this.nomeProvedor = nomeProvedor;
	} 
	
	
}

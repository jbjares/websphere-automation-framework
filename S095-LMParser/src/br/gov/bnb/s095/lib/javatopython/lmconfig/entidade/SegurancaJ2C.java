package br.gov.bnb.s095.lib.javatopython.lmconfig.entidade;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;

@ODMEntity
public class SegurancaJ2C {

	@ODMColumn(name="J2C Alias")
	private String alias;
	
	@ODMColumn(name="J2C ID do usuario")
	private String usuario;
	
	@ODMColumn(name="J2C Senha")
	private String senha;
	
	@ODMColumn(name="J2C Descricao")
	private String descricao;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

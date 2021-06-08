package br.gov.bnb.s095.lib.javatopython.lmconfig.entidade;

import java.util.List;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;

@ODMEntity
public class SegurancaLoginAplicativo {

	@ODMColumn(name="LA Alias")
	private String alias;
	
	@ODMColumn(name="LA Estrategia de Autenticacao")
	private String estrategiaAutenticacao;
	
	@ODMColumn(name="LA Nome da Classe do Modulo")
	private String nomeClasseModulo;
	
	@ODMColumn(name="LA Propriedades Personalizadas")
	private List<String> propriedadesPersonalizadas;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEstrategiaAutenticacao() {
		return estrategiaAutenticacao;
	}

	public void setEstrategiaAutenticacao(String estrategiaAutenticacao) {
		this.estrategiaAutenticacao = estrategiaAutenticacao;
	}

	public String getNomeClasseModulo() {
		return nomeClasseModulo;
	}

	public void setNomeClasseModulo(String nomeClasseModulo) {
		this.nomeClasseModulo = nomeClasseModulo;
	}

	public List<String> getPropriedadesPersonalizadas() {
		return propriedadesPersonalizadas;
	}

	public void setPropriedadesPersonalizadas(
			List<String> propriedadesPersonalizadas) {
		this.propriedadesPersonalizadas = propriedadesPersonalizadas;
	}

	
	
}

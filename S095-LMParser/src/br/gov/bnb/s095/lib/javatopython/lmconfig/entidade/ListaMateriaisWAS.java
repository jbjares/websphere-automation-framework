package br.gov.bnb.s095.lib.javatopython.lmconfig.entidade;

import java.util.List;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;

@ODMEntity
public class ListaMateriaisWAS {

	@ODMColumn(name="Localizacao do pacote aplicativo")
	private String localizacaoPacoteAplicativo;
	
	@ODMColumn(name="Nome da raiz de contexto")
	private String nomeRaizContexto;
	
	@ODMColumn(name="Pre-compilar arquivos JSP?")
	private Boolean preCompilarArquivosJSP;
	
	@ODMColumn(name="Celula/No/Servidor destino",required=false)
	private String celulaNoServidorDestino;
	
	@ODMColumn(name="Diretorio de instalacao do aplicativo")
	private String diretorioInstalacaoAplicativo;
	
	@ODMColumn(name="Distribuir aplicativo?")
	private Boolean distribuirAplicativo;
	
	@ODMColumn(name="Implementar Beans Corporativos?")
	private Boolean implementarBeansCorporativos;
	
	@ODMColumn(name="Nome do aplicativo")
	private String nomeAplicativo;
	
	@ODMColumn(name="Nome do Modulo WEB")
	private String nomeModuloWEB;
	
	@ODMColumn(name="Nome do(s) Modulo(s) EJB")
	private List<String> nomeModulosEJB;
	
	@ODMColumn(name="Criar MBeans para recursos?")
	private Boolean criarMBeansParaRecursos;
	
	@ODMColumn(name="Validar Entrada Desligar/Avisar/Falhar")
	private String validarEntrada;
	
	@ODMColumn(name="Processar configuracao incorporada?")
	private Boolean processarConfiguracaoIncorporada;

	@ODMColumn(name="Permissoes de arquivo")
	private String permissoesArquivo;
	
	@ODMColumn(name="Mapeamento de modulos para servidores",required=false)
	private List<String> mapeamentoModulosServidores;
	
	@ODMColumn(name="Referenciar bibliotecas compartilhadas")
	private List<String> bibliotecasCompartilhadas;
	
	@ODMColumn(name="Esta em Cluster")
	private Boolean isInCluster;
	
	@ODMColumn(name="Escopo do Application Manager")
	private String escopoAplicationManager;	
	
	public String getEscopoAplicationManager() {
		return escopoAplicationManager;
	}

	public void setEscopoAplicationManager(String escopoAplicationManager) {
		this.escopoAplicationManager = escopoAplicationManager;
	}

	public Boolean getIsInCluster() {
		return isInCluster;
	}

	public void setIsInCluster(Boolean isInCluster) {
		this.isInCluster = isInCluster;
	}

	public List<String> getNomeModulosEJB() {
		return nomeModulosEJB;
	}

	public void setNomeModulosEJB(List<String> nomeModulosEJB) {
		this.nomeModulosEJB = nomeModulosEJB;
	}

	public String getNomeModuloWEB() {
		return nomeModuloWEB;
	}

	public void setNomeModuloWEB(String nomeModuloWEB) {
		this.nomeModuloWEB = nomeModuloWEB;
	}

	public String getLocalizacaoPacoteAplicativo() {
		return localizacaoPacoteAplicativo;
	}

	public void setLocalizacaoPacoteAplicativo(String localizacaoPacoteAplicativo) {
		this.localizacaoPacoteAplicativo = localizacaoPacoteAplicativo;
	}

	public String getNomeRaizContexto() {
		return nomeRaizContexto;
	}

	public void setNomeRaizContexto(String nomeRaizContexto) {
		this.nomeRaizContexto = nomeRaizContexto;
	}

	public Boolean getPreCompilarArquivosJSP() {
		return preCompilarArquivosJSP;
	}

	public void setPreCompilarArquivosJSP(Boolean preCompilarArquivosJSP) {
		this.preCompilarArquivosJSP = preCompilarArquivosJSP;
	}

	public String getCelulaNoServidorDestino() {
		return celulaNoServidorDestino;
	}

	public void setCelulaNoServidorDestino(String celulaNoServidorDestino) {
		this.celulaNoServidorDestino = celulaNoServidorDestino;
	}

	public String getDiretorioInstalacaoAplicativo() {
		return diretorioInstalacaoAplicativo;
	}

	public void setDiretorioInstalacaoAplicativo(
			String diretorioInstalacaoAplicativo) {
		this.diretorioInstalacaoAplicativo = diretorioInstalacaoAplicativo;
	}

	public Boolean getDistribuirAplicativo() {
		return distribuirAplicativo;
	}

	public void setDistribuirAplicativo(Boolean distribuirAplicativo) {
		this.distribuirAplicativo = distribuirAplicativo;
	}

	public Boolean getImplementarBeansCorporativos() {
		return implementarBeansCorporativos;
	}

	public void setImplementarBeansCorporativos(Boolean implementarBeansCorporativos) {
		this.implementarBeansCorporativos = implementarBeansCorporativos;
	}

	public String getNomeAplicativo() {
		return nomeAplicativo;
	}

	public void setNomeAplicativo(String nomeAplicativo) {
		this.nomeAplicativo = nomeAplicativo;
	}

	public Boolean getCriarMBeansParaRecursos() {
		return criarMBeansParaRecursos;
	}

	public void setCriarMBeansParaRecursos(Boolean criarMBeansParaRecursos) {
		this.criarMBeansParaRecursos = criarMBeansParaRecursos;
	}

	public String getValidarEntrada() {
		return validarEntrada;
	}

	public void setValidarEntrada(String validarEntrada) {
		this.validarEntrada = validarEntrada;
	}

	public Boolean getProcessarConfiguracaoIncorporada() {
		return processarConfiguracaoIncorporada;
	}

	public void setProcessarConfiguracaoIncorporada(
			Boolean processarConfiguracaoIncorporada) {
		this.processarConfiguracaoIncorporada = processarConfiguracaoIncorporada;
	}

	public String getPermissoesArquivo() {
		return permissoesArquivo;
	}

	public void setPermissoesArquivo(String permissoesArquivo) {
		this.permissoesArquivo = permissoesArquivo;
	}

	public List<String> getMapeamentoModulosServidores() {
		return mapeamentoModulosServidores;
	}

	public void setMapeamentoModulosServidores(
			List<String> mapeamentoModulosServidores) {
		this.mapeamentoModulosServidores = mapeamentoModulosServidores;
	}

	public List<String> getBibliotecasCompartilhadas() {
		return bibliotecasCompartilhadas;
	}

	public void setBibliotecasCompartilhadas(List<String> bibliotecasCompartilhadas) {
		this.bibliotecasCompartilhadas = bibliotecasCompartilhadas;
	}
	
	
	
}

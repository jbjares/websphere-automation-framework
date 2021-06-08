package br.gov.bnb.s095.lib.javatopython.lmconfig.to;

import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;

public class PyDeployTO extends PyObject{
	private static final long serialVersionUID = -8937085115328192039L;
	
	private PyString localizacaoPacoteAplicativo;
	
	private PyList atributos;
	
	private PyString isInCluster;
	
	private PyString nomeAplicacao;
	
	private PyString escopoAplicationManager;
	


	public PyString getNomeAplicacao() {
		return nomeAplicacao;
	}

	public void setNomeAplicacao(PyString nomeAplicacao) {
		this.nomeAplicacao = nomeAplicacao;
	}

	public PyString getEscopoAplicationManager() {
		return escopoAplicationManager;
	}

	public void setEscopoAplicationManager(PyString escopoAplicationManager) {
		this.escopoAplicationManager = escopoAplicationManager;
	}

	public PyString getIsInCluster() {
		return isInCluster;
	}

	public void setIsInCluster(PyString isInCluster) {
		this.isInCluster = isInCluster;
	}

	public PyString getLocalizacaoPacoteAplicativo() {
		return localizacaoPacoteAplicativo;
	}

	public void setLocalizacaoPacoteAplicativo(PyString localizacaoPacoteAplicativo) {
		this.localizacaoPacoteAplicativo = localizacaoPacoteAplicativo;
	}

	public PyList getAtributos() {
		return atributos;
	}

	public void setAtributos(PyList atributos) {
		this.atributos = atributos;
	}


}

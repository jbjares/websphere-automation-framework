package br.gov.bnb.s095.lib.javatopython.lmconfig.to;

import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;

public class PyRecursoDataSourceTO extends PyObject{
	private static final long serialVersionUID = -8937085115328192039L;
	
	private PyString escopoProvedor;
	
	private PyString escopoDataSource;
	
	private PyList atributos;
	
	private PyString isInCluster;
	
	

	public PyString getIsInCluster() {
		return isInCluster;
	}

	public void setIsInCluster(PyString isInCluster) {
		this.isInCluster = isInCluster;
	}

	public PyString getEscopoProvedor() {
		return escopoProvedor;
	}

	public void setEscopoProvedor(PyString escopoProvedor) {
		this.escopoProvedor = escopoProvedor;
	}

	public PyString getEscopoDataSource() {
		return escopoDataSource;
	}

	public void setEscopoDataSource(PyString escopoDataSource) {
		this.escopoDataSource = escopoDataSource;
	}

	public PyList getAtributos() {
		return atributos;
	}

	public void setAtributos(PyList atributos) {
		this.atributos = atributos;
	}

	

	
}

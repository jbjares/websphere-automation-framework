package br.gov.bnb.s095.lib.javatopython.lmconfig.to;

import org.python.core.PyList;
import org.python.core.PyObject;

public class PyRecursoURLTO extends PyObject{
	private static final long serialVersionUID = -8937085115328192039L;
	
	private String provedorAtributo;
	
	private PyList urlAtributos;

	public String getProvedorAtributo() {
		return provedorAtributo;
	}

	public void setProvedorAtributo(String provedorAtributo) {
		this.provedorAtributo = provedorAtributo;
	}

	public PyList getUrlAtributos() {
		return urlAtributos;
	}

	public void setUrlAtributos(PyList urlAtributos) {
		this.urlAtributos = urlAtributos;
	}

	
}

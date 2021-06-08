package br.gov.bnb.s095.lib.javatopython.lmconfig.to;

import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;

public class PyJMSActAspectTO extends PyObject{
	private static final long serialVersionUID = -8937085115328192039L;
	
	private PyString escopo;
	
	private PyList atributos;
	
	public PyString getEscopo() {
		return escopo;
	}

	public void setEscopo(PyString escopo) {
		this.escopo = escopo;
	}

	public PyList getAtributos() {
		return atributos;
	}

	public void setAtributos(PyList atributos) {
		this.atributos = atributos;
	}


}

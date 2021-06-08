package br.gov.bnb.s095.lib.javatopython.lmconfig.to;

import org.python.core.PyList;
import org.python.core.PyObject;

public class PySegurancaLoginAplicativoTO extends PyObject{
	private static final long serialVersionUID = -8937085115328192039L;
	
	private PyList atributosLoginEntry;
	
	private PyList atributosLoginModule;

	public PyList getAtributosLoginEntry() {
		return atributosLoginEntry;
	}

	public void setAtributosLoginEntry(PyList atributosLoginEntry) {
		this.atributosLoginEntry = atributosLoginEntry;
	}

	public PyList getAtributosLoginModule() {
		return atributosLoginModule;
	}

	public void setAtributosLoginModule(PyList atributosLoginModule) {
		this.atributosLoginModule = atributosLoginModule;
	}



}

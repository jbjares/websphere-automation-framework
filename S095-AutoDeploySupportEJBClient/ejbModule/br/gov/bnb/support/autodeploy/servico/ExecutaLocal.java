package br.gov.bnb.support.autodeploy.servico;
import javax.ejb.Local;

@Local
public interface ExecutaLocal {
	public String executar();
}

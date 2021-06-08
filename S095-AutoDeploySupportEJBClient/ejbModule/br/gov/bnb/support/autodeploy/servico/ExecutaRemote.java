package br.gov.bnb.support.autodeploy.servico;
import javax.ejb.Remote;

@Remote
public interface ExecutaRemote {

	public String executar();
}

package br.gov.bnb.support.autodeploy.servico;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
@Stateless
public class Executa implements ExecutaRemote, ExecutaLocal {

	@WebMethod
	public String executar() {
		return "OK";
	}



}

package br.gov.bnb.s095.exemplo;

import javax.ejb.Remote;

import br.gov.bnb.s095.lib.excecao.UtilitariosException;

@Remote
public interface ExecutaRemote {
	public String executar() throws UtilitariosException;
	public void enviarEmail(String mensagem);
}

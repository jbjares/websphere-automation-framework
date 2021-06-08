package br.gov.bnb.s095.exemplo;
import javax.ejb.Local;

import br.gov.bnb.s095.lib.excecao.UtilitariosException;

@Local
public interface ExecutaLocal {
	public String executar() throws UtilitariosException;
	public void enviarEmail(String mensagem);
}

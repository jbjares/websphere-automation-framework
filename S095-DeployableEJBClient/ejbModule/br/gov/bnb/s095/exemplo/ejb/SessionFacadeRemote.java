package br.gov.bnb.s095.exemplo.ejb;
import javax.ejb.Remote;

import br.gov.bnb.s095.exemplo.ejb.to.V533audiTO;
import br.gov.bnb.s095.exemplo.ejb.to.VatividadesTO;

@Remote
public interface SessionFacadeRemote {
	public V533audiTO localizarAudiDB2(Integer id);
	public VatividadesTO localizarAtividadeSQLServer(Integer id);
	public void postarMensagem(String mensagem);
}

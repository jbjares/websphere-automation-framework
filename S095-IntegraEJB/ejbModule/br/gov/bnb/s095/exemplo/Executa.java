package br.gov.bnb.s095.exemplo;

import javax.ejb.Stateless;

import br.gov.bnb.autodeploy.integra.servico.ExecutaPortProxy;
import br.gov.bnb.s095.lib.excecao.UtilitariosException;
import br.gov.bnb.s095.lib.referencia.ReferenciaEmail;
import br.gov.bnb.s095.lib.referencia.ReferenciaURL;
import br.gov.bnb.s095.lib.util.email.EmailVO;


@Stateless
public class Executa implements ExecutaLocal,ExecutaRemote {

	private static final String REF_MAIL = "ref-mail/S095-BNBMail";
	
	public String executar() throws UtilitariosException{
		String result = "";
		String endpoint = ReferenciaURL.getEndpoint("ref-url/servico");
		ExecutaPortProxy proxy = new ExecutaPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);
		result = proxy.executar();
		return result;
	}

	@Override
	public void enviarEmail(String mensagem) {
		try {
			String[] msg = mensagem.split(";");
			StringBuilder texto = new StringBuilder();
			texto.append(msg[1]);
			EmailVO email = new EmailVO("E-Mail para exibir funcionamento do recurso JMS do AutoDeploy!","s095-AutoDeploy@bnb.intra.gov.br",msg[0]);
			email.setTexto(texto.toString());
			ReferenciaEmail.send(REF_MAIL,email);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

}

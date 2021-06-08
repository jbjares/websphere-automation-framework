package br.gov.bnb.autodeploy.integra.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.gov.bnb.s095.exemplo.ExecutaLocal;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/F095ENT.BNBAUTODEPLOY") })
public class IntegraMDB implements MessageListener {

	@EJB
	private ExecutaLocal servico;

	
    public void onMessage(Message message) {
    	TextMessage txtMsg = (TextMessage) message;
        try {
        	servico.enviarEmail(txtMsg.getText());
		} catch (JMSException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
    }
    


}

package br.gov.bnb.s095.exemplo.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.bnb.s095.exemplo.ejb.to.V533audiTO;
import br.gov.bnb.s095.exemplo.ejb.to.VatividadesTO;
import br.gov.bnb.s095.exemplo.jpa.dao.DAO;
import br.gov.bnb.s095.exemplo.jpa.entity.V533audi;
import br.gov.bnb.s095.exemplo.jpa.entity.Vatividades;


@Stateless
public class SessionFacade implements SessionFacadeRemote {
	
	@PersistenceContext(unitName = "S095-DeployableJPA_DB2")
	private EntityManager entityManagerDB2;
	
	@PersistenceContext(unitName = "S095-DeployableJPA_SQLServer")
	private EntityManager entityManagerSQLServer;
	
	@Resource(name = "ref-jms/S095-QueueCF")
	private QueueConnectionFactory connectionFactory;

	@Resource(name = "ref-jms/S095-Queue")
	private Queue queue;

	@Override
	public V533audiTO localizarAudiDB2(Integer id) {
		V533audi v533audi = new DAO(entityManagerDB2).findAudi(new Integer("181"));
		V533audiTO result = new V533audiTO();
		result.setSqAud(v533audi.getSqAud());
		result.setTpEvt(v533audi.getTpEvt());
		result.setDtIniEvt(v533audi.getDtIniEvt());
		result.setDtFinEvt(v533audi.getDtFinEvt());
		result.setIdtRsp(v533audi.getIdtRsp());
		result.setIdtSis(v533audi.getIdtSis());
		result.setMdlSis(v533audi.getMdlSis());
		result.setDeFucEvt(v533audi.getDeFucEvt());
		result.setIdtIpOri(v533audi.getIdtIpOri());
		result.setIdtHosOri(v533audi.getIdtHosOri());
		result.setIdtDmnOri(v533audi.getIdtDmnOri());
		result.setDeRstFin(v533audi.getDeRstFin());
		result.setDeInfAdc(v533audi.getDeInfAdc());
		return result;
	}

	@Override
	public VatividadesTO localizarAtividadeSQLServer(Integer id) {
		Vatividades atividades = new DAO(entityManagerSQLServer).findAtividade(new Integer("33555633"));
		VatividadesTO result = new VatividadesTO();
		result.setAmActualWork(atividades.getAmActualWork());
		result.setDataAbertura(atividades.getDataAbertura());
		result.setDataFechamento(atividades.getDataFechamento());
		result.setDbid(atividades.getDbid());
		result.setId(atividades.getId());
		result.setName(atividades.getName());
		result.setNomeOwner(atividades.getNomeOwner());
		result.setOwner(atividades.getOwner());
		result.setProjeto(atividades.getProjeto());
		result.setRecordType(atividades.getRecordType());
		result.setSistema(atividades.getSistema());
		return result;
	}

	@Override
	public void postarMensagem(String mensagem) {
		QueueSession session = null;
		QueueConnection connection = null;
		MessageProducer producer =null;
		TextMessage txtMsg = null;
		try{
			connection = connectionFactory.createQueueConnection();
			session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			txtMsg = session.createTextMessage();
			txtMsg.setText(mensagem);
			producer.send(txtMsg);
			session.close();
			connection.close();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}


}

package br.gov.bnb.s095.lib.odm.parser;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.MultiHashMap;

public class ODMParserMock extends ODMParser{
	
	private static HashMap lmMap = new MultiHashMap();
	
	static{
		
		//### app_deploy.py ###
		lmMap.put("Localização do pacote aplicativo","C:\\Users\\c010098\\Desktop\\S095-AutoDeployEAR.ear");
		lmMap.put("Nome da raiz de contexto","S095-AutoDeployWEB");
		lmMap.put("Pré-compilar arquivos JSP?","Sim");
		
//		lmMap.put("Célula/Nó/Servidor destino","WebSphere:cell=wdcell,cluster=WDCLS01");
//		lmMap.put("Diretório de instalação do aplicativo","/was/v7r0/wdcell/wdnodea/AppServer/profiles/default/installedApps/wdcell");
		lmMap.put("Célula/Nó/Servidor destino","WebSphere:cell=M1072317Node01Cell,node=M1072317Node01,Server=server1");
		lmMap.put("Diretório de instalação do aplicativo","C:\\Program Files (x86)\\IBM\\SDP_75\\runtimes\\base_v7\\profiles\\was70profile1\\installedApps\\M1072317Node01Cell");
		
		lmMap.put("Distribuir aplicativo?","Sim");
		lmMap.put("Implementar Beans Corporativos?","Sim");
		lmMap.put("Nome do aplicativo","S095-AutoDeployEAR");
		lmMap.put("Nome do Módulo WEB","S095-AutoDeployWEB");
		lmMap.put("Nome do(s) Módulo(s) EJB","S095-DeployableEJB");
		lmMap.put("Nome do(s) Módulo(s) EJB","S095-IntegraEJB");
		lmMap.put("Criar MBeans para recursos?","Sim");
		lmMap.put("Validar Entrada Desligar/Avisar/Falhar","Avisar");
		lmMap.put("Processar configuração incorporada?","Não");
		lmMap.put("Permissões de arquivo",".*\\.dll=755#.*\\.so=755#.*\\.a=755#.*\\.sl=755");
//		lmMap.put("Mapeamento de módulos para servidores","WebSphere:cell=wdcell,cluster=WDCLS01");
//		lmMap.put("Mapeamento de módulos para servidores","WebSphere:cell=wdcell,node=wdnodea,server=HTTPServer");
		lmMap.put("Mapeamento de módulos para servidores","");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployEAR/Log4J");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployEAR/BNB-Utilitarios ");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployWEB/BNB-JCIFS ");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployWEB/BNB-Sitelib ");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployWEB/Log4J");

		
		//### app_deploy.py ###
		lmMap.put("Segurança – Autenticação J2C","");
		lmMap.put("J2C Alias","S533_DB2_JAAS_1");
		lmMap.put("J2C ID do usuário","U533DES");
		lmMap.put("J2C Senha","46TQ3653");
		lmMap.put("J2C Descrição","Autenticacao com o banco DB2 do S533");
		
		lmMap.put("Segurança – Autenticação J2C","");
		lmMap.put("J2C Alias","S234_SQLSERVER_JAAS_2");
		lmMap.put("J2C ID do usuário","s234con");
		lmMap.put("J2C Senha","s234cons");
		lmMap.put("J2C Descrição","Autenticacao com o banco SQL Server do S234");

		
		//### app_datasource.py ###
		lmMap.put("Recursos JDBC – Origens de Dados","");
		lmMap.put("DS Nome da origem de dados","S533DS");
		lmMap.put("DS Nome JNDI","jdbc/S533DS");
		lmMap.put("DS Alias de autenticação","S533_DB2_JAAS_1");
		lmMap.put("DS Escopo do Provedor","/");
		//lmMap.put("DS Escopo do Provedor","WebSphere:Server=server1");
		lmMap.put("DS Nome do Provedor","DB2 Universal JDBC Driver Provider (XA)");
		lmMap.put("DS Nome do banco de dados","DB2T");
		lmMap.put("DS Nome do servidor","d001mfd1");
		lmMap.put("DS Numero da porta","5021");
		lmMap.put("DS Utilizar a origem no CMP","Sim");
		lmMap.put("DS Nome da Classe Helper","com.ibm.websphere.rsadapter.DB2UniversalDataStoreHelper");
		lmMap.put("DS Esta em Cluster","Sim");
		
/*		lmMap.put("Recursos JDBC – Origens de Dados","");
		lmMap.put("DS Nome da origem de dados","DS234_SQLServer");
		lmMap.put("DS Nome JNDI","jdbc/DS234_SQLServer");
		lmMap.put("DS Alias de autenticação","S234_SQLSERVER_JAAS_2");
		lmMap.put("DS Escopo do Provedor","/");
		//lmMap.put("DS Escopo do Provedor","WebSphere:Server=server1");
		lmMap.put("DS Nome do Provedor","Microsoft SQL Server JDBC Driver");
		lmMap.put("DS Nome do banco de dados","DAPO234_CQU");
		lmMap.put("DS Nome do servidor","D001SRP02");
		lmMap.put("DS Numero da porta","1433");
		lmMap.put("DS Utilizar a origem no CMP","Sim");
		lmMap.put("DS Nome da Classe Helper","com.ibm.websphere.rsadapter.MicrosoftSQLServerDataStoreHelper");
		lmMap.put("DS Esta em Cluster","Sim");
*/		
		//### app_url.py ###
		lmMap.put("Recursos – URLs","");
		lmMap.put("URL Nome","url_1");
		lmMap.put("URL Nome JNDI","url/url1");
		lmMap.put("URL SPEC","http://www.google.com");
		lmMap.put("URL Escopo Provedor","Cell=wdcell");
		lmMap.put("URL Nome Provedor","Default URL Provider");
		
		lmMap.put("Recursos – URLs","");
		lmMap.put("URL Nome","url_2");
		lmMap.put("URL Nome JNDI","url/url2");
		lmMap.put("URL SPEC","http://www.google.com");
		lmMap.put("URL Escopo Provedor","Cell=wdcell");
		lmMap.put("URL Nome Provedor","Default URL Provider");
		
		lmMap.put("Recursos – URLs","");
		lmMap.put("URL Nome","url_3");
		lmMap.put("URL Nome JNDI","url/url3");
		lmMap.put("URL SPEC","http://www.google.com");
		lmMap.put("URL Escopo Provedor","Cell=wdcell");
		lmMap.put("URL Nome Provedor","Default URL Provider");
		
		lmMap.put("Recursos – URLs","");
		lmMap.put("URL Nome","url_3");
		lmMap.put("URL Nome JNDI","url/url3");
		lmMap.put("URL SPEC","http://www.google.com");
		lmMap.put("URL Escopo Provedor","Cell=wdcell");
		lmMap.put("URL Nome Provedor","Default URL Provider");
		
		lmMap.put("Recursos – URLs","");
		lmMap.put("URL Nome","url_3");
		lmMap.put("URL Nome JNDI","url/url3");
		lmMap.put("URL SPEC","http://www.google.com");
		lmMap.put("URL Escopo Provedor","Cell=wdcell");
		lmMap.put("URL Nome Provedor","Default URL Provider");
		
		lmMap.put("Recursos – JMS Actvation Specfification","");
		lmMap.put("JMS Escopo Actvation Specfification","Node:M1072317Node01");
		lmMap.put("JMS Nome Actvation Specfification","M1072317_AS_LM");
		lmMap.put("JMS Nome JNDI Actvation Specfification","as/M1072317_AS_LM");
		lmMap.put("JMS Nome JNDI Destino","jms/filaUnica");
		lmMap.put("JMS Tipo Destino","javax.jms.Queue");
		lmMap.put("JMS Descricao","descricao");
		lmMap.put("JMS Nome do Queue Manager","QM_M1072317");
		lmMap.put("JMS Host do Queue Manager","M1072317");
		lmMap.put("JMS Canal de Conexao do Queue Manager","SYSTEM.AUTO.SVRCONN");
		
		lmMap.put("Recursos JMS – Filas","");
		lmMap.put("JMS Escopo Fila","Node:M1072317Node01");
		lmMap.put("JMS Nome Fila","FILA_1");
		lmMap.put("JMS Nome JNDI Fila","jms/FILA_1");
		lmMap.put("JMS Nome da Fila no MQ","filaLM");
		lmMap.put("JMS Tipo de Fila","QUEUE");
		
		lmMap.put("Recursos JMS – Filas","");
		lmMap.put("JMS Escopo Fila","Node:M1072317Node01");
		lmMap.put("JMS Nome Fila","TOPIC_1");
		lmMap.put("JMS Nome JNDI Fila","jms_TOPIC_1");
		lmMap.put("JMS Nome da Fila no MQ","topicoLM");
		lmMap.put("JMS Tipo de Fila","TOPIC");
	}
	

	@Override
	public String getValorAtributoLM(String atributo) {
		return (String) ((List<?>)lmMap.get(atributo)).get(0);			
	}

	@Override
	public List<?> getValorAtributoLMLista(String atributo) {
		return (List<?>) lmMap.get(atributo);			
	}
}

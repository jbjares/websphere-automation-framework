package br.gov.bnb.s095.lib.odm.parser;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.MultiHashMap;

public class ODMParserMockLocal extends ODMParser{
	
	private static HashMap lmMap = new MultiHashMap();
	
	static{
		
		//### app_deploy.py ###
		lmMap.put("Localizacao do pacote aplicativo","C:\\Users\\c010098\\Desktop\\AutoDeploy\\S095-AutoDeployEAR.ear");
		lmMap.put("Nome da raiz de contexto","S095-AutoDeployWEB");
		lmMap.put("Pre-compilar arquivos JSP?","Sim");
		lmMap.put("Celula/No/Servidor destino","WebSphere:cell=M1072317Node02Cell,node=M1072317Node02,Server=server1");
		lmMap.put("Diretorio de instalacao do aplicativo","C:\\Program Files (x86)\\IBM\\SDP_75\\runtimes\\base_v7\\profiles\\AppSrv02\\installedApps\\M1072317Node02Cell");
		lmMap.put("Distribuir aplicativo?","Sim");
		lmMap.put("Implementar Beans Corporativos?","Sim");
		lmMap.put("Nome do aplicativo","S095-AutoDeployEAR");
		lmMap.put("Nome do Modulo WEB","S095-AutoDeployWEB");
		lmMap.put("Nome do(s) Modulo(s) EJB","S095-DeployableEJB");
		lmMap.put("Nome do(s) Modulo(s) EJB","S095-IntegraEJB");
		lmMap.put("Criar MBeans para recursos?","Sim");
		lmMap.put("Validar Entrada Desligar/Avisar/Falhar","Avisar");
		lmMap.put("Processar configuracao incorporada?","Nao");
		lmMap.put("Permissoes de arquivo",".*\\.dll=755#.*\\.so=755#.*\\.a=755#.*\\.sl=755");
		lmMap.put("Mapeamento de modulos para servidores","");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployEAR/Log4J");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployEAR/BNB-Utilitarios");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployWEB/BNB-JCIFS");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployWEB/BNB-Sitelib");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployWEB/Log4J");
		lmMap.put("Referenciar bibliotecas compartilhadas","S095-AutoDeployWEB/BNB-Seguranca");
		lmMap.put("Esta em Cluster","Nao");
		
		//### app_jaas.py ###
		lmMap.put("Seguranca - Autenticacao J2C","");
		lmMap.put("J2C Alias","S533_DB2_JAAS_1");
		lmMap.put("J2C ID do usuario","U533DES");
		lmMap.put("J2C Senha","46TQ3653");
		lmMap.put("J2C Descricao","Autenticacao com o banco DB2 do S533");
		
		lmMap.put("Seguranca - Autenticacao J2C","");
		lmMap.put("J2C Alias","S234_SQLSERVER_JAAS_2");
		lmMap.put("J2C ID do usuario","s234con");
		lmMap.put("J2C Senha","s234cons");
		lmMap.put("J2C Descricao","Autenticacao com o banco SQL Server do S234");

		
		//### app_datasource.py ###
		lmMap.put("Recursos JDBC - Origens de Dados","");
		lmMap.put("DS Nome da origem de dados","S533DS");
		lmMap.put("DS Nome JNDI","jdbc/S533DS");
		lmMap.put("DS Alias de autenticacao","S533_DB2_JAAS_1");
		lmMap.put("DS Escopo do Provedor","WebSphere:Server=server1");
		lmMap.put("DS Nome do Provedor","DB2 Universal JDBC Driver Provider (XA)");
		lmMap.put("DS Nome do banco de dados","DB2T");
		lmMap.put("DS Nome do servidor","d001mfd1");
		lmMap.put("DS Numero da porta","5021");
		lmMap.put("DS Utilizar a origem no CMP","Sim");
		lmMap.put("DS Nome da Classe Helper","com.ibm.websphere.rsadapter.DB2UniversalDataStoreHelper");
		lmMap.put("DS Esta em Cluster","Nao");
		
		lmMap.put("Recursos JDBC - Origens de Dados","");
		lmMap.put("DS Nome da origem de dados","DS234_SQLServer");
		lmMap.put("DS Nome JNDI","jdbc/DS234_SQLServer");
		lmMap.put("DS Alias de autenticacao","S234_SQLSERVER_JAAS_2");
		lmMap.put("DS Escopo do Provedor","WebSphere:Server=server1");
		lmMap.put("DS Nome do Provedor","Microsoft SQL Server JDBC Driver");
		lmMap.put("DS Nome do banco de dados","DAPO234_CQU");
		lmMap.put("DS Nome do servidor","D001SRP02");
		lmMap.put("DS Numero da porta","1433");
		lmMap.put("DS Utilizar a origem no CMP","Sim");
		lmMap.put("DS Nome da Classe Helper","com.ibm.websphere.rsadapter.MicrosoftSQLServerDataStoreHelper");
		lmMap.put("DS Esta em Cluster","Nao");

		//### app_url.py ###
		lmMap.put("Recursos - URLs","");
		lmMap.put("URL Nome","S033-Autodeploy-paginaAcessoNegado");
		lmMap.put("URL Nome JNDI","url/paginaAcessoNegado");
		lmMap.put("URL SPEC","http://localhost:9080/S095-AutoDeployWEB/faces/acessonegado.jsp");
		lmMap.put("URL Escopo Provedor","Cell=M1072317Node02Cell");
		lmMap.put("URL Nome Provedor","Default URL Provider");
		
		lmMap.put("Recursos - URLs","");
		lmMap.put("URL Nome","servico");
		lmMap.put("URL Nome JNDI","url/servico");
		lmMap.put("URL SPEC","http://d001mfd1.capgv.intra.bnb:9082/S095-AutoDeploySupportEJB_HTTPRouter/ExecutaService");
		lmMap.put("URL Escopo Provedor","Cell=M1072317Node02Cell");
		lmMap.put("URL Nome Provedor","Default URL Provider");

		
		//### app_jms_actspec.py ###
		lmMap.put("Recursos - JMS Actvation Specfification","");
		lmMap.put("JMS Escopo Actvation Specfification","Node:M1072317Node02");
		lmMap.put("JMS Nome Actvation Specfification","M1072317-AUTODEPLOY-AS");
		lmMap.put("JMS Nome JNDI Actvation Specfification","jms/M1072317-AUTODEPLOY-AS");
		lmMap.put("JMS Nome JNDI Destino","jms/F095ENT.BNBAUTODEPLOY");
		lmMap.put("JMS Tipo Destino","javax.jms.Queue");
		lmMap.put("JMS Descricao","descricao");
		lmMap.put("JMS Nome do Queue Manager","CSQ1");
		lmMap.put("JMS Host do Queue Manager","D001MFD1");
		lmMap.put("JMS Porta do Queue Manager","1414");
		lmMap.put("JMS Canal de Conexao do Queue Manager","SYSTEM.DEF.SVRCONN");
		
		
		//### app_jms_queue.py ###
		lmMap.put("Recursos JMS - Filas","");
		lmMap.put("JMS Escopo Fila","Node:M1072317Node02");
		lmMap.put("JMS Nome Fila","F095ENT.BNBAUTODEPLOY");
		lmMap.put("JMS Nome JNDI Fila","jms/F095ENT.BNBAUTODEPLOY");
		lmMap.put("JMS Nome da Fila no MQ","F095ENT.BNBAUTODEPLOY");
		lmMap.put("JMS Tipo de Fila","QUEUE");
		
		
		//### app_jaas_iskey.py ###
		lmMap.put("Seguranca - Logins do Aplicativo","");
		lmMap.put("LA Alias","S095-AutoDeployISKEY4");
		lmMap.put("LA Nome da Classe do Modulo","br.gov.bnb.seguranca.login.IsKeyLoginModule");
		lmMap.put("LA Estrategia de Autenticacao","REQUIRED");
		lmMap.put("LA Propriedades Personalizadas","acao=autorizarUsuario");
		lmMap.put("LA Propriedades Personalizadas","aplicacao=S033ORC");
		lmMap.put("LA Propriedades Personalizadas","endereco=http://d001wwd01/ISKEY/WSISKey.asmx");
		lmMap.put("LA Propriedades Personalizadas","nivel.log=ALL");
		lmMap.put("LA Propriedades Personalizadas","nome.espaco=http://tempuri.org/");
		lmMap.put("LA Propriedades Personalizadas","tipo=web.service");
		
	}
	

	@Override
	public List<String> getValorAtributoLMLista(String atributo, String fileName) {
		return (List<String>) lmMap.get(atributo);			
	}
}

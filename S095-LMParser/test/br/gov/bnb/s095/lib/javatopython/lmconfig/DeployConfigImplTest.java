package br.gov.bnb.s095.lib.javatopython.lmconfig;

import org.junit.Assert;
import org.junit.Test;
import org.python.core.PyList;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.ListaMateriaisWAS;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyDeployTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;


public class DeployConfigImplTest extends AutoDeployTest{

	
	@Test
	public void testExecutar(){
		ListaMateriaisWAS listaMateriais = (ListaMateriaisWAS) ODMFactory.getODMEntity(ListaMateriaisWAS.class,FILE_NAME).get(0);
		Assert.assertEquals("C:\\Users\\c010098\\Desktop\\AutoDeploy\\S095-AutoDeployEAR.ear",listaMateriais.getLocalizacaoPacoteAplicativo());
		Assert.assertEquals("S095-AutoDeployWEB",listaMateriais.getNomeRaizContexto());
		Assert.assertEquals(Boolean.TRUE,listaMateriais.getPreCompilarArquivosJSP());
		Assert.assertEquals("WebSphere:cell=M1072317Node02Cell,node=M1072317Node02,Server=server1",listaMateriais.getCelulaNoServidorDestino());
		Assert.assertEquals("C:\\Program Files (x86)\\IBM\\SDP_75\\runtimes\\base_v7\\profiles\\AppSrv02\\installedApps\\M1072317Node02Cell",
				listaMateriais.getDiretorioInstalacaoAplicativo());
		Assert.assertEquals(Boolean.TRUE,listaMateriais.getDistribuirAplicativo());
		Assert.assertEquals(Boolean.TRUE,listaMateriais.getImplementarBeansCorporativos());
		Assert.assertEquals("S095-AutoDeployEAR",listaMateriais.getNomeAplicativo());
		Assert.assertEquals("S095-AutoDeployWEB",listaMateriais.getNomeModuloWEB());
		Assert.assertEquals(2,listaMateriais.getNomeModulosEJB().size());
		Assert.assertEquals("S095-DeployableEJB",listaMateriais.getNomeModulosEJB().get(0));
		Assert.assertEquals("S095-IntegraEJB",listaMateriais.getNomeModulosEJB().get(1));
		Assert.assertEquals(Boolean.TRUE,listaMateriais.getCriarMBeansParaRecursos());
		Assert.assertEquals("Avisar",listaMateriais.getValidarEntrada());
		Assert.assertEquals(Boolean.FALSE,listaMateriais.getProcessarConfiguracaoIncorporada());
		Assert.assertEquals(".*\\.dll=755#.*\\.so=755#.*\\.a=755#.*\\.sl=755",listaMateriais.getPermissoesArquivo());
		Assert.assertEquals(Boolean.FALSE,listaMateriais.getProcessarConfiguracaoIncorporada());
		Assert.assertEquals(6,listaMateriais.getBibliotecasCompartilhadas().size());
		Assert.assertEquals("S095-AutoDeployEAR/Log4J",listaMateriais.getBibliotecasCompartilhadas().get(0));
		Assert.assertEquals("S095-AutoDeployEAR/BNB-Utilitarios",listaMateriais.getBibliotecasCompartilhadas().get(1));
		Assert.assertEquals("S095-AutoDeployWEB/BNB-JCIFS",listaMateriais.getBibliotecasCompartilhadas().get(2));
		Assert.assertEquals("S095-AutoDeployWEB/BNB-Sitelib",listaMateriais.getBibliotecasCompartilhadas().get(3));
		Assert.assertEquals("S095-AutoDeployWEB/Log4J",listaMateriais.getBibliotecasCompartilhadas().get(4));
		Assert.assertEquals("S095-AutoDeployWEB/BNB-Seguranca",listaMateriais.getBibliotecasCompartilhadas().get(5));
		Assert.assertEquals(Boolean.FALSE,listaMateriais.getIsInCluster());
		Assert.assertEquals("cell=M1072317Node02Cell,node=M1072317Node02,type=ApplicationManager,process=server1,*",listaMateriais.getEscopoAplicationManager());
		
		
		PyList result = new DeployConfigImpl().getConfig(FILE_NAME);
		PyDeployTO itemZero = (PyDeployTO) result.__getitem__(0);
		Assert.assertEquals("C:\\Users\\c010098\\Desktop\\AutoDeploy\\S095-AutoDeployEAR.ear",itemZero.getLocalizacaoPacoteAplicativo().toString());
		String teste = "['-verbose', '-CtxRootForWebMod', [['S095-AutoDeployWEB', 'S095-AutoDeployWEB.war, " +
		"WEB-INF/web.xml', '/S095-AutoDeployWEB']], '-preCompileJSPs', '-installed.ear.destination', " +
		"'C:\\\\Program Files (x86)\\\\IBM\\\\SDP_75\\\\runtimes\\\\base_v7\\\\profiles\\\\AppSrv02\\\\" +
		"installedApps\\\\M1072317Node02Cell', '-distributeApp', '-deployejb', '-appname', 'S095-AutoDeployEAR', " +
		"'-createMBeansForResources', '-validateinstall', 'warn', '-nouseMetaDataFromBinary', '-filepermission', " +
		"'.*\\\\.dll=755#.*\\\\.so=755#.*\\\\.a=755#.*\\\\.sl=755', '-cell', 'M1072317Node02Cell', '-node', 'M1072317Node02', " +
		"'-server', 'server1', '-MapSharedLibForMod', [['S095-AutoDeployEAR', 'META-INF/application.xml', 'Log4J+BNB-Utilitarios'], " +
		"['S095-AutoDeployWEB', 'S095-AutoDeployWEB.war, WEB-INF/web.xml', 'BNB-JCIFS+BNB-Sitelib+Log4J+BNB-Seguranca']]]";
		System.out.println(teste);
		System.out.println(itemZero.getAtributos().toString());
		Assert.assertEquals(teste,itemZero.getAtributos().toString());

	}
	
}

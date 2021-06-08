package br.gov.bnb.s095.lib.javatopython.lmconfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import br.gov.bnb.s095.lib.javatopython.lmconfig.entidade.ListaMateriaisWAS;
import br.gov.bnb.s095.lib.javatopython.lmconfig.to.PyDeployTO;
import br.gov.bnb.s095.lib.odm.factory.ODMFactory;

//TODO Refatorar (Criar properties, constantes etc..)
public class DeployConfigImpl implements Config{
		

		public PyList getConfig(String fileName){
			ListaMateriaisWAS listaMateriais = (ListaMateriaisWAS) ODMFactory.getODMEntity(ListaMateriaisWAS.class,fileName).get(0);
			new PythonInterpreter();
			PyDeployTO pyDeployTO = new PyDeployTO();
			PyList result = new PyList();
			PyList pyListTemp = new PyList();
			
			//LM item 1
			//Localização do pacote aplicativo
			pyDeployTO.setLocalizacaoPacoteAplicativo(new PyString(listaMateriais.getLocalizacaoPacoteAplicativo()));

			pyListTemp.append(new PyString("-verbose"));

			//LM item 9
			//Nome do Módulo WEB
			String nomeModuloWeb = listaMateriais.getNomeModuloWEB();
			
			//LM item 2
			//Nome da raiz de contexto
			String nomeRaizContexto = listaMateriais.getNomeRaizContexto();
			pyListTemp.append(new PyString("-CtxRootForWebMod"));
			PyList pyListContextRootInner = new PyList();
			PyList pyListContextRootOuter = new PyList();
			pyListContextRootInner.append(new PyString(nomeModuloWeb.trim()));
			pyListContextRootInner.append(new PyString(nomeModuloWeb.trim()+".war, WEB-INF/web.xml"));
			pyListContextRootInner.append(new PyString("/"+nomeRaizContexto.trim()));
			pyListContextRootOuter.append(pyListContextRootInner);
			pyListTemp.append(pyListContextRootOuter);

			
			//LM item 3 
			//Pré-compilar arquivos JSP?
			Boolean preCompilarJsp = listaMateriais.getPreCompilarArquivosJSP();
			if(preCompilarJsp){
				pyListTemp.append(new PyString("-preCompileJSPs"));
			}else{
				pyListTemp.append(new PyString("-nopreCompileJSPs"));
			}
			
			//LM item 5
			//Diretório de instalação do aplicativo
			String diretorioInstalacaoAplicativo = listaMateriais.getDiretorioInstalacaoAplicativo();
			pyListTemp.append(new PyString("-installed.ear.destination"));
			pyListTemp.append(new PyString(diretorioInstalacaoAplicativo));
			
			//LM item 6
			//Distribuir aplicativo?
			Boolean distribuirAplicativo = listaMateriais.getDistribuirAplicativo();
			if(distribuirAplicativo){
				pyListTemp.append(new PyString("-distributeApp"));
			}else{
				pyListTemp.append(new PyString("-nodistributeApp"));
			}
			
			
			//LM item 7
			//Implementar Beans Corporativos?
			Boolean implementarBeansCorporativos = listaMateriais.getImplementarBeansCorporativos();
			if(implementarBeansCorporativos){
				pyListTemp.append(new PyString("-deployejb"));
			}else{
				pyListTemp.append(new PyString("-nodeployejb"));
			}
			
			
			//LM item 8
			//Nome do aplicativo
			String nomeAplicativo = listaMateriais.getNomeAplicativo();
			pyListTemp.append(new PyString("-appname"));
			pyListTemp.append(new PyString(nomeAplicativo));
				
			//LM item 11
			//Criar MBeans para recursos?
			Boolean criarMBeansParaRecursos = listaMateriais.getCriarMBeansParaRecursos();
			if(criarMBeansParaRecursos){
				pyListTemp.append(new PyString("-createMBeansForResources"));
			}else{
				pyListTemp.append(new PyString("-nocreateMBeansForResources"));
			}
			
			
			//LM item 12
			//Validar Entrada Desligar/Avisar/Falhar
			String validarEntrada = listaMateriais.getValidarEntrada();
			if("Desligar".trim().toUpperCase().equals(validarEntrada.trim().toUpperCase())){
				pyListTemp.append(new PyString("-validateinstall"));
				pyListTemp.append(new PyString("off"));
			}else if("Avisar".trim().toUpperCase().equals(validarEntrada.trim().toUpperCase())){
				pyListTemp.append(new PyString("-validateinstall"));
				pyListTemp.append(new PyString("warn"));
			}else if("Falhar".trim().toUpperCase().equals(validarEntrada.trim().toUpperCase())){
				pyListTemp.append(new PyString("-validateinstall"));
				pyListTemp.append(new PyString("fail"));
			}
			
			
			//LM item 13
			//Processar configuração incorporada?
			Boolean possuiConfiguracaoIncorporada = listaMateriais.getProcessarConfiguracaoIncorporada();
			if(possuiConfiguracaoIncorporada){
				pyListTemp.append(new PyString("-useMetaDataFromBinary"));
			}else{
				pyListTemp.append(new PyString("-nouseMetaDataFromBinary"));
			}
			
			//LM item 14
			//Permissões de arquivo
			String permissaoArquivo = listaMateriais.getPermissoesArquivo();
			pyListTemp.append(new PyString("-filepermission"));
			pyListTemp.append(new PyString(permissaoArquivo));
			
			//a) LM item 15
			//Obtem módulos para mapeamento
			List<String> modulosMapeamento = listaMateriais.getMapeamentoModulosServidores();
			String modulos = "";
			if(modulosMapeamento!=null){
				for(String modulo:modulosMapeamento){
					modulos += modulo+"+";				
				}
				
				if(modulos!=null){
					if(modulos.endsWith("+")){
						modulos = modulos.substring(0,modulos.length()-1);
					}
				}				
				
			}
			//LM item 4
			//Célula/Nó/Servidor destino
			//Se nao houver configuracao de modulos configurar modulo unico.
			if(modulos==null||"".equals(modulos)){
				String celulaNoServidorOuCluster = listaMateriais.getCelulaNoServidorDestino();
				if(celulaNoServidorOuCluster.startsWith("WebSphere:")){
					celulaNoServidorOuCluster = celulaNoServidorOuCluster.substring(10,celulaNoServidorOuCluster.length());
				}
				String[] mods = null;
				if(celulaNoServidorOuCluster.contains(",")){
					mods = celulaNoServidorOuCluster.split(",");				
				}
				for(String item : mods){
					String[] itemMod = item.split("=");
					pyListTemp.append(new PyString("-"+itemMod[0].toLowerCase()));
					pyListTemp.append(new PyString(itemMod[1]));	
				}
			}else{
				//b) LM item 15
				//Mapeamento de módulos para servidores
				PyList pyListMapWEBModuleInner = new PyList();
				PyList pyListMapModulesOuter = new PyList();

				//Mapeia modulos para modulo WEB
				pyListTemp.append(new PyString("-MapModulesToServers"));
				pyListMapWEBModuleInner.append(new PyString(nomeModuloWeb.trim()));
				pyListMapWEBModuleInner.append(new PyString(nomeModuloWeb.trim()+".war, WEB-INF/web.xml"));
				pyListMapWEBModuleInner.append(new PyString(modulos));
				pyListMapModulesOuter.append(pyListMapWEBModuleInner);
			
				//LM item 10
				//Nome do(s) Módulo(s) EJB
				List<String> nomeModulosEJBList = listaMateriais.getNomeModulosEJB();
				
				//Mapeia modulos para modulo EJB
				PyList pyListMapEJBModuleInner = null;
				for(String ejbModule:nomeModulosEJBList){
					pyListMapEJBModuleInner = new PyList();
					pyListMapEJBModuleInner.append(new PyString(ejbModule.trim()));
					pyListMapEJBModuleInner.append(new PyString(ejbModule.trim()+".jar, META-INF/ejb-jar.xml"));
					pyListMapEJBModuleInner.append(new PyString(modulos));
					pyListMapModulesOuter.append(pyListMapEJBModuleInner);
				}
				pyListTemp.append(pyListMapModulesOuter);
			}
			
			
			//LM item 16
			//Referenciar bibliotecas compartilhadas
			List<String> bibliotecasCompartilhadas = listaMateriais.getBibliotecasCompartilhadas();
			PyList pyListSharedLibOuter = new PyList();
			PyList pyListSharedLibInnerEAR = null;
			PyList pyListSharedLibInnerWEB = null;
			pyListTemp.append(new PyString("-MapSharedLibForMod"));
			
			int countEAR = 0;
			int countWEB = 0;
			for(String biblioteca:bibliotecasCompartilhadas){
					String[] s = biblioteca.split("/");

					//TODO PREVINIR CONTRA INDEXOUTOFBOUNDEXCEPTION
					String appModule = null;
					String libNome = null;

					if(biblioteca.trim().toUpperCase().contains(("EAR"))){
						appModule = s[0];
						libNome = s[1];
						if(countEAR==0){
							pyListSharedLibInnerEAR = new PyList();
							pyListSharedLibInnerEAR.append(new PyString(appModule));
							pyListSharedLibInnerEAR.append(new PyString("META-INF/application.xml"));
							pyListSharedLibInnerEAR.append(new PyString(libNome.trim()));
							countEAR++;							
						}else{
							PyObject ultimoItem = pyListSharedLibInnerEAR.__finditem__(pyListSharedLibInnerEAR.__len__()-1);
							pyListSharedLibInnerEAR.remove(ultimoItem);
							String novaLib = ultimoItem+"+"+libNome;
							pyListSharedLibInnerEAR.append(new PyString(novaLib.trim()));
						}
					}else if(biblioteca.trim().toUpperCase().contains(("WEB"))){
						appModule = s[0];
						libNome = s[1];
						if(countWEB==0){
							pyListSharedLibInnerWEB = new PyList();
							pyListSharedLibInnerWEB.append(new PyString(appModule.trim()));
							pyListSharedLibInnerWEB.append(new PyString(appModule.trim()+".war, WEB-INF/web.xml"));
							pyListSharedLibInnerWEB.append(new PyString(libNome.trim()));
							countWEB++;
						}else{
							PyObject ultimoItem = pyListSharedLibInnerWEB.__finditem__(pyListSharedLibInnerWEB.__len__()-1);
							pyListSharedLibInnerWEB.remove(ultimoItem);
							String novaLib = ultimoItem+"+"+libNome;
							pyListSharedLibInnerWEB.append(new PyString(novaLib.trim()));
						}
					}

			}
			if(pyListSharedLibInnerEAR!=null){
				pyListSharedLibOuter.append(pyListSharedLibInnerEAR);				
			}
			if(pyListSharedLibInnerWEB!=null){
				pyListSharedLibOuter.append(pyListSharedLibInnerWEB);				
			}
			pyListTemp.append(pyListSharedLibOuter);
			pyDeployTO.setAtributos(pyListTemp);
			pyDeployTO.setIsInCluster(new PyString(listaMateriais.getIsInCluster().toString()));
			pyDeployTO.setNomeAplicacao(new PyString(nomeAplicativo));
			pyDeployTO.setEscopoAplicationManager(new PyString(listaMateriais.getEscopoAplicationManager()));
			result.append(pyDeployTO);
			return result;
		}

		public static void main(String[] args) throws FileNotFoundException, IOException {
			PyList result = new DeployConfigImpl().getConfig("C:\\BNB\\AutoDeploy\\conf\\s095-lista-materiais.xml");
			PyDeployTO itemZero = (PyDeployTO) result.__getitem__(0);
			System.out.println(itemZero.getLocalizacaoPacoteAplicativo());
			System.out.println(itemZero.getAtributos());
		}

	
}

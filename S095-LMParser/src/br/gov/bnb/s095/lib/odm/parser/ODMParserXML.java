package br.gov.bnb.s095.lib.odm.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.beanutils.PropertyUtils;
import org.xml.sax.InputSource;

import br.gov.bnb.s095.autodeploy.xml.ns.v1.ListaDeMateriais;

public class ODMParserXML extends ODMParser{
	
	private static final String VAZIO = "empty";

	private static final String ITEM = "item";

	private static final String VALOR = "valor";

	private static final String NOME_ITEM = "nomeItem";
	
	
	
	@Override
	public List<String> getValorAtributoLMLista(String atributo,String fileName) {
		try {
			List<String> result = new ArrayList<String>();
			String xml = getArquivoDeConfiguracao(fileName);
			ListaDeMateriais listaDeMateriais = (ListaDeMateriais) parseXMLToObject(xml,ListaDeMateriais.class);
			descobrirValor(listaDeMateriais,atributo,result);
			return  result;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	
	private void descobrirValor(Object obj,String valor, List<String> result) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String, Object> lm = PropertyUtils.describe(obj);
		for (String atributoLM : lm.keySet()) {
			if((VAZIO.equals(atributoLM))){
				continue;
			}
			
			Object nomeItemValor = PropertyUtils.getProperty(obj, atributoLM);
					
			if(NOME_ITEM.equals(atributoLM)){
				if(valor.equals(nomeItemValor)){				
					try{
						List<String> lista = (List<String>) PropertyUtils.getProperty(obj, ITEM);		
						for(String s:lista){
							if(!"".equals(s)&&s!=null){
								result.add(s);															
							}
						}
						break;
					}catch(java.lang.NoSuchMethodException e){
						String valorItem = (String) PropertyUtils.getProperty(obj, VALOR);
						result.add(valorItem);
						break;
					}
				}
			}else{
				Object proxObjetoGrafo= PropertyUtils.getProperty(obj, atributoLM);
				boolean isList = proxObjetoGrafo instanceof List;
				
				if(isList){
					if(((List) proxObjetoGrafo).size()>0){
						List lista = (List) proxObjetoGrafo;
						int listaSize = lista.size();
						for(int i=0;i<listaSize;i++){
							Object itemList = lista.get(i);
							descobrirValor(itemList,valor,result);								
						}
					}						
				}
				
				if (proxObjetoGrafo == null || (proxObjetoGrafo instanceof Class)) {
					continue;
				}
				
				if(!isPrimitive(proxObjetoGrafo)){
					descobrirValor(proxObjetoGrafo,valor,result);					
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static  Object parseXMLToObject(String xml,Class clazz){
		try{
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller um = jc.createUnmarshaller();
			Object obj = um.unmarshal(new InputSource(new StringReader(xml)));
			return obj;
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	public static String getArquivoDeConfiguracao(String caminhoXML) {
		try{
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(caminhoXML);
			if(is==null){
				is = new FileInputStream(new File(caminhoXML));
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder xml = new StringBuilder();
			String s;
			while((s = br.readLine()) != null) {
				xml.append(s);
			}
			return xml.toString();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	public boolean isPrimitive(Object value) {
		return value.getClass().isPrimitive() || value instanceof String
				|| value instanceof Number || value instanceof byte[]
				|| value instanceof char[] || value instanceof int[]
				|| value instanceof double[] || value instanceof long[]
				|| value instanceof float[];
	}
	
}

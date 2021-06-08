package br.gov.bnb.s095.lib.odm.util;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.Scanner;

public class ODMParserUtil extends Properties{
	private static final long serialVersionUID = -8026755587209964940L;
	
	private volatile static ODMParserUtil properties;


	public synchronized static String getPropertieParameter(String propriedade){
		try{
			if(properties==null){
				properties = new ODMParserUtil();
				ClassLoader cl = ODMParserUtil.class.getClassLoader();
				InputStream fin = cl.getResourceAsStream("lmparser.properties");
				properties.load(fin);
				fin.close();
			}				
			return properties.getProperty(propriedade);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e); 
		}
	}
	
	public static String getPropertieParameter(String propriedade,Object... argumentos){
		try{
			String result = getPropertieParameter(propriedade);
			return MessageFormat.format(result,argumentos);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e); 
		}
	}
	
	public static String obterLocalizacaoListaMateriaisXML(){
		Scanner s = new Scanner(System.in);
		System.out.println("Qual a localizacao do arquivo XML da lista de materiais?");
		String result = s.nextLine();
		return result;
	}

}

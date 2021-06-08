package br.gov.bnb.s095.lib.odm.factory;

import java.lang.reflect.Constructor;
import java.util.List;

import br.gov.bnb.s095.lib.odm.parser.ODMParser;
import br.gov.bnb.s095.lib.odm.util.ODMParserUtil;

public class ODMFactory {
	@SuppressWarnings("unchecked")
	public static <T> List<T> getODMEntity(Class classe, String fileName) {
		try{
			Constructor constructor = classe.getConstructor();
			ODMParser parser = (ODMParser) Class.forName(ODMParserUtil.getPropertieParameter("implementacao.classe.parser")).newInstance();
			return (List<T>) parser.parse(constructor.newInstance(),fileName);			
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}

package br.gov.bnb.s095.lib.odm.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.gov.bnb.s095.lib.odm.anotacao.ODMColumn;
import br.gov.bnb.s095.lib.odm.anotacao.ODMEntity;


public abstract class ODMParser {

	private static final String SIM = "SIM";
	
	private static final String DOC = "doc";

	private static final String STRING_LIST_CLASS_TO_STRING = "java.util.List<java.lang.String>";
	
//TODO Implementar suporte aos demais tipos
//	private static final String ODT = "odt";
//	private static final String PLUGIN = "PLUGIN";
	
	private void validarListaDeObrigatoriosVazia(List<String> listAttr,ODMColumn annField) {
		if(annField.required()){
			for(String s:listAttr){
				if(s==null || "".equals(s)){
					throw new RuntimeException("O campo do tipo lista de campos obrigatorios, " +
							"contendo a anotacao @ODMColumn" +
							"(name='"+annField.name()+"',required=true), possui valores nulos e/ou vazios.");
				}
			}
			
		}
	}	

	private void validarTipoCampo(Boolean isStringType, Boolean isBooleanType,Boolean isListOfTypeString, Boolean isCampoSemDefinicao, ODMColumn annField) {
		if(isCampoSemDefinicao && annField.required()){
			throw new RuntimeException("O campo contendo a anotacao @ODMColumn" +
							"(name='"+annField.name()+"',required=true) nao possui valor definido " +
							"na fonte definida para a Lista de Materiais!");
		}
		if(annField instanceof ODMColumn && (!isStringType && !isBooleanType && !isListOfTypeString)){
			throw new RuntimeException("O tipo do campo com anotacao @ODMColumn" +
					"(name='"+annField.name()+"') nao e suportado pela ferramenta. " +
					"Somente os tipos String, Boolean e List<String> sao permitidos!");
		}

	}

	private void validarAnotacaoCampo(ODMColumn annField, Field field) {
		if(annField==null){
			throw new RuntimeException("Nehnuma anotacao definida para o campo "+field.getName());
		}
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> parse(T arg, String fileName) throws FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException, SecurityException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		List<T> resultList = new ArrayList();
		ODMEntity annType = arg.getClass().getAnnotation(ODMEntity.class);
		validarAnotacaoClasse(annType);
		int maxNumberOfItens = getMaxNumberOfItensForList(arg.getClass().getDeclaredFields(),fileName);
		Map<String,Integer> mapCount = new TreeMap<String,Integer>();
		
		//Varre objetos
		for(int i=0;i<maxNumberOfItens;i++){
			T obj = (T) arg.getClass().getConstructor().newInstance();
			
			//Varre campos do objeto
			for(Field field : obj.getClass().getDeclaredFields()){		
				field.setAccessible(true);
				ODMColumn annField = field.getAnnotation(ODMColumn.class);
				validarAnotacaoCampo(annField,field);
				
				Boolean isStringType = field.getType().toString().equals(java.lang.String.class.toString());
				if(isStringType){
					List<String> stringsAttr = (List<String>)getValorAtributoLMLista(annField.name(),fileName);
					if (stringsAttr==null || stringsAttr.size()==0){
						if(annField.required()){
							throw new RuntimeException("O campo contendo a anotacao @ODMColumn" +
									"(name='"+annField.name()+"',required=true) nao possui valor definido " +
									"na fonte definida para a Lista de Materiais!");
						}
					}
					if(stringsAttr==null){continue;}
					if(stringsAttr.size()==1){
						String stringAttr = stringsAttr.get(0);
						field.set(obj,stringAttr);
					}
					if(stringsAttr.size()>1){
						Integer count = mapCount.get(field.getName());
						if(count==null){
							mapCount.put(field.getName(),0);
						}
						count = mapCount.get(field.getName());
						field.set(obj,stringsAttr.get(count));
						count++;
						mapCount.put(field.getName(),count);
			
					}

				}
				
				Boolean isBooleanType = field.getType().toString().equals(java.lang.Boolean.class.toString());
				if(isBooleanType){
					List<String> booleansAttr = (List<String>)getValorAtributoLMLista(annField.name(),fileName);
					if(booleansAttr==null || booleansAttr.size()==0){
						if(annField.required()){
							throw new RuntimeException("O campo contendo a anotacao @ODMColumn" +
									"(name='"+annField.name()+"',required=true) nao possui valor definido " +
									"na fonte definida para a Lista de Materiais!");
						}
					}
					if(booleansAttr==null){continue;}
					if(booleansAttr.size()==1){
						String result =  booleansAttr.get(0);
						Boolean booleanAttr =  SIM.equals(result.trim().toUpperCase())?true:false;
						field.set(obj,booleanAttr);
					}
					if(booleansAttr.size()>1){
						for(String booleanAttr: booleansAttr){
							Boolean booleanAttrBoolean =  SIM.equals(booleanAttr.trim().toUpperCase())?true:false;
							field.set(obj,booleanAttrBoolean);
							booleansAttr.remove(booleanAttr);
							break;
						}						
					}

				}

				Boolean isList = field.getType().toString().equals(java.util.List.class.toString());
				Boolean isListOfTypeString = Boolean.FALSE;
				Boolean isCampoSemDefinicao = Boolean.FALSE;
				if(isList){
					ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
					isListOfTypeString = STRING_LIST_CLASS_TO_STRING.equals(stringListType.toString());
					if(isListOfTypeString){
						if(getValorAtributoLMLista(annField.name(),fileName)!=null){
							List<String> listAttr = (List<String>) getValorAtributoLMLista(annField.name(),fileName);
							if(listAttr==null){break;}
							validarListaDeObrigatoriosVazia(listAttr,annField);
							field.set(obj,listAttr);
						}else{
							isCampoSemDefinicao = Boolean.TRUE;
						}
					}
					
				}
				validarTipoCampo(isStringType,isBooleanType,isListOfTypeString,isCampoSemDefinicao,annField);
			}
			resultList.add(obj);
		}
		
		return resultList;
	}
	

	private int getMaxNumberOfItensForList(Field[] declaredFields, String fileName) {
		for(Field field : declaredFields){
			ODMColumn annField = field.getAnnotation(ODMColumn.class);
			if(annField!=null && annField.required()){
				return getValorAtributoLMLista(annField.name(),fileName).size();
			}
		}
		throw new RuntimeException("Nenhum campo anotado com @ODMColumn ou nenhum campo definido como obrigatorio!");
	}

	private void validarAnotacaoClasse(ODMEntity annType) {
		if(annType==null){throw new RuntimeException("Nenhuma anotacao definida para a classe informada");}
//		if(!DOC.equals(annType.docType())){
//			throw new RuntimeException("O componente autalmente suporta somente o tipo doc");
//		}
	}

	
	public abstract List<String> getValorAtributoLMLista(String atributo,String fileName);
	
	
}

package br.gov.bnb.s095.lib.odm.doc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MultiHashMap;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadDocFileFromJava_ {

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	String fileName = "C:\\S095_AutoDeploy_LM.doc";
    	HashMap<String,List<String>> map = readTable(fileName);
    	for(Map.Entry<String,List<String>> entry:map.entrySet()){
    		System.out.println(entry.getKey());
    		for(String s:entry.getValue()){
    			System.out.println(s);
    		}
    	}
    }

    public static HashMap readTable(String fileName) throws FileNotFoundException, IOException {
    	HashMap result = new MultiHashMap();
    	POIFSFileSystem fs = null;
        fs = new POIFSFileSystem(new FileInputStream(fileName));
        HWPFDocument doc = new HWPFDocument(fs);
    	Range range = doc.getRange();  
    	
    	//Utilizado para memorizar a ultima chave a ser definida
    	//para os itens do tipo Item
    	String lastKey = "";
        Paragraph tablePar = range.getParagraph(0);  
        if (tablePar.isInTable()) {  
            Table table = range.getTable(tablePar);  
            for (int rowIdx=0; rowIdx<table.numRows(); rowIdx++) {  
                TableRow row = table.getRow(rowIdx);  
                String key = null;
                String value = null;
                for (int colIdx=0; colIdx<row.numCells(); colIdx++) {  
                    TableCell cell = row.getCell(colIdx);  
                    if((colIdx+1)%2!=0){
                    	key = cell.getParagraph(0).text();
                    	//Item e uma palavra reservada da lista de materiais para agrupar 
                    	//configuracoes semelhantes.
                    	if(key.trim().toUpperCase().startsWith("Item".trim().toUpperCase())){
                    		key = lastKey;
                    	}else{
                    		lastKey = key;                    		
                    	}
                    	
                    }else{
                    	value = cell.getParagraph(0).text();;
                    }
                    if(key!=null && !"".equals(key) && value!=null && !"".equals(value)){
                    	//Ignorar comentarios
                    	if(value.startsWith("<")){
                    		continue;
                    	}
                    	result.put(key.trim(),value.trim());
                    	key=null;
                    	value=null;
                    }
                }  
            }  

            
        }  
        return result;
		
	}

}


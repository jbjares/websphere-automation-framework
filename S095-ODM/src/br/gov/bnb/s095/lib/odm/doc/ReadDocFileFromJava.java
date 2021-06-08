package br.gov.bnb.s095.lib.odm.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.collections.MultiHashMap;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.model.ListData;
import org.apache.poi.hwpf.model.ListLevel;
import org.apache.poi.hwpf.model.ListTables;
import org.apache.poi.hwpf.usermodel.ListEntry;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadDocFileFromJava {

	public static void main(String[] args) {

		String filename = "C:\\lm_original.doc";
		ReadDocFileFromJava e = new ReadDocFileFromJava();
		e.readDocFile();
	}

	public static HashMap readTable(String fileName, String commentFlag,
			String subitemFlag) throws FileNotFoundException, IOException {
		HashMap result = new MultiHashMap();
		POIFSFileSystem fs = null;
		fs = new POIFSFileSystem(new FileInputStream(fileName));
		HWPFDocument doc = new HWPFDocument(fs);
		Range range = doc.getRange();
		// Utilizado para memorizar a ultima chave a ser definida
		// para os itens do tipo Item
		String lastKey = "";
		Paragraph tablePar = range.getParagraph(0);

		System.out.println("1===>");
		if (tablePar.isInTable()) {
			Table table = range.getTable(tablePar);
			System.out.println("2===>");
			for (int rowIdx = 0; rowIdx < table.numRows(); rowIdx++) {
				TableRow row = table.getRow(rowIdx);
				String key = null;
				String value = null;
				System.out.println("3===>");
				for (int colIdx = 0; colIdx < row.numCells(); colIdx++) {
					TableCell cell = row.getCell(colIdx);
					System.out.println("4===>");
					if ((colIdx + 1) % 2 != 0) {
						key = cell.getParagraph(0).text();
						// subitemFlag deve ser uma palavra reservada da lista
						// de materiais para agrupar
						// configuracoes semelhantes.
						if (key.trim().toUpperCase().startsWith(
								subitemFlag.trim().toUpperCase())) {
							key = lastKey;
						} else {
							lastKey = key;
						}

					} else {
						value = cell.getParagraph(0).text();
					}

					if ("".equals(key) || key == null || key.length() < 2) {
						continue;
					}
					String lastChar = key.substring(key.length() - 1, key
							.length());
					Boolean isLastCharNumerical = isLastCharNumerical(lastChar);

					if (key != null && !"".equals(key) && value != null
							&& !"".equals(value)) {
						// Ignorar comentarios
						if (value.startsWith(commentFlag)
								&& !isLastCharNumerical) {
							continue;
						}

						result.put(key.trim(), value.trim());
						System.out.println(key);
						System.out.println(value);
						key = null;
						value = null;
					}
				}
			}

		}
		return result;

	}

	private static Boolean isLastCharNumerical(String lastChar) {
		try {
			new Integer(lastChar);
		} catch (NumberFormatException e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public void readDocFile() {
		File docFile = null;
		WordExtractor docExtractor = null;
		WordExtractor exprExtractor = null;
		try {
			docFile = new File("C:\\lm_original.doc");
			// A FileInputStream obtains input bytes from a file.
			FileInputStream fis = new FileInputStream(docFile.getAbsolutePath());

			// A HWPFDocument used to read document file from FileInputStream
			HWPFDocument doc = new HWPFDocument(fis);

			docExtractor = new WordExtractor(doc);
		} catch (Exception exep) {
			System.out.println(exep.getMessage());
		}

		// This Array stores each line from the document file.
		String[] docArray = docExtractor.getParagraphText();

		for (int i = 0; i < docArray.length; i++) {
			if (docArray[i] != null)
				System.out.println("Line " + i + " : " + docArray[i]);
		}
	}


}

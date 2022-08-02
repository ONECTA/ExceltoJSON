package com.xlsx.read.controllers;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.*;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;  
public class excel {
	 private static final Logger LOGGER = LogManager.getLogger();
	 private static final String FILE_NAME = "C:\\Users\\Ashutosh\\git\\spring-boot-rest-2\\src\\main\\resources\\excelread.xlsx";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// File newFile = new File("excelread.xlsx");
		 try {
			 // Workbook book = new XSSFWorkbook(new FileInputStream("C:\\Users\\Gi\\Desktop\\ExcelReader\\ExcelFramework\\src\\test\\java\\com\\ExcelFramework\\ExcelFramework\\data\\data.xlsx"));
			   
			FileInputStream excelFile = new FileInputStream(FILE_NAME);
			 System.out.println(excel.getExcelDataAsJsonObject(excelFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	       
	}
	@SuppressWarnings("deprecation")
	public static JsonObject getExcelDataAsJsonObject(FileInputStream excelFile) {

	    JsonObject sheetsJsonObject = new JsonObject();
	    Workbook workbook = null;

	    try {
	        workbook = new XSSFWorkbook(excelFile);
	    } catch ( IOException e) {
	      System.out.println("error occured");
	              
	    }

	    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

	        JsonArray sheetArray = new JsonArray();
	        ArrayList<String> columnNames = new ArrayList<String>();
	        Sheet sheet = workbook.getSheetAt(i);
	        Iterator<Row> sheetIterator = sheet.iterator();

	        while (sheetIterator.hasNext()) {

	            Row currentRow = sheetIterator.next();
	            JsonObject jsonObject = new JsonObject();

	            if (currentRow.getRowNum() != 0) {

	                for (int j = 0; j < columnNames.size(); j++) {

	                    if (currentRow.getCell(j) != null) {
	                        if (currentRow.getCell(j).getCellTypeEnum() == CellType.STRING) {
	                            jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getStringCellValue());
	                        } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.NUMERIC) {
	                            jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getNumericCellValue());
	                        } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.BOOLEAN) {
	                            jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getBooleanCellValue());
	                        } else if (currentRow.getCell(j).getCellTypeEnum() == CellType.BLANK) {
	                            jsonObject.addProperty(columnNames.get(j), "");
	                        }
	                    } else {
	                        jsonObject.addProperty(columnNames.get(j), "");
	                    }

	                }

	                sheetArray.add(jsonObject);

	            } else {
	                // store column names
	                for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
	                    columnNames.add(currentRow.getCell(k).getStringCellValue());
	                }
	            }

	        }

	        sheetsJsonObject.add(workbook.getSheetName(i), sheetArray);

	    }

	    return sheetsJsonObject;

	}

}

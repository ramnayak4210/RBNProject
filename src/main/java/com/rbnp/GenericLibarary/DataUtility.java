package com.rbnp.GenericLibarary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	public String getDataFromProperty(String Key) throws IOException
	{
		String propertyFilePath = "./src/test/resources/CommonData.properties";
		FileInputStream fis = new FileInputStream(propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
	}
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		String propertyFilePath = "./src/test/resources/TestData.xlsx";
		FileInputStream fis = new FileInputStream(propertyFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		String value = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
}

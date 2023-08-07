package vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic methods related to Excel File
 * @author Shannu
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will give data from Excel Sheet based on 
	 sheet name,row number,cell number given by caller
	 * @param SheetName
	 * @param Rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getDataFromExcel(String SheetName,int Rownum,int cellnum) throws EncryptedDocumentException, IOException 
{
	 FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
	 Workbook wb = WorkbookFactory.create(fis);
     String value = wb.getSheet(SheetName).getRow(Rownum).getCell(cellnum).getStringCellValue();
     return value;
}
/**
 * This method will write data into the excel sheet
 * @param SheetName
 * @param rowNo
 * @param cellNo
 * @param data
 * @throws Throwable
 */
public void writeDataintoExcel(String SheetName,int rowNo,int cellNo,String data) throws Throwable
{
	FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.createSheet();
	Row row = sh.createRow(rowNo);
	Cell cel = row.createCell(cellNo);
	cel.setCellValue(data);
	FileOutputStream fos=new FileOutputStream(IConstants.excelFilePath);
	wb.write(fos);//main action
	wb.close();
}
/**
 * This method will read all the data inside a sheet and used in data Provider
 * @param sheetName
 * @return
 */
public Object[][] readMultipleData(String sheetName) throws Throwable
{
	FileInputStream fis=new FileInputStream(IConstants.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int lastrow = sh.getLastRowNum();//captures the number of rows
	int lastcell = sh.getRow(0).getLastCellNum();//captures the number of cells
	
	Object [][] data=new Object[lastrow][lastcell];//for feeding data to data provider
	
	for(int i=1;i<lastrow;i++)//for row navigation
	{
		for(int j=0;j<lastcell;j++)//for cell navigation
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}



}
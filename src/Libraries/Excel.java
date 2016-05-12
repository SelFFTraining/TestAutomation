package Libraries;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestNG.DemoTestNG;

public class Excel extends DemoTestNG{

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	@SuppressWarnings("unused")
	private static FileOutputStream fout;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
public static void setExcelFile(String Path,String SheetName) throws Exception {

	try {
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){
		  throw (e);
		}
}

//This method is to read the test data from the Excel cell, in this we are passing parameters as RowNum and ColNum
public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{		
			//Get the row and column
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
			}catch (Exception e){
			 return"";
			}
		}


//This method is to write in the Excel cell,Excel Path,Sheet Name, Row num and Column are the parameters
public static String setCellData(String Path,String Sheet,String result,int RowNum, int ColNum) throws Exception	{

		try{
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(Sheet);			
			Row = ExcelWSheet.getRow(RowNum);			
			try{
				Cell = Row.getCell(ColNum);	
			}catch(NullPointerException e){
				
			}	
			if (Row==null){
				Row =ExcelWSheet.createRow(RowNum);
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(result);
			}
			else{
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(result);
			}
					
		//Create output stream for getting result as output		
		FileOutputStream fout = new FileOutputStream(new File(Path));
		ExcelWBook.write(fout);
		ExcelWBook.close();
		fout.close();
		
		}catch (Exception e){
			throw (e);
		}
		return result;
	}
}



		
	

		
		



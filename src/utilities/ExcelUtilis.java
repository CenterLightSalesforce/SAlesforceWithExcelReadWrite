package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelUtilis {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	public static final String Path_TestData = "C:\\Users\\jakther\\Desktop\\jahed\\workspace\\DataDriven\\src\\testData\\";
	public static final String File_TestData = "TestData.xlsx";
	public WebDriver driver;
	
	public ExcelUtilis(WebDriver driver){
		this.driver=driver;
		}
	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	public  void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(SheetName);
      		} catch (Exception e) {
			throw (e);
		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public  String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			String cellData = cell.getStringCellValue();
			return cellData;
	    	} catch (Exception e) {
			return "";
		}
	}
	
	//For Total Row Count
	public  int getRowCountFromExcel(){
		return excelWSheet.getLastRowNum();
		}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public  void setCellData(String excelPath,String Result, int RowNum, int ColNum) throws Exception {

		try {

			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellType(cell.CELL_TYPE_STRING);
				cell.setCellValue(Result);
			} else {
				cell.setCellType(cell.CELL_TYPE_STRING);
				cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(excelPath);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
	
public  int getRowSize(String sheet1){
	            int cou=excelWBook.getSheet(sheet1).getLastRowNum();
	            return cou;
                        }
}

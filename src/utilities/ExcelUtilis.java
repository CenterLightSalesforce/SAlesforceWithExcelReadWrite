package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelUtilis {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

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

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public  String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}
	
	//For Total Row Count
	public  int getRowCountFromExcel(){
		return ExcelWSheet.getLastRowNum();
		
		
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public  void setCellData(String excelPath,String Result, int RowNum, int ColNum) throws Exception {

		try {

			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);
				Cell.setCellType(Cell.CELL_TYPE_STRING);
				Cell.setCellValue(Result);

			} else {

				Cell.setCellType(Cell.CELL_TYPE_STRING);
				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(excelPath);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}
	}
	
public  int getRowSize(String sheet1){
		
	//int rowSize=ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
	//int rowSize=ExcelWSheet.getLastRowNum();
	int cou=ExcelWBook.getSheet(sheet1).getLastRowNum();
	return cou;
}
}

package testCase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.SignInPage;
import utilities.ExcelUtilis;


public class ProsMemInqAwarTesting {
static WebDriver driver=null;
static String excelPath="C:\\Users\\jakther\\Desktop\\Awarness.xlsx";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jakther\\Desktop\\jahed\\java\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.get("https://test.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SignInPage sign = new SignInPage(driver);
		sign.validLogin();
				
		ExcelUtilis excel = new ExcelUtilis(driver);
		excel.setExcelFile(excelPath,"Sheet1");
		int totalRow=excel.getRowCountFromExcel();
			
		for(int i=1;i<totalRow;i++){
		String data=excel.getCellData(i, 1);
		if(data.equals("")){
			break;
		}else{

		System.out.println(i+"/ "+data);

		switch(data){
		case"Print Advertisement":
			for(int x=2;x<=totalRow;x++){
			String data1=excel.getCellData(x, 3);
		    	if(data1.equals("")){
			    	break;
			       }else
			        System.out.println("\t\t"+data1);
			     }
			break;
		case"Television Advertisement":
			for(int x=2;x<=totalRow;x++){
				String data1=excel.getCellData(x, 4);
				if(data1.equals("")){
					break;
				}else
				System.out.println("\t\t"+data1);
				}
			break;
		case"Radio Advertisement":
			for(int x=2;x<=totalRow;x++){
				String data1=excel.getCellData(x, 5);
				if(data1.equals("")){
					break;
				}else
				System.out.println("\t\t"+data1);
				}
			break;
		case"Outdoor Advertisement":
			for(int x=2;x<=totalRow;x++){
				String data1=excel.getCellData(x, 6);
				if(data1.equals("")){
					break;
				}else
				System.out.println("\t\t"+data1);
				}
			break;
		case"Doctor":
			for(int x=2;x<=totalRow;x++){
				String data1=excel.getCellData(x, 7);
				if(data1.equals("")){
					break;
				}else
				System.out.println("\t\t"+data1);
				}
			break;
		case"Social Media":
			for(int x=2;x<=totalRow;x++){
				String data1=excel.getCellData(x, 8);
				if(data1.equals("")){
					break;
				}else
				System.out.println("\t\t"+data1);
				}
			break;
			default:
				
			continue;
			
		}}
		/*if(data.equals("Print Advertisement")){
			
			System.out.println("\t\t");
			
			for(int j=1;j<=totalRow;j++){
				String data1=excel.getCellData(j, 3);
				if(data1.equals("")){
				break;
				        }
				else{
					System.out.println("\t"+data1);
				}
			}
			
			continue;
		}else{
		
		System.out.println(data);
		}*/
		
		}
	}

}

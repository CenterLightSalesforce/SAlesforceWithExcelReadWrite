package testCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ExcelUtilis;

public class TestingDemo1 {
	
 	static ExcelUtilis exc=new ExcelUtilis();
	 public static final String testData = "C:\\Users\\jakther\\Desktop\\jahed\\workspace\\DataDriven\\src\\testData\\TestData.xlsx";
	 
    // public static final String File_TestData = "TestData.xlsx";Sheet1
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		exc.setExcelFile(testData, "Sheet1");
		Thread.sleep(2000);
		//driver=new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://test.salesforce.com");
		Thread.sleep(2000);
		System.err.println(exc.getRowSize("Sheet1"));
		/*for(int i=1;i<=4;i++){		
		String userName=exc.getCellData(i, 1);
		String password=exc.getCellData(i, 2);
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		String sandBox=driver.findElement(By.xpath(".//*[@id='phHeader']/tbody/tr/td[2]/div/div[1]/div/span/span[2]")).getText().toString();
		driver.findElement(By.id("userNavButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]")).click();
		Thread.sleep(3000);
	
		exc.setCellData(testData,sandBox ,i, 4);
		System.out.println(userName);
		System.out.println(password);
		}
		
		//exc.setCellData(testData,"Salesforce", 3, 3);
		
		
		
		*/
		

	}

}

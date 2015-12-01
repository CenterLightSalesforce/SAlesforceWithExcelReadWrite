package testCase;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ExcelUtilis;

public class TestingDemo1 {
	
 	///static ExcelUtilis exc=new ExcelUtilis();
	 //public static final String testData = "C:\\Users\\jakther\\Desktop\\jahed\\workspace\\DataDriven\\src\\testData\\TestData.xlsx";
	 
    // public static final String File_TestData = "TestData.xlsx";Sheet1
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		//exc.setExcelFile(testData, "Sheet1");
		Thread.sleep(2000);
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://test.salesforce.com");
		Thread.sleep(2000);
		//System.err.println(exc.getRowSize("Sheet1"));
			
		//String userName=exc.getCellData(1, 1);
		//String password=exc.getCellData(1, 2);
		
		String userName="Jakther@centerlight.org.qual";
		String password="06082003Tuba";
				
		
		
		//driver.findElement(By.id("username")).sendKeys("hdlsdhsadh");
		//driver.findElement(By.id("password")).sendKeys("12346788");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		WebElement logInError=driver.findElement(By.id("error"));
		String errorMsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		
		
		if(logInError.isDisplayed()){
			System.out.println("Pass");
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("Login")).click();
			Thread.sleep(2000);
		}else{
			System.out.println("fail");
			driver.close();
		}

			
	logInError.getText().compareTo(errorMsg);
		
		
		
		
		
		
		String sandBox=driver.findElement(By.xpath(".//*[@id='phHeader']/tbody/tr/td[2]/div/div[1]/div/span/span[2]")).getText().toString();
		driver.findElement(By.id("userNavButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]")).click();
		Thread.sleep(3000);
	
	//	exc.setCellData(testData,sandBox ,1, 4);
		System.out.println(userName);
		System.out.println(password);
		
		
		//exc.setCellData(testData,"Salesforce", 3, 3);
		
		
		
		
		

	}

}

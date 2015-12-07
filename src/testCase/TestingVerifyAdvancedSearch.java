package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pageObject.CommonObjects;
import pageObject.SignInPage;

public class TestingVerifyAdvancedSearch {
	WebDriver driver;
	CommonObjects common=new 	CommonObjects(driver); 
	SignInPage sign=new SignInPage(driver);
	
	@Test(priority=0)
	public void openDriver() {
		driver=new FirefoxDriver();
		driver.get("https://test.salesforce.com/");
		
	}
	
	
	@Test(priority=1)
	public void logIN() throws InterruptedException{
		Thread.sleep(2000);
		sign.validLogin();
		
	}
	
	
	@Test(priority=2)
	public void searchingCase(){
		common.insertTxtOnSearchTxtBoxAndClickGoButton("00001288");
		
	}

}

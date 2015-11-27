package testCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObject.CommonObjects;

public class CommonStartUp {
	
	WebDriver driver ;
	CommonObjects common = new CommonObjects(driver);

	/*@BeforeSuite
	public void starup() {
		driver= new FirefoxDriver();
		driver.get("https://test.salesforce.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}*/
		
	
	//@AfterClass
	//public void Logout() {		
	//	common.logOut();
		//	}
	
	@AfterSuite
	public void CleanUp() {
				driver.quit();
			}

}

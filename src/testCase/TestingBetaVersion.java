package testCase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.CommonObjects;
import pageObject.SignInPage;

public class TestingBetaVersion {
	static WebDriver driver;
   
    
    
    public static void main(String[] args) throws InterruptedException {
    	  SignInPage sign=new SignInPage(driver);
    	  CommonObjects common=new CommonObjects(driver);
    	driver=new FirefoxDriver();
    	driver.get("https://test.salesforce.com");
    	Thread.sleep(2000);
    	sign.enterUserName("jakther@centerlight.org.qual");
    	sign.enterPassword("06082003Tuba");
        sign.clickOnSignIn();
		//driver.findElement(By.id("username")).sendKeys("jakther@centerlight.org.qual");
		//driver.findElement(By.id("password")).sendKeys("06082003Tuba");
		//driver.findElement(By.id("Login")).click();

	}

}

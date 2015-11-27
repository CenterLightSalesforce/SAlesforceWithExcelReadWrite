package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.NavigateToOtherPage;
import utilities.AllMethod;

public class testingPurpose {
	
	static WebDriver driver=null;
	static NavigateToOtherPage pageNavi=new NavigateToOtherPage(driver);
	public static void main(String[] args) throws InterruptedException {
		driver=new FirefoxDriver();
		driver.get("https://test.salesforce.com/");
		Thread.sleep(2000);
		
		//driver.findElement(By.id("username")).sendKeys("Jakther@centerlight.org.qual");
	//	driver.findElement(By.id("password")).sendKeys("06082003Tuba");
		//driver.findElement(By.id("Login")).click();
		
		
		AllMethod.useSendkeys("id", "username","jakthet@centerlight.org.qual");
		AllMethod.useSendkeys("id", "password","06082003Tuba");
		AllMethod.clickButton("id","Login","click");
		Thread.sleep(2000);
		//driver.findElement(pageNavi.getAccountTab()).click();
		//Thread.sleep(2000);
		//driver.findElement(pageNavi.getNewAccountButtin()).click();
		//Thread.sleep(2000);
	    //driver.findElement(pageNavi.getContinueButtonForNewAcc()).click();
		
		pageNavi.navigateToAccountCreatePage();
		Thread.sleep(2000);
	//	AllMethod.logOut();
		

	}

}

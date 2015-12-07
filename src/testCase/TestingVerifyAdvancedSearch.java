package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.CommonObjects;
import pageObject.CreateNewCasePage;
import pageObject.SignInPage;

public class TestingVerifyAdvancedSearch {
	WebDriver driver;
	static String caseNumber="00001288";
	
	
	
	
	
	@Test(priority=0)
	public void openDriver() {
		driver=new FirefoxDriver();
		driver.get("https://test.salesforce.com/");
		
	}
	
	
	@Test(priority=1)
	public void logIN() throws InterruptedException{
		SignInPage sign=new SignInPage(driver);
		Thread.sleep(2000);
		sign.validLogin();
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=2)
	public void  searchingCase() throws InterruptedException{
		CommonObjects common=new CommonObjects(driver);
		
		Thread.sleep(2000);
		common.insertTxtOnSearchTxtBoxAndClickGoButton(caseNumber);
		
	}
	
	
	@Test(priority=3)
	public void verifyOpenCase() throws InterruptedException {
		Thread.sleep(2000);
		CreateNewCasePage caseLabel=new CreateNewCasePage(driver);
		String acctuelCaseLabel=caseLabel.getNewAccountLabel();
		
		Assert.assertEquals(acctuelCaseLabel,caseNumber);
		//if(acctuelCaseLabel==caseNumber){
		//	System.out.println("Case Number Match");
		////}else{
		//	System.out.println("Case Number Didnt Match.Case number found :"+acctuelCaseLabel+" insted of :"+caseNumber);
		//}
	}

}

package testCase;

//import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.LogStatus;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.CreateIndividualProviderAccount;
import pageObject.NavigateToOtherPage;
import utilities.AllMethod;
import utilities.ScreenShot;
import utilities.StartUp;

public class TestCaseForCreateIndiviualProviderAc extends StartUp{

	
	@Test(priority = 0)
	public void validLoginForNewAcCreate() throws InterruptedException {
		
		 NavigateToOtherPage pageNavi=new NavigateToOtherPage(driver);
		extent.startTest("TC03.1 Individual Provider New Account Create Verify", "Valid Login");
		AllMethod.validLogin();
			
		pageNavi.navigateToAccountCreatePage();
		Thread.sleep(3000);
		extent.log(LogStatus.PASS, "Open Individual Provider New Account Create Page",
				"View details below:",
				ScreenShot.captureScreen(driver, "Open New Account Create window"));
		extent.endTest();

	}
	
	@Test(priority = 1)
	public void blankSubmit() throws InterruptedException{
		CreateIndividualProviderAccount indiPro=new CreateIndividualProviderAccount(driver);
		extent.startTest("TC03.2", "Blank Submission.Looking Appropriate Error Message ");
		indiPro.clickSaveButton();
		Thread.sleep(2000);
		if(indiPro.errorMsg()){
			extent.log(LogStatus.PASS, "Appropriate Error Message for Blank Submmision",
					"View details below:",
					ScreenShot.captureScreen(driver, "Appropriate Error Message Blank Submission"));
			
		}else{
			extent.log(LogStatus.FAIL, "Appropriate Error Message for Blank Submmision",
					"View details below:",
					ScreenShot.captureScreen(driver, "Appropriate Error Message on Blank Submission"));
		}
				
		extent.endTest();
			}
	@Test(priority = 2)
	public void lastNameVerify() throws Exception{
		CreateIndividualProviderAccount indiPro=new CreateIndividualProviderAccount(driver);
		extent.startTest("TC03.3", "Last Name Verify.Looking Appropriate Error Message ");
		indiPro.enterTxtOnFirstName("MD");
		indiPro.enterTxtOnMiddleName("JAHED");	
		indiPro.clickSaveButton();
		if(indiPro.errorMsg()){
			extent.log(LogStatus.PASS, "Appropriate Error Message for Blank Last Name Submmision",
					"View details below:",
					ScreenShot.captureScreen(driver, "Appropriate Error Message for Last Name Verify"));
			
		}else{
			extent.log(LogStatus.FAIL, "Appropriate Error Message for Blank Last Name Submmision",
					"View details below:",
					ScreenShot.captureScreen(driver, "Appropriate Error Message for Last Name Verify"));
		}
				
		extent.endTest();
		
	}
	
	
	@Test(priority = 3)
	public void EmailVerify() throws Exception{
		CreateIndividualProviderAccount indiPro=new CreateIndividualProviderAccount(driver);
		extent.startTest("TC03.4", "Valid Email Verify.Looking Appropriate Error Message ");
		indiPro.clearTextAllBox();
		indiPro.enterTxtOnFirstName("MD");
		indiPro.enterTxtOnMiddleName("JAHED");
		indiPro.enterTxtOnLastName("Akther");
		indiPro.enterEmail("testyahoo.com");
		indiPro.clickSaveButton();
		if(indiPro.errorMsg()){
			extent.log(LogStatus.PASS, "Appropriate Error Message for invalid Email Submmision",
					"View details below:",
					ScreenShot.captureScreen(driver, "Appropriate Error Message for invalid Email Verify"));
			
		}else{
			extent.log(LogStatus.FAIL, "Appropriate Error Message for invalid Email Submmision",
					"View details below:",
					ScreenShot.captureScreen(driver, "Appropriate Error Message for invalid Email Verify"));
		}
				
		extent.endTest();
		
	}
	
	
}

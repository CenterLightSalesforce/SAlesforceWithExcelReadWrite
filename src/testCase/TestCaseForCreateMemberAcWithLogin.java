package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.CommonObjects;
import pageObject.NavigateToOtherPage;
import pageObject.SignInPage;
import utilities.AllMethod;
import utilities.ScreenShot;
import utilities.StartUp;

public class TestCaseForCreateMemberAcWithLogin extends StartUp{
	
	//SignInPage sign=new SignInPage(driver);
	
	NavigateToOtherPage navi=new NavigateToOtherPage(driver); 
	
	@Test(priority=0)
	public void loginIntoApplication() throws InterruptedException{
		extent.startTest("TC02.1 Member Account Verify", "Create Member Account.Step:Valid LogIn");
		//Thread.sleep(2000);
		//sign.validLogin();
		AllMethod.validLogin();
		//Thread.sleep(2000);
		extent.log(LogStatus.INFO, "Verify Valid Login","View details below:", ScreenShot.captureScreen(driver,"valid Login"));
		extent.endTest();
	}
	
	
	@Test(priority=1)
	public void navigateToAccountPage() throws InterruptedException{
		extent.startTest("TC02.2", "Navigate To Account Home Page");
		driver.findElement(By.xpath(".//*[@id='Account_Tab']/a")).click();
		//Thread.sleep(1000);
		extent.log(LogStatus.INFO, "Verify Navigation Syep 1","View details below:", ScreenShot.captureScreen(driver,"Account Home Page"));
		driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
		//Thread.sleep(1000);
		extent.log(LogStatus.INFO, "Verify Navigation Step 2","View details below:", ScreenShot.captureScreen(driver,"Account Home Page2"));
		driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();
		
		//navi.navigateToAccountCreatePage();
		//Thread.sleep(2000);
		extent.log(LogStatus.INFO, "Verify Navigation Step 3","View details below:", ScreenShot.captureScreen(driver,"Account Home Page3"));
		extent.endTest();
	}
	
	@Test(priority = 2)
	public void enterBlankDataIntoMemberAc() {
		// Verify Blank Data Submit for Member New Account Create
		extent.startTest("TC02.3", "Blank Data Submit(Nagetive Test)");
		extent.log(LogStatus.INFO, "Submit Blank Form", "View details below:",
				ScreenShot.captureScreen(driver, "Blank Form"));
		driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]"))
				.click();
		WebElement errorMsgPopUp = driver.findElement(By
				.xpath(".//*[@id='errorDiv_ep']"));
		// Verify Error Massage
		if (errorMsgPopUp.isDisplayed()) {
			extent.log(LogStatus.PASS, "Error Messege Popup ",
					"View details below:", ScreenShot.captureScreen(driver,
							"Error Msg for Blank Submit"));
		} else {
			extent.log(LogStatus.FAIL, "NO error Messege ",
					"View details below:",
					ScreenShot.captureScreen(driver, "Error on submit(Blank)"));
		}
		extent.endTest();

	}

	@Test(priority = 3)
	public void enterInvalidSsn() throws InterruptedException {
		// Verify SSN Number
		extent.startTest("TC02.4", "Verify Invalid SSN(Negetive Test))");
		AllMethod.enterDataOnTheMembarAcc("Nahida", "akther", "chuni",
				"10/12/1981", "221212014", "3215247548", "Test@yahoo.com");
		//Thread.sleep(1000);
		extent.log(LogStatus.INFO, "Submit Valid Data withinvalid SSN",
				"View details below:");
		driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]"))
				.click();
		// Verify Appropriate Error Massage
		WebElement errorMsgPopUp = driver.findElement(By
				.xpath(".//*[@id='errorDiv_ep']"));

		if (errorMsgPopUp.isDisplayed()) {
			extent.log(LogStatus.PASS, "Error Messege Popup on Invalid SSN ",
					"View details below:", ScreenShot.captureScreen(driver,
							"Error Msg for Invalid SSN Submit"));
		} else {
			extent.log(LogStatus.FAIL, "NO error Messege fron Invalid SSN ",
					"View details below:",
					ScreenShot.captureScreen(driver, "Error on Invalid SSN"));
		}
		extent.endTest();
	}

	@Test(priority = 4)
	public void enterInvalidDate() throws InterruptedException {
		// Verify Invalid Date
		extent.startTest("TC02.5", "Verify Invalid Date(Negetive Test))");
		AllMethod.clearAllDataOnTheMembarAcc();
		AllMethod.enterDataOnTheMembarAcc("Nahida", "akther", "chuni",
				"10122451981", "221-21-2014", "3215247548", "test@yahoo.com");
		extent.log(LogStatus.INFO, "Submit Valid Data with invalid Date",
				"View details below:");
		driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]"))
				.click();
		WebElement errorMsgPopUp = driver
				.findElement(By
						.xpath(".//*[@id='ep']/div[2]/div[5]/table/tbody/tr[2]/td[4]/div"));
		// Verify Appropriate Error Massege
		if (errorMsgPopUp.isDisplayed()) {
			extent.log(LogStatus.PASS, "Error Messege Popup on Invalid Date ",
					"View details below:", ScreenShot.captureScreen(driver,
							"Error Msg for Invalid Date Submit"));
		} else {
			extent.log(LogStatus.FAIL, "NO error Messege fron Invalid Date ",
					"View details below:",
					ScreenShot.captureScreen(driver, "Error on Invalid Date"));
		}
		extent.endTest();
	}

	@Test(priority = 5)
	public void enterInvalidEmail() throws InterruptedException {

		extent.startTest("TC02.6", "Verify Invalid Email(Negetive Test))");
		// Verify Invalid Email
		AllMethod.clearAllDataOnTheMembarAcc();

		AllMethod.enterDataOnTheMembarAcc("Nahida", "akther", "chuni",
				"10/12/1980", "221-21-2014", "3215247548", "testyahoo.com");
		extent.log(LogStatus.INFO, "Submit Valid Data with invalid Email",
				"View details below:");
		driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]"))
				.click();
		WebElement errorMsgPopUp = driver
				.findElement(By
						.xpath(".//*[@id='ep']/div[2]/div[5]/table/tbody/tr[6]/td[4]/div"));
		// Verify Appropriate Error Massege
		if (errorMsgPopUp.isDisplayed()) {
			extent.log(LogStatus.PASS, "Error Messege Popup on Invalid Email ",
					"View details below:", ScreenShot.captureScreen(driver,
							"Error Msg for Invalid Email Submit"));
		} else {
			extent.log(LogStatus.FAIL, "NO error Messege fron Invalid Email ",
					"View details below:",
					ScreenShot.captureScreen(driver, "Error on Invalid Email"));
		}
		extent.endTest();
	}

	@Test(priority = 6)
	public void createAMemberAcWithValidData() throws InterruptedException {

		extent.startTest("TC02.7", "Verify Creating A New Member Account");
		// New Member create
		AllMethod.clearAllDataOnTheMembarAcc();

		AllMethod.enterDataOnTheMembarAcc("Naima", "Akther", "Nabil",
				"10/12/1980", "221-21-2014", "3215247548", "jakther@centerlight.org");
	extent.log(LogStatus.INFO, "Submit Valid Data ", "View details below:");
		driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]"))
				.click();
		WebElement accCreate = driver.findElement(By
				.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2"));
		// Verify Title for Newly Create Member Acoount.
		if (accCreate.isDisplayed()) {
			extent.log(LogStatus.PASS, "Successfully Create A Member Account ",
					"View details below:",
					ScreenShot.captureScreen(driver, "Member Account"));
		} else {
			extent.log(LogStatus.FAIL, "Member Account ",
					"View details below:",
					ScreenShot.captureScreen(driver, "Member Acount"));
		}
		
		AllMethod.logOut();
		extent.log(LogStatus.INFO,"Log Out");
		extent.endTest();
		
		
	}
	
	

}

package testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.NavigateToOtherPage;
import utilities.AllMethod;
import utilities.ScreenShot;
import utilities.StartUp;

public class TestCaseForCreateMemberAc extends StartUp{

	static NavigateToOtherPage pageNavi=new NavigateToOtherPage(driver);

	@Test(priority = 1)
	public void navigateToHomeAccountPage() throws InterruptedException {
		
		AllMethod.validLogin();
		extent.startTest("TC02.1", "Navigate to Accounts Home Page ");
		
		
		Thread.sleep(2000);
		extent.log(LogStatus.INFO,"Log Into Application ");
		pageNavi.navigateToAccountCreatePage();
		
		extent.log(LogStatus.INFO,"NAvigate To New Member Account Create Page","View details below:",
				ScreenShot.captureScreen(driver, "New Member Account Create Page"));
		// Navigate Account Home Page

		//AllMethod.clickButton("xpath", ".//*[@id='Account_Tab']/a",
			//	"click");
		driver.findElement(By.xpath(".//*[@id='Account_Tab']/a")).click();
		Thread.sleep(2000);
		extent.log(LogStatus.INFO,"NAvigate To New Member Account Create Page","View details below:",
				ScreenShot.captureScreen(driver, "Account PAge"));
		//String labelTxt = driver.findElement(
			//By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1"))
		//.getText();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Verify Page Tilte
		/*if (labelTxt.matches("Accounts")) {
			extent.log(LogStatus.PASS,
					"Successfully Naviget Account Home page",
					"View details below:",
					ScreenShot.captureScreen(driver, "Account Home Page"));
		} else {
			extent.log(LogStatus.FAIL, "Error to Navigate Account Home Page",
					"View details below:",
					ScreenShot.captureScreen(driver, "Navigation Error"));
		}
*/
		extent.endTest();

	}

	@Test(priority = 2)
	public void navigateToSelectAcTypePage() throws InterruptedException {
		extent.startTest("TC02.3",
				"Navigate to Select Account Record Type Page ");

		// Navigate select Record type Page
		//AllMethod.clickButton("xpath",
			//	".//*[@id='hotlist']/table/tbody/tr/td[2]/input", "click");
		
		driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
		Thread.sleep(2000);
		extent.log(LogStatus.PASS,
					"Successfully Navigate Select Accoutn record Type page",
					"View details below:", ScreenShot.captureScreen(driver,
							"Account Record Type Page"));
		/*driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String labelSelectAcTyePage = driver.findElement(
				By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td/h2"))
				.getText();
		// Verify Page Title
		System.out.println("selet page txt:" + labelSelectAcTyePage);
		if (labelSelectAcTyePage.matches("Select Account Record Type")) {
			extent.log(LogStatus.PASS,
					"Successfully Navigate Select Accoutn record Type page",
					"View details below:", ScreenShot.captureScreen(driver,
							"Account Record Type Page"));
		} else {
			extent.log(
					LogStatus.FAIL,
					"Error to Navigate Account Home Page",
					"View details below:",
					ScreenShot
							.captureScreen(driver,
									"Navigation Error on At Select Account Record Type Page"));
		}*/
		extent.endTest();
	}

	@Test(priority = 3)
	public void selectTextFromListBox() throws InterruptedException {
		String listData = "Member";

		extent.startTest("TC02.4", "Open New Account Create form for Member ");
		// Select Member From List
		AllMethod.selectTextFromComboByVisibleText("xpath",
				".//*[@id='p3']", listData);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		extent.log(LogStatus.INFO, "Select Member From List",
				"View details below:");
		driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		// Verify Appropriate Data Selected or Not
		String combo = driver
				.findElement(
						By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[1]/td[4]"))
				.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (combo.matches(listData)) {
			extent.log(LogStatus.PASS, "Open New Member Account Create form",
					"View details below:",
					ScreenShot.captureScreen(driver, "New Member Create form"));
		} else {
			extent.log(LogStatus.FAIL,
					"Error to Open New member Create  form ",
					"View details below:", ScreenShot.captureScreen(driver,
							"Error on New Member Create form"));
		}

		extent.endTest();

	}

	@Test(priority = 2)
	public void enterBlankDataIntoMemberAc() {
		// Verify Blank Data Submit for Member New Account Create
		extent.startTest("TC02.5", "Blank Data Submit(Nagetive Test)");
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
		extent.startTest("TC02.6", "Verify Invalid SSN(Negetive Test))");
		AllMethod.enterDataOnTheMembarAcc("Nahida", "akther", "chuni",
				"10/12/1981", "221212014", "3215247548", "Test@yahoo.com");
		Thread.sleep(1000);
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
		extent.startTest("TC02.7", "Verify Invalid Date(Negetive Test))");
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

		extent.startTest("TC02.8", "Verify Invalid Email(Negetive Test))");
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

		extent.startTest("TC02.9", "Verify Creating A New Member Account");
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

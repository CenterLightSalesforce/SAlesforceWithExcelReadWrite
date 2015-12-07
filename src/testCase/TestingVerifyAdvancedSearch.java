package testCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.CommonObjects;
import pageObject.CreateNewCasePage;
import pageObject.SignInPage;

public class TestingVerifyAdvancedSearch {
	WebDriver driver = null;
	static String caseNumber = "00001288";

	@BeforeTest
	public void tearup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void openApplication() {
		driver.get("https://test.salesforce.com/");

	}

	@Test(priority = 1)
	public void logIN() {
		SignInPage sign = new SignInPage(driver);
		sign.validLogin();
	}

	@Test(priority = 2)
	public void searchingCase() {
		CommonObjects common = new CommonObjects(driver);
		common.insertTxtOnSearchTxtBoxAndClickGoButton(caseNumber);
	}

	@Test(priority = 3)
	public void verifyOpenCase() {
		CreateNewCasePage caseLabel = new CreateNewCasePage(driver);
		String acctuelCaseLabel = caseLabel.getNewAccountLabel();
		Assert.assertEquals(acctuelCaseLabel, caseNumber);
	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

}

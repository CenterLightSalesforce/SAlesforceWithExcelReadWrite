package testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseForCreateNewContact {
	
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
	public void openApp() {
		driver.get("https://test.salesforce.com/");

	}
	

}

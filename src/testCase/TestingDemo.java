package testCase;
/*package testCase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObject.CommonObjects;
import pageObject.SignInPage;

public class testingDemo {
	WebDriver driver = new FirefoxDriver();;
	SignInPage sign = new SignInPage(driver);
	CommonObjects common = new CommonObjects(driver);
	private ExtentReports extentReport = null;
	private ExtentTest extentTest = null;
	private String localFilePath = "/Users/Mujab/Documents/workspace/MavenTest/screenshot/";

	public String captureScreenShot(WebDriver driver, String screenShotName) {

		try {

			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			String dest = localFilePath + screenShotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot Taken");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot "
					+ e.getMessage());
			return e.getMessage();

		}

	}

	private ExtentReports getInstance() {
		extentReport = new ExtentReports("Extent_Reports/textExtent.html", true);
		extentReport.config().documentTitle("Automation Report")
				.reportName("Regression Result")
				.reportHeadline("Report for build #101");
		return extentReport;
	}
	
	
	@BeforeSuite
	public void beforeSuite(){
		getInstance();
	}
	
	@BeforeTest
	public void starup() {

		driver.get("https://test.salesforce.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void inValidLogIn() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (sign.verifySignIn() == true) {
			System.out.println("Pass");
		} else {
			System.out.println("Test Case Fail");
		}
	}

	@Test(priority = 2)
	public void validLogIn() {
		sign.validLogin();

	}

	@Test(priority = 3)
	public void advancedSearch() throws InterruptedException {
		common.insertTxtOnSearchTxtBoxAndClickGoButton("akther nabil");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th/a")).click();

	}

	@Test(priority = 4)
	public void verifyProsMemInqCase() {
		WebElement vrf = common
				.getElement(By.xpath(".//*[@id='001L000000o0tea_RelatedCaseList_body']/table/tbody/tr[2]/td[7]"));

		System.out.println("Toatl Elements :" + vrf.getSize());
		
		 * if(vrf.isDisplayed()&&vrf.isEnabled()){
		 * if(common.getText(vrf).toString()=="Prospective Member Inquiry"){
		 * System.out.println("Pass"); }else{ System.out.println("Fail"); }
		 * }else{ System.out.println("No OPen pros Mem Inq Case"); }
		 
	}

}
*/
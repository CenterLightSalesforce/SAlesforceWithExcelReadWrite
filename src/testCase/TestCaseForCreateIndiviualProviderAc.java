package testCase;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import pageObject.NavigateToOtherPage;
import utilities.AllMethod;
import utilities.StartUp;

public class TestCaseForCreateIndiviualProviderAc extends StartUp{
	NavigateToOtherPage pageNavi=new NavigateToOtherPage(driver);
	
	@Test(priority = 1)
	public void validLoginForNewAcCreate() throws InterruptedException {

		extent.startTest("TC03.1", "Valid Login");
		AllMethod.validLogin();
		pageNavi.navigateToAccountCreatePage();
		extent.endTest();

	}
	
	
}

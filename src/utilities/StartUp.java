package utilities;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.GridType;
import com.relevantcodes.extentreports.LogStatus;

import pageObject.CreateIndividualProviderAccount;
import pageObject.NavigateToOtherPage;

public class StartUp {
	public static WebDriver driver = null;
	public static final String url = "https://test.salesforce.com/";
	public static final ExtentReports extent = ExtentReports.get(StartUp.class);
	public static final String reportLocation = "C:\\Users\\jakther\\Desktop\\jahed\\javawork\\Report\\";
	public static String imageLocation = "images/";
	public static final String validID = "Jakther@centerlight.org.qual";
	public static final String validPassword = "06082003Tuba";
	
    //public static String timeStamp=new SimpleDateFormat("mmddyyyy").format(Calendar.getInstance().getTime());
	
	
	@BeforeSuite
	public void openBrowser() throws InterruptedException {
	/*
	 * WebDriver driver = null;
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jakther\\Desktop\\jahed\\java\\chromedriver\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
       /// driver=new InternetExplorerDriver(); 
		  System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
	        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
	        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        WebDriver driver = new InternetExplorerDriver(ieCapabilities);
		*/
		//System.setProperty("webdriver.ie.driver", "c://IEDriverServer.exe");
        //driver=new InternetExplorerDriver(); 
	
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jakther\\Desktop\\jahed\\java\\chromedriver\\chromedriver.exe");
		extent.init(reportLocation + "Salesforce.html", true,
				DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);
		extent.config().documentTitle("Salesforce Test report");
		extent.config()
				.reportTitle(
						"<h1><font color='#000099'>Salesforce Automation Test Result</font></h1> <h4>1.Verify LogIn Screen(Positive,Negetive)</h4><h4>\n2.Member Account(Positive,Negetive).</h4><h4>\n2.Individual Provider Account(Positive,Negetive).</h4>");
		extent.config()
				.reportHeadline(
						"<b>Salesforce Selenium Automation Test Report.Develop By:JAHED AKTHER</b>");
		extent.startTest("TC01.1", "Open The Browser");
		//  driver = new ChromeDriver();  
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
		
		driver.manage().window().maximize();
		extent.log(LogStatus.PASS, "Open Salesforce Application",
				"View details below:",
				ScreenShot.captureScreen(driver, "Open Aplication"));
		extent.endTest();
		
	}

	@AfterSuite
	public void tearDown() {
		// driver.close();

		driver.get("C:\\Users\\jakther\\Desktop\\jahed\\javawork\\Report\\salesforce.html");
		driver.manage().window().maximize();
	}

}

package testCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObject.ContactsPage;
import pageObject.SignInPage;


public class TestCaseForCreateNewContact {

	static WebDriver driver = null;
    //static String errorMsg="Error: Invalid Data.Review all error messages below to correct your data.";

	@BeforeTest
	public void tearup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void openApplication() {
		SignInPage sign = new SignInPage(driver);
		driver.get("https://test.salesforce.com/");
		sign.validLogin();
	}

	@Test(priority = 1)
	public void navigateToContactsPage()  {

	 ContactsPage contact = new ContactsPage(driver);
		driver.findElement(By.xpath(".//*[@id='Contact_Tab']/a")).click();
		contact.clickToNewButton();
		WebElement combo = driver.findElement(By.id("p3"));
		Select mySelect = new Select(combo);
		mySelect.selectByVisibleText("Member Contact");
		contact.clickToContinueButton();
		}
	
	@Test(priority = 2)
	public void  verifyErrorMsgOnBlankSubmit() throws InterruptedException{
		ContactsPage contact = new ContactsPage(driver);
		contact.clickSaveButton();
		WebElement error = driver.findElement(By.xpath(".//*[@id='errorDiv_ep']"));
		String errorMsg=error.getText();
		
		
		//Assert.assertEquals(contact.getErrorTxt(),errorMsg);
		Assert.assertEquals(contact.getErrorTxt(), errorMsg, "Didnt Match");
		Thread.sleep(2000);

	}
		
	@Test(priority=3)
	public void createANewContact() throws InterruptedException, AWTException{
		ContactsPage contact = new ContactsPage(driver);
		String mainwindow=driver.getWindowHandle();
		Set <String> handles=driver.getWindowHandles(); 
		
		contact.clickToAccountNameLookUp();
		
		for(String popup :handles) //iterating on child windows
	    {
			Thread.sleep(2000);
	    
	    //System.out.println("Popup values: "+popup);
	    // Perform any operations on child window
	    if(!popup.equals(mainwindow)){}
	         driver.switchTo().window(popup);	
			
			
			WebElement lookUpframe=driver.findElement(By.id("resultsFrame"));
		driver.switchTo().frame(lookUpframe);
	    driver.findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th/a")).click();
	    }
		driver.switchTo().window(mainwindow);
		
		
		/*String txt;
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		driver.manage().window().maximize();
		Robot rr =new Robot();
		for(int i=1;i<25;i++){
		rr.keyPress(KeyEvent.VK_TAB);
		rr.keyRelease(KeyEvent.VK_TAB);
		rr.delay(500);
		txt=driver.switchTo().activeElement().getText();
		if(txt=="Sharmeen ahmed"){
			driver.switchTo().activeElement().click();
			break;
		       }		    
				
		}
			
		
		
		contact.enterContact("Shiam", "huss","2153214214");
		contact.clickSaveButton();*/
	}

}

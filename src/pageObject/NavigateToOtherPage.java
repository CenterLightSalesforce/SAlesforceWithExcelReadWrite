package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.AllMethod;


public class NavigateToOtherPage {
	private WebDriver driver;
	private By accountTab = By.xpath(".//*[@id='Account_Tab']/a");
	private By newAccountButton = By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input");
	private By continueButtonForNewAcc = By.xpath(".//*[@id='bottomButtonRow']/input[1]");
	private By comboBox=By.xpath(".//*[@id='p3']");
	
	
	public NavigateToOtherPage(WebDriver driver) {
		this.driver=driver;
	}
			
	public By getAccountTab(){
		return accountTab;
	}
		
	public By getNewAccountButtin(){
		return newAccountButton;
	}
	
	public By getContinueButtonForNewAcc(){
		return continueButtonForNewAcc;
	}
	
	public  void navigateToAccountCreatePage() throws InterruptedException{
		
		driver.findElement(getAccountTab()).click();
		//driver.findElement(By.xpath(".//*[@id='Account_Tab']/a")).click();
		driver.findElement(getNewAccountButtin()).click();
		//Thread.sleep(2000);
		AllMethod.selectTextFromComboByVisibleTextUseBy(comboBox, "Individual Provider");
		//AllMethod.selectTextFromComboByVisibleText("xpath",".//*[@id='p3']",visibleTxt);
		//Thread.sleep(2000);
		driver.findElement(getContinueButtonForNewAcc()).click();
		
		
	}

}

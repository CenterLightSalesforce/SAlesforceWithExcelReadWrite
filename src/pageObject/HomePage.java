package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.AllMethod;

public class HomePage {
	public static WebDriver driver;
	private By homePageUserNameLabel = By.xpath(".//*[@id='ptBody']/div/div[2]/span[1]/h1");
	private By comboList = By.id("tasklist_mode");
	private By newButton = By.xpath(".//*[@id='actionForm']/div[1]/table/tbody/tr/td[2]/input");
	private By scheduledTab = By.id("homeCalRegEventTab");
	private By requestMeetingTab = By.id("homeCalProposedEventTab");
	private By newEventButton = By.xpath(".//*[@id='homeCalendarSection']/div/div[1]/table/tbody/tr/td[2]/input[1]");
	private By newMeetingReqButton = By
			.xpath(".//*[@id='homeCalendarSection']/div/div[1]/table/tbody/tr/td[2]/input[2]");
	
	private static By myTask=By.id("actionForm");

	// This is A Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// For Home Tab
	public String getUserName() {
		String getName = driver.findElement(homePageUserNameLabel).getText();
		return getName;
	}
	
	
	public static WebElement getMyTask() {
		WebElement getMyTask = driver.findElement(myTask);
		return getMyTask;
	}

	// For Click On New Button
	public void clickNewbutton() {
		driver.findElement(newButton).click();
	}

	// For Click On New Event Button
	public void clickOnNewEvent() {
		driver.findElement(newEventButton).click();

	}

	// For Click On New Meeting Request Button
	public void clickNewMeetingReqButton() {
		driver.findElement(newMeetingReqButton).click();

	}

	// For Click On scheduled Meeting Tab
	public void clickScheduledTab() {
		driver.findElement(scheduledTab).click();

	}// For Click On Request Meeting Tab

	public void clickOnRequestMeetingTab() {
		driver.findElement(requestMeetingTab).click();

	}
	
	//For Select Data From ComboList
	public void clickAndSelectFromCombo(String comboData){
		
		driver.findElement(comboList).click();
		AllMethod.selectTextFromComboByVisibleText("id","tasklist_mode",comboData);
		
	}
}

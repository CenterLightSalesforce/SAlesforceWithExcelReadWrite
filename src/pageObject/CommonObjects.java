package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonObjects {
	private static WebDriver driver;
	private By homeTab = By.id("home_Tab");
	private By accountsTab = By.id("Account_Tab");
	private By caseTab = By.id("Case_Tab");
	private By reportTab = By.id("report_Tab");
	
	private By contactTab = By.xpath(".//*[@id='Contact_Tab']/a");
	private static By contractTab = By.id("Contract_Tab");
	private By plusTab = By.id("AllTab_Tab");
	private By setUpLink = By.id("setupLink");
	private By userNaviArrow = By.id("userNavButton");
	private By helpLink = By.xpath(".//*[@id='phHeader']/tbody/tr/td[2]/div/div[2]/div/a[2]");
	private By frameOnSearch = By.id("066F0000002PWsj");
	private By searchTxtBox = By.id("searchTerms");
	private By goButton = By.xpath(".//*[@id='body']/button");
	private By logOutLink = By.xpath(".//*[@id='userNav-menuItems']/a[3]");

	// for Web Driver
	public CommonObjects(WebDriver driver) {
		this.driver = driver;
	}

	// For Switch Frame
	public void switchToFrame() {
		WebElement frameLocator = driver.findElement(frameOnSearch);
		driver.switchTo().frame(frameLocator);
	}

	// For Home Tab
	public By getHomeTab() {
		return homeTab;
	}

	public void clickHomeTab() {
		driver.findElement(homeTab).click();
	}

	// For Accounts TAb
	public By getAccountsTab() {
		return accountsTab;
	}

	public void clickAccountsTab() {
		driver.findElement(accountsTab).click();
	}

	// For Case Tab
	public By getCaseTab() {
		return caseTab;
	}

	public void clickCaseTab() {
		driver.findElement(caseTab).click();
	}

	// For Report Tab
	public By getReportTab() {
		return reportTab;
	}

	public void clickReportTab() {
		driver.findElement(reportTab).click();
	}
	
	
	// For Contact Tab
		public By getContactTab() {
			return contactTab;
		}

		public void clickContactTab() {
			driver.findElement(contactTab).click();
		}
	
	

	// For Contract Tab
	public By getContractTab() {
		return contractTab;
	}

	static public void clickContractTab() {
		driver.findElement(contractTab).click();
	}

	// For Plus Tab
	public By getPlusTab() {
		return plusTab;
	}

	public void clickPlusTab() {
		driver.findElement(plusTab).click();
	}

	// For Setup Link
	public By getSetUpLink() {
		return setUpLink;
	}

	public void clickSetupLink() {
		driver.findElement(setUpLink).click();
	}

	// For Help Link
	public By getHelpLink() {
		return helpLink;
	}

	public void clickHelpTab() {
		driver.findElement(helpLink).click();
	}

	// For Insert Text on Search TextBox and Click Go button
	public void insertTxtOnSearchTxtBoxAndClickGoButton(String txtValue) {
		switchToFrame();
		driver.findElement(searchTxtBox).sendKeys(txtValue);
		clickOnGoButton();
	}

	// For Click Go Button
	public void clickOnGoButton() {
		// switchToFrame();
		driver.findElement(goButton).click();
	}

	// For Get Text From Element
	public String getText(By bytxt) {
		String getTextFrmEle = driver.findElement(bytxt).getText();
		return getTextFrmEle;
	}

	// For Get Text From Element
	public String getText(WebElement bytxt) {
		String getTextFrmEle = bytxt.getText();
		return getTextFrmEle;
	}

	// For Click User Navigation Menu
	public void userNaviButton() {

		driver.findElement(userNaviArrow).click();
	}

	// For Click User Navigation Menu
	public void logOutLinkClick() {

		driver.findElement(logOutLink).click();
	}

	public void logOut() {
		userNaviButton();
		logOutLinkClick();
	}

	public WebElement getElement(By atr) {
		WebElement getEle = driver.findElement(atr);
		return getEle;
	}
}

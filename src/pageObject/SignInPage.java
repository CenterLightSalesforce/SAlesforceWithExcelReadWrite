package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	private WebDriver driver;

	private By headerPageImage = By.xpath(".//*[@id='logo']");
	private By createAccountLink = By.id("link-signup");
	private By userId = By.id("username");
	private By passwordTextBox = By.id("password");
	private By loginBtn = By.id("Login");
	private By errorMsgTxt = By.id("error");
	private String userName = "jakther@centerlight.org.qual";
	private String password = "06082003Tuba";

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifySignInPageTitle() {
		String expectedTitle = "Login | Salesforce";
		return getSignInPageTitle().contains(expectedTitle);
	}

	public boolean verifySignInPageText() {
		WebElement element = driver.findElement(headerPageImage);
		String pageImage = element.getText();
		String expectedPageImage = "Sign in with your Google Account";
		return pageImage.contains(expectedPageImage);
	}

	public CreateMemberAccountPage clickonCreateAnAccount() {
		WebElement element = driver.findElement(createAccountLink);
		if (element.isDisplayed() || element.isEnabled())
			element.click();
		return new CreateMemberAccountPage(driver);
	}

	public boolean verifySignIn() {
		enterUserName("test");
		enterPassword("pass");
		clickOnSignIn();
		return getErrorMessage().contains(
				"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}

	public void enterUserName(String userName) {
		WebElement userNameTextBox = driver.findElement(userId);
		if (userNameTextBox.isDisplayed()) {
			userNameTextBox.sendKeys(userName);
		}

	}

	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordTextBox);
		if (passwordTxtBox.isDisplayed()) {
			passwordTxtBox.sendKeys(password);
		}
	}

	public void clickOnSignIn() {
		WebElement signInBtn = driver.findElement(loginBtn);
		if (signInBtn.isDisplayed())
			signInBtn.click();
	}

	public String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(errorMsgTxt);
		if (errorMsg.isDisplayed() && errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	}

	public void validLogin() {
		driver.findElement(userId).sendKeys(userName);
		driver.findElement(passwordTextBox).sendKeys(password);
		driver.findElement(loginBtn).click();
	}

}

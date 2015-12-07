package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.LogStatus;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AllMethod extends StartUp {

	// method for fluentwait
	// Parametar Value timeout and Polling time integer type data

	public static void fluenWait() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
	}
	
	public static void logOut() throws InterruptedException{
	
	// Expanding Menu for Logout
	driver.findElement(By.xpath(".//*[@id='userNavLabel']")).click();
	// Click Logout Link
	driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"))
		.click();
		
	}
	
	public static void validLogin() throws InterruptedException  {

		useSendkeys("id", "username",validID);

		useSendkeys("id", "password",
				validPassword);
		Thread.sleep(2000);
		clickButton("id", "Login","click");
		Thread.sleep(2000);
	}
	

	// Method for Enter Data into WebEditbox
	// Parametar Value locator ,attribute and value String type data
	public static void useSendkeys(String locator, String attribute, String value) {

		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attribute)).sendKeys(value);
		} else if (locator.equalsIgnoreCase("className")) {
			driver.findElement(By.className(attribute)).sendKeys(value);
		} else if (locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(attribute)).sendKeys(value);
		} else if (locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attribute)).sendKeys(value);
		} else if (locator.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(attribute)).sendKeys(value);
		} else
			throw new NoSuchElementException("No Such Element : " + attribute);
	}

	// Method for Click or Submit
	public static void clickButton(String locator, String attribute, String action) {
		String locatorlowerCase = locator.toLowerCase();
		String actionLowerCase = action.toLowerCase();
		if (locatorlowerCase == "xpath" && actionLowerCase == "click") {
			driver.findElement(By.xpath(attribute)).click();
		} else if (locatorlowerCase == "xpath" && actionLowerCase == "submit") {
			driver.findElement(By.xpath(attribute)).submit();
		} else if (locatorlowerCase == "id" && actionLowerCase == "click") {
			driver.findElement(By.id(attribute)).click();
		} else if (locatorlowerCase == "id" && actionLowerCase == "submit") {
			driver.findElement(By.id(attribute)).submit();
		} else if (locatorlowerCase == "css" && actionLowerCase == "click") {
			driver.findElement(By.cssSelector(attribute)).click();
		} else if (locatorlowerCase == "css" && actionLowerCase == "submit") {
			driver.findElement(By.cssSelector(attribute)).submit();
		} else if (locatorlowerCase == "tagname" && actionLowerCase == "click") {
			driver.findElement(By.tagName(attribute)).click();
		} else if (locatorlowerCase == "tagname" && actionLowerCase == "submit") {
			driver.findElement(By.tagName(attribute)).submit();
		} else if (locatorlowerCase == "name" && actionLowerCase == "click") {
			driver.findElement(By.name(attribute)).click();
		} else if (locatorlowerCase == "name" && actionLowerCase == "submit") {
			driver.findElement(By.name(attribute)).submit();
		} else
			throw new NoSuchElementException("No Such Element : " + attribute);
	}

	// Method for get text from object
	// Return String value
	public static String getStringForObject(String locator, String attribute) {
		String locatorlowerCase = locator.toLowerCase();
		String objectString = null;
		if (locatorlowerCase == "xpath") {
			objectString = driver.findElement(By.xpath(attribute)).getText();
			return objectString;
		} else if (locatorlowerCase == "id") {
			objectString = driver.findElement(By.id(attribute)).getText();
			return objectString;
		} else if (locatorlowerCase == "css") {
			objectString = driver.findElement(By.cssSelector(attribute)).getText();
			return objectString;
		} else if (locatorlowerCase == "tagname") {
			objectString = driver.findElement(By.tagName(attribute)).getText();
			return objectString;
		} else if (locatorlowerCase == "name") {
			objectString = driver.findElement(By.name(attribute)).getText();
			return objectString;
		} else
			throw new NoSuchElementException("No Such Element : " + attribute);
	}

	// Method for Compare Two String
	public static void dataVerify(String actuelData, String expectedData, String errorMsg) {

		try {
			Assert.assertEquals(actuelData, expectedData, errorMsg);
			Reporter.log("Suceesfully log into " + actuelData + " Account");
		} catch (AssertionError a) {
			Reporter.log(a.getMessage());
		}
	}

	// Method for Checkbox
	public static boolean checkElementSelected(String locator, String attribute) {
		WebElement chqBox;
		if (locator.equalsIgnoreCase("id")) {
			chqBox = driver.findElement(By.id(attribute));
			return chqBox.isSelected();
		} else if (locator.equalsIgnoreCase("className")) {
			chqBox = driver.findElement(By.className(attribute));
			return chqBox.isSelected();
		} else if (locator.equalsIgnoreCase("name")) {
			chqBox = driver.findElement(By.name(attribute));
			return chqBox.isSelected();
		} else if (locator.equalsIgnoreCase("xpath")) {
			chqBox = driver.findElement(By.xpath(attribute));
			return chqBox.isSelected();
		} else if (locator.equalsIgnoreCase("css")) {
			chqBox = driver.findElement(By.cssSelector(attribute));
			return chqBox.isSelected();
		} else
			throw new NoSuchElementException("No Such Element : " + attribute);

	}

	// Method for Enter Data in Member Account.
	public static void enterDataOnTheMembarAcc(String mId, String fName, String lName, String dOB, String sSn,
			String pHone, String email) {

		useSendkeys("xpath", ".//*[@id='00NF000000D2YFo']", mId);
		// For First Name
		useSendkeys("xpath", ".//*[@id='00NF000000ColTt']", fName);
		// For Last Name
		useSendkeys("xpath", ".//*[@id='00NF000000ColTx']", lName);
		// For Phone Number
		useSendkeys("xpath", ".//*[@id='00NF000000ColTm']", dOB);
		// For Email address
		useSendkeys("xpath", ".//*[@id='00NF000000ColUL']", sSn);
		// For Enrollment date
		useSendkeys("xpath", ".//*[@id='00NF000000D2YFg']", pHone);
		// For Email
		useSendkeys("xpath", ".//*[@id='00NF000000ColTs']", email);

	}

	// Method For Clear All Data on New Member Account Form
	public static void clearAllDataOnTheMembarAcc() {

		clearDataOnTheField("xpath", ".//*[@id='00NF000000D2YFo']");
		// For First Name
		clearDataOnTheField("xpath", ".//*[@id='00NF000000ColTt']");
		// For Last Name
		clearDataOnTheField("xpath", ".//*[@id='00NF000000ColTx']");
		// For Phone Number
		clearDataOnTheField("xpath", ".//*[@id='00NF000000ColTm']");
		// For Email address
		clearDataOnTheField("xpath", ".//*[@id='00NF000000ColUL']");
		// For Enrollment date
		clearDataOnTheField("xpath", ".//*[@id='00NF000000D2YFg']");
		// For Email
		clearDataOnTheField("xpath", ".//*[@id='00NF000000ColTs']");

	}

	// Method for Clear Data from a Textbox
	public static void clearDataOnTheField(String locator, String attribute) {

		if (locator.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attribute)).clear();
		} else if (locator.equalsIgnoreCase("className")) {
			driver.findElement(By.className(attribute)).clear();
		} else if (locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(attribute)).clear();
		} else if (locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attribute)).clear();
		} else if (locator.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(attribute)).clear();
		} else
			throw new NoSuchElementException("No Such Element : " + attribute);
	}

	// Select A Data From ComboList
	public static void selectTextFromComboByVisibleText(String locator, String atLocator, String value) {

		if (locator.equalsIgnoreCase("id")) {
			WebElement mySelectElm = driver.findElement(By.id(atLocator));
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByVisibleText(value);

		} else if (locator.equalsIgnoreCase("className")) {
			WebElement mySelectElm = driver.findElement(By.className(atLocator));
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByVisibleText(value);
		} else if (locator.equalsIgnoreCase("name")) {

			WebElement mySelectElm = driver.findElement(By.name(atLocator));
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByVisibleText(value);

		} else if (locator.equalsIgnoreCase("xpath")) {

			WebElement mySelectElm = driver.findElement(By.xpath(atLocator));
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByVisibleText(value);

		} else if (locator.equalsIgnoreCase("css")) {

			WebElement mySelectElm = driver.findElement(By.cssSelector(atLocator));
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByVisibleText(value);

		} else
			throw new NoSuchElementException("No Such Element : " + atLocator);
	}

	// Select A Data From ComboList
	public static void selectTextFromComboByVisibleTextUseBy(By byValue, String value) {
		try {
			WebElement mySelectElm = driver.findElement(byValue);
			Select mySelect = new Select(mySelectElm);
			mySelect.selectByVisibleText(value);
		} catch (IllegalArgumentException n) {
			Reporter.log("Element Not Found");
		}
	}

	// For ShowStopper MEthod

	public static void showStopper(String result, String msgShow) {

		if (result.equalsIgnoreCase("yes")) {
			driver.get(url);
		} else {
			Reporter.log(msgShow);
		}
	}

	// For Verify element
	public static boolean verifyElementText(By attibute, String expectedString, String trueMsg, String falseMsg) {
		String actuelTest = driver.findElement(attibute).getText();
		boolean result = expectedString.matches(actuelTest);

		try {

			if (result == true) {
				Reporter.log(trueMsg);
				return true;
			} else {
				Reporter.log(falseMsg);
				return false;
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Element Not Found");
			return false;
		}
	}

	// For Verify Title
	public static void verifyTitle(String exceptedTitle, String trueMsg, String falseMsg) {
		String actuelTitle = driver.getTitle();
		try {

			if (actuelTitle == exceptedTitle) {
				Reporter.log(trueMsg);
			} else {
				Reporter.log(falseMsg);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Element not Found");
		}
	}

}

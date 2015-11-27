package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.AllMethod;

public class AccountPage {
	public WebDriver driver;
	private By accountHomeLabel = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2");
	private By comboListViewAccountRecently = By.xpath(".//*[@id='hotlist_mode']");
	private By comboListViewAccount = By.id("fcf");
	private By editLink = By.linkText("Edit");
	private By createNewView = By.linkText("Create New View");
	private By goButton = By.xpath(".//*[@id='filter_element']/div/span/span[1]/input");
    public CommonObjects common=new CommonObjects(driver);
	// For Select Data From Recently ComboList
	public void clickAndSelectFromComboRecently(String comboData) {
		driver.findElement(comboListViewAccountRecently).click();
		AllMethod.selectTextFromComboByVisibleText("xpath", ".//*[@id='hotlist_mode']", comboData);
	}

	// For Select Data From Recently ComboList
	public void clickAndSelectFromComboViewAcount(String comboData) {
		driver.findElement(comboListViewAccount).click();
		AllMethod.selectTextFromComboByVisibleText("id", "fcf", comboData);
		driver.findElement(goButton).click();
	}

	// For Geting Page Label Text
	public String getPageName() {
		String getName = driver.findElement(accountHomeLabel).getText();
		return getName;
	}

	// For Click Edit Link
	public void clickEditLink() {
		driver.findElement(editLink).click();
	}

	// For Click Create New View Link
	public void clicCreateNewViewLink() {
		driver.findElement(createNewView).click();
	}

}

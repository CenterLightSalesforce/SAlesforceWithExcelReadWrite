package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.AllMethod;

public class SelectAccountTypePage {
	public WebDriver driver;
	private By selectAccRecTypLabel = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2");
	
	private By recordTypeComboList = By.id("p3");
	private By continueButton = By.xpath(".//*[@id='bottomButtonRow']/input[1]");
	private By cancelButton = By.xpath(".//*[@id='bottomButtonRow']/input[2]");
	

	public SelectAccountTypePage(WebDriver driver){
		this.driver=driver;
	}
	
	
	// For Select Data From Recently ComboList
	public void clickAndSelectFromComboViewAcount(String comboData) {
		driver.findElement(recordTypeComboList).click();
		AllMethod.selectTextFromComboByVisibleText("id", "p3", comboData);
		driver.findElement(continueButton).click();
	}

	// For Geting Page Label Text
	public String getPageName() {
		String getName = driver.findElement(selectAccRecTypLabel).getText();
		return getName;
	}


	// For Click Create New View Link
	public void clicCancelButton() {
		driver.findElement(cancelButton).click();
	}
}

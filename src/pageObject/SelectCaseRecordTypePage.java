package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.AllMethod;

public class SelectCaseRecordTypePage {
	
	public WebDriver driver;
	private By tittleCasesPage = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2");
	private By viewListBox = By.id("p3");
	private By continueButton = By.xpath(".//*[@id='bottomButtonRow']/input[1]");
	private By cancelButton = By.xpath(".//*[@id='bottomButtonRow']/input[2]");

	// This is Constructor
	public SelectCaseRecordTypePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickContinueButton() {
		driver.findElement(continueButton).click();

	}
	
	
	
	public void clickCancelButton() {
		driver.findElement(cancelButton).click();

	}

	public void selectDataFromCombo(String dataForSelect) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(viewListBox, dataForSelect);

	}
}

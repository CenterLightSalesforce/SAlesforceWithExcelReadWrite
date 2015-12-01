package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.AllMethod;

public class CasesPage {
	public WebDriver driver;
	private By tittleCasesPage = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1");
	private By viewListBox = By.id("fcf");
	private By newButton = By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input");
	private By cases = By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div");

	// This is Constructor
	public CasesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickNewButton() {
		driver.findElement(newButton).click();

	}

	public void selectDataFromCombo(String dataForSelect) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(viewListBox, dataForSelect);

	}

}

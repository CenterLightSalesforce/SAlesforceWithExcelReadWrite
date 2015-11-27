package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.AllMethod;

public class SelectAccountRecordTypePage {
	private WebDriver driver;
	private NavigateToOtherPage seleAccRecTy;
	private String atLocatorForCombo=".//*[@id='p3']";
	private By cancelButton =By.xpath(".//*[@id='bottomButtonRow']/input[2]");
	
	
	public void clickContinueButton(){
	seleAccRecTy=new NavigateToOtherPage(driver);
	driver.findElement(seleAccRecTy.getContinueButtonForNewAcc()).click();
	
	}
	public void clickCancelButton(){
		driver.findElement(cancelButton).click();
	}
	
	public void selectDataFromCombo(String comboData){
		AllMethod.selectTextFromComboByVisibleText("xpath",atLocatorForCombo,comboData);
	}
	
	
	
	

}

package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.AllMethod;

public class CreateNewCasePage {

	public WebDriver driver;
	private By newAccountLabel = By.xpath(".//*[@id='bodyCell']/div/div[1]/div[1]/h2");
	private By saveButton = By.xpath(".//*[@id='topButtonRow']/input[1]");
	private By saveAndCloseButton = By.xpath(".//*[@id='topButtonRow']/input[2]");
	private By saveAndNewButton = By.xpath(".//*[@id='topButtonRow']/input[3]");
	private By checkSpelButton = By.xpath(".//*[@id='topButtonRow']/input[4]");
	private By canCelButton = By.xpath(".//*[@id='topButtonRow']/input[5]");
	private By caseOwnerLabel = By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[1]/td[2]");
	private By caseRecordType = By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[1]/td[4]");
	private By contactNameTxtbox = By.id("cas3");
	private By accNameTxtbox = By.id("cas4");
	private By statusListbox = By.id("cas7");
	private By priortyListbox = By.id("cas8");
	private By caseOriginListbox = By.id("cas11");
	private By typeListbox = By.id("cas5");
	private By subTypeListbox = By.id("00NF000000ColXK");
	
	private By subjectTxtbox = By.id("cas14");
	
	private By descriptionTxtbox = By.id("cas15");
	private By internalCommentsTxtbox = By.id("cas16");
	private By assignRulesCheckbox = By.id("cas21");
	
	
	
	
	
	//This is Constructor
	public CreateNewCasePage(WebDriver driver) {
		this.driver = driver;
	}

	// For New Account Label
	public String getNewAccountLabel() {
		String getNewAccLabel = driver.findElement(newAccountLabel).getText();
		return getNewAccLabel;
	}

	// Click Save Button
	public void clickSaveButton() {
		driver.findElement(saveButton).click();
	}
	
	
	// Click Save and Close Button
		public void clickSaveAndCloseButton() {
			driver.findElement(saveAndCloseButton).click();
		}
	

	// Click Save and New Button
	public void clickSaveAndNewButton() {
		driver.findElement(saveAndNewButton).click();
	}

	// Click Check Spelling Button
		public void clickCheckSpellButton() {
			driver.findElement(checkSpelButton).click();
		}
	
	
	
	// Click Cancel Button
	public void clickCancelButton() {
		driver.findElement(canCelButton).click();
	}

	// For Account Name Textbox
	public WebElement getAccName() {
		WebElement accNameTXt = driver.findElement(accNameTxtbox);
		return accNameTXt;
	}

	// For Insert Text on the Member ID Field
	public void enterTxtOnContactName(String memberId) {

		driver.findElement(contactNameTxtbox).sendKeys(memberId);
		if (memberId == null) {
			driver.findElement(contactNameTxtbox).sendKeys("N/A");
		}
	}

	

	// For Insert Text on First Name
	public void enterTxtOnAccountName(String fName) throws Exception {
		driver.findElement(accNameTxtbox ).sendKeys(fName);
		if (fName == null) {
			throw new Exception(fName);
		}
	}
	
	
	
	/*
	 * For Select Status from List By Text
	 * 
	 * @Param String visible Text
	 */
	public void selectStatus(String status) {

		AllMethod.selectTextFromComboByVisibleTextUseBy(statusListbox, status);
	}
	
	
	
	/*
	 * For Select Priorty from List By Text
	 * 
	 * @Param String visible Text
	 */
	public void selectPriortity(String priority) {

		AllMethod.selectTextFromComboByVisibleTextUseBy(priortyListbox, priority);
	}
	
	
	/*
	 * For Select Case Origin from List By Text
	 * 
	 * @Param String visible Text
	 */
	public void selectCaseOrigin(String caseOrigin) {

		AllMethod.selectTextFromComboByVisibleTextUseBy(caseOriginListbox, caseOrigin);
	}	

	/*
	 * For Select Case Type from List By Text
	 * 
	 * @Param String visible Text
	 */
	public void selectType(String caseType) {

		AllMethod.selectTextFromComboByVisibleTextUseBy(typeListbox, caseType);
	}
	
	
	/*
	 * For Select Case Sub Type from List By Text
	 * 
	 * @Param String visible Text
	 */
	public void selectSubType(String caseSubType) {

		AllMethod.selectTextFromComboByVisibleTextUseBy(subTypeListbox, caseSubType);
	}
	
	
	
	
	// For Insert Text on Subject
		public void enterTxtOnSubject(String subject) throws Exception {
			driver.findElement(subjectTxtbox).sendKeys(subject);
			if (subject == null) {
				throw new Exception(subject);
			}
		}

		
		// For Insert Text on Internal Comments
				public void enterTxtOnInternalComments(String InternalComments) throws Exception {
					driver.findElement(internalCommentsTxtbox).sendKeys(InternalComments);
					if (InternalComments == null) {
						throw new Exception(InternalComments);
					}
				}
				// For Check on Assign Using Active Assignment Rules
				public void checkOnAssignRuls() {
					driver.findElement(assignRulesCheckbox).click();
				}
	
}

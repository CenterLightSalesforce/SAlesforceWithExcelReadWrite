package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.AllMethod;

public class CreateMemberAccountPage {

	public WebDriver driver;
	private By newAccountLabel = By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[1]/td[4]");
	private By saveButton = By.xpath(".//*[@id='topButtonRow']/input[1]");
	private By saveAndNewButton = By.xpath(".//*[@id='topButtonRow']/input[2]");
	private By canCelButton = By.xpath(".//*[@id='topButtonRow']/input[3]");
	private By accNameTxtbox = By.id("acc2");
	private By memberIdTxtbox = By.id("00NF000000D2YFo");
	private By doNotCallCheckbox = By.id("00NF000000D2YFl");
	private By disposiotionDateTxtbox = By.id("00NF000000D2YFk");
	private By disposiotionCodeListbox = By.id("00NF000000D2YFj");
	private By zoneListbox = By.id("00NL0000003ea2Z");
	private By currentProduct = By.id("CF00NL0000003eepp");
	private By salesTerritoryListbox = By.id("00NL0000003ea3X");
	private By paceCheckbox = By.id("00NL0000003edqc");
	private By selectCheckbox = By.id("00NL0000003edqh");
	private By directCheckbox = By.id("00NL0000003edqm");
	private By fidaCheckbox = By.id("00NL0000003edrL");
	private By fNameTxtbox = By.id("00NF000000ColTt");
	private By lNameTxtbox = By.id("00NF000000ColTx");
	private By genderListbox = By.id("00NF000000ColTv");
	private By dobTxtbox = By.id("00NF000000ColTm");
	private By ssnTxtbox = By.id("00NF000000ColUL");
	private By contactPre1Txtbox = By.id("00NF000000ColTo_unselected");
	private By contactPre2Txtbox = By.id("0NF000000ColTo_selected");
	private By contactNoPre1Txtbox = By.id("00NF000000ColTr_unselected");
	private By contactNoPre2Txtbox = By.id("00NF000000ColTr_selected");
	private By contactPreSeleArrow = By.id("00NF000000ColTo_right_arrow");
	private By contactPreDeSeleArrow = By.id("00NF000000ColTo_left_arrow");
	private By contactNoPreSeleArrow = By.id("00NF000000ColTr_right_arrow'");
	private By contactNoPreDeSeleArrow = By.id("00NF000000ColTr_left_arrow");
	private By phoneTxtbox = By.id("acc10");
	private By cellPhoneTxtbox = By.id("00NF000000D2YFg");
	private By emailTxtbox = By.id("00NF000000ColTs");
	private By maritalStatusListbox = By.id("00NF000000D2YFn");
	private By citizenStatusListbox = By.id("00NF000000D2YFh");
	private By raceListbox = By.id("00NF000000D2YFq");
	private By countryOfOriginListbox = By.id("00NF000000D2YFi");
	private By religionListbox = By.id("00NF000000D2YFr");
	private By addLine1Txtbox = By.id("00NF000000ColUU");
	private By addLine2Txtbox = By.id("00NF000000ColUV");
	private By cityTxtbox = By.id("00NF000000ColUR");
	private By stateListbox = By.id("00NF000000ColUX");
	private By zipTxtbox = By.id("00NF000000ColUZ");
	private By mAddLine1Txtbox = By.id("00NF000000D2YFt");
	private By mAddLine2Txtbox = By.id("00NF000000D2YFu");
	private By mCityTxtbox = By.id("00NF000000D2YFs");
	private By mStateListbox = By.id("00NF000000D2YFv");
	private By mZipTxtbox = By.id("00NF000000D2YFw");
	private By addNoteTxtbox = By.id("00NF000000D2YFf");
	private By priLanListbox = By.id("00NF000000ColUB");
	private By secLanListbox = By.id("00NF000000ColUK");
	private By terLanListbox = By.id("00NF000000ColUO");
	private By mailLanListbox = By.id("00NF000000D2YFm");
	private By priDiaListbox = By.id("00NF000000ColUA");
	private By secDiaListbox = By.id("00NF000000ColUJ");
	private By terDiaListbox = By.id("00NF000000ColUN");
	private By contactTxtbox = By.id("CF00NF000000ColTp");
	private By parentTxtbox = By.id("acc3");
	
	
	//This is Constructor
	public CreateMemberAccountPage(WebDriver driver) {
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

	// Click Save and New Button
	public void clickSaveAndNewButton() {
		driver.findElement(saveAndNewButton).click();
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
	public void enterTxtOnMemberId(String memberId) {

		driver.findElement(memberIdTxtbox).sendKeys(memberId);
		if (memberId == null) {
			driver.findElement(memberIdTxtbox).sendKeys("N/A");
		}
	}

	/*
	 * For Select Dispostion code from List By Text
	 * 
	 * @Param String visible Text
	 */
	public void selectDisCode(String memberId) {

		AllMethod.selectTextFromComboByVisibleTextUseBy(disposiotionCodeListbox, memberId);
	}

	// For Select Do NOt Call CheckBox
	public void doNotCallCheckBox() {
		driver.findElement(doNotCallCheckbox).click();
	}

	// For Insert Text on First Name
	public void enterTxtOnFirstName(String fName) throws Exception {
		driver.findElement(fNameTxtbox).sendKeys(fName);
		if (fName == null) {
			throw new Exception(fName);
		}
	}

	// For Insert Text on Last Name
	public void enterTxtOnLastName(String lName) throws Exception {
		driver.findElement(lNameTxtbox).sendKeys(lName);
		if (lName == null) {
			throw new Exception(lName);
		}
	}

	/*
	 * For Select Gender from List 
	 * @Param String visible Text
	 */
	public void selectGender(String gender) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(genderListbox, gender);
	}

	// For Enter Dispostion Date
	public void enterDisDate(String dDate) {
		driver.findElement(disposiotionDateTxtbox).sendKeys(dDate);
	}

	// For Enter Date of Birth
	public void enterDOB(String dOB) {
		driver.findElement(dobTxtbox).sendKeys(dOB);
	}

	// For Enter Social Securities Number
	public void enterSSN(String sSN) {
		driver.findElement(ssnTxtbox).sendKeys(sSN);
	}

	// For Choose Contact Preferences
	public void selectConPre(String conPre) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(contactPre1Txtbox, conPre);
		driver.findElement(contactPreSeleArrow).click();
	}

	// For Choose Deselect Contact Preferences
	public void deSelectConPre(String deConPre) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(contactPre2Txtbox, deConPre);
		driver.findElement(contactPreDeSeleArrow).click();
	}

	// For Choose No Contact Preferences
	public void selectNoConPre(String noConPre) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(contactNoPre1Txtbox, noConPre);
		driver.findElement(contactNoPreSeleArrow).click();
	}

	// For Choose Deselect No Contact Preferences
	public void deSelectNoConPre(String noConPre) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(contactNoPre2Txtbox, noConPre);
		driver.findElement(contactNoPreDeSeleArrow).click();
	}

	// For Enter Email
	public void enterEmail(String eMail) {
		driver.findElement(emailTxtbox).sendKeys(eMail);
	}

	// For Enter Phone Number
	public void enterPhone(String phone) {
		driver.findElement(phoneTxtbox).sendKeys(phone);
	}

	// For Enter Cell Phone Number
	public void enterCellPhone(String cPhone) {
		driver.findElement(cellPhoneTxtbox).sendKeys(cPhone);
	}

	/*
	 * For Select Marital Status from List By Text
	 * @Param String visible Text
	 */
	public void selectMaritalStatus(String mStatus) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(maritalStatusListbox, mStatus);
	}

	/*
	 * For Select Race from List By Text
	 * @Param String visible Text
	 */
	public void selectRace(String race) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(raceListbox, race);
	}

	/*
	 * For Select Gender from List By Text
	 * @Param String visible Text
	 */
	public void selectReligion(String religion) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(religionListbox, religion);
	}

	/*
	 * For Select CitizenShip Status from List By Text
	 * @Param String visible Text
	 */
	public void selectCitizenStatus(String citizen) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(citizenStatusListbox, citizen);
	}

	/*
	 * For Select Country Of Origin from List By Text
	 * @Param String visible Text
	 */
	public void selectCountryOfOrigin(String country) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(countryOfOriginListbox, country);
	}

	// For enter Address
	public void address(String line1, String line2, String city, String state, String zip) {
		driver.findElement(addLine1Txtbox).sendKeys(line1);
		if (line2 == null) {
			driver.findElement(addLine2Txtbox).sendKeys(line2);
		} else {
			driver.findElement(addLine2Txtbox).sendKeys(" ");
		}
		driver.findElement(cityTxtbox).sendKeys(city);
		AllMethod.selectTextFromComboByVisibleTextUseBy(stateListbox, state);
		driver.findElement(zipTxtbox).sendKeys(zip);
	}

	// For enter Mailling Address
	public void maillingAddress(String line1, String line2, String city, String state, String zip) {

		driver.findElement(mAddLine1Txtbox).sendKeys(line1);
		if (line2 == null) {
			driver.findElement(mAddLine2Txtbox).sendKeys(line2);
		} else {
			driver.findElement(mAddLine2Txtbox).sendKeys(" ");
		}
		driver.findElement(mCityTxtbox).sendKeys(city);
		AllMethod.selectTextFromComboByVisibleTextUseBy(mStateListbox, state);
		driver.findElement(mZipTxtbox).sendKeys(zip);

	}

	// For Enter Address Note
	public void enterAddressNote(String addNote) {
		driver.findElement(addNoteTxtbox).sendKeys(addNote);
	}

	// For Select Primary Language
	public void selectPrimaryLanguage(String language) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(priLanListbox, language);
	}

	// For Select Secondary Language
	public void selectSecondaryLanguage(String language) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(secLanListbox, language);
	}

	// For Select tertiary Language
	public void selectTertiaryLanguage(String language) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(terLanListbox, language);
	}

	// For Select Primary Language
	public void selectMailingLanguage(String language) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(mailLanListbox, language);
	}

	// For Select Primary Dialect
	public void selectPrimaryDialect(String dialect) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(priDiaListbox, dialect);
	}

	// For Select Secondary Dialect
	public void selectSecondaryDialect(String dialect) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(secDiaListbox, dialect);
	}

	// For Select tertiary Dialect
	public void selectTertiaryDialect(String dialect) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(terDiaListbox, dialect);
	}

	// For Enter contact
	public void enterContact(String contact) {
		driver.findElement(contactTxtbox).sendKeys(contact);
	}

	// For Enter parent Account
	public void enterparentAccount(String pAccount) {
		driver.findElement(parentTxtbox).sendKeys(pAccount);
	}

}

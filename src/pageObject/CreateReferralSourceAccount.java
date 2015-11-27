package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.AllMethod;

public class CreateReferralSourceAccount {

	public WebDriver driver;
	private By newAccountLabel = By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr[1]/td[4]");
	private By saveButton = By.xpath(".//*[@id='topButtonRow']/input[1]");
	private By saveAndNewButton = By.xpath(".//*[@id='topButtonRow']/input[2]");
	private By canCelButton = By.xpath(".//*[@id='topButtonRow']/input[3]");
	private By accNameTxtbox = By.id("acc2");
	private By providerAccTxtbox = By.id("CF00NL0000003e6kd");
	private By referralSSCategoryCheckbox = By.id("00NL0000003e6kf");
	private By referralSCategoryListbox = By.id("00NL0000003e6ke");
	private By referralSSubCategoryListbox = By.id("00NL0000003e6kg'");
	private By professionalSuffix = By.id("00NF000000ColU5");
	private By fNameTxtbox = By.id("00NF000000ColTt");
	private By lNameTxtbox = By.id("00NF000000ColTx");
	private By genderListbox = By.id("00NF000000ColTv");
	private By phoneTxtbox = By.id("acc10");
	private By emailTxtbox = By.id("00NF000000ColTs");
	private By faxTxtbox = By.id("acc11");
	private By priLanListbox = By.id("00NF000000ColUB");
	private By secLanListbox = By.id("00NF000000ColUK");
	private By terLanListbox = By.id("00NF000000ColUO");
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
	private By copyPriAddToMailAddChqBox = By.id("00NL0000003GwUh");
	private By districtManagerTxtBox = By.id("CF00NL0000003e6kb");
	private By delegatredStaffTxtbox = By.id("CF00NL0000003e6kc");
	private By staffTitleListbox = By.id("00NL0000003H9H7");
	private By parentTxtbox = By.id("acc3");

	// This is Constructor
	public CreateReferralSourceAccount(WebDriver driver) {
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

	// For Enter Text on Account Name
	public void enterTxtOnAccountName(String aName) throws Exception {
		driver.findElement(accNameTxtbox).sendKeys(aName);
		if (aName == null) {
			throw new Exception(aName);
		}
	}

	// For Enter Text on Provider Account Text Box
	public void enterTxtOnProviderAccount(String pAccount) throws Exception {
		driver.findElement(providerAccTxtbox).sendKeys(pAccount);
		if (pAccount == null) {
			throw new Exception(pAccount);
		}
	}

	// For check Referral Source Group Indicator
	public void checkReferralSGIndicator() {
		driver.findElement(referralSSCategoryCheckbox).click();
	}

	// Select Referral Source Sub Category
	public void selectReferralSCategory(String rcategory) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(referralSCategoryListbox, rcategory);
	}

	// Select Referral Source Sub Category
	public void selectReferralSSubCategory(String rSubCategory) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(referralSSubCategoryListbox, rSubCategory);
	}

	// Select Professional Suffix
	public void selectProfessionalSuffix(String proSuffix) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(professionalSuffix, proSuffix);
	}

	// For Insert Text on Last Name
	public void enterTxtOnLastName(String lName) throws Exception {
		driver.findElement(lNameTxtbox).sendKeys(lName);
		if (lName == null) {
			throw new Exception(lName);
		}
	}

	// For Insert Text on First Name
	public void enterTxtOnFirstName(String fName) throws Exception {
		driver.findElement(fNameTxtbox).sendKeys(fName);
		if (fName == null) {
			throw new Exception(fName);
		}
	}

	/*
	 * For Select Gender from List By Text
	 * 
	 * @Param String visible Text
	 */
	public void selectGender(String gender) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(genderListbox, gender);
	}

	// For Enter Phone Number
	public void enterPhone(String phone) {
		driver.findElement(phoneTxtbox).sendKeys(phone);
	}

	// For Enter Fax
	public void enterfax(String fax) {
		driver.findElement(faxTxtbox).sendKeys(fax);
	}

	// For Enter Email
	public void enterEmail(String eMail) {
		driver.findElement(emailTxtbox).sendKeys(eMail);
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

	// For Check Auto Address Copy to Mailling Address
	public void checkAutoAddressCopy() {
		driver.findElement(copyPriAddToMailAddChqBox).click();
	}

	// For Enter District Manager
	public void enterDistrictManager(String mName) {
		driver.findElement(districtManagerTxtBox).sendKeys(mName);
	}

	// For Enter District Manager
	public void enterDelegatedStaff(String dStaff) {
		driver.findElement(delegatredStaffTxtbox).sendKeys(dStaff);
	}

	// For Select Staff Title
	public void selectPrimaryDialect(String sTitle) {
		AllMethod.selectTextFromComboByVisibleTextUseBy(staffTitleListbox, sTitle);
	}

	// For Enter parent Account
	public void enterparentAccount(String pAccount) {
		driver.findElement(parentTxtbox).sendKeys(pAccount);
	}

}

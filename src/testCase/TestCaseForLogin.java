package testCase;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;
import pageObject.HomePage;
import pageObject.NavigateToOtherPage;
import utilities.AllMethod;
import utilities.ScreenShot;
import utilities.StartUp;

public class TestCaseForLogin extends StartUp {
  
	// Verify Invalid LogIn
	NavigateToOtherPage navi=new NavigateToOtherPage(driver);
	
	@Test(priority = 0)
	public void verifyInvalidIDBlank() throws InterruptedException {
		
		
		extent.startTest("TC01.2",
				"Verify Invalid Login(Invalid User ID): Nagetive Test");
		
		extent.log(LogStatus.INFO, "Submit Blank User Name And Password");
		AllMethod.clickButton("xpath", ".//*[@id='Login']", "click");
		Thread.sleep(1000);
		System.out.println("click login");
		/*if(driver.findElements(By
				.xpath(".//*[@id='error']")).size()!=0){
			extent.log(LogStatus.PASS, "Verify Invalid User Login",
					"View details below:", ScreenShot.captureScreen(driver,
							"Blank (ID and Password) submit  Error Messege"));
		}else{
					
			extent.log(LogStatus.FAIL, "No Error Massege Popup on Blank User Name and Password Submit","View detail below:",
					ScreenShot.captureScreen(driver, "No Error PopUp"));
		}*/
		
		extent.endTest();
		driver.get(url);
		}
	
	@Test(priority = 1)
	public void verifyInvalidID() throws InterruptedException {

		extent.startTest("TC01.3",
				"Verify Invalid Login(Invalid User ID): Nagetive Test");
		System.out.println("Step 3rd start");	
				// Enter User Name on the User ID Field
		AllMethod.useSendkeys("xpath", ".//*[@id='username']",
				"Jakther");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Enter Password
		extent.log(LogStatus.INFO, "Enter User ID and Password");
		AllMethod.useSendkeys("xpath", ".//*[@id='password']",
				"06082003Tuba");
		extent.log(LogStatus.INFO, "Enter User ID and Password","View detail below:");
		// Click SignIn Button
		AllMethod.clickButton("xpath", ".//*[@id='Login']", "click");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement errorMsgOnLogIn = driver.findElement(By
				.xpath(".//*[@id='error']"));

		// Verify Appropriate Error Massege
		if (errorMsgOnLogIn.isDisplayed()) {

			extent.log(LogStatus.PASS, "Verify Invalid User Login",
					"View details below:", ScreenShot.captureScreen(driver,
							"Invalid User ID Error Messege"));
		} else {
			extent.log(LogStatus.FAIL, "Verify Invalid User Login",
					"View details below:", ScreenShot.captureScreen(driver,
							"Invalid User ID Error Messege"));
			//AllUtilitiesAsset.showStopper("Yes", "No login Button Found");
			
		}

		driver.get(url);
		Thread.sleep(2000);
		// Skip password recovery Link
		extent.log(LogStatus.SKIP, "Verify Forget Link", "View details below:");
		extent.endTest();
	}

	@Test(priority = 2)
	public void verifyInvalidPassword() {

		extent.startTest("TC01.4",
				"Verify Invalid Login(Invalid Password):Nagetive Test");
		

		// Enter User ID
		AllMethod.useSendkeys("xpath", ".//*[@id='username']",
				validID);

		// Enter Password
		AllMethod.useSendkeys("xpath", ".//*[@id='password']", "1234");
		extent.log(LogStatus.INFO, "Enter User ID and Password",
				"View detail below:");
		// Click SignIn button
		AllMethod.clickButton("xpath", ".//*[@id='Login']", "click");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement errorMsgForInvalidLogIn = driver.findElement(By.id("error"));
		ScreenShot
				.captureScreenAny(driver, "Error Messge for Invalid password");
		// Verify Appropriate Error Massege
		if (errorMsgForInvalidLogIn.isDisplayed()) {
			System.err.println("Invalid Login:"
					+ errorMsgForInvalidLogIn.getText());
			
			extent.log(LogStatus.PASS, "Verify Invalid User Login",
					"View details below:", ScreenShot.captureScreen(driver,
							"Invalid Password Error Messege"));
		} else {
			extent.log(LogStatus.FAIL, "Verify Invalid User Login",
					"View details below:", ScreenShot.captureScreen(driver,
							"Invalid Password Error Messege"));
			//AllUtilitiesAsset.showStopper("Yes", "No login Button Found");
		}

		extent.endTest();
		driver.get(url);
	}

	@Test(priority = 3)
	public void validLogin() throws InterruptedException {
		// For Keep User Name and Pawword
		WebElement userNameEditBox = driver.findElement(By.id("username"));
		WebElement passwordEditBox = driver.findElement(By.id("password"));

		extent.startTest("TC01.5", "Verify Valid Login");
		
		// Enter User Id
		AllMethod.useSendkeys("xpath", ".//*[@id='username']", validID);
		// Enter Password
		AllMethod.useSendkeys("xpath", ".//*[@id='password']",
				validPassword);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		extent.log(LogStatus.INFO, "Enter User ID and Password");
		String pass = passwordEditBox.getText().toString();
		

		// Verify Appropriate Error Massage
		if (userNameEditBox.getText().toString().equals(validID)
				&& pass.equals(validPassword)) {
			extent.log(LogStatus.PASS,
					"Verify User ID and Password Enter on the Text Box ",
					"View details below:", ScreenShot.captureScreen(driver,
							"Enter Valid ID and Password"));
		} else {
			extent.log(LogStatus.FAIL,
					"Verify User ID and Password Enter on the Text Box ",
					"View details below:", ScreenShot.captureScreen(driver,
							"Enter Valid ID and Password"));
			//AllUtilitiesAsset.showStopper("Yes", "No Error Messege Found");
		}
		extent.endTest();

	}

	@Test(priority = 4)
	public void verifyRemebarMeCheckBox() throws InterruptedException {
		boolean chq;
		extent.startTest("TC01.6", "Verify Remember Me CheckBox");

		WebElement checkBox = driver.findElement(By.id("rememberUn"));
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		extent.log(LogStatus.INFO, "Verify Remember Me CheckBox");

		// For Rotate Code Two Time
		for (int i = 0; i < 2; i++) {
			chq = AllMethod.checkElementSelected("id", "rememberUn");
			// Verify Remember me Checkbox Selected or Not then Passing Error
			// Massage
			if (chq == true) {
				checkBox.click();
				extent.log(LogStatus.PASS, "Remember Me CheckBox",
						"View details below:",
						ScreenShot.captureScreen(driver, "CheckBox Uncheck"));

			} else {

				checkBox.click();
				extent.log(LogStatus.FAIL, "Remember Me CheckBox Check",
						"View details below:",
						ScreenShot.captureScreen(driver, "CheckBok Selected"));
				//AllUtilitiesAsset.showStopper("no", "Remember me CheckBox check ");

			}
		}

		extent.endTest();
	}

	@Test(priority = 5)
	public void logIn() throws InterruptedException {
		extent.startTest("TC01.7",
				"Verify Sucessfully Landed on Salesfore Application Home Page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Landed in HomePage
		AllMethod.clickButton("xpath", ".//*[@id='Login']", "click");
		Thread.sleep(2000);
		extent.log(LogStatus.PASS,
				"Sucessefully Landed on Salesforce Application Home Page ",
				"View details below:");
		
		HomePage homepage1=new HomePage(driver);
		homepage1.clickAndSelectFromCombo("This Month");
		Thread.sleep(2000);
		System.out.println("User name is :"+homepage1.getUserName());
		extent.log(LogStatus.INFO,
				"Click on Combobox and Navigate this month data",
				"View details below:",
				ScreenShot.captureScreen(driver, "data From Combo"));
		extent.endTest();
	}

	// Verify User Id
	@Test(priority = 6)
	public void verifyTitle() {

		// Verifying Application Title
		String userAcLabel = driver.findElement(
				By.xpath(".//*[@id='ptBody']/div/div[2]/span[1]/h1")).getText();
		extent.startTest("TC01.8",
				"Verify Successfully  Login To Title ( User Name:"
						+ userAcLabel + " )");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Verifying Any Error Exist
		if (userAcLabel.matches("Jahed Akther at Centerlight Healthcare")) {
			extent.log(LogStatus.PASS, "User Name chekPoint Verify",
					"View details below:",
					ScreenShot.captureScreen(driver, "Verify User Title Label"));
		} else {
			extent.log(LogStatus.FAIL, "User Name chekPoint Verify",
					"View details below:",
					ScreenShot.captureScreen(driver, "Verify User Title Label"));
			//AllUtilitiesAsset.showStopper("no", "Data Didnt Captutre");
		}
		extent.endTest();
	}
	

	@Test(priority = 7)
	public void logout() throws InterruptedException {

		extent.startTest("TC01.9", "Verify Sucessfully LogOut");
		// Expanding Menu for Logout
		driver.findElement(By.xpath(".//*[@id='userNavLabel']")).click();
		extent.log(LogStatus.INFO, "Successfully expand Logout panel",
				"View details below:");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click Logout Link
		driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		String title = driver.getTitle();
		
		// Verify Succesfully Logout
		if (title.matches("Login | Salesforce")) {
			extent.log(LogStatus.PASS, "Successfully Logout from User Account",
					"View details below:",
					ScreenShot.captureScreen(driver, "logout"));
		} else {
			extent.log(LogStatus.FAIL, "Error on  Logout from User Account",
					"View details below:",
					ScreenShot.captureScreen(driver, "logout Error"));
		}
		extent.endTest();

	}

	
}

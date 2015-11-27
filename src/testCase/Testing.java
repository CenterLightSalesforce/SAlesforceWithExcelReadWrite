package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testing {
	static WebDriver driver = new FirefoxDriver();
	public static WebElement myTask = driver.findElement(By.id("actionForm"));

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		navigateLoginPage();
		Thread.sleep(2000);
		login();
		Thread.sleep(2000);
		printLine();
		splitTxt();

	}

	public static void login() {
		driver.findElement(By.id("username")).sendKeys("jakther@centerlight.org.qual");
		driver.findElement(By.id("password")).sendKeys("06082003Tuba");
		driver.findElement(By.id("Login")).click();
		
	}

	public static void splitTxt() {
		String myTaskTxt = myTask.getText();
		try {
			for (int i = 1; i <= myTaskTxt.length(); i++) {
				String[] getTxt = myTaskTxt.split("X");
				// System.out.println("Array Index: "+i);
				System.out.println(getTxt[i]);
			}
		} catch (ArrayIndexOutOfBoundsException a) {

		}
	}

	public static void printLine() {
		System.err.println("  Date       Status         Subject              Name	   Related To Account");
		System.out.println("******************************************************************************");
	}

	public static void navigateLoginPage()  {
		driver.get("https://test.salesforce.com");
		
	}
}

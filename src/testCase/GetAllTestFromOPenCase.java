package testCase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.SignInPage;

public class GetAllTestFromOPenCase {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		SignInPage sign = new SignInPage(driver);

		driver.get("https://test.salesforce.com/");
		Thread.sleep(2000);
		sign.validLogin();
		Thread.sleep(3000);
		String frame = "066F0000002PWsj";
		driver.switchTo().frame(frame);
		driver.findElement(By.id("searchTerms")).sendKeys("Mark D Pace");
		driver.findElement(By.xpath(".//*[@id='body']/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th/a")).click();
		Thread.sleep(3000);

		// List<WebElement> allEdit =
		// driver.findElements(By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr"));
		List<WebElement> allEdit = driver.findElements(By.xpath(".//div[starts-with(@id,'00NF000000')]"));
		for (int i = 0; i < allEdit.size(); i++) {
			WebElement text = allEdit.get(i);
			System.out.println(text.getText());
		}
	}

}

package testCase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.SignInPage;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		SignInPage sign = new SignInPage(driver);

		driver.get("https://test.salesforce.com/");
		Thread.sleep(2000);
		sign.validLogin();
		Thread.sleep(3000);
		
		List<WebElement> dateList=driver.findElements(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr"));
		
		
			WebElement getAllDate1=dateList.get(0);
			
			if(getAllDate1.getText().equals("December 2015")){
				for(int j=0;j<4;j++){   
				driver.findElement(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[1]/td[3]/a/img")).click();
				Thread.sleep(1000);
				}
				
				System.out.println(dateList.size());
				for(int i=0;i<dateList.size();i++){
					
				
				
				
			}
			
			
		}
		
		//.//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr
	}

}

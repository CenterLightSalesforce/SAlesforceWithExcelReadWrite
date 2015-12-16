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
		
		
		
		for(int i=0;i<12;i++){
			List<WebElement> dateList=driver.findElements(By.cssSelector(".header>td"));		  
			  WebElement getMonth=dateList.get(1);
			  WebElement nextMonth=driver.findElement(By.cssSelector(".nextCalArrow"));
				String monthVerify=getMonth.getText();
				System.out.println(monthVerify);
		if(monthVerify.equals("April 2016")){
			System.out.println("Valid Month Found");
		
		List<WebElement> dateList1=driver.findElements(By.cssSelector(".calActive"));
		for(int d=0;d<dateList1.size();d++){
		WebElement days=dateList1.get(d);
		String daysText=days.getText();
		if(days.isDisplayed())
			if(daysText.equals("29")){
				days.click();
			}
		}
		
		}else{
			nextMonth.click();
			Thread.sleep(1000);
		}
		
		}
		/*
			
			for(int i=0;i<12;i++){
				List<WebElement> dateList=driver.findElements(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr"));		  
				  WebElement getMonth=dateList.get(0);
					String monthVerify=getMonth.getText();
			if(monthVerify.equals("April 2016")){
				System.out.println("Valid Month Found");
				     
				for(int y=0;y<5;y++){
					
					for(int z=0;z<7;z++){
					WebElement days=driver.findElement(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr["+(y+3)+"]/td["+(z+1)+"]/a"));
					String dayText=days.getText();
					if(days.isEnabled()){
						if(dayText.equals("27")){
						days.click();
						break;
						}
					}
					
				}}
				
				
				
				
				break;
			}else{
				driver.findElement(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[1]/td[3]/a/img")).click();
				Thread.sleep(1000);
				}
			}*/
					}

}

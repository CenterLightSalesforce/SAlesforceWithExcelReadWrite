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
        String monthLooking="July 2016";
        String dayLooking="19";
        String[] monthLeftside=monthLooking.split(" ");
        String fSplit=monthLeftside[0];
        String sSplit=monthLeftside[1];
        String verifyTitle=fSplit+" "+dayLooking+","+sSplit;
		driver.get("https://test.salesforce.com/");
		Thread.sleep(2000);
		sign.validLogin();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Date Looking For:"+verifyTitle);
		
		try{
		
		for(int i=0;i<12;i++){
			List<WebElement> dateList=driver.findElements(By.cssSelector(".header>td"));		  
			  WebElement getMonth=dateList.get(1);
			  WebElement nextMonth=driver.findElement(By.cssSelector(".nextCalArrow"));
				String monthVerify=getMonth.getText();
				//System.out.println(monthVerify);
		if(monthVerify.equals(monthLooking)){
			//System.out.println("Valid Month Found");
		Thread.sleep(2000);
		List<WebElement> dateList1=driver.findElements(By.cssSelector(".calActive"));
		for(int d=0;d<dateList1.size();d++){
		WebElement days=dateList1.get(d);
		String daysText=days.getText();
		if(days.isDisplayed())
			if(daysText.equals(dayLooking)){
				days.click();
				break;
			}
		}
		
		}else{
			nextMonth.click();
			Thread.sleep(1000);
		}
		
		}}catch(IndexOutOfBoundsException a){}
		
		String title=driver.findElement(By.cssSelector(".dateText")).getText();
		String []getTitle=title.split(" ");
		String fTitle=getTitle[1];
		String sTitle=getTitle[2];
		String tTitle=getTitle[3];
		String finalTitle=fTitle+" "+sTitle+tTitle;
		System.out.println("Succesfully Date Found "+finalTitle);
		//Thread.sleep(2000);
		if(finalTitle.equals(verifyTitle)){
			System.out.println("Test Pass");
		}else{
			System.out.println("Test Fail");
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

package testCase;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.SignInPage;

public class TestingWithCalender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		//SignInPage sign = new SignInPage(driver);
		//driver.get("https://test.salesforce.com/");
			
		/*sign.validLogin();
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath(".//*[@id='actionForm']/div[2]/table/tbody/*"));
		
		System.out.println(list.size());
		for(int i=1;i<=list.size();i++){
			int row=i+1;
			List<WebElement> getData=driver.findElements(By.xpath(".//*[@id='actionForm']/div[2]/table/tbody/tr["+row+"]/th"));
			
				for(WebElement d:getData){
			    if(d.getText().equals("11/21/2015")){
			    	Thread.sleep(2000);
			    	driver.findElement(By.xpath(".//*[@id='actionForm']/div[2]/table/tbody/tr["+row+"]/td[3]/a")).click();
			    	
			    	return;
			    }
					System.out.println(d.getText());
		       	}
		}*/
		//String calData=driver.findElement(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
		//System.out.println(calData);
		//driver.get("https://www.google.com");
		//Thread.sleep(2000);
		//String msg=driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		//driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[2]/div[4]/div[1]/a/span")).click();
		//String handle= driver.getWindowHandle();
		//Set handles = driver.getWindowHandles();
		//String firstWinHandle;
		//System.out.println(msg);
		//System.out.println(handles.size());
		
		driver.get("http://www.6pm.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='hpSideCol']/a[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='FCTzc2Select']/a[8]")).click();
		Thread.sleep(2000);
		
		boolean lop=true;
		
		/*driver.findElement(By.xpath(".//*[@id='resultWrap']/div[1]/div[2]/a[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='resultWrap']/div[1]/div[2]/a[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='resultWrap']/div[1]/div[2]/a[5]")).click();
		Thread.sleep(2000);*/
		
		//List<WebElement> list1=driver.findElements(By.xpath(".//*[@id='resultWrap']/div[1]/div[2]/a[5]"));
		//System.out.println(list1.size());
		List<WebElement> list=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		int totalItem=list.size();
		driver.findElement(By.xpath(".//*[@id='resultWrap']/div[1]/div[2]/a[4]")).click();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement navi;
		WebElement list1;
	    
		
		do
	    {
	    	navi=driver.findElement(By.xpath(".//*[@id='resultWrap']/div[1]/div[2]/a[5]"));
			list=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
	    	list1=driver.findElement(By.xpath(".//*[@id='resultWrap']/div[1]/div[2]/a[5]"));
        	totalItem=totalItem+list.size();
        
	    	  //Thread.sleep(2000);
		        if(list1.isDisplayed()){
		        	navi.click();
		    	    Thread.sleep(2000);
		    	    System.out.println(totalItem);
		        }else{
		      
		    	  lop=false;
		        }
		}while(lop);
	    
		System.out.println(totalItem);
		
		/*driver.findElement(By.id(“id of the link/button which opens new window”)).click();
		//wait till two windows are not opened
		waitForNumberofWindowsToEqual(2);//this method is for wait

		Set handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);
		String winHandle=handles.iterator().next();
		if (winHandle!=firstWinHandle){
		//To retrieve the handle of second window, extracting the handle which does not match to first window handle
		secondWinHandle=winHandle; //Storing handle of second window handle

		//Switch control to new window
		driver.switchTo().window(secondWinHandle);
		//Control is switched now
		*/
		
	}
	
	/*public void clickAndSwitchToSecondWindow(WebDriver driver)
	{
	//Perform the click operation that opens new window

	driver.findElement(By.id(“id of the link/button which opens new window”)).click();
	//wait till two windows are not opened
	waitForNumberofWindowsToEqual(2);//this method is for wait

	Set handles = driver.getWindowHandles();
	firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);
	String winHandle=handles.iterator().next();
	if (winHandle!=firstWinHandle){
	//To retrieve the handle of second window, extracting the handle which does not match to first window handle
	secondWinHandle=winHandle; //Storing handle of second window handle

	//Switch control to new window
	driver.switchTo().window(secondWinHandle);
	//Control is switched now
	}*/

}

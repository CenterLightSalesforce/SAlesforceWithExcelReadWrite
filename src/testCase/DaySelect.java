package testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import pageObject.SignInPage;

public class DaySelect {
   static String verifyTitle=null;
   static WebDriver driver=null;
	
   public static void main(String[] args) throws InterruptedException {
				
		
		try{
		
		     for(int r=0;r<3;r++)
		          {
				     if (r == 0)
				         {
				          driver = new FirefoxDriver();
				          System.out.println("Start Mozila Firefox\n");
		                 }
				     else if (r == 1) 
			          	{
				          System.setProperty("webdriver.chrome.driver",
						  "C:\\Users\\jakther\\Desktop\\jahed\\java\\chromedriver\\chromedriver.exe");
				          driver = new ChromeDriver();
				          System.out.println("Start Google Chrome\n ");
			            }
				     else if (r == 2)
			            {
				          System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
				          DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				          ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						  true);
				          driver = new InternetExplorerDriver(ieCapabilities);
				          System.out.println("Start Internet Explorar\n");
			            }
				    else
			            {
					    }
		
		SignInPage sign = new SignInPage(driver);
		driver.get("https://test.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		sign.validLogin();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String yearLooking="2016";
		String monthLooking="July";
		String dayLooking="19";
		String dateVerify=monthLooking+" "+yearLooking;
	    verifyTitle=monthLooking+" "+dayLooking+","+yearLooking;
			
				    
			 for(int i=0;i<12;i++){
			 
				 String applicationCurrentMonth=driver.findElement(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
				 WebElement nextMonth=driver.findElement(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[1]/td[3]/a/img"));
		       	    if  (applicationCurrentMonth.equals(dateVerify))
		       	          { 
			        	  System.out.println("Month Found");
			    	      List<WebElement>daysList=driver.findElements(By.cssSelector(".calActive"));
			    	         for(int j=0;j<daysList.size();j++)  
			    	              {
			    	               WebElement day=daysList.get(j);
			    	               String daysText=day.getText();
			    	                  if(daysText.equals(dayLooking))
			    	                  {
			    	            	    day.click();
			    	            	    break;
			    	                  }
			    	            
			    	              }break;
			    				    	
			              }else{
			    	        nextMonth.click();
			    	        Thread.sleep(1000);
			                   }
		  	 }
				 
		       //Start Verify Perticular Date open 
		       Thread.sleep(2000);
		     String fullText=driver.findElement(By.xpath(".//*[@id='bCalDiv']/div/div[2]/span[3]")).getText();
		     String []getTitle=fullText.split(" ");
		     String fTitle=getTitle[1];
		     String sTitle=getTitle[2];
		     String tTitle=getTitle[3];
		     String finalDate=fTitle+" "+sTitle+tTitle;
		
		        if(finalDate.equals(verifyTitle))
		            {
			         System.out.println("TestCase Pass");
			         }
		       else {
			         System.err.println("TestCase Fail");
		            }
		 	 driver.close();
	      }
				
	   }catch(Exception a)
		    {
		      throw(a);
         	}
				
	}	 //for main method end
}// for class end			 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
			
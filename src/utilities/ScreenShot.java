package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot extends StartUp{

	public static String captureScreen(WebDriver driver,String screeShotName){
		
		
		try{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String dest="C:\\Users\\jakther\\workspace\\SmokeTesting\\ScrShot\\"+screeShotName+".png";
		File destination =new File(dest);
		
		FileUtils.copyFile(source,destination);
		
		return dest;
		}
		catch(Exception e)
		{
			
			System.out.println("Exception While taking ScreenShot "+e.getMessage());
			return e.getMessage();
		}
	}
		
		
		public static void captureScreenAny(WebDriver driver,String screeShotName){
			
			
			try{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String dest="C:\\Users\\jakther\\workspace\\SmokeTesting\\ScrShot\\"+screeShotName+".png";
			File destination =new File(dest);
			
			FileUtils.copyFile(source,destination);
						
			}
			catch(Exception e)
			{
				
				System.out.println("Exception While taking ScreenShot "+e.getMessage());
				
			}
		}
		
	}
	
	


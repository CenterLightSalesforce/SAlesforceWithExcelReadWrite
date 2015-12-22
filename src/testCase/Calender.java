package testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.SignInPage;
import utilities.ExcelUtilis;

public class Calender {
	static int countMatchLanguage = 0;
	static int countUnMatchLanguage = 0;
	static String excelPath = "C:\\Users\\jakther\\Desktop\\jahed\\workspace\\SalesforceDemo\\src\\testData\\TestData.xlsx";
	
	
	public static void main(String[] args) throws Exception {

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jakther\\Desktop\\jahed\\java\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SignInPage sign = new SignInPage(driver);
		ExcelUtilis excel = new ExcelUtilis(driver);
		excel.setExcelFile(excelPath, "Sheet2");

		// String monthLooking="July 2016";
		// String dayLooking="19";
		// String[] monthLeftside=monthLooking.split(" ");
		// String fSplit=monthLeftside[0];
		// String sSplit=monthLeftside[1];
		// String verifyTitle=fSplit+" "+dayLooking+","+sSplit;
		driver.get("https://test.salesforce.com/");
		Thread.sleep(2000);
		sign.validLogin();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Account_Tab']/a")).click();
		driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();

		List<WebElement> listData = driver.findElements(By.xpath(".//*[@id='00NF000000ColUB']/option"));
		// List<WebElement>
		// listData=driver.findElements(By.tagName("select")).get(1);
		for (int h = 1; h < listData.size(); h++) {
			WebElement listText = driver.findElements(By.xpath(".//*[@id='00NF000000ColUB']/option")).get(h);
			String text = listText.getText();
			String getDataFromExcel = excel.getCellData(h - 1, 0);
			System.out.println("Data From Application Data From Excel File");

			if (text.length() < 8) {

				System.out.println(text + "\t\t\t" + getDataFromExcel);
			} else {
				System.out.println(text + "\t\t" + getDataFromExcel);
			}

			if (text.equals(getDataFromExcel)) {
				countMatchLanguage = countMatchLanguage + 1;
			} else {
				countUnMatchLanguage = countUnMatchLanguage + 1;
				System.out.println("Language Didnt Match.On the Application Language Found :" + text
						+ " But on The Excel Sheet Language are:" + getDataFromExcel);
			}

		}

		if (countMatchLanguage == listData.size()) {
			System.out.println("All Language Match with Excel File");
		} else {
			System.out.println(countUnMatchLanguage + " Language Didnt Match with Excel File");
		}
		System.out.println(countMatchLanguage + " Language  Match with Excel File");
		
		
		driver.close();
		/*
		 * System.out.println("Date Looking For:"+verifyTitle);
		 * 
		 * try{
		 * 
		 * for(int i=0;i<12;i++){ List<WebElement>
		 * dateList=driver.findElements(By.cssSelector(".header>td"));
		 * WebElement getMonth=dateList.get(1); WebElement
		 * nextMonth=driver.findElement(By.cssSelector(".nextCalArrow")); String
		 * monthVerify=getMonth.getText(); //System.out.println(monthVerify);
		 * if(monthVerify.equals(monthLooking)){ //System.out.println(
		 * "Valid Month Found"); Thread.sleep(2000); List<WebElement>
		 * dateList1=driver.findElements(By.cssSelector(".calActive")); for(int
		 * d=0;d<dateList1.size();d++){ WebElement days=dateList1.get(d); String
		 * daysText=days.getText(); if(days.isDisplayed())
		 * if(daysText.equals(dayLooking)){ days.click(); break; } }
		 * 
		 * }else{ nextMonth.click(); Thread.sleep(1000); }
		 * 
		 * }}catch(IndexOutOfBoundsException a){}
		 * 
		 * String
		 * title=driver.findElement(By.cssSelector(".dateText")).getText();
		 * String []getTitle=title.split(" "); String fTitle=getTitle[1]; String
		 * sTitle=getTitle[2]; String tTitle=getTitle[3]; String
		 * finalTitle=fTitle+" "+sTitle+tTitle; System.out.println(
		 * "Succesfully Date Found "+finalTitle); //Thread.sleep(2000);
		 * if(finalTitle.equals(verifyTitle)){ System.out.println("Test Pass");
		 * }else{ System.out.println("Test Fail"); }
		 * 
		 */

		/*
		 * 
		 * for(int i=0;i<12;i++){ List<WebElement>
		 * dateList=driver.findElements(By.xpath(
		 * ".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr"
		 * )); WebElement getMonth=dateList.get(0); String
		 * monthVerify=getMonth.getText(); if(monthVerify.equals("April 2016")){
		 * System.out.println("Valid Month Found");
		 * 
		 * for(int y=0;y<5;y++){
		 * 
		 * for(int z=0;z<7;z++){ WebElement days=driver.findElement(By.xpath(
		 * ".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr["
		 * +(y+3)+"]/td["+(z+1)+"]/a")); String dayText=days.getText();
		 * if(days.isEnabled()){ if(dayText.equals("27")){ days.click(); break;
		 * } }
		 * 
		 * }}
		 * 
		 * 
		 * 
		 * 
		 * break; }else{ driver.findElement(By.xpath(
		 * ".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[1]/td[3]/a/img"
		 * )).click(); Thread.sleep(1000); } }
		 */
	}

}

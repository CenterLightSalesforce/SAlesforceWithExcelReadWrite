package testCase;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.SignInPage;

public class TestingWithCalender {
	static String accName = null;
	static Scanner inp = new Scanner(System.in);
	static int con = 0;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		SignInPage sign = new SignInPage(driver);

		driver.get("https://test.salesforce.com/");
		Thread.sleep(2000);
		sign.validLogin();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='Case_Tab']/a")).click();
		Thread.sleep(3000);
		
		
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total "+totalLinks.size()+" Links are Present on this Page");
		for(int h=0;h<totalLinks.size();h++){
			WebElement ele =totalLinks.get(h);
			System.out.println(ele.getText());
			
		}
		
		
		List<WebElement> openCase = driver
				.findElements(By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr"));
		System.out.println(openCase.size());
		int countCase = 0;
		String caseAccNameEx = "Akther Nabil";
		for (int n = 2; n < openCase.size(); n++) {

			try {
				String caseAccName2 = driver
						.findElement(By.xpath(
								".//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[" + n + "]/td[1]/a"))
						.getText().toString();
							
				String caseNumber = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr["+n+"]/th/a")).getText();
				String dateOpen = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr["+n+"]/td[4]")).getText();
							
				if (caseAccName2.equalsIgnoreCase(caseAccNameEx)) {
					countCase = (countCase + 1);
					System.out.println("Matching Case Number:"+caseNumber+" case opened "+dateOpen);
				}
			} catch (NoSuchElementException a) {
				continue;
			}
		}
		System.out.println("Total " + countCase + " Case open for " + caseAccNameEx + " Account");

		// System.out.println("Enter Data for Srearh");
		// String srData=inp.nextLine();
		/*
		 * String frame = "066F0000002PWsj"; driver.switchTo().frame(frame);
		 * driver.findElement(By.id("searchTerms")).sendKeys("Mark");
		 * driver.findElement(By.xpath(".//*[@id='body']/button")).click();
		 * Thread.sleep(3000);
		 * 
		 * String accNa = "Mark A Jara"; driver.manage().window().maximize();
		 * 
		 * List<WebElement> allEdit = driver.findElements(By.xpath(
		 * ".//*[@id='Account_body']/table/tbody/tr"));
		 * System.out.println(allEdit.size() - 1);
		 * 
		 * for (int x = 1; x < allEdit.size(); x++) { // WebElement
		 * tab=driver.findElements(By.tagName("li")).get(x); WebElement nameLink
		 * = driver
		 * .findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr[" + x
		 * + "]/th/a")); String getName = nameLink.getText();
		 * 
		 * if (getName.endsWith(accNa)) { WebElement accType = driver
		 * .findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr[" + x
		 * + "]/td[6]")); String accTypeRec = accType.getText(); if
		 * (accTypeRec.endsWith("Referral Source")) { nameLink.click();
		 * Thread.sleep(2000); List<WebElement> alldata =
		 * driver.findElements(By.xpath(
		 * ".//tr/td[starts-with(@id,'00NF000000')]")); for (int m = 0; m <
		 * alldata.size(); m++) { WebElement alldata1 =
		 * driver.findElements(By.xpath(
		 * ".//tr/td[starts-with(@id,'00NF000000')]")) .get(m); String printData
		 * = alldata1.getText(); System.out.println("TextBox Number:" + m);
		 * System.out.println(printData); }
		 * 
		 * break; } }
		 * 
		 * }
		 */

		// String srearchData=inp.nextLine();
		// System.out.println("Recent Item Found:"+leftRecentItem.size());
		// System.out.println("Item Found List:");

		// .//*[@id='Account_body']/table/tbody/tr[2]/th/a

		/*
		 * driver.manage().window().maximize(); List<WebElement>
		 * leftRecentItem=driver.findElements(By.className("mruText"));
		 * List<WebElement> allTab=driver.findElements(By.tagName("li"));
		 * //List<WebElement>
		 * allTab=driver.findElements(By.xpath("li[ends-with(@id,'Tab']"));
		 * for(int x=0;x<allTab.size();x++){ WebElement
		 * tab=driver.findElements(By.tagName("li")).get(x); //WebElement
		 * tab=driver.findElements(By.xpath("li[ends-with(@id,'Tab']")).get(x);
		 * String tabName=tab.getText(); System.out.println(tabName); } String
		 * srearchData=inp.nextLine(); System.out.println("Recent Item Found:"
		 * +leftRecentItem.size()); System.out.println("Item Found List:");
		 * 
		 * 
		 * for(int j=0;j<leftRecentItem.size();j++){ WebElement
		 * obj=driver.findElements(By.className("mruText")).get(j); String
		 * text=obj.getText(); System.out.println(text);
		 * 
		 * if(text.equals(srearchData)){ obj.click(); con=1; continue; }
		 * 
		 * }
		 * 
		 * if(con==0){ System.out.println(srearchData+
		 * " Data Didnt found on The List"); }else{ System.out.println(
		 * "Record Match.Record open :"+srearchData); }
		 */

		/*
		 * List<WebElement> list=driver.findElements(By.xpath(
		 * ".//*[@id='actionForm']/div[2]/table/tbody/*"));
		 * 
		 * System.out.println(list.size()-1); for(int i=1;i<=list.size();i++){
		 * int row=i+1; List<WebElement> getData=driver.findElements(By.xpath(
		 * ".//*[@id='actionForm']/div[2]/table/tbody/tr["+row+"]/th"));
		 * 
		 * for(WebElement d:getData){ if(d.getText().equals("11/20/2015")){
		 * Thread.sleep(2000); accName=driver.findElement(By.xpath(
		 * ".//*[@id='actionForm']/div[2]/table/tbody/tr["+row+"]/td[5]/a")).
		 * getText(); // .//*[@id='actionForm']/div[2]/table/tbody/tr[8]/td[5]/a
		 * driver.findElement(By.xpath(
		 * ".//*[@id='actionForm']/div[2]/table/tbody/tr["+row+"]/td[3]/a")).
		 * click(); System.out.println(accName); return; }
		 * System.out.println(d.getText()); }
		 * 
		 * }
		 */
		// String
		// calData=driver.findElement(By.xpath(".//*[@id='homeCalendarSection']/div/div[2]/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
		// System.out.println(calData);
		// driver.get("https://www.google.com");
		// Thread.sleep(2000);
		// String msg=driver.switchTo().alert().getText();
		// driver.switchTo().alert().accept();
		// driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[2]/div[4]/div[1]/a/span")).click();
		// String handle= driver.getWindowHandle();
		// Set handles = driver.getWindowHandles();
		// String firstWinHandle;
		// System.out.println(msg);
		// System.out.println(handles.size());

		/*
		 * driver.get("http://www.6pm.com/"); Thread.sleep(2000); int
		 * totalItem=0;
		 * 
		 * driver.findElement(By.xpath(".//*[@id='hpSideCol']/a[2]")).click();
		 * Thread.sleep(2000); String
		 * itemF=driver.findElement(By.xpath("//*[@id='FCTzc2Select']/a[8]")).
		 * getText(); String [] da=itemF.split("\\("); String
		 * itemFound[]=da[1].split("\\)"); System.out.println(itemFound[0]);
		 * 
		 * driver.findElement(By.xpath("//*[@id='FCTzc2Select']/a[8]")).click();
		 * Thread.sleep(2000); List<WebElement>
		 * item=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		 * totalItem=item.size(); //boolean lop=true;
		 * driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[4]")).click();
		 * Thread.sleep(2000);
		 * item=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		 * totalItem=totalItem+item.size(); driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[5]")).click();
		 * Thread.sleep(2000);
		 * item=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		 * totalItem=totalItem+item.size(); driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[5]")).click();
		 * Thread.sleep(2000);
		 * item=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		 * totalItem=totalItem+item.size(); System.out.println(totalItem);
		 * String compare=""+totalItem; if(itemFound[0].equals(compare)){
		 * System.out.println("Total item Match"); }else{ System.out.println(
		 * "Total item UnMatch"); } driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[4]")).click();
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[5]")).click();
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[5]")).click();
		 * Thread.sleep(2000); //int totalItem=0; //List<WebElement>
		 * list1=driver.findElements(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[5]"));
		 * //System.out.println(list1.size()); List<WebElement>
		 * item=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		 * int total=item.size(); Thread.sleep(2000); System.out.println(
		 * "1st page Item Count item on the 1st Page"+totalItem);
		 * driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[4]")).click();
		 * Thread.sleep(2000); //driver.manage().window().maximize(); WebElement
		 * navi; List<WebElement> list1;
		 * 
		 * 
		 * do {
		 * 
		 * //list=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		 * 
		 * // totalItem=totalItem+list.size();
		 * List<WebElement>list=driver.findElements(By.xpath(
		 * ".//*[@id='searchResults']/a")); totalItem=totalItem+list.size();
		 * navi=driver.findElement(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[4]"));
		 * list1=driver.findElements(By.xpath(
		 * ".//*[@id='resultWrap']/div[1]/div[2]/a[5]")); Thread.sleep(2000);
		 * if(list1.size()>0){
		 * 
		 * list=driver.findElements(By.xpath(".//*[@id='searchResults']/a"));
		 * navi.click(); Thread.sleep(2000); System.out.println(
		 * "2nd page item count:on 2nd page :"+totalItem); }else{
		 * 
		 * lop=false; }
		 * 
		 * }while(lop);
		 * 
		 * 
		 * int finalitem=total+totalItem; System.out.println(
		 * "Total Item Ccount:"+finalitem);
		 * 
		 * driver.findElement(By.id(“id of the link/button which opens new
		 * window”)).click(); //wait till two windows are not opened
		 * waitForNumberofWindowsToEqual(2);//this method is for wait
		 * 
		 * Set handles = driver.getWindowHandles(); firstWinHandle =
		 * driver.getWindowHandle(); handles.remove(firstWinHandle); String
		 * winHandle=handles.iterator().next(); if (winHandle!=firstWinHandle){
		 * //To retrieve the handle of second window, extracting the handle
		 * which does not match to first window handle
		 * secondWinHandle=winHandle; //Storing handle of second window handle
		 * 
		 * //Switch control to new window
		 * driver.switchTo().window(secondWinHandle); //Control is switched now
		 * 
		 */
	}

	/*
	 * public void clickAndSwitchToSecondWindow(WebDriver driver) { //Perform
	 * the click operation that opens new window
	 * 
	 * driver.findElement(By.id(“id of the link/button which opens new
	 * window”)).click(); //wait till two windows are not opened
	 * waitForNumberofWindowsToEqual(2);//this method is for wait
	 * 
	 * Set handles = driver.getWindowHandles(); firstWinHandle =
	 * driver.getWindowHandle(); handles.remove(firstWinHandle); String
	 * winHandle=handles.iterator().next(); if (winHandle!=firstWinHandle){ //To
	 * retrieve the handle of second window, extracting the handle which does
	 * not match to first window handle secondWinHandle=winHandle; //Storing
	 * handle of second window handle
	 * 
	 * //Switch control to new window driver.switchTo().window(secondWinHandle);
	 * //Control is switched now }
	 */

}

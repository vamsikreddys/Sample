package com.ps.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.Test.TrafficChannels;
import com.ps.TestSamples.AllSurveys;
import com.ps.base.TestBase;

public class TC_TrafficChannelflow extends TestBase{

	@Test(priority = 1)
	public static void TCCreation() throws Exception {
		
		Login.Buyerlogin1();

		Thread.sleep(2000);
		
		AllSurveys.TrafficChannelSurvey();

		TrafficChannels.Search();


		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//li//a[@role='tab'])[8]")));

		driver.findElement(By.xpath("(//li//a[@role='tab'])[8]")).click();

	}

	@Test(priority = 3)
	public static void tcchild() throws Exception {
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1333,365)");
		driver.findElement(
				By.cssSelector("html>body>div>div>section>div>div>div>div>div:nth-of-type(4)>ul>li:nth-of-type(8)>a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#trafficManagement>div>form>div>div>div>div>div>button:nth-of-type(2)"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@data-toggle='modal'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='SAVE & LAUNCH SURVEY']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#trafficManagement>div>form>div>div>div>div>div>button:nth-of-type(2)"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@id='trafficManagement']/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='SAVE & LAUNCH SURVEY']")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.cssSelector("html>body>div>div>section>div>div>div>div>div:nth-of-type(4)>ul>li:nth-of-type(8)>a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#trafficManagement>div>form>div>div>div>div>div>button:nth-of-type(2)"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@id='trafficManagement']/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]"))
				.click();

		driver.findElement(By.xpath("//button[text()='SAVE & LAUNCH SURVEY']")).click();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(1333,265)");
		Thread.sleep(4000);
		driver.findElement(By.id("#genderModal")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Census']")).click();
		driver.findElement(By.xpath("//button[@id='#rbModal']")).click();
		driver.findElement(By.xpath("(//button[text()='Census'])[2]")).click();
		driver.findElement(By.xpath("//button[@id='#rbModal']")).click();
		driver.findElement(By.xpath("//button[@id='#empModal']")).click();
		driver.findElement(By.xpath(
				"//form[@name='surveyform']/div[3]/div[1]/div[8]/div[1]/div[1]/div[1]/span[1]/ul[1]/li[1]/button[3]"))
				.click();
		driver.findElement(By.xpath("//button[@id='#empModal']")).click();

		js.executeScript("window.scrollBy(1333,1562)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Save & Launch Survey']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();

	}

	@Test(priority = 4)
		public static void verifyTC() throws Exception {
		
		///Login.Buyerlogin();
		
		//TrafficChannels.Search();

			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div/div/div[4]/ul/li[8]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(1333,565)");

			for (int i = 1; i < 5; i++)  {
				
				Thread.sleep(2000);
				String tCRRDefaultsurvey = driver.findElement(By.xpath("(//td[@class='text-left ng-binding'])[" + i + "]"))
						.getText();
				try {
					if (tCRRDefaultsurvey.startsWith("TC-UT")) {

						System.out.println("Survey No :" + i + "- UT Created");

					} else if (tCRRDefaultsurvey.startsWith("TC-UT")) {

						System.out.println("Survey No :" + i + "- UT Survey Created Successfully");

					} else if (tCRRDefaultsurvey.startsWith("TC-SA")) {

						System.out.println("Survey No :" + i + "- SPA Survey Created Successfully");

					}

					else if (tCRRDefaultsurvey.startsWith(surveytitle1)) {

						System.out.println("Survey No :" + i + "- Parent Survey Created Successfully");

					} else if (tCRRDefaultsurvey.startsWith("TC-R")) {

						System.out.println("Survey No :" + i + "- Replica Created Successfully");

					}

					else {

						System.out.println("No Survey Found");

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					driver.navigate().refresh();
				}

			}
	}
	
	
	@Test (priority = 5)
	public static void TCSearch () throws Exception {
		
		
		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();
		
	TrafficChannels.Search();
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div/div/div[4]/ul/li[8]")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(1333,565)");
		
		
	}
}

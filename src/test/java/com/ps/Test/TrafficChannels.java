package com.ps.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ps.TestSamples.AllSurveys;
import com.ps.base.TestBase;

public class TrafficChannels extends TestBase {

	

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
	
	
	@Test (priority = 9)
	public static void TCStatus () throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//driver.findElement(By.xpath("(//button[text()[normalize-space()='Live']])[2]"))
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])[3]")).click();
		
		driver.findElement(By.xpath("(//a[text()[normalize-space()='Paused']])[2]")).click();
		
		driver.findElement(By.xpath("//a[text()[normalize-space()='Save as Paused and Close']]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='status-change-modal']/div/div/div/div[2]/div[2]/p/span")));
		
		assertEquals(driver.findElement(By.xpath("//div[@id='status-change-modal']/div/div/div/div[2]/div[2]/p/span")).getText(), "Success!");
		
		Thread.sleep(2000);
		
		Login.logout();
		
		Login.Buyerlogin();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		driver.findElement(By.xpath("(//div//div//ul//li//a[contains(text(),'Paused')])[1]")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		TrafficChannels.Search();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
	
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//li//a[@role='tab'])[8]")));

		driver.findElement(By.xpath("(//li//a[@role='tab'])[8]")).click();
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id='user-options'])[7]")));
		
		 	try {
		 		
		 		Thread.sleep(3000);
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[4]")).getText(), "Paused");
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[5]")).getText(), "Paused");
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[6]")).getText(), "Paused");
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[7]")).getText(), "Paused");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				driver.navigate().refresh();
				Thread.sleep(2000);
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[4]")).getText(), "Paused");
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[5]")).getText(), "Paused");
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[6]")).getText(), "Paused");
				assertEquals(driver.findElement(By.xpath("(//button[@id='user-options'])[7]")).getText(), "Paused");
			}
		
	}
	
	
	
	public static void Search() throws Exception {

		// Login.Buyerlogin();

		Reporter.log("Buyer Login Successful");

		// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");

		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input[@type='text'])[2]")));

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveytitle5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input[@type='text'])[3]")));

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[3]")).click();

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[3]")).clear();

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[3]")).sendKeys(surveytitle5);
		}

		Thread.sleep(2000);
		
		int table = 10;

		for (int i = 1; i < table; i++) {
			
			Thread.sleep(1000);

			String Surveytitle = driver.findElement(By.xpath("(//tr//td[@class='survey-title ng-binding'])[" + i + "]"))
					.getText();

			System.out.println(Surveytitle);

			if (Surveytitle.contains(surveytitle5)) {

				driver.findElement(By.xpath("(//tr//td[@class='ng-binding'])[" + i + "]")).click();

				Reporter.log("Search Working Fine");

				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-left ng-binding']")));

				break;
			}

			/*
			 * String Surveytitle = driver.findElement(By.cssSelector(
			 * "div#live>div:nth-of-type(2)>table>tbody>tr>td:nth-of-type(3)")).getText();
			 * 
			 * System.out.println(Surveytitle);
			 * 
			 * Reporter.log("Seach Completed");
			 * 
			 * WebElement element = driver.findElement(By.cssSelector(
			 * "div#live>div:nth-of-type(2)>table>tbody>tr>td:nth-of-type(3)"));
			 * 
			 * wait.until(ExpectedConditions.visibilityOf(element));
			 * 
			 * if(Surveytitle.contains(surveytitle1)) {
			 * 
			 * driver.findElement(By.cssSelector(
			 * "div#live>div:nth-of-type(2)>table>tbody>tr>td:nth-of-type(3)")).click();
			 * 
			 * Reporter.log(Surveytitle);
			 * 
			 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.
			 * xpath("//h6[text()='Fielded vs. Goal']")));
			 * 
			 * Assert.assertTrue(true);
			 */

			else {

				Reporter.log("No element Found");
				System.out.println("No Survey Found");
				Assert.fail();

			}

		}
	
	
	}
	
}

package com.ps.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ps.base.TestBase;

public class QBPTest extends TestBase {

	@Test(priority = 0)
	public static void QBPSurvey() throws Exception {

		
		  try {
		  
			  driver.findElement(By.xpath("//img[@alt='Logo']")).click(); 
		  
		  } catch (Exception e1) { // TODO Auto-generated catch block
		  //Thread.sleep(2000);
			  Login.Buyerlogin1();
		  }

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='survey-title ng-binding']")));

		Thread.sleep(1000);

		// driver.get("http://platformstaging.spectrumsurveys.com/#/Login");

		Thread.sleep(2000);

		// Login.Buyerlogin();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

		Reporter.log("Create Survey Page opened");

		driver.findElement(By.name("surveyTitle")).sendKeys(surveytitle2 + " " + date1);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Survey_Sample_Title")));

		driver.findElement(By.id("Survey_Sample_Title")).click();

		driver.findElement(By.cssSelector(
				"html>body>div>div>section>div>div>div>form>div>div>div:nth-of-type(2)>div>ul>li:nth-of-type(2)>a"))
				.click();

		driver.findElement(By.id("completes")).sendKeys("100");

		driver.findElement(By.id("LengthofSurvey")).sendKeys("10");

		driver.findElement(By.id("incidence")).sendKeys("45");

		driver.findElement(By.id("field_time")).sendKeys("10");

		Reporter.log("Meta Data Entered Successfully");

		js.executeScript("window.scrollTo(0, 350)");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("#genderModal")));

		Thread.sleep(1000);

		try {
			driver.findElement(By.id("#genderModal")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.findElement(By.id("#genderModal")).click();
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Census']")).click();

		driver.findElement(By.id("#genderModal")).click();

		Reporter.log("Gender Census Added Successfully");

		// driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize &
		// Launch!']]")).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")));

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress container ng-scope']")));
		// Thread.sleep(3000);
		driver.findElement(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Supplier')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//th[text()[normalize-space()='FEASIBILITY']]")));

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		Reporter.log("Supplier Selected");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("liveUrl")));

		Reporter.log("Entered to Finalize and launch Page");

		driver.findElement(By.id("liveUrl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("liveUrl")).sendKeys(config.getProperty("liveurl"));

		driver.findElement(By.id("testUrl")).sendKeys(config.getProperty("testurl"));

		js.executeScript("window.scrollTo(0, 350)");

		driver.findElement(By.xpath("(//label//div[@class='slider round'])[6]")).click();

		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-default')])[3]")).click();

		driver.findElement(By.xpath("//button[text()='Launch Your Survey']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding']")));

		Reporter.log("Survey Created Successfully");

	}

	@Test(priority = 1)
	public static void Search() throws Exception {

		// Login.Buyerlogin();

		driver.findElement(By.xpath("//img[@alt='Logo']")).click();

		Reporter.log("Buyer Login Successful");

		// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input[@type='text'])[2]")));

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveytitle2);

		Thread.sleep(2000);

		int table = 10;

		for (int i = 1; i < table; i++) {

			String Surveytitle = driver.findElement(By.xpath("(//tr//td[@class='survey-title ng-binding'])[" + i + "]"))
					.getText();

			System.out.println(Surveytitle);

			if (Surveytitle.contains(surveytitle2)) {

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

	@Test(priority = 2)
	public static void VerifyDashboard() {

		Reporter.log("Survey Dashboard Verification Started");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/thead/tr/th/span/span")));

		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/thead/tr/th/span/span"))
				.getText(), "Gender");
		assertEquals(driver.findElement(By.xpath("(//div//span[@class='ng-scope'])[1]")).getText(), "QBP");
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td/div/div"))
				.getText(), "Male");
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody[2]/tr/td/div/div"))
				.getText(), "Female");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td[2]")).getText(),
				"0 | 30");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody[2]/tr/td[2]")).getText(),
				"0 | 70");

		Reporter.log("Survey Dashboard Verified after Creating Survey");

	}

	@Test(priority = 3)
	public static void VerifyCPIoverride() throws Exception {

		Reporter.log("Started VerifyCPIoverride ");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(3000);

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.xpath("(//td//div//div//i[@class='fa fa-ellipsis-h'])[1]")).click();

		driver.findElement(By.xpath("//div//ul//li//a[contains(text(),'PRICING')]")).click();

		driver.findElement(By.xpath("//div//div[@class='glyphicon glyphicon-pencil']")).click();

		driver.findElement(By.xpath("//input[contains(@class,'inputText hover-font-color')]")).clear();

		driver.findElement(By.xpath("//input[contains(@class,'inputText hover-font-color')]"))
				.sendKeys(config.getProperty("Qbp1Cpi"));

		driver.findElement(By.xpath("//div[@ng-show='editStateModal']//div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();

		Reporter.log("Entered QBP 1 CPI Value Successfully ");

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress
		// container ng-scope']")));
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//td//div//div//i[@class='fa fa-ellipsis-h'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div//ul//li//a[contains(text(),'PRICING')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div//div[@class='glyphicon glyphicon-pencil']")).click();

		driver.findElement(By.xpath("//input[contains(@class,'inputText hover-font-color')]")).clear();

		driver.findElement(By.xpath("//input[contains(@class,'inputText hover-font-color')]"))
				.sendKeys(config.getProperty("Qbp2Cpi"));

		driver.findElement(By.xpath("//div[@ng-show='editStateModal']//div[1]")).click();

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress container ng-scope']")));

		driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();

		Reporter.log("Entered QBP 2 CPI Value Successfully ");

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress
		// container ng-scope']")));

		driver.findElement(By.xpath("(//li//a[@role='tab'])[3]")).click();

		Reporter.log("Selected Supplier Tab ");

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		assertEquals(driver.findElement(By.xpath("(//tr[@data-target='#collps0']//td)[3]")).getText(), "$7.5");
		assertEquals(driver.findElement(By.xpath("(//tr[@data-target='#collps1']//td)[3]")).getText(), "$7.5");
		assertEquals(driver.findElement(By.xpath("(//tr[@data-target='#collps2']//td)[3]")).getText(), "$7.5");

		Reporter.log("Supplier CPI Verified Successfully ");

		Login.operatorlogout();

	}

}

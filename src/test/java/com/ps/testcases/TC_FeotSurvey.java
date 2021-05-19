package com.ps.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.base.TestBase;

public class TC_FeotSurvey extends TestBase{
  
	
	

  
	@Test(priority = 1)
	
	public void FeotSurvey () throws Exception {
		
		Login.Buyerlogin();
		
		log.info("Entered to Survey Page");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

		Reporter.log("Create Survey Page opened");

		driver.findElement(By.name("surveyTitle")).sendKeys("R-Feot" + " " + date1);

		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		driver.findElement(By.id("Survey_Sample_Title")).click();

		driver.findElement(By.cssSelector(
				"html>body>div>div>section>div>div>div>form>div>div>div:nth-of-type(2)>div>ul>li:nth-of-type(2)>a"))
				.click();

		driver.findElement(By.id("completes")).sendKeys("100");

		driver.findElement(By.id("LengthofSurvey")).sendKeys("1");

		driver.findElement(By.id("incidence")).sendKeys("45");

		driver.findElement(By.id("field_time")).sendKeys("10");

		log.info("Meta Data Entered Successfully");
		
		driver.findElement(By.xpath("//span[text()='Completes']")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		js.executeScript("window.scrollTo(0, 350)");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("#genderModal")));
		
	
			driver.findElement(By.id("#genderModal")).click();
		

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Census']")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("#genderModal")).click();

		log.info("Gender Census Added Successfully");

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

		log.info("Supplier Selection Done from CPI Drop down");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();
		
		log.info("Clicked on Finalize and launch");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("liveUrl")));

		Reporter.log("Entered to Finalize and launch Page");

		driver.findElement(By.id("liveUrl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("liveUrl")).sendKeys(config.getProperty("liveurl"));

		driver.findElement(By.id("testUrl")).sendKeys(config.getProperty("testurl"));
		
		log.info("Live and test url Entered");

		js.executeScript("window.scrollTo(0, 350)");

		driver.findElement(By.xpath("(//label//div[@class='slider round'])[5]")).click();
		
		log.info("Enabled FEOT");

		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-default')])[3]")).click();

		driver.findElement(By.xpath("//button[text()='Launch Your Survey']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding']")));

		Reporter.log("Survey Created Successfully");
		
		log.info("Survey Launched Successfully");
	}
	
	
	@Test(priority = 2)
	public void search () throws Exception {
		
		Login.Buyerlogin();

				driver.findElement(By.xpath("//img[@alt='Logo']")).click();
				
				log.info("Redirected to dashboard");

				//Reporter.log("Buyer Login Successful");

				// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");

				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input[@type='text'])[2]")));

				driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();
				
				log.info("Search Started");

				driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

				driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys("R-Feot");

				Thread.sleep(2000);

				int table = 10;

				for (int i = 1; i < table; i++) {

					String Surveytitle = driver.findElement(By.xpath("(//tr//td[@class='survey-title ng-binding'])[" + i + "]"))
							.getText();

					System.out.println(Surveytitle);

					if (Surveytitle.contains("R-Feot")) {

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
				
				log.info("Search Completed , Survey Found");

		
		
	}
	
	@Test (priority = 3)
	public void verifydashboard () throws Exception {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//th[@class='text-left'])[2]")));
		
		Thread.sleep(2000);
		
		log.info("Start verifying Buyer Dashboard");
		
		assertEquals(driver.findElement(By.xpath("(//th[@class='text-left'])[2]")).getText(), "Gender");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-left ng-scope']")).getText(), "Male");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-left ng-scope'])[2]")).getText(), "Female");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-center ng-binding']")).getText(), "0 | 60");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-center ng-binding'])[3]")).getText(), "0 | 40");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-center min-wid-130']")).getText(), "6");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-center min-wid-130'])[2]")).getText(), "4");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-center']")).getText(), "6");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-center'])[3]")).getText(), "4");
		
		log.info("Buyer dashboard Verification Completed");
	}
	
	@Test (priority = 4)
	public void RemoveFeot() throws Exception {
		
		driver.findElement(By.linkText("Edit Details")).click();
		
		log.info("Entered to Edit Step 3");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0, 350)");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//label//div[@class='slider round'])[5]")).click();
		Thread.sleep(1000);
		log.info("Disabled FEOT ");
		driver.findElement(By.xpath("//button[text()[normalize-space()='Save Changes']]")).click();
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//h2[@class='text-left ng-binding']"))));
		
		
	}
	
	
	@Test (priority = 5)
	public void verifydashboard2 () throws Exception {
		
		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//th[@class='text-left'])[2]")));
		
		Thread.sleep(2000);
		log.info("Buyer dashboard Verification started");
		assertEquals(driver.findElement(By.xpath("(//th[@class='text-left'])[2]")).getText(), "Gender");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-left ng-scope']")).getText(), "Male");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-left ng-scope'])[2]")).getText(), "Female");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-center ng-binding']")).getText(), "0 | 60");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-center ng-binding'])[3]")).getText(), "0 | 40");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-center min-wid-130']")).getText(), "60");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-center min-wid-130'])[2]")).getText(), "40");
		assertEquals(driver.findElement(By.xpath("//td[@class='text-center']")).getText(), "60");
		assertEquals(driver.findElement(By.xpath("(//td[@class='text-center'])[3]")).getText(), "40");
		log.info("Buyer dashboard Verification Completed");
	}
  
  
}

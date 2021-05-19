package com.ps.TestSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import com.ps.Test.Login;
import com.ps.base.TestBase;

public class AllSurveys extends TestBase{
  
	
  public static void NormalSurvey() throws Exception {
	  

		driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

		Reporter.log("Create Survey Page opened");

		driver.findElement(By.name("surveyTitle")).sendKeys(surveytitle1 + " " + date1);

		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		driver.findElement(By.id("Survey_Sample_Title")).click();

		driver.findElement(By.cssSelector(
				"html>body>div>div>section>div>div>div>form>div>div>div:nth-of-type(2)>div>ul>li:nth-of-type(2)>a"))
				.click();

		driver.findElement(By.id("completes")).sendKeys("100");

		driver.findElement(By.id("LengthofSurvey")).sendKeys("10");

		driver.findElement(By.id("incidence")).sendKeys("45");

		driver.findElement(By.id("field_time")).sendKeys("10");

		Reporter.log("Meta Data Entered Successfully");

		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")));
		
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress container ng-scope']")));
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Supplier')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//th[text()[normalize-space()='FEASIBILITY']]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("liveUrl")));

		driver.findElement(By.id("liveUrl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("liveUrl")).sendKeys(config.getProperty("liveurl"));

		driver.findElement(By.id("testUrl")).sendKeys(config.getProperty("testurl"));

		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-default')])[3]")).click();

		driver.findElement(By.xpath("//button[text()='Launch Your Survey']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding']")));

		Reporter.log("Normal Survey Created Successfully");
  }
  
  public static void HTsurvey() throws Exception {
	  
	  
	  try {
			Login.Buyerlogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Login.logout();
			
			Login.Buyerlogin();
		}

			driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

			Reporter.log("Create Survey Page opened");

			driver.findElement(By.name("surveyTitle")).sendKeys(surveytitle3 + " " + date1);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Survey_Sample_Title")));
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"loader-wrapper\"]")));
			

			driver.findElement(By.id("Survey_Sample_Title")).click();

			driver.findElement(By.cssSelector(
					"html>body>div>div>section>div>div>div>form>div>div>div:nth-of-type(2)>div>ul>li:nth-of-type(2)>a"))
					.click();

			driver.findElement(By.id("completes")).sendKeys("100");

			driver.findElement(By.id("LengthofSurvey")).sendKeys("1");

			driver.findElement(By.id("incidence")).sendKeys("45");

			driver.findElement(By.id("field_time")).sendKeys("10");

			Reporter.log("Meta Data Entered Successfully");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			driver.findElement(By.xpath("(//div//button[@data-target='#advanceTargetingModal'])[1]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//div//input[@placeholder='Start typing ...'])")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//div//input[@placeholder='Start typing ...'])")).sendKeys("pet owner");
			Thread.sleep(1000);
			
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//div//div[contains(text(),'Pet')])")));
			
			driver.findElement(By.xpath("(//div//div[contains(text(),'Pet')])")).click();
			
			driver.findElement(By.xpath("//*[@id=\"advanceTargetingModal\"]/div/div")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div//div//input[@placeholder='Pick something']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div//div[@class='option'])")).click();
			driver.findElement(By.xpath("(//div//div[@class='option'])[1]")).click();
			driver.findElement(By.xpath("(//div//div[@class='option'])[2]")).click();
			driver.findElement(By.xpath("(//div//div[@class='option'])[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Question Description:']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'Apply Targeting')]")).click();

			//driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();
			Thread.sleep(2000);
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")));
			
			wait.until(
					ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress container ng-scope']")));
			//Thread.sleep(3000);
			driver.findElement(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")).click();

			driver.findElement(By.xpath("//button[contains(text(),'Supplier')]")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//th[text()[normalize-space()='FEASIBILITY']]")));

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			

			driver.findElement(By.xpath("//button[text()='Save']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")));
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("liveUrl")));

			driver.findElement(By.id("liveUrl")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("liveUrl")).sendKeys(config.getProperty("liveurl"));

			driver.findElement(By.id("testUrl")).sendKeys(config.getProperty("testurl"));

			driver.findElement(By.xpath("(//button[contains(@class,'btn btn-default')])[3]")).click();

			driver.findElement(By.xpath("//button[text()='Launch Your Survey']")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding']")));

			Reporter.log("HT Survey Created Successfully");
  }
  
  public static void QBPsurvey() throws Exception {
	  
	  driver.findElement(By.xpath("//img[@alt='Logo']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='survey-title ng-binding']")));
		
		Thread.sleep(1000);
		
		//driver.get("http://platformstaging.spectrumsurveys.com/#/Login");
		
		Thread.sleep(2000);
		
		//Login.Buyerlogin();
		
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

		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")));
		
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress container ng-scope']")));
		//Thread.sleep(3000);
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

		Reporter.log("QBP Survey Created Successfully");
		
  }
  
  
  public static void TrafficChannelSurvey() throws Exception {
	  

		driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

		Reporter.log("Create Survey Page opened");

		driver.findElement(By.name("surveyTitle")).sendKeys(surveytitle5 + " " + date1);

		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		driver.findElement(By.id("Survey_Sample_Title")).click();

		driver.findElement(By.cssSelector(
				"html>body>div>div>section>div>div>div>form>div>div>div:nth-of-type(2)>div>ul>li:nth-of-type(2)>a"))
				.click();

		driver.findElement(By.id("completes")).sendKeys("100");

		driver.findElement(By.id("LengthofSurvey")).sendKeys("10");

		driver.findElement(By.id("incidence")).sendKeys("45");

		driver.findElement(By.id("field_time")).sendKeys("10");

		Reporter.log("Meta Data Entered Successfully");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")));
		
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress container ng-scope']")));
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Supplier')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//th[text()[normalize-space()='FEASIBILITY']]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("liveUrl")));

		driver.findElement(By.id("liveUrl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("liveUrl")).sendKeys(config.getProperty("liveurl"));

		driver.findElement(By.id("testUrl")).sendKeys(config.getProperty("testurl"));

		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-default')])[3]")).click();

		driver.findElement(By.xpath("//button[text()='Launch Your Survey']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding']")));

		Reporter.log("TC Survey Created Successfully");
  }
  
  
}

package com.production;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ps.base.TestBase;

public class Defaultsurvey extends TestBase{
	
	
	@Test(priority = 0)
	public static void Buyerlogin () {
		
		driver.get("https://platform.purespectrum.com/#/login");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
		
		try {
			try {
				driver.findElement(By.id("LoginEmail")).sendKeys(OR.getProperty("buyerusername1"));
				driver.findElement(By.id("LoginPassword")).sendKeys(OR.getProperty("Buyerpassword1"));
				driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				driver.findElement(By.xpath("(//img[@class='img-responsive'])[2]")).click();
				driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/dynamicheader[1]/div[1]/ul[1]/li[8]/a[1]")).click();
			}
		} catch (Exception e) {
			
			driver.findElement(By.xpath("//dynamicheader//div//button[@id='user-options']")).click();
			
			driver.findElement(By.xpath("//ul//li//a[contains(text(),'Logout')]")).click();
			
			Buyerlogin();
		}
		
	}
	
	@Test(priority = 1)
	public static void createsurvey () throws Exception {
		
		
		driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

		Reporter.log("Create Survey Page opened");

		driver.findElement(By.name("surveyTitle")).sendKeys(surveytitle1 + " " + date1);

		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		Thread.sleep(1000);

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

		Reporter.log("Survey Created Successfully");
	}
		
	}
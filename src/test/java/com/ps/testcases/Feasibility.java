package com.ps.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.inject.spi.Element;
import com.ps.Test.Login;
import com.ps.base.TestBase;

public class Feasibility extends TestBase{
	
	
	public static void feasCPI () throws Exception {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//h6//span[@ng-if='showDotAtLoad'])[2]")));
		Thread.sleep(1000);
		
		String feas = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[1]")).getText();
		
		Thread.sleep(1000);
		
		System.out.println("Feasibility = " + feas);
		
		String  CPI = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[2]")).getText();
		
		System.out.println(CPI);
		
		
	}

	@Test
	public void feasibility() throws Exception {
		
		
		Login.Buyerlogin();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

		Reporter.log("Create Survey Page opened");

		driver.findElement(By.name("surveyTitle")).sendKeys("R-Feasibility" + " " + date1);

		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		driver.findElement(By.id("Survey_Sample_Title")).click();

		driver.findElement(By.cssSelector(
				"html>body>div>div>section>div>div>div>form>div>div>div:nth-of-type(2)>div>ul>li:nth-of-type(2)>a"))
				.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		driver.findElement(By.id("completes")).sendKeys("100");

		driver.findElement(By.id("LengthofSurvey")).sendKeys("1");

		driver.findElement(By.id("incidence")).sendKeys("45");

		driver.findElement(By.id("field_time")).sendKeys("10");

		Reporter.log("Meta Data Entered Successfully");
		
		driver.findElement(By.xpath("//label[@for='completes']")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//h6//span[@ng-if='showDotAtLoad'])[2]")));
		Thread.sleep(1000);
		
		String feas = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[1]")).getText();
		
		Thread.sleep(1000);
		
		System.out.println(feas);
		
		String  CPI = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[2]")).getText();
		
		System.out.println(CPI);
		
		assertEquals(feas, "26,315");
		
		assertEquals(CPI, "$3.44");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
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
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//h6//span[@ng-if='showDotAtLoad'])[2]")));
		Thread.sleep(1000);
		
		String feas1 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[1]")).getText();
		
		Thread.sleep(1000);
		
		System.out.println(feas1);
		
		String  CPI1 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[2]")).getText();
		
		System.out.println(CPI1);
		
		assertEquals(feas1, "26,314");
		
		assertEquals(CPI1, "$3.44");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("#genderModal")));

		Thread.sleep(1000);

		try {
			driver.findElement(By.id("#genderModal")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.findElement(By.id("#genderModal")).click();
		}
		
		//driver.findElement(By.id("#genderModal")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@data-ng-click='parentDisabled?return:deselectAll(true,checkAllLabel);']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='×'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("#genderModal")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("#genderModal")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//h6//span[@ng-if='showDotAtLoad'])[2]")));
		Thread.sleep(1000);
		
		String feas2 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[1]")).getText();
		
		Thread.sleep(1000);
		
		System.out.println(feas2);
		
		assertEquals(feas2, "15,789");
		
		String  CPI2 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[2]")).getText();
		
		System.out.println(CPI2);
		
		assertEquals(CPI2, "$3.44");
		
		try {
			driver.findElement(By.id("#genderModal")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.findElement(By.id("#genderModal")).click();
		}
		
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//ul//li//a//span[@class='glyphicon glyphicon-ok'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Census']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("#genderModal")).click();
		
		Reporter.log("Gender Census Added Successfully");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//h6//span[@ng-if='showDotAtLoad'])[2]")));
		Thread.sleep(1000);
		
		String feas3 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[1]")).getText();
		
		Thread.sleep(1000);
		
		System.out.println(feas3);
		
		assertEquals(feas3, "26,314");
		
		String  CPI3 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[2]")).getText();
		
		System.out.println(CPI3);
		
		assertEquals(CPI3, "$3.44");
		
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		driver.findElement(By.xpath("(//div//button[@data-target='#advanceTargetingModal'])[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div//input[@placeholder='Start typing ...'])")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div//input[@placeholder='Start typing ...'])")).sendKeys("1031");
		Thread.sleep(2000);
		
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div//div[contains(text(),'Pet Ownership')])")));
		
		driver.findElement(By.xpath("(//div//div[contains(text(),'Pet Ownership')])")).click();
		
		driver.findElement(By.xpath("//*[@id=\"advanceTargetingModal\"]/div/div")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div//div//input[@placeholder='Pick something']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div//div[@class='option'])")).click();
		//driver.findElement(By.xpath("(//div//div[@class='option'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Question Description:']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Apply Targeting')]")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//h6//span[@ng-if='showDotAtLoad'])[2]")));
		Thread.sleep(1000);
		
		String feas4 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[1]")).getText();
		
		Thread.sleep(1000);
		
		System.out.println(feas4);
		
		assertEquals(feas4, "15,789");
		
		String  CPI4 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[2]")).getText();
		
		System.out.println(CPI4);
		
		assertEquals(CPI4, "$17.19");
		
		driver.findElement(By.xpath("//i[@class='fa fa-window-close']")).click();
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//h6//span[@ng-if='showDotAtLoad'])[2]")));
		Thread.sleep(1000);
		
		String feas5 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[1]")).getText();
		
		Thread.sleep(1000);
		
		System.out.println(feas5);
		
		assertEquals(feas5, "26,314");
		
		String  CPI5 = driver.findElement(By.xpath("(//span[contains(@class,'feas-count ng-binding')])[2]")).getText();
		
		System.out.println(CPI5);
		
		assertEquals(CPI5, "$3.44");
		
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
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		Thread.sleep(2000);
		
		
		String winHandleBefore = driver.getWindowHandle();
		
		 // Switch to new window opened
		  for(String winHandle : driver.getWindowHandles()){
		      driver.switchTo().window(winHandle);
		  }

		  Thread.sleep(2000);
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='ng-binding ng-scope']")));
		
		Thread.sleep(5000);

		driver.findElement(By.id("ans000_229")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ans000_229")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("ans000_229")).sendKeys("12345");
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[@id='answerid-244']/span")).click();
		//Thread.sleep(1000);
		///driver.findElement(By.linkText("White")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='answerid-211']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Female")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='answerid-235']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("1998")).click();
		Thread.sleep(2000);
		driver.findElement(By.tagName("button")).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//center[text()='Uh-oh, something went wrong. Please close this page and return to your survey provider']")));
		
		System.out.println("Test Button Working as Expected");
		
		//Switch back to original browser (first window)
	     driver.switchTo().window(winHandleBefore);
		
		
		
		
	}
}

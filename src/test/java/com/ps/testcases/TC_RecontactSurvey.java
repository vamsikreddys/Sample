package com.ps.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.base.TestBase;

public class TC_RecontactSurvey extends TestBase {

	@Test (priority = 1)
	public void recontactCreation() throws Exception {

		Login.Buyerlogin();
		log.info("Buyer LOgin Successful");
		
		{
			WebElement element = driver.findElement(By.cssSelector(".btn"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@ng-model='searchSurvey.query'])[2]")));
		
		driver.findElement(By.cssSelector("#decipherList > .fa")).click();
		driver.findElement(By.cssSelector(".decipherBut a")).click();
		driver.findElement(By.id("SurveyTitle")).click();
		driver.findElement(By.id("SurveyTitle")).sendKeys("R-Recontact Survey");
		driver.findElement(By.id("LengthofSurvey")).click();
		driver.findElement(By.id("LengthofSurvey")).sendKeys("10");
		driver.findElement(By.id("incidence")).sendKeys("45");
		driver.findElement(By.id("fieldTime")).sendKeys("10");
		driver.findElement(By.cssSelector(".form-inline:nth-child(4) > .col-sm-8 > #SurveyTitle")).click();
		driver.findElement(By.cssSelector(".form-inline:nth-child(4) > .col-sm-8 > #SurveyTitle"))
				.sendKeys("http://b_emulator.purespectrum.net:3000/emulated_surveys");
		log.info("Meta Data Entered Successfully");
		driver.findElement(By.linkText("Upload a file"))
				.sendKeys("C:\\Users\\Vamsi Reddy\\Downloads\\incl_excl (3).csv");
		log.info("File uploaded Successfully");
		// driver.findElement(By.xpath("//input[@type='file']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Upload a file"))
				.sendKeys(System.getProperty("user.dir")+"/src/PSID/incl_excl.csv");
		//System.out.println(System.getProperty("user.dir"));
		log.info("File uploaded Successfully1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".col-xs-4 > .btn")).click();
		log.info("Survey Launched Successfully");
	}
	
	@Test(priority = 2)
	public void Vaidate () throws InterruptedException {
		
		//Login.Buyerlogin();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@ng-model='searchSurvey.query'])[2]")).click();
		
		driver.findElement(By.xpath("(//input[@ng-model='searchSurvey.query'])[2]")).sendKeys("R-Recontact");
		Thread.sleep(2000);
		log.info("Search for Recontact Survey");
		
		for (int i = 1; i < 10; i++) {
			
			Thread.sleep(1000);
			
			String surveyname = driver.findElement(By.xpath("//td[@class='survey-title ng-binding']["+i+"]")).getText();
			System.out.println(surveyname);
			log.info("SurveyName Searching");
			if (surveyname.contains("R-Recontact")) {
				
				driver.findElement(By.xpath("//div[@id='live']/div[2]/table[1]/tbody[1]/tr["+i+"]/td[2]")).click();
				log.info("SurveyName Found");
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-left ng-binding']")));
				break;
				
			}
			
			else {
				
				System.out.println("Survey Not Found");
				log.error("SurveyName Not Found !! Please Check");
			}
		}
		
	}
	
	@Test(priority = 3)
	public void verify () throws InterruptedException {
		
			Thread.sleep(2000);
			log.info("Recontact Survey opened");
			assertEquals(driver.findElement(By.xpath("//h2")).getText(), "R-Recontact Survey");
			log.info("Title Validated");
			String  completes = driver.findElement(By.xpath("(//p[@class='ng-binding'])[3]")).getText();
			
			assertEquals(completes, "0 | 3");
			log.info("Completes Validated");
		    driver.findElement(By.xpath("//section/div/div/div/div")).click();
		    
		    driver.findElement(By.xpath("(//a[@data-toggle='tab'])[3]")).click();
		    log.info("Supplier tab opened");
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    
		    Thread.sleep(2000);
		    log.info("Suppliers Found");
		    String pramodNagar = driver.findElement(By.xpath("//td[@class='text-left ng-binding']")).getText();
		    String globalTestSupplier = driver.findElement(By.xpath("(//td[@class='text-left ng-binding'])[2]")).getText();
		    assertEquals(pramodNagar, "PramodNagar");
		    assertEquals(globalTestSupplier, "Global Test Supplier");
		    log.info("Suppliers Validated");
		    assertEquals(driver.findElement(By.xpath("//div[@id='suppliers']/div/div/table[2]/tbody/tr/td[3]")).getText(), "$48.8");
		    assertEquals(driver.findElement(By.xpath("//div[@id='suppliers']/div/div/table[2]/tbody/tr/td[4]")).getText(), "3");
		    assertEquals(driver.findElement(By.xpath("//div[@id='suppliers']/div/div/table[2]/tbody[2]/tr/td[4]")).getText(), "3");
		    assertEquals(driver.findElement(By.xpath("//div[@id='suppliers']/div/div/table[2]/tbody/tr/td[5]")).getText(), "0  |  3");
		    log.info("Supplier Data Validated");
	}
	
	@Test(priority = 4)
	
	public void closerecontact () throws InterruptedException {
		
		Thread.sleep(1000);
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		 js.executeScript("window.scrollTo(0, 0)");
		    
		    Thread.sleep(1000);
		    
		    driver.findElement(By.xpath("//button[text()[normalize-space()='Live']]")).click();
		    
		    driver.findElement(By.xpath("(//a[@data-toggle='modal'])[2]")).click();
		    
		    driver.findElement(By.linkText("Save as Closed and Close")).click();
		    
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='pull-right invoiceSurveyBtn']")));
		    
		    String invoiceSurvey = driver.findElement(By.xpath("//a[@class='pull-right invoiceSurveyBtn']")).getText();
		    
		    System.out.println(invoiceSurvey);
		    
		   assertEquals(invoiceSurvey, "Invoice Survey");
		    
		    Thread.sleep(2000);
		    
	}
}

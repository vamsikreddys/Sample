package com.ps.rough;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.base.TestBase;

public class QbP extends TestBase {

	@Test
	public static void verify() throws Exception {

		Login.Operatorlogin();

		Search.SearchQBPChild1();

		verifyq();

	}

	public static void verifyq() throws Exception {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td/div/div")));
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td/div/div"))
				.getText(), "Male");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td[2]")).getText(),
				"4 | 60");
		
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[3]")).click();
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	
		
		assertEquals(driver.findElement(By.xpath("//div[@id='suppliers']/div/div/div[2]/table[2]/tbody/tr/td")).getText(), "Peanut Lab Supplier");
	    assertEquals(driver.findElement(By.xpath("//div[@id='suppliers']/div/div/div[2]/table[2]/tbody[2]/tr/td")).getText(), "PramodNagar");
	    assertEquals(driver.findElement(By.xpath("//div[@id='suppliers']/div/div/div[2]/table[2]/tbody[3]/tr/td")).getText(), "Global Test Supplier");
	    
	    
	    driver.findElement(By.xpath("(//a[@data-toggle='tab'])[5]")).click();
	    
	    Thread.sleep(1000);
	    
	    String surveyid = driver.findElement(By.xpath("(//tbody//tr//td[@class='ng-binding'])[2]")).getText();
	    
	    System.out.println(surveyid);
	    
	    Thread.sleep(1000);
	    
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    
		// Store the current window handle ***Acts as a Ladder***
		  String winHandleBefore = driver.getWindowHandle();


		  // Switch to new window opened
		  for(String winHandle : driver.getWindowHandles()){
		      driver.switchTo().window(winHandle);
		  
		  }
		  
		  driver.get("https://staging.spectrumsurveys.com/#/start-survey?survey_id=" + surveyid
					+ "&supplier_id=36&bsec=a70mx8&ps_simu_forced_loi=555&ps_simu_forced_status=21&ps_supplier_respondent_id=456&ps_byr_simuenv=staging");

			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h4")));

			Thread.sleep(5000);

			driver.findElement(By.id("ans000_229")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ans000_229")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("ans000_229")).sendKeys("12345");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='answerid-211']/span")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Male")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='answerid-235']/span")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("1998")).click();
			Thread.sleep(1000);
			driver.findElement(By.className("img-responsive")).click();

			Thread.sleep(2000);

			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//table//thead//tr//th)[3]")));

		 
		  
		  driver.switchTo().window(winHandleBefore);
		  
		  
        
	    Thread.sleep(30000);
	    
	}
	
	

}

package com.ps.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ps.Test.HTtest;
import com.ps.base.TestBase;
import com.ps.rough.Search;

public class Hyper extends TestBase{
  
	
	@Test(priority = 0)
  public static void Login() throws Exception {
		
		HTtest.HTCreation();
		
		com.ps.Test.Login.Operatorlogin();
		
		Search.SearchHTParent();
		
  }
	@Test(priority = 1)
	public static void HTPresp1 () throws Exception {
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li//a[@role='tab'])[5]")));
		
		driver.findElement(By.xpath("(//li//a[@role='tab'])[5]")).click();

		Thread.sleep(2000);

		String surveyid = driver.findElement(By.xpath("(//table//tbody//tr//td[@class='ng-binding'])[1]")).getText();

		System.out.println(surveyid);
		
		driver.get("https://staging.spectrumsurveys.com/#/start-survey?survey_id=" + surveyid +" &supplier_id=36&bsec=a70mx8&ps_simu_forced_loi=555&ps_simu_forced_status=21&ps_supplier_respondent_id=456&ps_byr_simuenv=staging");
		
		Thread.sleep(5000);

		driver.findElement(By.id("ans000_229")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ans000_229")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("ans000_229")).sendKeys("12345");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='answerid-244']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("White")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='answerid-211']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Female")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='answerid-235']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("1998")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='ng-binding'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='ng-binding'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("button")).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//table//thead//tr//th)[3]")));

	}
	
	@Test(priority = 3)
	public static void VerifyHTParent () throws Exception {
		
		com.ps.Test.Login.Operatorlogin();
		
		Search.SearchHTParent();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-binding ng-scope']")));
		
		Thread.sleep(2000);
		
		String  CPI = driver.findElement(By.xpath("(//span[@class='ng-binding ng-scope'])[1]")).getText();
		
		Assert.assertEquals(CPI, "$30.78");
		
		String  Completes = driver.findElement(By.xpath("(//p[@class='ng-binding'])[3]")).getText();
		
		Assert.assertEquals(Completes, "6 | 100");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0, 350)");
		
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td[2]")).getText(), "0 | 30");
	    assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody[2]/tr/td[2]")).getText(), "6 | 70");
	    assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div[2]/div/table[2]/tbody/tr/td[2]")).getText(), "6 | 16");
	    assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div[2]/div/table[2]/tbody[2]/tr/td[2]")).getText(), "0 | 16");
	    assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div[2]/div/table[2]/tbody[3]/tr/td[2]")).getText(), "0 | 16");
	    assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div[2]/div/table[2]/tbody[4]/tr/td[2]")).getText(), "0 | 16");
		
	}
	
}

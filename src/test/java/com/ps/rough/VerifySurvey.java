package com.ps.rough;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ps.base.TestBase;

public class VerifySurvey extends TestBase {

	public static void HTParent() throws Exception {

		String ParentGoal = driver.findElement(By.xpath("(//div//div//p[@class='ng-binding'])[3]")).getText();

		System.out.println(ParentGoal);

		String ParentTR = driver.findElement(By.xpath("(//div//span[@class='ng-binding ng-scope'])[1]")).getText();

		System.out.println(ParentTR);

		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(0, 250)");

		String content = driver.findElement(By.xpath("//div[@class='tab-content']")).getText();

		System.out.println(content);

		Thread.sleep(3000);
		// assertEquals(driver.findElement(By.xpath("//h2")).getText(), surveytitle1);
		assertEquals(driver.findElement(By.xpath("//div[2]/span")).getText(), "$0.00");
		assertEquals(driver.findElement(By.xpath("//div[3]/div[4]/span")).getText(), "$24.41");
		assertEquals(driver.findElement(By.xpath("//div[3]/div/div/p")).getText(), "0 | 100");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		assertEquals(
				driver.findElement(By.xpath("//div//div//div//p[contains(text(),'Survey has no Quotas')]")).getText(),
				"SURVEY HAS NO QUOTAS");

	}

	public static void HTChild() throws Exception {

		String ParentGoal1 = driver.findElement(By.xpath("(//div//div//p[@class='ng-binding'])[3]")).getText();

		System.out.println(ParentGoal1);

		String ParentTR1 = driver.findElement(By.xpath("(//div//span[@class='ng-binding ng-scope'])[1]")).getText();

		System.out.println(ParentTR1);

		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(0, 250)");

		String content1 = driver.findElement(By.xpath("//div[@class='tab-content']")).getText();

		System.out.println(content1);

		Thread.sleep(3000);
		// assertEquals(driver.findElement(By.xpath("//h2")).getText(), surveytitle1);
		assertEquals(driver.findElement(By.xpath("//div[2]/span")).getText(), "$0.00");
		assertEquals(driver.findElement(By.xpath("//div[3]/div[4]/span")).getText(), "$17.09");
		assertEquals(driver.findElement(By.xpath("//div[3]/div/div/p")).getText(), "0 | 100");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		assertEquals(
				driver.findElement(By.xpath("//div//div//div//p[contains(text(),'Survey has no Quotas')]")).getText(),
				"SURVEY HAS NO QUOTAS");

	}
	
	public static void HTParentafteradding() throws Exception {
		
		Thread.sleep(2000);
		
		String Quota1 = "Gender\n" + 
				"Fielded Vs Goal Current Target\n" + 
				"Currently Open Quota Progress In Progress\n" + 
				"Male\n" + 
				"0 | 30\n" + 
				"30\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"30\n" + 
				"0\n" + 
				"Female\n" + 
				"0 | 70\n" + 
				"70\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"70\n" + 
				"0";
		String Quota2 = "Race/Ethnicity\n" + 
				"Fielded Vs Goal Current Target\n" + 
				"Currently Open Quota Progress In Progress\n" + 
				"White\n" + 
				"0 | 16\n" + 
				"16\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"16\n" + 
				"0\n" + 
				"Black or African American\n" + 
				"0 | 16\n" + 
				"16\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"16\n" + 
				"0\n" + 
				"Asian\n" + 
				"0 | 16\n" + 
				"16\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"16\n" + 
				"0\n" + 
				"Native Hawaiian or Other Pacific Islander\n" + 
				"0 | 16\n" + 
				"16\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"16\n" + 
				"0\n" + 
				"American Indian or Alaska Native\n" + 
				"0 | 16\n" + 
				"16\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"16\n" + 
				"0\n" + 
				"Other Race\n" + 
				"0 | 20\n" + 
				"20\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"20\n" + 
				"0";
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		String container1 = driver.findElement(By.xpath("(//div[@class='container_list'])[1]")).getText();
		Thread.sleep(2000);
		System.out.println(container1);
		Thread.sleep(2000);
		String container2 = driver.findElement(By.xpath("(//div[@class='container_list'])[2]")).getText();
		Thread.sleep(2000);
		System.out.println(container2);
		Thread.sleep(2000);
		assertEquals(container1, Quota1);
		assertEquals(container2, Quota2);
		
		
	}
}

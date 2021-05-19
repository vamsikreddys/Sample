package com.ps.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.base.TestBase;

public class Search extends TestBase {

	//@Test
	public static void SearchDefault() throws Exception {

		// Login.Buyerlogin();

		Reporter.log("Buyer Login Successful");

		// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input[@type='text'])[2]")));

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveytitle1);

		Thread.sleep(2000);

		int table = 10;

		for (int i = 1; i < table; i++) {

			String Surveytitle = driver.findElement(By.xpath("(//tr//td[@class='survey-title ng-binding'])[" + i + "]"))
					.getText();

			System.out.println(Surveytitle);

			if (Surveytitle.contains(surveytitle1)) {

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
	
	//@Test
	public static void SearchHTParent() throws Exception {

	 //Login.Buyerlogin();

		Reporter.log("Buyer Login Successful");
		
		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();
		
		Thread.sleep(2000);

		// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"loader-wrapper\"]")));

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input)[2]")));
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div//div//label//input)[2]")).click();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveytitle3);

		Thread.sleep(2000);

		int table = 10;

		for (int i = 1; i < table; i++) {

			String Surveytitle = driver.findElement(By.xpath("(//tr//td[@class='survey-title ng-binding'])[" + i + "]"))
					.getText();

			System.out.println(Surveytitle);

			if (Surveytitle.contains(surveytitle3)) {

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
	
	//@Test
	public static void SearchHTChild() throws Exception {

	 //Login.Buyerlogin();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"loader-wrapper\"]")));

		Reporter.log("Buyer Login Successful");
		
		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

		// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"loader-wrapper\"]")));
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveytitle3);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"loader-wrapper\"]")));

		String surveynumber = driver
				.findElement(By.xpath("(//tbody//tr//td[@ng-click='openSurveyDetails(survey, $index)'])[1]")).getText();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveynumber);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"loader-wrapper\"]")));

		Thread.sleep(2000);

		int table = 10;

		for (int i = 1; i < table; i++) {

			String Surveytitle = driver.findElement(By.xpath("(//tr//td[@class='survey-title ng-binding'])[" + i + "]"))
					.getText();

			System.out.println(Surveytitle);

			if (Surveytitle.startsWith("HT-Survey")) {

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
	
	
	//@Test
	public static void SearchQBPParent() throws Exception {

	 //Login.Buyerlogin();

		Reporter.log("Buyer Login Successful");
		
		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

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
	
	
	public static void SearchQBPChild1() throws Exception {
		
					
			driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

			// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");

			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input[@type='text'])[2]")));

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

			driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys("-1");

			wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

			int table = 10;

			for (int i = 1; i < table; i++) {
				
				Thread.sleep(2000);

				String Surveytitle = driver.findElement(By.xpath("(//tr//td[@class='survey-title ng-binding'])[" + i + "]"))
						.getText();

				System.out.println(Surveytitle);

				if (Surveytitle.contains(surveytitle2)) {

					driver.findElement(By.xpath("(//tr//td[@class='ng-binding'])[" + i + "]")).click();

					Reporter.log("QBP Child 1 Found");

					break;
				}


				else {

					Reporter.log("No element Found");
					System.out.println("No Survey Found");
			

				}

			}
		}
}

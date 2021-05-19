package com.ps.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ps.base.TestBase;
import com.ps.rough.Adding;
import com.ps.rough.Search;
import com.ps.rough.VerifySurvey;

public class HTstaging extends TestBase {

	@Test(priority = 0)
	public static void HTCreation() throws Exception {
		
		
		
		HTtest.HTCreation();
		
		Login.logout();
		
		Login.Operatorlogin();

	}

	@Test(priority = 1)
	public static void SearchHT() throws Exception {

		// Login.Buyerlogin();

		Reporter.log("Buyer Login Successful");

		// driver.get("http://platformstaging.spectrumsurveys.com/#/dashboard");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//div//label//input[@type='text'])[2]")));

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveytitle3);

		Thread.sleep(2000);

		String surveynumber = driver
				.findElement(By.xpath("(//tbody//tr//td[@ng-click='openSurveyDetails(survey, $index)'])[1]")).getText();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).click();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).clear();

		driver.findElement(By.xpath("(//div//div//label//input[@type='text'])[2]")).sendKeys(surveynumber);

		try {
			Thread.sleep(2000);

			int table = 10;

			for (int i = 1; i < table; i++) {

				String Surveytitle = driver
						.findElement(By.xpath(
								"(//tbody//tr//td[@ng-click='openSurveyDetails(survey, $index)'][2])[" + i + "]"))
						.getText();

				System.out.println(Surveytitle);

				if (Surveytitle.contains(surveytitle3)) {

					System.out.println("HT Parent Found");

					Reporter.log("HT Parent Created");

				}

				else if (Surveytitle.contains("HT-Survey")) {

					System.out.println("HT Child Found");

					Reporter.log("HT Child Created");

					softAssertion.assertTrue(false);

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No Survey Found");
			softAssertion.assertTrue(false);

		}
	}

	@Test(priority = 2)
	public static void VerifyHT1() throws Exception {
		
		Search.SearchHTParent();
		
		Thread.sleep(1000);
		
		VerifySurvey.HTParent();
		
		Thread.sleep(1000);
		
		Search.SearchHTChild();
		
		Thread.sleep(1000);
		
		VerifySurvey.HTChild();
		
	}
	
	@Test(priority = 3)
	public static void AddingQuotas() throws Exception {
		
		
		Search.SearchHTParent();
		
		Adding.addingQuotas();
		
		
	}
	
	@Test(priority = 4)
	public static void VerifyafteraddingQuotas() throws Exception {
		
		
		Search.SearchHTParent();
		
		VerifySurvey.HTParentafteradding();
		
		Search.SearchHTChild();
	
		VerifySurvey.HTParentafteradding();
		
		Login.operatorlogout();
		
		
	}
	

}

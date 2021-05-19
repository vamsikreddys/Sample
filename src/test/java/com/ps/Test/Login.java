package com.ps.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ps.base.TestBase;

public  class Login extends TestBase {

	
	public static void Buyerlogin() {

		try {
			
			//driver.get(OR.getProperty("testsiteurl"));
			
			softAssertion.assertTrue(isElementPresent(By.xpath("//section//form//h2[@class='text-center']")));

			Reporter.log("Entered Into Login Page");

			driver.findElement(By.id("LoginEmail")).sendKeys(OR.getProperty("buyerusername"));
			driver.findElement(By.id("LoginPassword")).sendKeys(OR.getProperty("Buyerpassword"));
			driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

			Reporter.log("Buyer Login Successfully");

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Searchinput"))));

			if (isElementPresent(By.xpath(OR.getProperty("Searchinput")))) {

				Reporter.log("Buyer Login Successful");

				Assert.assertTrue(true, "Buyer Login Successful");
				
			}

			else {

				Reporter.log("Buyer Login Failure");

			}
			
		} catch (Exception e) {
			
			driver.navigate().refresh();
			
			Buyerlogin();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Searchinput"))));
		}

	}
	
	
	public static void Operatorlogin() throws Exception {
		
		Thread.sleep(2000);
		
		
		try {
			
			driver.get("https://platformstaging.spectrumsurveys.com/#/login");
			
			Assert.assertTrue(isElementPresent(By.xpath("//section//form//h2[@class='text-center']")));

			Reporter.log("Entered Into Login Page");

			driver.findElement(By.id("LoginEmail")).sendKeys(OR.getProperty("operatorusername"));
			driver.findElement(By.id("LoginPassword")).sendKeys(OR.getProperty("operatorpassword"));
			driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

			Reporter.log("operator Login Successfully");

			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Searchinput"))));

			if (isElementPresent(By.xpath(OR.getProperty("Searchinput")))) {

				Reporter.log("operator Login Successful");

				
			}

			else {

				Reporter.log("operator Login Failure");
				
			}
		} catch (Exception e) {
			
			driver.findElement(By.xpath("//dynamicheader//div//button[@id='user-options']")).click();
			
			driver.findElement(By.xpath("//ul//li//a[contains(text(),'Logout')]")).click();
			
			Operatorlogin();
		}

	}
	
	public static void Supplierlogin() {

		Assert.assertTrue(isElementPresent(By.xpath("//section//form//h2[@class='text-center']")));

		Reporter.log("Entered Into Login Page");

		driver.findElement(By.id("LoginEmail")).sendKeys(OR.getProperty("supplierusername"));
		driver.findElement(By.id("LoginPassword")).sendKeys(OR.getProperty("supplierpassword"));
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

		Reporter.log("Buyer Login Successfully");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Searchinput"))));

		if (isElementPresent(By.xpath(OR.getProperty("Searchinput")))) {

			Reporter.log("Buyer Login Successful");

			Assert.assertTrue(true);
		}

		else {

			Reporter.log("Buyer Login Failure");

			Assert.fail();
		}

	}
	
	public static void logout () {
		
		driver.findElement(By.xpath("(//img[@class='img-responsive'])[2]")).click();
		
		driver.findElement(By.xpath("//ul//li//a[contains(text(),'Logout')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section//form//h2[@class='text-center']")));
		
		Assert.assertTrue(isElementPresent(By.xpath("//section//form//h2[@class='text-center']")));
		
		
	}
	
public static void operatorlogout () {
		
	driver.findElement(By.xpath("//button[@id='user-options']")).click();
		
		driver.findElement(By.xpath("//ul//li//a[contains(text(),'Logout')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section//form//h2[@class='text-center']")));
		
		Assert.assertTrue(isElementPresent(By.xpath("//section//form//h2[@class='text-center']")));
		
		
	}

public static void Buyerlogin1() {
	
	
	
	try {
		try {
			driver.findElement(By.id("LoginEmail")).sendKeys(OR.getProperty("buyerusername"));
			driver.findElement(By.id("LoginPassword")).sendKeys(OR.getProperty("Buyerpassword"));
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

}



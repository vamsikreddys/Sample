package com.ps.rough;

import static org.testng.Assert.assertEquals;

import java.awt.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mysql.cj.api.log.Log;
import com.ps.Test.Login;
import com.ps.base.TestBase;


public class closeSurvey extends TestBase {

	@Test(priority = 0)
	public static void closeLiveSurvey() throws Exception, NoSuchElementException {

		Login.Buyerlogin1();
		

		for (int i = 1; i < 50; i++) {
			

			try {

				try {
					assertEquals("No Data Available In Table",
							driver.findElement(By.xpath("//tr//td[contains(text(),'No Data Available In Table')]"))
									.getText());

					System.out.println("No Surveys Found here ");
					break;
				} catch (Error e) {
					//verificationErrors.append(e.toString());

					
						Thread.sleep(1000);
						driver.findElement(By.xpath("(//button[@id='user-options'])[2]")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("(//a[contains(text(),'Closed')])[2]")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//div[@class='text-center']//a")).click();
						Thread.sleep(2000);
					
				}

			} catch (Exception Exception ) {
				try {
					
					assertEquals("No Data Available In Table",
							driver.findElement(By.xpath("//tr//td[contains(text(),'No Data Available In Table')]"))
									.getText());

					System.out.println("No Surveys Found here ");
					break;
				} catch (Error e) {
					//verificationErrors.append(e.toString());

					Thread.sleep(1000);
					driver.findElement(By.xpath("(//button[@id='user-options'])[2]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//a[contains(text(),'Closed')])[2]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//div[@class='text-center']//a")).click();
					Thread.sleep(2000);
				}
			}
		}
	}

	@Test(priority = 1)
	public static void closeDraftSurvey() throws Exception, NoSuchElementException, ElementClickInterceptedException {

		Login.Buyerlogin1();

		for (int j = 1; j < 20; j++) {

			Thread.sleep(1000);
			driver.findElement(By.xpath("//li//a[contains(text(),'Drafts')]")).click();
			Thread.sleep(1000);

			for (int k = 1; k < 20; k++) {
				
				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//a[@data-target='#survey-delete-modal']//span)[" + k + "]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@class='status-change-yes']")).click();
					Thread.sleep(1000);

				} catch (Exception e) {

					
						

						System.out.println("No Surveys Found here ");
						
					
				}
			}

			driver.navigate().refresh();

		}
	}

	//@Test(priority = 2)
	public static void closeDraftSurvey1() throws Exception {
		
	}
}

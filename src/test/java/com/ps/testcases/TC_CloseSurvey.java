package com.ps.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.base.TestBase;

public class TC_CloseSurvey extends TestBase {

	
	public void closelive() throws Exception {

		Login.Buyerlogin();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Survey Title']")));

		for (int i = 1; 1 < 20; i++) {
			
			Thread.sleep(1000);

			String noDataAvailable = driver.findElement(By.xpath("(//td[text()='No Data Available In Table'])[2]"))
					.getText();

			if (noDataAvailable.contains("No Data Available In Table")) {

				System.out.println("No Live Survey Found");
				break;

			}

			else {
				
				driver.navigate().refresh();
				
				Thread.sleep(1000);

				driver.findElement(By.xpath("//button[text()[normalize-space()='Live']]")).click();
				

				driver.findElement(By.xpath("(//a[@data-target='#status-change-modal'])[2]")).click();

				driver.findElement(By.linkText("Save as Closed and Close")).click();

				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@ng-if='showSuccessMessage']")));

				Assert.assertEquals(driver.findElement(By.xpath("//span[@ng-if='showSuccessMessage']")).getText(),
						"Success!");

				Thread.sleep(1000);

			}

		}
	}
	 
	
	public void closePaused() throws Exception {
		
		

	
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[3]")).click();
		
		Thread.sleep(1000);

		for (int i = 1; 1 < 20; i++) {
			
			Thread.sleep(1000);

			String noDataAvailable = driver.findElement(By.xpath("(//td[text()='No Data Available In Table'])[3]"))
					
					.getText();

			if (noDataAvailable.contains("No Data Available In Table")) {

				System.out.println("No Live Survey Found");
				break;

			}

			
			else {
				
				try {
					driver.navigate().refresh();
					
					driver.findElement(By.xpath("(//a[@data-toggle='tab'])[3]")).click();
					
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//button[text()[normalize-space()='Paused']]")).click();

					driver.findElement(By.xpath("(//a[@data-target='#status-change-modal'])[2]")).click();

					driver.findElement(By.linkText("Save as Closed and Close")).click();

					wait.until(
							ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@ng-if='showSuccessMessage']")));

					Assert.assertEquals(driver.findElement(By.xpath("//span[@ng-if='showSuccessMessage']")).getText(),
							"Success!");

					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("No Surveys Found");

			}

			}
		}
	}
	
	@Test
	public void close () throws Exception {
		
		closelive();
		closePaused();
	}
}

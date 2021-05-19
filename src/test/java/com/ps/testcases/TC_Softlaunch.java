package com.ps.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.Test.Surveys;
import com.ps.base.TestBase;
import com.ps.rough.Search;

public class TC_Softlaunch extends TestBase{

	
	public void softlaunch() throws Exception {
		
		Surveys.Defaultsurvey();
		Search.SearchDefault();
		
	}
	
	
	public void Enablesoftlaunch () throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit Details")));
		log.info("Entered to DefaultSurvry");
		driver.findElement(By.linkText("Edit Details")).click();
		log.info("Clicked on Edit Deatails");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-center")));
		
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("(//div[@class='slider round'])[3]"));
		
		element.getClass();
		
		System.out.println(element.getClass());
		
		driver.findElement(By.xpath("(//div[@class='slider round'])[3]")).click();
		
		driver.findElement(By.xpath("//input[@ng-change='launchquantityChange();checkIfEdited(launchSurvey.$dirty)']")).click();
		
		driver.findElement(By.xpath("//input[@ng-change='launchquantityChange();checkIfEdited(launchSurvey.$dirty)']")).clear();
		
		driver.findElement(By.xpath("//input[@ng-change='launchquantityChange();checkIfEdited(launchSurvey.$dirty)']")).sendKeys("1");
		
		driver.findElement(By.xpath("//button[text()[normalize-space()='Save Changes']]")).click();
		
	}
	
	
	
	public void verifysoftlaunch () throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-toggle='tab'])[7]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[7]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		
		String Activitylog =  driver.findElement(By.xpath("//div[@class='tab-content']")).getText();
		
		if (Activitylog.contains("Soft Launch")) {
			
			System.out.println("Activity Log Created for SoftLaunch");
		}
	
	}

	public static void respondentflow () throws InterruptedException {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-toggle='tab'])[5]")));
		
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[5]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		String  surveyid = driver.findElement(By.xpath("//td[@class='ng-binding']")).getText();
		
		System.out.println(surveyid);
		
		driver.get("https://staging.spectrumsurveys.com/#/start-survey?survey_id="+surveyid+"&supplier_id=301&bsec=a70mx8&ps_simu_forced_loi=555&ps_simu_forced_status=21&ps_supplier_respondent_id=456&ps_byr_simuenv=staging\n" + 
				"");
		
		Thread.sleep(5000);

		driver.findElement(By.id("ans000_229")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ans000_229")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("ans000_229")).sendKeys("12345");
		//Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath("//a[@id='answerid-244']/span")).click();
		 * Thread.sleep(1000); driver.findElement(By.linkText("White")).click();
		 */
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='answerid-211']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Female")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='answerid-235']/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("1998")).click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("button")).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//table//thead//tr//th)[3]")));

	}
	
	
	public static void respondent () throws Exception  {
		
		respondentflow();
		
		Login.Buyerlogin();
		
		Search.SearchDefault();
		
		respondentflow();
		
		Login.Buyerlogin();
		
		driver.findElement(By.xpath("(//a[@data-toggle='tab'])[3]")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//input[contains(@class,'ng-pristine ng-untouched')])[3]")));
		
		
		
		for (int i = 1; i <3; i++) {
			
			Thread.sleep(1000);
			String rDefaultsurvey = driver.findElement(By.xpath("//div[@id='paused']/div[2]/table[1]/tbody[1]/tr["+i+"]/td[3]")).getText();
			
			if (rDefaultsurvey.contains("R-Defaultsurvey")) {
				
				driver.findElement(By.cssSelector("div#paused>div:nth-of-type(2)>table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(2)")).click();
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-toggle='tab'])[5]")));
				
				log.info("Soft launch Test Passed");
				System.out.println("Soft launch Test Paused!!");
				
				break;
				
			}
			
			else {
				
				System.out.println("No Surveys Found on Paused Surveys");
			}
			
			
		}
		
	}
	
	
	public void verifyPausedSoftlaunch () throws Exception {
		
	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit Details")));
		log.info("Entered to DefaultSurvry");
		driver.findElement(By.linkText("Edit Details")).click();
		log.info("Clicked on Edit Deatails");
		
		Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("(//div[@class='slider round'])[3]"));
		
		element.getClass();
		
		element.equals(driver.findElement(By.xpath("//input[@class='ng-untouched ng-valid ng-dirty ng-valid-parse ng-empty']")));
		
		System.out.println(element.getClass());
		
		Thread.sleep(2000);
		
		if (element.isSelected()) {
			
			System.out.println("Enabled");
		}
		
		else  {
			
			System.out.println("Not Enabled");
		}
		
		
	}
	
	@Test(priority = 0)
	public void Softlaunch1 () throws Exception {
		
		softlaunch();
		Enablesoftlaunch();
		verifysoftlaunch();
		//respondentflow();
		respondent();
		//verifyPausedSoftlaunch();
		
	}
}

package com.ps.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ps.base.TestBase;

public class Surveys extends TestBase {

	@Test(priority = 0)
	public static void Defaultsurvey() throws Exception {
		
	
		
		Login.Buyerlogin();

		driver.findElement(By.cssSelector("html>body>div>div>header>div:nth-of-type(2)>div>a>span")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("surveyTitle")));

		Reporter.log("Create Survey Page opened");

		driver.findElement(By.name("surveyTitle")).sendKeys(surveytitle1 + " " + date1);

		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		driver.findElement(By.id("Survey_Sample_Title")).click();

		driver.findElement(By.cssSelector(
				"html>body>div>div>section>div>div>div>form>div>div>div:nth-of-type(2)>div>ul>li:nth-of-type(2)>a"))
				.click();

		driver.findElement(By.id("completes")).sendKeys("100");

		driver.findElement(By.id("LengthofSurvey")).sendKeys("10");

		driver.findElement(By.id("incidence")).sendKeys("45");

		driver.findElement(By.id("field_time")).sendKeys("10");

		Reporter.log("Meta Data Entered Successfully");

		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")));
		
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div//span[@class='progress container ng-scope']")));
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//li//div//button//div//span[@class='caret'])[2]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'Supplier')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//th[text()[normalize-space()='FEASIBILITY']]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.xpath("//button[text()='Save']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()[normalize-space()='Finalize & Launch!']]")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("liveUrl")));

		driver.findElement(By.id("liveUrl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("liveUrl")).sendKeys(config.getProperty("liveurl"));

		driver.findElement(By.id("testUrl")).sendKeys(config.getProperty("testurl"));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));

		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-default')])[3]")).click();

		driver.findElement(By.xpath("//button[text()='Launch Your Survey']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding']")));

		Reporter.log("Survey Created Successfully");
	}

	@Test(priority = 1)
	public static void Search() throws Exception {

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


			else {

				Reporter.log("No element Found");
				System.out.println("No Survey Found");
				Assert.fail();

			}

		}
	}

	@Test(priority = 2)

	public static void VerifyDashboard() throws Exception {

		Thread.sleep(3000);
		// assertEquals(driver.findElement(By.xpath("//h2")).getText(), surveytitle1);
		assertEquals(driver.findElement(By.xpath("//div[2]/span")).getText(), "$0.00");
		assertEquals(driver.findElement(By.xpath("//div[3]/div[4]/span")).getText(), "$33.73");
		assertEquals(driver.findElement(By.xpath("//div[3]/div/div/p")).getText(), "0 | 100");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		assertEquals(
				driver.findElement(By.xpath("//div//div//div//p[contains(text(),'Survey has no Quotas')]")).getText(),
				"SURVEY HAS NO QUOTAS");

	}

	@Test(priority = 3)
	public static void addingQuotas() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("html>body>div>div>header>div>img")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='ng-binding']")));

		driver.findElement(By.cssSelector("div#live>div:nth-of-type(2)>table>tbody>tr>td:nth-of-type(3)")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.cssSelector("html>body>div>div>section>div>div>div>div>div:nth-of-type(3)>h2")));

		driver.findElement(By.xpath("//div//ul//li//a[contains(text(),'Edit Audience')]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 250)");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("#genderModal")));

		Thread.sleep(1000);

		try {
			driver.findElement(By.id("#genderModal")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.findElement(By.id("#genderModal")).click();
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Census']")).click();

		driver.findElement(By.id("#genderModal")).click();

		driver.findElement(By.xpath("//button[@id='#rbModal']")).click();

		driver.findElement(By.xpath("(//button[text()='Census'])[2]")).click();

		driver.findElement(By.xpath("//button[@id='#rbModal']")).click();

		driver.findElement(By.xpath("//button[text()='Save Changes']")).click();
		
		driver.findElement(By.cssSelector("div#directEditReset>div>div>div:nth-of-type(2)>button:nth-of-type(2)")).click();

		//driver.findElement(By.xpath("(//button[text()='Yes'])[2]")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.cssSelector("html>body>div>div>section>div>div>div>div>div:nth-of-type(3)>h2")));

	}

	@Test(priority = 4)
	public static void VerifyDashboardAAQ() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/thead/tr/th/span/span")));

		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/thead/tr/th/span/span"))
				.getText(), "Gender");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div[2]/div/table[2]/thead/tr/th/span/span"))
						.getText(),
				"Race/Ethnicity");
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td/div/div"))
				.getText(), "Male");
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody[2]/tr/td/div/div"))
				.getText(), "Female");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td[2]")).getText(),
				"0 | 60");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody[2]/tr/td[2]")).getText(),
				"0 | 40");

	}

	@Test(priority = 5)
	public static void Suppliers() throws Exception {

		// Login.Buyerlogin();

		// Search();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//li//a[@role='tab'])[3]")));

		driver.findElement(By.xpath("(//li//a[@role='tab'])[3]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(2000);

		for (int i = 1; i < 3; i++) {

			String Supplier = driver.findElement(By.xpath("(//td[@class='text-left ng-binding'])[" + i + "]"))
					.getText();

			System.out.println(Supplier);

			if (Supplier.contains("Peanut")) {

				System.out.println("Supplier Name : Peanut Lab Supplier, Supplier Id : 35");

				// driver.get("https://staging.spectrumsurveys.com/#/start-survey?survey_id=+"+surveyid+"+&supplier_id=35&bsec=a70mx8&ps_simu_forced_loi=555&ps_simu_forced_status=21&ps_supplier_respondent_id=456&ps_byr_simuenv=staging");
			}

			else if (Supplier.contains("Pramod")) {

				System.out.println("Supplier Name : Pramod Nagar, Supplier Id : 36");
			}

			else if (Supplier.contains("Global")) {

				System.out.println("Supplier Name : Global Test Supplier, Supplier Id : 301");

			}
		}
		Reporter.log("Supplier Found");

		driver.findElement(By.xpath("(//li//a[@role='tab'])[5]")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[text()='Survey ID']")));

		driver.findElement(By.xpath("//td[text()='Survey ID']")).click();

		String surveyid = driver.findElement(By.xpath("(//table//tbody//tr//td[@class='ng-binding'])[1]")).getText();

		System.out.println(surveyid);

	}

	@Test(priority = 6, dependsOnMethods = { "Suppliers" })
	public static void Respondentflow() throws Exception {

		String surveyid = driver.findElement(By.xpath("(//table//tbody//tr//td[@class='ng-binding'])[1]")).getText();

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
		driver.findElement(By.xpath("//div[@id='stSurvey']/section/div/div/div/div[6]/div/button/img")).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//table//thead//tr//th)[3]")));

	}

	@Test(priority = 7)
	public static void afterComplete() throws Exception {

		 driver.get(config.getProperty("testsiteurl"));

		Login.Buyerlogin();
		
		Reporter.log("Buyer login Successful");

		Search();
		
		
		
		Reporter.log("Search Successful");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/thead/tr/th/span/span")));

		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/thead/tr/th/span/span"))
				.getText(), "Gender");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div[2]/div/table[2]/thead/tr/th/span/span"))
						.getText(),
				"Race/Ethnicity");
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td/div/div"))
				.getText(), "Male");
		assertEquals(driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody[2]/tr/td/div/div"))
				.getText(), "Female");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody/tr/td[2]")).getText(),
				"0 | 60");
		assertEquals(
				driver.findElement(By.xpath("//div[@id='quotas']/div[2]/div/div/table[2]/tbody[2]/tr/td[2]")).getText(),
				"1 | 40");
		Reporter.log("Complete Validated");
		

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//li//a[@role='tab'])[3]")));

		driver.findElement(By.xpath("(//li//a[@role='tab'])[3]")).click();

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Reporter.log("supplier selected Successful");

	}
	
	@Test(priority = 8)
	public static void priceoverride() throws Exception {
		
		driver.findElement(By.xpath("(//footer//div//ul//li)[3]")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'col-sm-12 col-md-8')]")).getSize();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//tr//td[@class='ng-binding'])[1]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//tr//td[@class='ng-binding'])[1]")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		for (int j = 1; j < 5; j++) {
			
			 String globalTestSupplier = driver.findElement(By.cssSelector("html>body>div>div>section>div>div>form>div>div:nth-of-type(5)>div>table>tbody>tr:nth-of-type("+j+")>td:nth-of-type(2)")).getText();
			Thread.sleep(1000);
			if(globalTestSupplier.contains("Pramod")) {
				
				driver.findElement(By.xpath("(//tr//td[@class='ng-binding'])["+j+"]")).click();
				
				Assert.assertTrue(true, "Pramod Nagar Found");
				
				break;
				
			} else {
				
				System.out.println("No Supplier Found");
				
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div//div//div//div//h4//a//i[@class='fa fa-angle-down'])[2]")).click();
		
		driver.findElement(By.xpath("(//h4//a//i)[2]")).click();
		
		driver.findElement(By.xpath("(//div//div//p//input)[3]")).clear();
		
		driver.findElement(By.xpath("(//div//div//p//input)[3]")).sendKeys("3.50");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Save Changes']")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		assertEquals(driver.findElement(By.xpath("(//div//div//span[@class='ng-binding ng-scope'])[2]")).getText(), "$3.50");
		
		driver.findElement(By.xpath("//img[@alt='Logo']")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loader-wrapper"))));
		
		
	}
	

}

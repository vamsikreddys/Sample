package com.ps.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ps.base.TestBase;

public class Adding extends TestBase{
  @Test
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

		driver.findElement(By.xpath("(//button[text()='Yes'])[2]")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.cssSelector("html>body>div>div>section>div>div>div>div>div:nth-of-type(3)>h2")));

	}
}

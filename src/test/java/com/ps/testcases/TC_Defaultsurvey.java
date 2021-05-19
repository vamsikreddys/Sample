package com.ps.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.ps.base.TestBase;

public class TC_Defaultsurvey extends TestBase{

	@Test
	public void f() throws Exception {
		

		com.ps.Test.Surveys.Defaultsurvey();
		com.ps.Test.Surveys.Search();
		com.ps.Test.Surveys.VerifyDashboard();
		com.ps.Test.Surveys.addingQuotas();
		com.ps.Test.Surveys.VerifyDashboardAAQ();
		com.ps.Test.Surveys.Suppliers();
		com.ps.Test.Surveys.Respondentflow();
		com.ps.Test.Surveys.afterComplete();
		com.ps.Test.Surveys.priceoverride();
		
		
	}
}

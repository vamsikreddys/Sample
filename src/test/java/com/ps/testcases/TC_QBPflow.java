package com.ps.testcases;

import org.testng.annotations.Test;

import com.ps.Test.Login;
import com.ps.Test.Surveys;
import com.ps.base.TestBase;
import com.ps.rough.Search;

public class TC_QBPflow extends TestBase {
 
	
	public static void QBP1() throws Exception {
		
		Thread.sleep(1000);
		com.ps.Test.QBPTest.QBPSurvey();
		
	}
	
	
	public static void QBP2() throws Exception {
		
		Login.Operatorlogin();
		
		Search.SearchQBPChild1();
		
		
	
	}
	
	
	@Test
	public static void QBPExecution () throws Exception {
		
		//QBP1();
		QBP2();
	}
}

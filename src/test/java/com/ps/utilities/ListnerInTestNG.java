package com.ps.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class ListnerInTestNG implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("All test finished");
		Reporter.log("All test finished");
	}

	public void onStart(ITestContext arg0) {

		System.out.println("All Test Execution started");
		Reporter.log("All Test Execution started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Test is pass absed on percentage" + getMethodName(arg0));
		Reporter.log("Test is pass absed on percentage " + getMethodName(arg0));
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test failed " + getMethodName(arg0));
		Reporter.log("Test failed " + getMethodName(arg0));
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped " + getMethodName(arg0));
		Reporter.log("Test Skipped " + getMethodName(arg0));
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Starting test is " + getMethodName(arg0));
		Reporter.log("Starting test is " + getMethodName(arg0));
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test Passed " + getMethodName(arg0));
		Reporter.log("Test Passed " + getMethodName(arg0));
	}

	private static String getMethodName(ITestResult arg0) {
		return arg0.getMethod().getConstructorOrMethod().getName();
	}
}

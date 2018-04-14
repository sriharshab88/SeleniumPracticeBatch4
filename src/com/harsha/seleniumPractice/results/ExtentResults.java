package com.harsha.seleniumPractice.results;

import org.testng.Assert;
import org.testng.Reporter;

import com.harsha.seleniumPractice.libraries.Configurations;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * This classfile contains code related to the Extent Reports
 * @author Sri harsha
 *
 */
public class ExtentResults {
	public static ExtentReports extentReports = new ExtentReports(Configurations.resultsPath, true);
	public static ExtentTest log;
	
	public void createtestcase(String testcasename, String testname) throws Exception {
		
		log = extentReports.startTest(testcasename);
		log.assignCategory(testname);
		extentReports.endTest(log);
	}
	
	public void assertEquals(String actual, String expected, String message) {
		try {
		Assert.assertEquals(actual, expected, "FAIL -- "+message);
		log.log(LogStatus.PASS, "PASS -- "+message);
		}catch (AssertionError error) {
			log.log(LogStatus.FAIL, "FAIL -- "+message, error);
			throw new AssertionError();
		}finally {
			extentReports.endTest(log);
			extentReports.flush();
		}
	}
	
	public void log(String s, boolean logToStandardOut) {
		Reporter.log(s, logToStandardOut);
		log.log(LogStatus.PASS, s);
		
		extentReports.endTest(log);
		extentReports.flush();
	}
	
	
}

package com.harsha.seleniumPractice.libraries;

import java.io.File;

/**
 * This class file contains all the pre-requisites required to run the automation scripts
 * @author Sri harsha
 *
 */
public class Configurations {

	public static String applicationUrl = "http://automationpractice.com/index.php";
	public static String chromeDriverPath = System.getProperty("user.dir")
											+File.separator+"chromedriver";
	
	public static String resultsPath = System.getProperty("user.dir")+File.separator+"ExtentReports.html";
	public static String testDataPath = System.getProperty("user.dir") + File.separator+ "src/main/java"+
			File.separator +"com/harsha/seleniumPractice/testData"+ File.separator+"testData"; 
}

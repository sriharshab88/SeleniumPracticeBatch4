package com.harsha.seleniumPractice.libraries;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.harsha.seleniumPractice.results.ExtentResults;

/**
 * This class file contains the code related to the browser, application launch
 * @author Sri harsha
 *
 */
public class Utilities {

	WebDriver driver;
	ExtentResults results = new ExtentResults();
	public WebDriver launchBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver(); //To launch the Firefox browser
			System.out.println("PASS -- Launched Firefox browser successfully");
			driver.get(Configurations.applicationUrl);   //Opens the application URL specified
			Reporter.log("PASS -- Application URL: "+driver.getCurrentUrl(), true);  //To get current url
		}else if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"chromedriver");
			driver = new ChromeDriver();
			Reporter.log("PASS -- Launched Chrome browser successfully", true);
			driver.get(Configurations.applicationUrl);   //Opens the application URL specified
			Reporter.log("PASS -- Application URL: "+driver.getCurrentUrl(), true);  //To get current url
		}else {
			Reporter.log("FAIL -- Browser cannot be recognised", true);
		}
		
		return driver;
	}
}

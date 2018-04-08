package com.harsha.seleniumPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.harsha.seleniumPractice.libraries.GenericMethods;


/**
 * This class file contains all objects and methods related to Sign in page
 * @author Sri harsha
 *
 */
public class SignInPage {
	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public SignInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public String getAuthenticationText() throws Exception {
		String text = genericMethods.getTextByXpath("//h1[@class='page-heading']", 
				"FAIL -- Authentication text did not display");
		Reporter.log("PASS -- Authentication message is displayed successfully", true);
		return text;
	}
	
	
	public void isLoginModuleDisplayed() throws Exception {
		genericMethods.isWebElementDisplayed("//form[@id='login_form']", 
				"FAIL -- Login module did not display");
		Reporter.log("PASS -- Login module displayed successfully", true);
	}
}

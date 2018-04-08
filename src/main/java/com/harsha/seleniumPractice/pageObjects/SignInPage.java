package com.harsha.seleniumPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.harsha.seleniumPractice.libraries.GenericMethods;
import com.harsha.seleniumPractice.results.ExtentResults;


/**
 * This class file contains all objects and methods related to Sign in page
 * @author Sri harsha
 *
 */
public class SignInPage {
	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public SignInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public String getAuthenticationText() throws Exception {
		String text = genericMethods.getTextByXpath("//h1[@class='page-heading']", 
				"FAIL -- Authentication text did not display");
		results.log("PASS -- Authentication message is displayed successfully", true);
		return text;
	}
	
	
	public void isLoginModuleDisplayed() throws Exception {
		genericMethods.isWebElementDisplayed("//form[@id='login_form']", 
				"FAIL -- Login module did not display");
		results.log("PASS -- Login module displayed successfully", true);
	}
	
	public void enterUserName(String userName) throws Exception {
		genericMethods.enterTextByXpath("//input[@id='email']", userName, 
										"FAIL -- Did not enter username into the text field");
		results.log("PASS -- Entered Username '"+userName+"' successfully", true);
	}
	
	public void enterPassword(String password) throws Exception {
		genericMethods.enterTextById("passwd", password, 
										"FAIL -- Did not enter password into the text field");
		results.log("PASS -- Entered Password '"+password+"' successfully", true);
	}
	
	public void clickSignInButton() throws Exception {
		genericMethods.clickById("SubmitLogin", "FAIL -- Submit button is not clicked");
		results.log("PASS -- Submit button clicked successfully", true);
	}
	
	public void login(String userName, String password) throws Exception {
		isLoginModuleDisplayed();
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();
	}
}

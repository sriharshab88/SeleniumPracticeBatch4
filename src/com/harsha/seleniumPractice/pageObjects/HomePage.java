package com.harsha.seleniumPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.harsha.seleniumPractice.libraries.GenericMethods;
import com.harsha.seleniumPractice.results.ExtentResults;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}

	public void clickSignInLink() throws Exception {
		genericMethods.clickByXpath("//a[@class='login']", "FAIL -- Sign link display status");
		results.log("PASS -- Sign in link clicked successfully", true);
	}
	
	public String getUserNameText() throws Exception {
		String text = genericMethods.getTextByXpath("//a[@class='account']/span", "FAIL -- Did not get the Username text");
		results.log("PASS -- Username is displayed successfully", true);
		return text;
	}
	
	public void clickSignOut() throws Exception {
		genericMethods.clickByXpath("//a[@class='logout']", "FAIL -- Did not click Signout button");
		results.log("PASS -- Clicked Signout button successfully", true);
	}
	
	
}

package com.harsha.seleniumPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.harsha.seleniumPractice.libraries.GenericMethods;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}

	public void clickSignInLink() throws Exception {
		genericMethods.clickByXpath("//a[@class='login']", "FAIL -- Sign link display status");
		Reporter.log("PASS -- Sign in link clicked successfully", true);
	}
	
	
}

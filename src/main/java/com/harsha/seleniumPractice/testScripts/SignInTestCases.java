package com.harsha.seleniumPractice.testScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.harsha.seleniumPractice.libraries.GenericMethods;
import com.harsha.seleniumPractice.libraries.Utilities;
import com.harsha.seleniumPractice.pageObjects.HomePage;
import com.harsha.seleniumPractice.pageObjects.SignInPage;
import com.harsha.seleniumPractice.results.ExtentResults;
import com.harsha.seleniumPractice.testData.LoginCredentialsTestData;

/**
 * This class file contains all the test cases related to sign module
 * @author Sri harsha
 *
 */
public class SignInTestCases {
	
	WebDriver driver;
	WebDriverWait wait;
	String applicationUrl = "http://automationpractice.com/index.php";
	Utilities utilities = new Utilities();
	HomePage homePage;
	SignInPage signIn;
	ExtentResults results = new ExtentResults();
	
	@BeforeTest
	public void startBrowser() {
		driver = utilities.launchBrowser("Firefox"); //This will launch the browser and application
		wait = new WebDriverWait(driver, 30);
		homePage = new HomePage(driver, wait);
		signIn = new SignInPage(driver, wait);
	}
	
	
	@Test
	public void seleniumWebDriverCommands() throws Exception {
		
		results.createtestcase(Thread.currentThread().getStackTrace()[1].getMethodName(), 
								this.getClass().getSimpleName());
		
		String expectedText = "AUTHENTICATION";	
		homePage.clickSignInLink();
		
		String signInText = signIn.getAuthenticationText();
		results.assertEquals(signInText, expectedText, "Log in page did not display successfully");
		results.log("PASS -- Log in page displayed successfully", true);

	}
	
	
	@Test
	public void signinToTheApplication() throws Exception {
		
		results.createtestcase(Thread.currentThread().getStackTrace()[1].getMethodName(), 
				this.getClass().getSimpleName());
		
		String expectedText = "AUTHENTICATION";	
		homePage.clickSignInLink();
		
		String signInText = signIn.getAuthenticationText();
		results.assertEquals(signInText, expectedText, "Log in page did not display successfully");
		results.log("PASS -- Log in page displayed successfully", true);
		
		signIn.login("testautomation88@test.com", "123456");
			
		String actualUserName = homePage.getUserNameText();  //Fetching the text of that web element
		String expectedUserName = "Tester Selenium";
		results.assertEquals(actualUserName, expectedUserName, 
				"Username did not match");   //Compare the username
		results.log("PASS -- Username Matched", true);
		
		homePage.clickSignOut();
		
	}
	
	@Test(dataProviderClass=LoginCredentialsTestData.class, dataProvider="credentialsValidation")
	public void MultipleAccountsValidation(String emailId, String password) throws Exception {
		results.createtestcase(Thread.currentThread().getStackTrace()[1].getMethodName(), 
				this.getClass().getSimpleName());
		
		homePage.clickSignInLink();
		signIn.login(emailId, password);
		homePage.clickSignOut();
	}
	
	@AfterTest
	public void endBrowser() {
		driver.quit();
	}
	
	

}

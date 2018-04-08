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
	
	@BeforeTest
	public void startBrowser() {
		driver = utilities.launchBrowser("Firefox"); //This will launch the browser and application
		wait = new WebDriverWait(driver, 30);
		homePage = new HomePage(driver, wait);
		signIn = new SignInPage(driver, wait);
	}
	
	
	@Test
	public void seleniumWebDriverCommands() throws Exception {
		
		String expectedText = "AUTHENTICATION";	
		homePage.clickSignInLink();
		
		String signInText = signIn.getAuthenticationText();
		Assert.assertEquals(signInText, expectedText, "FAIL -- Log in page did not display successfully");
		Reporter.log("PASS -- Log in page displayed successfully", true);
		
		
	}
	
	@Test
	public void signinToTheApplication() throws Exception {
		
		String expectedText = "AUTHENTICATION";	
		homePage.clickSignInLink();
		
		String signInText = signIn.getAuthenticationText();
		Assert.assertEquals(signInText, expectedText, "FAIL -- Log in page did not display successfully");
		Reporter.log("PASS -- Log in page displayed successfully", true);
		
		signIn.isLoginModuleDisplayed();
		
		driver.findElement(By.xpath("//input[@id='email']"))
							 .sendKeys("testautomation88@test.com");   //Enter the email into the email text box
		
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("123456");   //Enter the password into the password text box
		
		WebElement signInButton = driver.findElement(By.id("SubmitLogin"));  //Fetch the webelement
		signInButton.click();  //Click on the Sign in button
		
		driver.get(applicationUrl);  //redirecting back to home page because of the faulty page
		
		WebElement userName = driver.findElement(By.xpath("//a[@class='account']/span"));  //fetching the username webelement
		String actualUserName = userName.getText();  //Fetching the text of that web element
		String expectedUserName = "Tester Selenium";
		
		Assert.assertEquals(actualUserName, expectedUserName, 
				"FAIL -- Username did not match");   //Compare the username
		Reporter.log("PASS -- Username Matched", true);
		
		driver.findElement(By.xpath("//a[@class='logout']")).click();   //Logout from the application
		Reporter.log("PASS -- User is logged out successfully", true);
		
				
		//driver.close(); //Closes the active selenium instance of the browser
		driver.quit();    //Closes the complete process of that driver/browser instance

		
	}
	
	@AfterTest
	public void endBrowser() {
		driver.quit();
	}
	
	

}

package com.harsha.seleniumPractice.testScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SignInTestCases {
	
	String applicationUrl = "http://automationpractice.com/index.php";
	
	@Test
	public void seleniumWebDriverCommands() {
		
		
		WebDriver driver = new FirefoxDriver(); //To launch the Firefox browser
		System.out.println("PASS -- Launched Firefox browser successfully");
		
		driver.get(applicationUrl);   //Opens the application URL specified
		System.out.println("Application URL: "+driver.getCurrentUrl());  //To get current url
		System.out.println("Window Title :"+driver.getTitle()); //To get the window title
		
		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); //Stores sign in link
		signInLink.click();   //Clicks on the Stored sign in link
		
		WebElement loginPageText = driver.findElement(By.xpath("//h1[@class='page-heading']"));
		String signInText = loginPageText.getText();
		
		//String signInText1 = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		
		if(signInText.equals("AUTHENTICATION")) {
			System.out.println("PASS -- Log in page displayed successfully");
		}else {
			System.out.println("FAIL -- Log in page did not display successfully");
		}
		
		//driver.close();
		driver.quit();
		
		
	}
	
	@Test
	public void signinToTheApplication() {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"chromedriver");
		WebDriver driver = new ChromeDriver();
		Reporter.log("PASS -- Launched Chrome browser successfully", true);

				
		driver.get(applicationUrl);   //Opens the application URL specified
		Reporter.log("PASS -- Application URL: "+driver.getCurrentUrl(), true);  //To get current url
		Reporter.log("PASS -- Window Title :"+driver.getTitle(), true); //To get the window title
		
		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); //Stores sign in link
		signInLink.click();   //Clicks on the Stored sign in link
		
		WebElement loginPageText = driver.findElement(By.xpath("//h1[@class='page-heading']"));
		String signInText = loginPageText.getText();  //Fetches the text
		String expectedSignInText = "AUTHENTICATION";
		
		Assert.assertEquals(signInText, expectedSignInText, 
				"FAIL -- Log in page did not display successfully"); //Compares the values using TestNG Assertion
		Reporter.log("PASS -- Log in page displayed successfully", true);
		
		WebElement loginModule = driver.findElement(By.xpath("//form[@id='login_form']"));
		loginModule.isDisplayed();  //Verifying whether the webelement is displayed or not
		
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
	
	

}

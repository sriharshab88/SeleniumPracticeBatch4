package com.harsha.seleniumPractice.webDriver.testScripts;



import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class NavigationPageVerificationTestCases {
	
	String applicationUrl = "http://automationpractice.com/index.php";
	
	@Test
	public void myAccountPagevalidation() {
		
		WebDriver driver = new FirefoxDriver();  //Launches the Firefox browser
		driver.manage().window().maximize();  //maximize the browser window
		Reporter.log("PASS -- Firefox browser launched successfully", true);
		
		driver.get(applicationUrl);  //Launch the application
		Reporter.log("PASS -- Application launched successfully", true);
		
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
		
		driver.findElement(By.xpath("//a[@title='Orders']")).click(); //Click on the order history button
		Reporter.log("PASS --  Click on the Order history button", true);
		
		String actualOrderHistoryTitle = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']")).getText();
		String expectedOrderHistoryTitle = "ORDER HISTORY";
		Assert.assertEquals(actualOrderHistoryTitle, expectedOrderHistoryTitle, 
								"FAIL -- Order History Page title did not match");
		Reporter.log("PASS -- Order History page is displayed successfully");
		
		driver.findElement(By.xpath("//a[contains(text(),'My account')]")).click();
		Reporter.log("PASS -- Click on the My Account link");
		
		
		String actualMyAccountTitle = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		String expectedMyAccountTitle = "MY ACCOUNT";
		Assert.assertEquals(actualMyAccountTitle, expectedMyAccountTitle, 
								"FAIL -- My Account Page title did not match");
		Reporter.log("PASS -- My Account page is displayed successfully");
		
		driver.findElement(By.xpath("//a[@title='Information']")).click();
		Reporter.log("PASS --  Click on the My Personal Information button", true);
		
		String actualPersonalInfoTitle = driver.findElement(By.xpath("//h1[@class='page-subheading']")).getText();
		String expectedPersonalInfoTitle = "YOUR PERSONAL INFORMATION";
		Assert.assertEquals(actualPersonalInfoTitle, expectedPersonalInfoTitle, 
								"FAIL -- My Personal Information Page title did not match");
		Reporter.log("PASS -- My Personal information page is displayed successfully");
		
		driver.findElement(By.xpath("//a[contains(text(),'My account')]")).click();
		Reporter.log("PASS -- Click on the My Account link");
		
		String actualMyAccountTitle1 = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		String expectedMyAccountTitle1 = "MY ACCOUNT";
		Assert.assertEquals(actualMyAccountTitle1, expectedMyAccountTitle1, 
								"FAIL -- My Account Page title did not match");
		Reporter.log("PASS -- My Account page is displayed successfully");
		
		driver.findElement(By.xpath("//a[@class='logout']")).click();   //Logout from the application
		Reporter.log("PASS -- User is logged out successfully", true);
		
		driver.quit();
		
	}
	
	@Test
	public void footerPageValidation() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();  //Launches the Firefox browser
		driver.manage().window().maximize();  //maximize the browser window
		Reporter.log("PASS -- Firefox browser launched successfully", true);
		
		driver.get(applicationUrl);  //Launch the application
		Reporter.log("PASS -- Application launched successfully", true);
		
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
		
		
		List<WebElement> footerLinks = driver.findElements(By.xpath("//section[@id='block_various_links_footer']/ul/li"));
		
		for(int i=1; i<=footerLinks.size(); i++) {
			driver.findElement(By.xpath("//section[@id='block_various_links_footer']/ul/li["+i+"]/a")).click();
			String windowTitle = driver.getTitle();
			Assert.assertNotNull(windowTitle, "FAIL -- Window title is not displayed");
			Reporter.log("PASS -- Window title : "+windowTitle+" is displayed successfully");
		}
		
		driver.findElement(By.xpath("//a[@class='logout']")).click();   //Logout from the application
		Reporter.log("PASS -- User is logged out successfully", true);
		
		driver.quit();
	}
	

}

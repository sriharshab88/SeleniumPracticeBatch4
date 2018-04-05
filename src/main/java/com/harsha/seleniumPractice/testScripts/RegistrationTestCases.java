package com.harsha.seleniumPractice.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RegistrationTestCases {

	String applicationUrl = "http://automationpractice.com/index.php";
	
	@Test
	public void createAccount() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();  //Launches the Firefox browser
		Reporter.log("PASS -- Firefox browser launched successfully", true);
		
		driver.get(applicationUrl);  //Launch the application
		Reporter.log("PASS -- Application launched successfully", true);
		
		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); //Stores sign in link
		signInLink.click();   //Clicks on the Stored sign in link
		
		WebElement registrationModule = driver.findElement(By
											 .xpath("//form[@id='create-account_form']"));//Stores the registration module into variable
		registrationModule.isDisplayed(); //Validates if the module is displayed or not
		
		driver.findElement(By.xpath("//input[@id='email_create']"))
							 .sendKeys("seleniumNewbatch6@test.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		Thread.sleep(2000);
		String ActualPageTitle = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		String expectedPageTitle = "CREATE AN ACCOUNT";
		Assert.assertEquals(ActualPageTitle, expectedPageTitle, "FAIL -- Page title did not match");
		Reporter.log("PASS -- Create account page displayed successfully", true);
		
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("SeleniumTester");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("JavaExpert");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123456");
		
		WebElement dateDD = driver.findElement(By.xpath("//select[@id='days']"));
		Select dateDropDown = new Select(dateDD);
		dateDropDown.selectByIndex(4); //selecting the Date by index
		
		WebElement monthDD = driver.findElement(By.xpath("//select[@id='months']"));
		Select monthDropDown = new Select(monthDD);
		monthDropDown.selectByValue("5");  //selecting the month by value
		
		WebElement yearDD = driver.findElement(By.xpath("//select[@id='years']"));
		Select yearDropDown = new Select(yearDD);
		yearDropDown.selectByValue("1988");
		//yearDropDown.selectByVisibleText("1988  ");   //selecting year by visible text
	
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("MyFirstname");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("MyLastname");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Address1, 8th Avenue");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Minneapolis");
		
		WebElement stateDD = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select stateDropDown = new Select(stateDD);
		stateDropDown.selectByVisibleText("Minnesota");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("55401");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("2223334444");
		WebElement addresText = driver.findElement(By.xpath("//input[@id='alias']"));
		addresText.clear();
		addresText.sendKeys("New address");
		
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		driver.get(applicationUrl);
		
		driver.findElement(By.xpath("//a[@class='logout']")).click();   //Logout from the application
		Reporter.log("PASS -- User is logged out successfully", true);
		
		driver.quit();
	}
	
	
}

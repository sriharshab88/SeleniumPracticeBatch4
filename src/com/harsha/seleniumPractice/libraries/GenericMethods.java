package com.harsha.seleniumPractice.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GenericMethods {

	WebDriver driver;
	WebDriverWait wait;
		
		public GenericMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickByXpath(String xpath, String message) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
		}
		catch(Exception e) {
			throw new Exception(message);
		}
	}
	
	public void clickById(String id, String message) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			driver.findElement(By.id(id)).click();
		}
		catch(Exception e) {
			throw new Exception(message);
		}
	}
	
	public String getTextByXpath(String xpath, String message) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String actualText = driver.findElement(By.xpath(xpath)).getText();
			return actualText;
		}
		catch(Exception e) {
			throw new Exception(message);
		}
		
	}
	
	public void isWebElementDisplayed(String xpath, String message) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).isDisplayed();
		}
		catch(Exception e) {
			throw new Exception(message);
		}
		
	}
	
	
	public void enterTextByXpath(String xpath, String value, String message) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(value);
		}
		catch(Exception e) {
			throw new Exception(message);
		}
		
	}
	
	
	public void enterTextById(String id, String value, String message) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(value);
		}
		catch(Exception e) {
			throw new Exception(message);
		}
		
	}

}

package com.harsha.seleniumPractice.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GenericMethods {
	
		WebDriver driver;
		WebDriverWait wait;
		
		
	public void clickByXpath(String xpath, String message) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
			Reporter.log("PASS -- Element is clicked successfully", true);
		}
		catch(Exception e) {
			Reporter.log("FAIL --  Element is not clicked", true);
		}
	}

}

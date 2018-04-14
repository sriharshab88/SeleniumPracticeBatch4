package com.harsha.seleniumPractice.testScripts;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumBasicsPractice {
	
	

	@Test
	public void startSelenium() {
		
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver");
		
		WebDriver driver = new FirefoxDriver(); 
		
	}
	
	@Test
	public void stopSelenium() {
		
		System.out.println("Webdriver stopped");
		System.out.println(System.getProperty("user.dir"));
	}
}

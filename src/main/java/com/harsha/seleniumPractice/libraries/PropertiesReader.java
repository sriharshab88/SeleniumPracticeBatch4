package com.harsha.seleniumPractice.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	Properties prop;
	

	public PropertiesReader() {
			
			File file = new File(Configurations.testDataPath);
			  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			}


//****************************************************************************************
	public String getExpectedText() {
		return prop.getProperty("expectedText");
	}

	public String getLoginPageErrorMessage() {
		return prop.getProperty("loginPageError");
	}
	
	public String getLoginPageSuccessMessage() {
		return prop.getProperty("loginPageSuccess");
	}
//****************************************************************************************
	public String getEmail() {
		return prop.getProperty("email");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getExpectedUserName() {
		return prop.getProperty("expectedUserName");
	}
	
	public String getExpectedUserNameErrorMessage() {
		return prop.getProperty("UsernameError");
	}
	
	public String getExpectedUserNameSuccessMessage() {
		return prop.getProperty("UserNameSuccess");
	}
//****************************************************************************************	
	
	
}	
	


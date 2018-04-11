package com.harsha.seleniumPractice.testData;

import com.harsha.seleniumPractice.libraries.PropertiesReader;

public class TestDataReader {

	public static PropertiesReader propReader = new PropertiesReader();
	
	public static String expectedText = propReader.getExpectedText();
	public static String loginPageErrorMsg = propReader.getLoginPageErrorMessage();
	public static String loginPageSuccessMsg = propReader.getLoginPageSuccessMessage();
	
	//**********************************************************************************
	public static String email = propReader.getEmail();
	public static String password = propReader.getPassword();
	public static String expectedUserName = propReader.getExpectedUserName();
	public static String expectedUserNameErrorMsg = propReader.getExpectedUserNameErrorMessage();
	public static String expectedUserNameSuccessMsg = propReader.getExpectedUserNameSuccessMessage();
	
}

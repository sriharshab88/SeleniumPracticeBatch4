package com.harsha.seleniumPractice.testData;

import org.testng.annotations.DataProvider;

public class LoginCredentialsTestData {

	@DataProvider
	public static Object[][] credentialsValidation(){
	return new Object[][] {{"testautomation88@test.com", "123456"},
						    {"seleniumbatch4@test.com", "123456"},
						    {"seleniumbatch441@test.com", "123456"}};
	}
	
	@DataProvider
	public static Object [][] LoginValidationData(){
		
		return new Object[][] {{"Invalid email 1", "emailInvalid", "123456", "Invalid email address."},
							   {"Invalid email 2","email@@@.ttt.com", "123456", "Invalid email address."},
							   {"Blank email","", "123456", "An email address required."},
							   {"Blank password","test@test.com", "", "Password is required."},
							   {"Invalid password", "test@test.com", "1", "Invalid password."},
							   {"Authentication error","test@test.com", "qqqwqsdhbsdhasd", "Authentication failed."},
							   {"All Blanks", "", "", "An email address required."}};
					
		}
}

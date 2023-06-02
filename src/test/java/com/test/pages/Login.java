package com.test.pages;

import com.test.wrappers.GenericWrappers;

public class Login extends GenericWrappers {

	
	
	
	public Login userNameandPasswordfields() {

		
		enterText("//input[contains(@id,'textBox3')]", properties.getProperty("wrongUsername"));
		enterText("//input[contains(@id, 'RyersonPOD.Login_Web_New.textBox5')]",
				properties.getProperty("password"));

		return this;

	}

	public Login signInBtn() {


		btnClick("//button[contains(@class, 'btn mx-button mx-name-actionButton2')]");

		return this;
	}

	public Login getTextFromPage() {

		sleep(2500);

		getTextFromPage("//span[@class='mx-text mx-name-text1 text-left d-block text-danger']");
		return this;
	}

	public Login textValidations() {

		sleep(3000);

		assertEqualsMethod("//span[@class='mx-text mx-name-text1 text-left d-block text-danger']",
				"The username or password you entered is incorrect.");
		return this;

	}

}

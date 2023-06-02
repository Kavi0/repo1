package com.test.testCases;

import org.testng.annotations.Test;

import com.test.pages.Login;

public class TC001_Login {

	@Test
	public void run() throws InterruptedException {

		new Login().userNameandPasswordfields().signInBtn().getTextFromPage().textValidations();

	}

}

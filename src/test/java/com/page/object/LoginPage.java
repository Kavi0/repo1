package com.page.object;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class LoginPage {

	@Test

	public void testLogin()

	{

		WebDriver driver = new ChromeDriver();


		driver.get("http://localhost:8080/index.html?profile=Responsive");
		
		LoginTest logsin = new LoginTest(driver);

		logsin.enterUsername("gAdmin");

		logsin.enterPassword("Welcome1!");

		logsin.clickLoginButton();
		
		driver.close();

	}

}
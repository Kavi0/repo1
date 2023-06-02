package com.test.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.test.wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {

	@Test

	public void launchApp()

	{

		System.out.println("Finding username field...");
		sleep(2500);
		WebElement uName = driver.findElement(By.xpath("//input[contains(@id,'textBox3')]"));
		explicitWait(uName);
		uName.sendKeys(properties.getProperty("username"));
		System.out.println("Username passed...");

		WebElement pWord = driver.findElement(By.xpath("//input[contains(@id, 'RyersonPOD.Login_Web_New.textBox5')]"));
		explicitWait(pWord);
		pWord.sendKeys(properties.getProperty("password"));

		WebElement login = driver
				.findElement(By.xpath("//button[contains(@class, 'btn mx-button mx-name-actionButton2')]"));
		explicitWait(login);
		login.click();
	}

}

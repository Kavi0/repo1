package com.page.object;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class LoginTest {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//input[contains(@id,'textBox3')]")
 
	private WebElement username;

	@FindBy(xpath = "//input[contains(@id, 'RyersonPOD.Login_Web_New.textBox5')]")

	private WebElement password;

	@FindBy(xpath = "//button[contains(@class, 'btn mx-button mx-name-actionButton2')]")

	private WebElement login;

	public LoginTest(WebDriver driver)

	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterUsername(String uname)

	{

		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(uname);

	}

	public void enterPassword(String pword)

	{

		wait.until(ExpectedConditions.visibilityOf(password));
//		element.sendKeys(pword);
		password.sendKeys(pword);

	}

	public void clickLoginButton()

	{

		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();

	}

}
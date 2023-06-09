package com.data.driventest;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginScenario {

	public static WebDriver driver;
	public static Properties properties;

	String[][] data = { 
			{ "gAdmin", "Welcome1!" },
			{ "gAdmin", "dummy" }, 
			{ "dummy", "Welcome1!" },
			{ "dummy", "dummy" } 
			};

	@DataProvider(name = "loginData")
	public String[][] LoginDatProvider() {
		return data;
	}

	@Test(dataProvider = "loginData")
	public void LoginTestCase(String userName, String passWord) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get(url);
		System.out.println("Fetching URL");
		driver.get("http://localhost:8080/index.html?profile=Responsive");

		System.out.println("Finding username field...");

		sleep(3000);
		WebElement uName = driver.findElement(By.xpath("//input[contains(@id,'textBox3')]"));
		explicitWait(uName);
		uName.sendKeys(userName);
		System.out.println("Username passed...");

		WebElement pWord = driver.findElement(By.xpath("//input[contains(@id, 'RyersonPOD.Login_Web_New.textBox5')]"));
		explicitWait(pWord);
		pWord.sendKeys(passWord);

		WebElement login = driver
				.findElement(By.xpath("//button[contains(@class, 'btn mx-button mx-name-actionButton2')]"));
		explicitWait(login);
		login.click();

	}

	public void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void explicitWait(WebElement elementForWait) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(elementForWait));
	}

}

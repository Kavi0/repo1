package com.test.wrappers;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class GenericWrappers {

	public static WebDriver driver;
	public static Properties properties;

	@BeforeSuite
	public void genericWrappers() {

		System.out.println("Properties file loading...");
		properties = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Properties file load completed...");

		System.out.println("Starting chrome browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get(url);
		System.out.println("Fetching URL");
		driver.get(properties.getProperty("url"));

		System.out.println("Finding username field...");

		sleep(3000);
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

	public void enterText(String xpath, String data) {

		WebElement inputText = driver.findElement(By.xpath(xpath));
		explicitWait(inputText);
		inputText.sendKeys(data);

	}

	public void btnClick(String xpath) {

		WebElement clickAction = driver.findElement(By.xpath(xpath));
		explicitWait(clickAction);
		clickAction.click();

	}

	public void getTextFromPage(String xpath) {

		System.out.println("The validation error message is: " + driver.findElement(By.xpath(xpath)).getText());
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

	public void assertEqualsMethod(String xpath, String expectedText) {

		String actualText = driver.findElement(By.xpath(xpath)).getText();
		assertEquals(actualText, expectedText);

	}

	public void clickCheckBox(String xpath) {

		driver.findElement(By.xpath(xpath)).click();
	}

	public void clickRadioButton(String xpath) {

		driver.findElement(By.xpath(xpath)).click();
	}

	public void searchBox(String xpath) {

		driver.findElement(By.xpath(xpath)).click();

	}
	
	
	public void datePickerWidget() {
		
		/*
		 * WebElement calendar =
		 * driver.findElement(By.xpath("//button[@aria-label='Show date picker']"));
		 * calendar.click();
		 */

		String enteredYear = properties.getProperty("enterYear");
		String enteredDate = properties.getProperty("enterDate");
		
		
		System.out.println(enteredYear);

		int integerYear = Integer.parseInt(enteredYear);
		System.out.println(integerYear);
		int futureYear=integerYear+1;
		int previousYear=integerYear-1;
		int currentYear = 2023;
		WebElement yearElement;
		
		// Create a Map
		Map<String, String> monthMap = new HashMap<String, String>();
		monthMap.put("January", "1");
		monthMap.put("February", "2");
		monthMap.put("March", "3");
		monthMap.put("April", "4");
		monthMap.put("May", "5");
		monthMap.put("June", "6");
		monthMap.put("July", "7");
		monthMap.put("August", "8");
		monthMap.put("September", "9");
		monthMap.put("October", "10");
		monthMap.put("November", "11");
		monthMap.put("December", "12");
		
		String monthValue = monthMap.get(properties.getProperty("enterMonth"));
		System.out.println(monthValue);
		
		
		if (integerYear < currentYear) {
		    // Code to execute if condition1 is true
		    String yearXpath = "//span[@class='mx-calendar-year-previous'=" + properties.getProperty("enterYear") + "]";
		   // String yearXpath = "//span[@class='mx-calendar-year-previous' =2010]";
		    yearElement = driver.findElement(By.xpath(yearXpath));

		   // int targetYear = integerYear - 1;
		    while (Integer.parseInt(yearElement.getText()) > previousYear) {
		        // Code to execute while condition is true

		        yearElement.click();

		        yearElement = driver.findElement(By.xpath(yearXpath));
		    }
		} else if (integerYear > currentYear) {
		    // Code to execute if condition1 is false
		    String yearXpath1 = "//span[@class='mx-calendar-year-next'=" + properties.getProperty("enterYear") + "]";
		    WebElement yearElement1 = driver.findElement(By.xpath(yearXpath1));

		   // int targetYear1 = integerYear;
		    while (Integer.parseInt(yearElement1.getText()) < futureYear) {
		        // Code to execute while condition3 is true

		        yearElement1.click();

		        yearElement1 = driver.findElement(By.xpath(yearXpath1));
		    }
		} else {
		    String yearXpath2 = "//span[@class='mx-calendar-year-selected'=2023]";
		    WebElement yearElement2 = driver.findElement(By.xpath(yearXpath2));
		    yearElement2.click();

		}
		
		WebElement dropdown = driver.findElement(By.

				xpath("//span[@class=\"glyphicon glyphicon-chevron-down\"]"));

				dropdown.click(); 
		
				driver.findElement(By.xpath("//div[contains(@class, 'mx-calendar-month-dropdown-options')]/div[contains(text()," + "'" + properties.getProperty("enterMonth") +"')]")).click();

				//driver.findElement(By.xpath("//td[contains(@aria-label,'1/1/2010')]")).click();

				driver.findElement(By.xpath("//td[contains(@aria-label,'"+monthValue+"/"+enteredDate+"/"+enteredYear+"')]")).click();

				//driver.findElement(By.xpath("//td[contains(@aria-label,'"+"2"+"/"+"20"+"/"+enteredYear+"')]")).click();
	}
	

}
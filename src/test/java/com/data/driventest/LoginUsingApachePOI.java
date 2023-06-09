package com.data.driventest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginUsingApachePOI {

	public static WebDriver driver;
	public static Properties properties;

	List<String> userNameLists = new ArrayList<String>();
	List<String> passwordsLists = new ArrayList<String>();

	public void readExcel() throws IOException {

		FileInputStream excel = new FileInputStream("D:\\TestData\\RyersonPODLogin.xlsx");
		Workbook workbook = new XSSFWorkbook(excel);

		Sheet sheet = workbook.getSheet("Sheet1");

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row rowValues = rowIterator.next();

			Iterator<Cell> columnIterator = rowValues.iterator();

			int i = 2;

			while (columnIterator.hasNext()) {

				if (i % 2 == 0) {

					userNameLists.add(columnIterator.next().toString());

				} else {

					passwordsLists.add(columnIterator.next().toString());

				}
				i++;

			}

		}

	}
	
	
	/*
	 * for (int i = 0; i < userNameLists.size(); i++) { String userName =
	 * userNameLists.get(i); String passWord = passwordsLists.get(i);
	 * //login(userName, passWord); }
	 */
	

	/*
	 * public void login(String userName, String passWord) { // Rest of the method
	 * implementation remains the same }
	 */

	@Test
	public void LoginTestCase(String userName1, String passWord1) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get(url);
		System.out.println("Fetching URL");
		driver.get("http://localhost:8080/index.html?profile=Responsive");

		
		
		System.out.println("Finding username field...");

		sleep(3000);
		WebElement uName = driver.findElement(By.xpath("//input[contains(@id,'textBox3')]"));
		explicitWait(uName);
		uName.sendKeys(userName1);
		System.out.println("Username passed...");

		WebElement pWord = driver.findElement(By.xpath("//input[contains(@id, 'RyersonPOD.Login_Web_New.textBox5')]"));
		explicitWait(pWord);
		pWord.sendKeys(passWord1);

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

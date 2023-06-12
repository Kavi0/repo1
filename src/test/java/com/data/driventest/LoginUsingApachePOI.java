package com.data.driventest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginUsingApachePOI {

	public static WebDriver driver;
	public static Properties properties;

	@Test
	public String[][] readExcel() throws IOException {

		FileInputStream excel = new FileInputStream("D:\\TestData\\RyersonPODLogin.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excel);

		Sheet sheet = workbook.getSheetAt(0);

		int LastRowNum = sheet.getLastRowNum();
		short LastCellNum = sheet.getRow(0).getLastCellNum();

		System.out.println("No of rows in this sheet: " + LastRowNum);

		String[][] data = new String[LastRowNum][LastCellNum];

		for (int i = 1; i <= LastRowNum; i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < LastCellNum; j++) {

				Cell cell = row.getCell(j);

				String value = cell.getStringCellValue();
				System.out.println(value);
				data[i - 1][j] = value;
			}
		}
		workbook.close();
		return data;

	}

	@DataProvider(name = "loginData")
	public String[][] LoginDatProvider() throws IOException {
		return readExcel();
	}

	@Test(dataProvider = "loginData")
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

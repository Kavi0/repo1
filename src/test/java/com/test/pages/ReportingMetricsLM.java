package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.wrappers.GenericWrappers;

public class ReportingMetricsLM extends GenericWrappers {

	
	@Test
	public ReportingMetricsLM LoginAsLM() {
		
		sleep(3000);
		WebElement uName = driver.findElement(By.xpath("//input[contains(@id,'textBox3')]"));
		explicitWait(uName);
		uName.sendKeys(properties.getProperty("logisticUsername"));
		
		WebElement pWord = driver.findElement(By.xpath("//input[contains(@id, 'RyersonPOD.Login_Web_New.textBox5')]"));
		explicitWait(pWord);
		pWord.sendKeys(properties.getProperty("logisticsPassword"));

		WebElement login = driver
				.findElement(By.xpath("//button[contains(@class, 'btn mx-button mx-name-actionButton2')]"));
		explicitWait(login);
		login.click();
		
		return this;
	}
	
public ReportingMetricsLM LMReportingMetrics() {
		
	sleep(2000);
	WebElement MetricsCard = driver.findElement(By.xpath("//img[contains(@class, 'mx-image mx-name-staticImage5')]"));
	explicitWait(MetricsCard);
	MetricsCard.click();
	
	//expand search button
	sleep(1500);
	driver.findElement(By.id("mxui_widget_ControlBarButton_0")).click();
	
	WebElement main = driver.findElement(By.xpath("//div[@id=\"mxui_widget_SearchInput_0\"]"));
	WebElement search = main.findElement(By.xpath("//input[@type='text']"));
	search.sendKeys("GULF COAST/ATLANTA");
	search.sendKeys(Keys.ENTER);
	
	WebElement mainRow = driver.findElement(By.xpath("//tr[@tabindex=\"0\"]"));
	String childXpath1 = mainRow.findElement(By.xpath("//td[@class='mx-name-column24 mx-right-aligned']")).getText();
	System.out.println("Total Shipments metrics is : " + childXpath1);

	
	sleep(1500);
	//logout from the application
	driver.findElement(By.xpath("//button[@title=\"Logout\"]")).click();
		return this;
	}
	
	
	
}

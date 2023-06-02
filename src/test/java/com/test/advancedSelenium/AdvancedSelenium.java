 package com.test.advancedSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdvancedSelenium {

	WebDriver driver = new ChromeDriver();

//	@Test
//	public void TestRun() throws InterruptedException {
//
//		driver.get("http://www.seleniumframework.com/Practiceform/");
//
//		driver.findElement(By.id("alert")).click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
//
//		driver.findElement(By.id("button1")).click();
//
//		String windowHandle = driver.getWindowHandle();
//		System.out.println("Parent window: " + windowHandle);
//
//		Set<String> windowHandles = driver.getWindowHandles();
//		System.out.println(windowHandles);
//
//		List<String> list = new ArrayList<String>(windowHandles);
//		driver.switchTo().window(list.get(1));
//
//		Thread.sleep(2000);
//		System.out.println(driver.getCurrentUrl());
//
//		driver.switchTo().window(list.get(0));
//		driver.close();
//
//		driver.switchTo().window(list.get(1));
//		driver.close();
//
//	}

	@Test
	public void frameConcepts() throws InterruptedException {

		driver.get("https://letcode.in/frame");
		driver.switchTo().frame(0);
		driver.findElement(By.name("fname")).sendKeys("Kavi");
		driver.findElement(By.name("lname")).sendKeys("bharathi");
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='card-footer-item']")).sendKeys("email");
		
	}

}

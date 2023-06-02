package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.wrappers.GenericWrappers;

public class AccountOverview extends GenericWrappers {
 
	@Test
	public AccountOverview AccOverviewPage() {

		sleep(2000);
		WebElement AccCard = driver.findElement(By.xpath("//img[contains(@class, 'mx-image mx-name-staticImage')]"));
		explicitWait(AccCard);
		AccCard.click();
		return this;
	}

	@Test
	public AccountOverview NewAcc() {

		sleep(1250);
		WebElement CreateAcc = driver
				.findElement(By.xpath("//button[@class='btn mx-button mx-name-microflowButton2 btn-primary']"));
		explicitWait(CreateAcc);
		CreateAcc.click();

		sleep(1000);
		WebElement FullName = driver
				.findElement(By.xpath("//input[contains(@id, 'Administration.Account_New.textBox6')]"));
		explicitWait(FullName);
		FullName.sendKeys((properties.getProperty("logisticsFullName")));

		sleep(1000);
		WebElement UserName = driver
				.findElement(By.xpath("//input[contains(@id, 'Administration.Account_New.textBox9')]"));
		explicitWait(UserName);
		UserName.sendKeys((properties.getProperty("logisticUsername")));

		sleep(1000);
		WebElement Email = driver
				.findElement(By.xpath("//input[contains(@id, 'Administration.Account_New.textBox1')]"));
		explicitWait(Email);
		Email.sendKeys((properties.getProperty("email")));

		sleep(1000);
		WebElement user = driver.findElement(By.xpath("//*[contains(@class, 'mx-name-referenceSetSelector2')]"));
		sleep(800);
		WebElement selectRole = user.findElement(
				By.xpath("//button[contains(@class, 'btn mx-button mx-referencesetselector-select-button')]"));
		selectRole.click();

		// selecting Logistics_Manager user role
		sleep(800);
		driver.findElement(By.xpath("//div[normalize-space()='Logistics_Manager']")).click();
		// Click Select Button
		sleep(800);
		driver.findElement(By.xpath("//button[contains(@class, 'btn mx-button mx-name-selectButton1 btn-primary')]"))
				.click();

		sleep(1000);
		driver.findElement(By.xpath("//label[contains(@id, 'Administration.Account_New.referenceSetSelector3')]"))
				.click();
		sleep(1000);
		// search expand button		
		driver.findElement(By.xpath("//button[contains(@data-mendix-id, 'Administration.PlantDB_Select.searchButton1')]")).click();
			
		sleep(2000);
		
		//plant select fields
		WebElement plantName = driver.findElement(By.xpath("//div[@class='mx-grid-search-input mx-name-searchField2']//input[@type='text']"));
		
		
		plantName.sendKeys("ATLANTA GENERAL LINE");
		plantName.sendKeys(Keys.ENTER);
		sleep(1500);
		WebElement parentRow = driver.findElement(By.xpath("//div[normalize-space()='ATLANTA GENERAL LINE']"));
		sleep(1000);
		parentRow.click();
		driver.findElement(By.xpath("//button[contains(@data-mendix-id, 'Administration.PlantDB_Select.selectButton1')]")).click();
		
		//new password
		driver.findElement(By.xpath("//input[contains(@id, 'Administration.Account_New.textBox5')]")).sendKeys("12345");
		//confirm password
		driver.findElement(By.xpath("//input[contains(@id, 'Administration.Account_New.textBox7')]")).sendKeys("12345");
		//save button
		sleep(2500);
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

		sleep(1500);
		// acc overview search expand button
		driver.findElement(
				By.xpath("//button[contains(@data-mendix-id, 'Administration.Account_Overview.searchButton1')]"))
				.click();
		sleep(2000);
		WebElement accUsername = driver.findElement(
				By.xpath("//div[@class='mx-grid-search-input mx-name-searchField5']//input[@type='text']"));

		// WebElement accUNameField = accUsername.findElement(By.xpath(""));

		accUsername.sendKeys((properties.getProperty("logisticUsername")));
		accUsername.sendKeys(Keys.ENTER);

		String givenName="//td[@title=\""+(properties.getProperty("logisticUsername"))+"\"]";
		
		//"//td[@title=\""+(properties.getProperty("logisticUsername"))+"\"]"
		
		WebElement parentRow1 = driver.findElement(By.xpath("//tr[@tabindex=\"0\"]"));
		//String userNameConfirm = parentRow1.findElement(By.xpath(givenName)).getText();
		//String userNameConfirm = parentRow1.findElement(By.xpath(givenName)).getText();
		String userNameConfirm = parentRow1.findElement(By.xpath("//td[@title=\""+(properties.getProperty("logisticUsername"))+"\"]")).getText();
		System.out.println(userNameConfirm);

		if (userNameConfirm.equals(properties.getProperty("logisticUsername"))) {
			System.out.println("Logistics Manager is created with user name"+ (properties.getProperty("logisticUsername")));

		} else {
			System.out.println("Logistics Manager is not created yet");

		}

		driver.findElement(By.xpath("//a[@role='button']")).click();
		
		sleep(1500);
		//logout from the application
		driver.findElement(By.xpath("//button[@title=\"Logout\"]")).click();

//	sleep(1500);
//	WebElement WebUser = driver.findElement(By.xpath("//input[@type='radio' and @value='true']"));
//	explicitWait(WebUser);
//	WebUser.click();
//	
//	sleep(1500);
//	WebElement timeZone = driver.findElement(By.xpath("//option[@value='14355223812243960']"));
//	timeZone.click();
		return this;
	}

}

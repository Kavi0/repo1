package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.wrappers.GenericWrappers;

public class PlantOverviewPage extends GenericWrappers {

	@Test (priority = 1)
	public  PlantOverviewPage PlantOverview() {

		sleep(5000);
		
		WebElement plantCard = driver.findElement(By.xpath("//img[contains(@class, 'mx-image mx-name-staticImage1')]"));
		explicitWait(plantCard);
		plantCard.click();
		return this;
	}

	@Test (priority = 2)
	public PlantOverviewPage PlantActiveStatus() {
		
//		sleep(5000);
//		WebElement datagridRow1 = driver.findElement(By.xpath("//*[contains(@id, 'mxui_widget_ListViewItem_0')]"));
//		sleep(5000);
//		WebElement checkBox1 = datagridRow1.findElement(By.xpath("//input[contains(@id, 'RyersonPOD.Plant_overview_Admin.checkBox2')]"));
		
		sleep(5000);
		WebElement datagridRow2 = driver.findElement(By.xpath("//*[contains(@id, 'mxui_widget_ListViewItem_1')]"));
		sleep(5000);
		WebElement checkBox2 = datagridRow2.findElement(By.xpath("//input[contains(@id, 'RyersonPOD.Plant_overview_Admin.checkBox2')]"));
		
//		if (checkBox2.isSelected())
//		{
//			System.out.println("Check box is already selected");
//		}
//		else
		checkBox2.click();
		
		sleep(2000);
		clickCheckBox("//button[normalize-space()='Proceed']");
		
		sleep(5000);
		WebElement closeCnfmPopup = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		closeCnfmPopup.click();				
		return this;

	}

}

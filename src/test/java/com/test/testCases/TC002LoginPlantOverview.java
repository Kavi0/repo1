package com.test.testCases;

import org.testng.annotations.Test;

import com.test.pages.AccountOverview;
import com.test.pages.LoginPage;
import com.test.pages.PlantOverviewPage;

public class TC002LoginPlantOverview {

	@Test
	public void run () {
		
		new PlantOverviewPage().PlantOverview().PlantActiveStatus();		
		
	}
	
}

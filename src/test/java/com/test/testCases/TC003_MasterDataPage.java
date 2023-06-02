package com.test.testCases;

import org.testng.annotations.Test;

import com.test.pages.MasterData;

public class TC003_MasterDataPage {
	
	
	@Test
	public void run() throws InterruptedException {

		new MasterData()
		.MasterDataPage().
		completedDateCalender()
		.createdDateCalender();

	}

}

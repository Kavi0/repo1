package com.test.testCases;

import org.testng.annotations.Test;

import com.test.pages.AccountOverview;
import com.test.pages.LoginPage;

public class TC004CreateNewAcc {

	@Test
	public void run () {
		
		new AccountOverview().AccOverviewPage().NewAcc();

	}
	
}

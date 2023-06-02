package com.test.testCases;

import org.testng.annotations.Test;
import com.test.pages.ReportingMetricsLM;

public class TC005LMReportingMetrics {

	@Test
	public void run () {
		
		new ReportingMetricsLM().LoginAsLM().LMReportingMetrics();

	}
	
}

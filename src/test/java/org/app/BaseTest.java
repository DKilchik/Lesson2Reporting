package org.app;

import com.aventstack.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import report.ExtentReportManager;

public class BaseTest {

    protected static ExtentReports extent;


     @BeforeSuite
        public void setUp() {
         extent = ExtentReportManager.createExtentReport();
        }

        @AfterSuite
        public void tearDown() {
            extent.flush();
        }

}

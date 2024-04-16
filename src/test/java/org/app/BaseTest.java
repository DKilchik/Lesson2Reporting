package org.app;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ExtentHtmlReporter htmlReporter;

     @BeforeSuite
        public void setUp() {
            htmlReporter = new ExtentHtmlReporter("extent.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }

        @AfterSuite
        public void tearDown() {
            extent.flush();
        }

}

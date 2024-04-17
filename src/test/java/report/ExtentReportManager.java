package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;

    public static ExtentReports createExtentReport(){
        htmlReporter = new ExtentHtmlReporter("extent.html");
        // set title and theme
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // set system info
        extent.setSystemInfo("Author","Orange Systems");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("OS","Windows 10");

        return extent;
    }
}

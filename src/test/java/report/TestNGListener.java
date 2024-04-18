package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener {

    ExtentReports extentReports;
    public static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context){
        extentReports = ExtentReportManager.createExtentReport();
    }

    @Override
    public void onFinish(ITestContext context){
        if(extentReports != null){
            extentReports.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        extentTest.fail(result.getThrowable());
    }
}

package Retrieving_API_Keys.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        repName="Test-Report-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);

        sparkReporter.config().setDocumentTitle("Lendsq_Adjutor APIs"); // Title of report
        sparkReporter.config().setReportName("Test Execution Results"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);
//            try {
//                sparkReporter.loadXMLConfig(".\\src\\test\\resources\\extent-config.xml");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "API");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","Silas Francis");
    }


    public void onTestSuccess(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.PASS, "Test Passed");
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        String screenshotPath = System.getProperty("user.dir")+ "\\Screenshots\\"+result.getName()+".png";
        File f = new File(screenshotPath);
        if(f.exists())
        {
            try{
                test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void onTestSkipped(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context)
    {
        extent.flush();
    }

}

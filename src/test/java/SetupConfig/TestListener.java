package SetupConfig;

import API.WebDriverAPI;
import StepDefination.SearchOption;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 * Created by pravin.kumbhare on 25-07-2018.
 */
public class TestListener extends BaseTestScript implements ITestListener {
    String filePath = "D:\\SCREENSHOTS";

  /*  public TestListener(WebDriver webdriver) {
        super(webdriver);
    }*/


    @Override
    public void onTestStart(ITestResult iTestResult) {

        System.out.println("The Start Testcase name is : "+iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("The name of the testcase passed/success is :"+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("The Failed Test case name is : "+iTestResult.getName());

        System.out.println("*********ERROR*****"+iTestResult.getName()+"******test has failed*******");
        String methodName = iTestResult.getName().toString().trim();
        System.out.println("methodName is : "+methodName);
        try {
            takeScreenShot(methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShot(String methodName) throws IOException {
        //get the driver
        System.out.println("***Placed screen shot in "+filePath+" ***");
        File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,  new File(filePath+methodName+".png"));
        System.out.println("***Placed screen shot in "+filePath+" ***");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        System.out.println("The name of the Testcase skipped is : "+iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

package Runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

/**
 * Created by pravin.kumbhare on 20-07-2018.
 */



@RunWith(Cucumber.class)
@CucumberOptions(features={"D:\\Solaris Project\\solaris\\Appium_Android_Project\\src\\test\\java\\Feature"},
        glue={"StepDefination"},
        tags={"@SmokeTest"},
        //plugin = { "pretty", "html:target/htmlreports" },
        //Generating Extent Report
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true)


public class TestRunner {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("D:\\Solaris Project\\solaris\\Appium_Android_Project\\config\\report.xml"));
    }
}

package ZGroup;

import SetupConfig.BaseTestScript;

/**
 * Created by pravin.kumbhare on 11-08-2018.
 */
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class ScreenshootGoogle extends BaseTestScript{

    @Test
    public void TestJavaS1() throws IOException {

        // Open Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pravin.kumbhare\\Downloads\\geckodriver-v0.9.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pravin.kumbhare\\Desktop\\chromedriver.exe");
        WebDriver webdriver1 = new ChromeDriver();
// Maximize the window
        webdriver1.manage().window().maximize();

// Pass the url
        webdriver1.get("http://www.google.com");

// Take screenshot and store as a file format
        File src = ((TakesScreenshot) webdriver1).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(src, new File("C:/selenium/error.png"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}


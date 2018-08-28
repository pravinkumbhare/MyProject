package ZGroup;

import SetupConfig.BaseTestScript;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by pravin.kumbhare on 10-08-2018.
 */

@Listeners(SetupConfig.TestListener.class)
public class CaptureScreenShotForFailureTestcases extends BaseTestScript{


    @Test (priority = 0)
    public void openBrowser(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pravin.kumbhare\\Downloads\\geckodriver-v0.9.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pravin.kumbhare\\Desktop\\chromedriver.exe");
        webdriver = new ChromeDriver();
        Assert.assertTrue(webdriver!=null,"Failed Testcase..");
        System.out.println("openBrowser====Testcase");
    }

    @Test (priority = 1)
    public void Login() throws InterruptedException, IOException {
//        String fileWithPath = "D:\\SCREENSHOTS\\test.png";

        webdriver.get("http://demo.guru99.com/V4/");
        Thread.sleep(3000);
        webdriver.findElement(By.name("uid")).sendKeys("mngr147982");
        webdriver.findElement(By.name("password")).sendKeys("vuvAhaq");
        webdriver.findElement(By.name("btnLogin")).click();

        Assert.assertTrue(false);
    }

    // Forcefully failed this test as to verify listener.
    @Test (priority = 2)
    public void TestToFail(){

        System.out.println("This method to test fail");
        Assert.assertTrue(false);
    }
}

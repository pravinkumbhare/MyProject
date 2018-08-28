import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by pravin.kumbhare on 18-07-2018.
 */
public class Login_Demo {
    public  AndroidDriver driver;
    public DesiredCapabilities capabilities;
    public String searchEmployee = "Kapil Bawankar";

    @BeforeClass
    public void prerequesite() throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        capabilities.setCapability("deviceName", "Redmi not 4");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion", "6.0.1");

        capabilities.setCapability("appPackage", "app.globallogic.com.glo");
        capabilities.setCapability("appActivity","app.globallogic.com.glo.view.activities.Splash");
        capabilities.setCapability("noReset", true);

        //Instantiate Appium Driver
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test(priority = 1)
    public void loginTest() throws MalformedURLException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@text = 'Username']")).sendKeys("pravin.kumbhare@globallogic.com");
        driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/et_password')]")).sendKeys("Pr@vin_2021");;

        driver.findElement(By.xpath("//*[@text = 'Login']")).click();
        Thread.sleep(7000);
        boolean isVisible = driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/action_search')]")).isDisplayed();
        Assert.assertTrue(isVisible, "User unable to login");
        System.out.print("User Login successfully..");
    }

    @Test(priority = 2)
    public void searchEmployee() throws InterruptedException, MalformedURLException {
        //Instantiate Appium Driver
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        boolean isVisible = driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/action_search')]")).isDisplayed();
        Assert.assertTrue(isVisible, "User is not loggedIn..");

        if (isVisible) {
            driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/action_search')]")).click();

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/searchKeyword')]")));

            driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/searchKeyword')]")).sendKeys(searchEmployee);

            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/result_LL')]")).click();
            Thread.sleep(5000);
            String actualName = driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/tvUserName')]")).getText();
            System.out.println(actualName);
            Assert.assertEquals(searchEmployee, actualName);
            System.out.println("Testcase Passed..");
        }
    }

}

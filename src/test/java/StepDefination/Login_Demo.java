package StepDefination;

import API.WebDriverAPI;
import SetupConfig.BaseTestScript;
import UIComponents_Locators.LoginPageComponents;
import UIComponents_Locators.SearchPageComponents;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import screen.abstractScreen.SearchScreen;
import screen.android.AndroidLoginScreen;
import screen.android.AndroidSearchScreen;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by pravin.kumbhare on 20-07-2018.
 */
public class Login_Demo extends BaseTestScript{
    /*public  AndroidDriver<AndroidElement> driver;
    public DesiredCapabilities capabilities;
    public String searchEmployee = "";
    AppiumDriverLocalService service;

    //Creating the Object of LoginPageComponents and SearchPageComponents to access Android Element/Locators
    LoginPageComponents loginpagecomponents;
    SearchPageComponents searchpagecomponents;
    WebDriverAPI webDriverAPI;

    AndroidSearchScreen androidSearchScreen;
    AndroidLoginScreen androidLoginScreen;
    //SearchScreen searchScreen;
*/
    LoginPageComponents loginpagecomponents;

    @Before
    public void prerequisite() throws InterruptedException {

        System.out.println("Execute before all the suites execution");
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        Thread.sleep(7000L);
    }

    @Given("^Open apps and User Navigate to LogIn Page$")
    public void open_Firefox_and_start_application() throws Throwable {

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

        //Creating the Object of LoginPageComponents and SearchPageComponents to access Android Element/Locators
        loginpagecomponents = new LoginPageComponents(driver);
        searchpagecomponents = new SearchPageComponents(driver);
        webDriverAPI = new WebDriverAPI(driver);

        androidLoginScreen = new AndroidLoginScreen(driver);
        androidSearchScreen = new AndroidSearchScreen(driver);

       // searchScreen = new AndroidSearchScreen(driver);
    }

    @When("^Enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_valid_and(String usrname, String pwd) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //webDriverAPI.implicitWait(10);
        Thread.sleep(4000);

        Assert.assertTrue(loginScreen.loginPageReusableMethod(), "Login page Reusable method return false.");
        loginpagecomponents.Username.sendKeys(usrname);
        loginpagecomponents.Password.sendKeys(pwd);
        loginpagecomponents.LoginButton.click();

        androidLoginScreen.loginPageReusableMethod();
    }


    @Then("^Message displayed Login Successfully$")
    public void user_should_be_able_to_login_into_the_application() throws Throwable {
        Thread.sleep(7000);
        //boolean isVisible = driver.findElement(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/action_search')]")).isDisplayed();
        boolean isVisible = searchpagecomponents.SearchIcon.isDisplayed();
        Assert.assertTrue(isVisible, "User unable to login");
        System.out.print("User Login successfully..");
    }


    @After
    public void postrequesite(){
        service.stop();
    }

}

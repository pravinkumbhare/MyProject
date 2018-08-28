package StepDefination;

import API.WebDriverAPI;
import SetupConfig.BaseTestScript;
import UIComponents_Locators.LoginPageComponents;
import UIComponents_Locators.SearchPageComponents;
import common.Constants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import screen.android.AndroidLoginScreen;
import screen.android.AndroidSearchScreen;

import java.net.URL;

import static common.Constants.TIMEOUT;
import static common.Constants.searchEmployee;

/**
 * Created by pravin.kumbhare on 25-07-2018.
 */
public class SearchOption extends BaseTestScript{
  /*  public AndroidDriver<AndroidElement> driver;
    public DesiredCapabilities capabilities;
    public String searchEmployee = "";
    AppiumDriverLocalService service;

    //Creating the Object of LoginPageComponents and SearchPageComponents to access Android Element/Locators
    LoginPageComponents loginpagecomponents;
    SearchPageComponents searchpagecomponents;
    WebDriverAPI webDriverAPI;

    AndroidSearchScreen androidSearchScreen;
    AndroidLoginScreen androidLoginScreen;
    //SearchScreen searchScreen;*/

    @Given("^Open apps and User Navigate to LogIn Page.$")
    public void open_Firefox_and_start_application() throws Throwable {

        System.setProperty(AppiumServiceBuilder.NODE_PATH ,
                "C:\\Program Files\\nodejs\\node.js");

        System.setProperty(AppiumServiceBuilder.APPIUM_PATH ,
                "C:\\Users\\pravin.kumbhare\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

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

    @When("^Search an \"([^\"]*)\"$")
    public void search_an(String searchedEmployee) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);

        searchScreen.searchPageReusableMethod();
        searchpagecomponents.SearchIcon.click();
        logger.debug("Clicking on Search Icon");
        //    webDriverAPI.Wait_For_Element_To_Appear(searchpagecomponents.SearchTextBox);

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'app.globallogic.com.glo:id/searchKeyword')]")));

        searchEmployee = searchedEmployee;
        searchpagecomponents.SearchTextBox.sendKeys(searchEmployee);
        logger.debug("Employee name is entered on searched box : "+searchedEmployee);
        Thread.sleep(3000);
        searchpagecomponents.SearchButton.click();

    }

    @Then("^Employee name should be displayed in searched option$")
    public void employee_name_should_be_displayed_in_searched_option() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
        String actualName = searchpagecomponents.SearchResult.getText();
        System.out.println(actualName);
        Assert.assertTrue(actualName.equalsIgnoreCase(searchEmployee),"Searched Employee not found");
        logger.debug("Testcase Passed..");

    }
}

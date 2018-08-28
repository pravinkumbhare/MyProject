package SetupConfig;

import API.WebDriverAPI;
import StepDefination.Login_Demo;
import UIComponents_Locators.LoginPageComponents;
import UIComponents_Locators.SearchPageComponents;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import screen.abstractScreen.LoginScreen;
import screen.abstractScreen.SearchScreen;
import screen.android.AndroidLoginScreen;
import screen.android.AndroidSearchScreen;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by pravin.kumbhare on 24-07-2018.
 */
public class BaseTestScript extends SuperBaseClass{
    //To configure a logger in the project
    public final static Logger logger = Logger.getLogger(BaseTestScript.class);

    public AndroidDriver<AndroidElement> driver;
    public DesiredCapabilities capabilities;
    //public String searchEmployee = "";
    public AppiumDriverLocalService service;

    //Creating the Object of LoginPageComponents and SearchPageComponents to access Android Element/Locators
    public LoginPageComponents loginpagecomponents;
    public SearchPageComponents searchpagecomponents;
    public WebDriverAPI webDriverAPI;

    public AndroidSearchScreen androidSearchScreen;
    public AndroidLoginScreen androidLoginScreen;
    //SearchScreen searchScreen;

    public BaseTestScript(){}


    @Override
    public void setLogger(){
        //To configure a logger in the project
        PropertyConfigurator.configure("D:\\Solaris Project\\solaris\\Appium_Android_Project\\src\\test\\resources\\log4j.properties");
        System.out.print("Debugging..1");
    }

    ScreenFactory screenFactory = new ScreenFactory();
    public LoginScreen loginScreen = screenFactory.getScreen(ScreenFactory.PLATFORM_ANDROID,ScreenFactory.LOGIN_SCREEN);
    public SearchScreen searchScreen = screenFactory.getScreen(ScreenFactory.PLATFORM_ANDROID,ScreenFactory.SEARCH_SCREEN);

    /*@Override
    public void initScreen(){
        System.out.print("Debugging..");
       // screenFactory = new ScreenFactory();

        loginScreen = screenFactory.getScreen(ScreenFactory.PLATFORM_ANDROID,ScreenFactory.LOGIN_SCREEN);
        searchScreen = screenFactory.getScreen(ScreenFactory.PLATFORM_ANDROID,ScreenFactory.SEARCH_SCREEN);
    }*/


    //Code for a RestAssured API Test
    public static Properties prop ;

    @BeforeTest
    public void getData() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Solaris Project\\solaris\\Appium_Android_Project\\src\\test\\resources\\environment.properties");
        prop.load(fis);
    }



    //RestAssured API Code
    public static String boardID = "", boardName = "";
    public static String list_ID = "";
    public static String cardID = "", cardName = "";


    //WebApplication
    public static WebDriver webdriver = null;

}

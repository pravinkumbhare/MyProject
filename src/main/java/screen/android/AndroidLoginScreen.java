package screen.android;

import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import screen.abstractScreen.LoginScreen;

/**
 * Created by pravin.kumbhare on 24-07-2018.
 */
public class AndroidLoginScreen extends LoginScreen {
    //To configure a logger in the project
    final static Logger logger = Logger.getLogger(AndroidSearchScreen.class);

    @BeforeSuite
    public void setLogger(){
        //To configure a logger in the project
        PropertyConfigurator.configure("D:\\Solaris Project\\solaris\\Appium_Android_Project\\src\\test\\resources\\log4j.properties");
    }

    public AndroidLoginScreen(){}

    public AndroidLoginScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(driver, this);
    }


    /**
     * Test Method
     * @return boolean
     */
    @Override
    public boolean loginPageReusableMethod(){
        boolean isVisible = true;

        if(isVisible){
            //System.out.println("Reusable Method...");
            logger.debug("AndroidSearchScreen Method is accessable...");
            return isVisible;
        }
        return false;
    }
}

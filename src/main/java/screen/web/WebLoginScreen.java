package screen.web;

import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import screen.abstractScreen.LoginScreen;
import screen.android.AndroidSearchScreen;

/**
 * Created by pravin.kumbhare on 25-07-2018.
 */
public class WebLoginScreen extends LoginScreen {
    //To configure a logger in the project
    final static Logger logger = Logger.getLogger(AndroidSearchScreen.class);

    @Before
    public void setLogger(){
        //To configure a logger in the project
        PropertyConfigurator.configure("D:\\Solaris Project\\solaris\\Appium_Android_Project\\src\\test\\resources\\log4j.properties");
    }



    @Override
    public boolean loginPageReusableMethod() {
        boolean isVisible = true;

        if(isVisible){
            //System.out.println("Reusable Method...");
            logger.debug("AndroidSearchScreen Method is accessable...");
            return isVisible;
        }
        return false;
    }
}

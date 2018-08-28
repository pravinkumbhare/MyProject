package API;

import cucumber.api.java.gl.E;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by pravin.kumbhare on 23-07-2018.
 */
public class WebDriverAPI {
    AppiumDriver<AndroidElement> drivers;
    public WebDriver webdriver;

    public WebDriverAPI(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.drivers = driver;

    }

  /*  public WebDriverAPI(WebDriver webdriver){
        PageFactory.initElements(webdriver, this);
        this.webdriver = webdriver;
    }*/


    /**
     * This method is used to wait until the visibility of the expected element
     * @param element
     * @return
     */
    public void Wait_For_Element_To_Appear(WebElement element){
        System.out.println("Element Name is : "+element.getText());

        try{
            WebDriverWait wait = new WebDriverWait(drivers, 60);
            wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    /**
     * This method is used for adding wait for given time
     * @param time
     */
    public void implicitWait(long time){
        try{
            drivers.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}

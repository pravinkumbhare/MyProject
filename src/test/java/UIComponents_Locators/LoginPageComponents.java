package UIComponents_Locators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pravin.kumbhare on 23-07-2018.
 */
public class LoginPageComponents {

    public LoginPageComponents(AndroidDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'app.globallogic.com.glo:id/et_username')]")
    public WebElement Username;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'app.globallogic.com.glo:id/et_password')]")
    public WebElement Password;

    @AndroidFindBy(xpath = "//*[@text = 'Login']")
    public WebElement LoginButton;


}

package UIComponents_Locators;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pravin.kumbhare on 23-07-2018.
 */
public class SearchPageComponents {

    public SearchPageComponents(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'app.globallogic.com.glo:id/action_search')]")
    public WebElement SearchIcon;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'app.globallogic.com.glo:id/searchKeyword')]")
    public WebElement SearchTextBox;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'app.globallogic.com.glo:id/result_LL')]")
    public WebElement SearchButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'app.globallogic.com.glo:id/tvUserName')]")
    public WebElement SearchResult;
}

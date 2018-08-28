package screen.abstractScreen;

import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import screen.android.AndroidSearchScreen;

/**
 * Created by pravin.kumbhare on 24-07-2018.
 */
public abstract class SearchScreen {

    public abstract boolean searchPageReusableMethod();
}

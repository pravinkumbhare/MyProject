import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by pravin.kumbhare on 19-07-2018.
 */
public class Prerequisite_BeforeSuite_Execution {
    AppiumDriverLocalService service;

    @BeforeSuite
    public void beforeSuite() throws InterruptedException, IOException {

       /* System.out.println("Execute before all the suites execution");
        Runtime.getRuntime().exec("cmd /c start C:\\Users\\pravin.kumbhare\\Desktop\\StartAppium.bat");
        Thread.sleep(7000L);*/

        System.out.println("Execute before all the suites execution");
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        Thread.sleep(7000L);
    }

    @AfterSuite
    public void AfterSuite(){

        System.out.println("Execute after all the suites execution");
        service.stop();
    }

    @BeforeTest
    public void beforeTest(){

        System.out.println("Execute before all Tests Classes");
    }

    @AfterTest
    public void afterTest(){

        System.out.println("Execute after all Tests Classes");
    }

}

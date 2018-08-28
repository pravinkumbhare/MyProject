import org.testng.annotations.*;

/**
 * Created by pravin.kumbhare on 19-07-2018.
 */
public class Landing_Page {

    @BeforeClass
    public void beforeClass(){

        System.out.println("Execute before executing all the test present in this class");
    }

    @BeforeMethod
    public void prerequisiteBeforeLandingPageDisplayed(){

        System.out.println("Prerequisite Before Landing Page is displayed");
    }

    @Test
    public void verifyLoginLandingPage(){

        System.out.println("Landing page is displayed after user done login successfully..");
    }

    @AfterMethod
    public void prerequisiteAfterLandingPageDisplayed(){

        System.out.println("Post-requisite After Landing Page is displayed");
    }


    @AfterClass
    public void afterClass(){

        System.out.println("Execute after executing all the test present in this class");
    }
}

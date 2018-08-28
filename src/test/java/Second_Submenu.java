import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by pravin.kumbhare on 19-07-2018.
 */
public class Second_Submenu {

    @BeforeMethod
    public void prerequisiteBeforeSubMenu(){

        System.out.println("Prerequisite Before Second SubMenu is displayed");
    }

    @Test
    public void verifySecondSubMenuOption(){

        System.out.println("Sceond SubMenu option is displayed successfully..");
    }

    @AfterMethod
    public void prerequisiteAfterSubMenu(){

        System.out.println("Post-requisite After Second SubMenu is displayed");
    }
}

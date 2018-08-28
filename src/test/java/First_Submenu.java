import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by pravin.kumbhare on 19-07-2018.
 */
public class First_Submenu {

    @BeforeMethod
    public void prerequisiteBeforeSubMenu(){

        System.out.println("Prerequisite Before First SubMenu is displayed");
    }

    @Test
    public void verifyFirstSubMenuOption(){

        System.out.println("First SubMenu option is displayed successfully..");
    }

    @AfterMethod
    public void prerequisiteAfterSubMenu(){

        System.out.println("Post-requisite After First SubMenu is displayed");
    }
}

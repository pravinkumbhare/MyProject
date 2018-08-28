package ZGroup;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by pravin.kumbhare on 26-07-2018.
 */
public class ParametersTest {

    @Test
    @Parameters({ "sUsername", "sPassword" })

    public void Login(String sUsername, String sPassword){
        System.out.println("ParametersTest====Testcase");
        System.out.println("paraUserName : "+sUsername);
        System.out.println("paraPassword : "+sPassword);
    }
}

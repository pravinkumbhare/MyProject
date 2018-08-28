package ZGroup;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by pravin.kumbhare on 26-07-2018.
 */

//To Capture Failure Test Cases
@Listeners(SetupConfig.TestListener.class)

public class GroupingTestcases {

    @Test (groups = {"State"})
    public void stateGovernment1(){

        System.out.println("stateGovernment1====Testcase 1");
    }

    @Test (groups = {"Central"})
    public void centralGovernment1(){

        System.out.println("centralGovernment1====Testcase 1");
    }

    @Test (groups = {"State"})
    public void stateGovernment2(){

        System.out.println("stateGovernment2====Testcase 2");
    }

    @Test (groups = {"Central"})
    public void centralGovernment2(){

        System.out.println("centralGovernment2====Testcase 2");
    }

    @Test (groups = {"State"})
    public void stateGovernment3(){

        System.out.println("stateGovernment3====Testcase 3");
    }

    @Test (groups = {"Central"})
    public void centralGovernment3(){

        System.out.println("centralGovernment3====Testcase 3");
    }

    @Test (groups = {"Central","State"})
    public void stateCentralGovernment11122(){

        System.out.println("centralGovernment1122====Testcase 1122");
    }

    @Test (groups = {"State"})
    public void openBrowser(){

        System.out.println("openBrowser====Testcase 3");
    }

    @Test (groups = {"State"})
    public void Login(){

        Assert.assertTrue(true,"Failed Testcase..");
        System.out.println("Login====Testcase 3");
    }

    @Test (dependsOnMethods = {"Login"}, groups = {"State"}, enabled = true, priority = 1, retryAnalyzer = ZGroup.RetryFailedTests.RetryAnalyzer.class)
    public void verifySettings(){

        Assert.assertEquals(false,true);
        System.out.println("verifySettings====Testcase 3");
        Reporter.log("*********  Reporter.log   ***********");
    }
}

package ZGroup.RetryFailedTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pravin.kumbhare on 26-07-2018.
 */
public class Test001 {

    @Test //(retryAnalyzer = ZGroup.RetryFailedTests.RetryAnalyzer.class)
    public void Test1()
    {
        Assert.assertEquals(false, true);
    }

    @Test //(retryAnalyzer = ZGroup.RetryFailedTests.RetryAnalyzer.class)
    public void Test2()
    {
        Assert.assertEquals(false, true);
    }
}

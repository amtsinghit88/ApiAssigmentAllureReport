import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ReporterUtil;

import java.lang.reflect.Method;

public class TestBase {

    @BeforeMethod(alwaysRun = true)
    public void beforeTC(Method mthd) {
        ReporterUtil.reportTC(mthd.getName(), "Started");
    }

    @AfterMethod(alwaysRun = true)
    public void logTestResult(ITestResult result, Method mthd) throws InterruptedException {
        if (null != result.getThrowable()) {
            Reporter.log("Exception : " + result.getThrowable().getMessage(), true);
        }

        ReporterUtil.reportTC(mthd.getName(), "Completed");
    }
}

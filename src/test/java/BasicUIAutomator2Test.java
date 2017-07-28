import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;



/**
 * Created by josep on 18.07.17.
 */
public class BasicUIAutomator2Test {


    AppiumDriver driver;

    @Before
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /* These are the capabilities we must provide to run our test on TestObject */
        capabilities.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY"));
        capabilities.setCapability("testobject_device", System.getenv("TESTOBJECT_DEVICE"));
        capabilities.setCapability("appiumVersion", "1.6.6-beta3");
        capabilities.setCapability("testobject_session_creation_timeout", "300000");
        capabilities.setCapability("testobject_test_name", "TestObject test");
        capabilities.setCapability("testobject_suite_name", "No suite");
        capabilities.setCapability("automationName", "uiautomator2");
        //capabilities.setCapability("autoWebview", "true");

        driver = new AndroidDriver(new URL("https://eu1.appium.testobject.com/wd/hub"), capabilities);
        //driver = new AndroidDriver(new URL("https://us1.appium.testobject.com/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TestMethod() {

        // list all contexts
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

    }


}

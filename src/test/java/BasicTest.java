import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;



/**
 * Created by josep on 18.07.17.
 */
public class BasicTest {


    AppiumDriver driver;

    @Before
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /* These are the capabilities we must provide to run our test on TestObject */
        capabilities.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY"));
        capabilities.setCapability("testobject_device", System.getenv("TESTOBJECT_DEVICE"));
        capabilities.setCapability("appiumVersion", "1.6.5");
        capabilities.setCapability("testobject_session_creation_timeout", "300000");
        capabilities.setCapability("testobject_test_name", "TestObject test");
        capabilities.setCapability("testobject_suite_name", "No suite");
        capabilities.setCapability("automationName", "XCUITest");
        //capabilities.setCapability("autoWebview", "true");

        /* only to test locally */
        /*
        //capabilities.setCapability("deviceName", "iPhone");
        //capabilities.setCapability("platformName", "iOS");
        //capabilities.setCapability("automationName", "XCUITest");
        //capabilities.setCapability("deviceName", "Motorola Moto E");
        //capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("udid", "");
        //installing app
        //File file = new File("/Users/josep/Downloads/OIShoppingList_1.7.0.5.apk");
        //capabilities.setCapability("app", file.getAbsolutePath());

        //driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        */

        driver = new AndroidDriver(new URL("https://eu1.appium.testobject.com/wd/hub"), capabilities);
        //driver = new AndroidDriver(new URL("https://us1.appium.testobject.com/wd/hub"), capabilities);
        //driver = new IOSDriver(new URL("https://eu1.appium.testobject.com/wd/hub"), capabilities);

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

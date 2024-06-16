import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class tests {

    private AndroidDriver<AndroidElement> driver;

    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_34_extension_level_7_x86_64");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "cal.CalculatorActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println("URL is malformed: " + e.getMessage());
            Assertions.fail("Failed to initialize driver due to malformed URL");
        } catch (Exception e) {
            System.out.println("Driver initialization failed: " + e.getMessage());
            Assertions.fail("Driver initialization failed");
        }
    }

    @Test
    public void checkCalculate() {
        if (driver == null) {
            Assertions.fail("Driver is not initialized");
            return;
        }

        try {
            driver.findElementById("com.calculator:id/btn_3_s").click();
            driver.findElementById("com.calculator:id/btn_plus_s").click();
            driver.findElementById("com.calculator:id/btn_9_s").click();
            driver.findElementById("com.calculator:id/btn_equal_s").click();

            String result = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.miui.calculator:id/result\")").getText();
            Assertions.assertEquals("= 12", result.trim());
        } catch (Exception e) {
            System.out.println("Error during test execution: " + e.getMessage());
            Assertions.fail("Test execution failed");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MySwagLabsTest {

    private AndroidDriver<AndroidElement> driver;

    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_34_extension_level_7_x86_64");
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
    public void SL001_addToCart() {
        if (driver == null) {
            Assertions.fail("Driver is not initialized");
            return;
        }

        // Replace "App Name" with the actual text or description of your app icon
        String appName = "My Demo App"; // Example app name

        try {
            // Locate the app icon using XPath and click it
            AndroidElement appIcon = driver.findElementByXPath(
                    "//android.widget.TextView[@content-desc='" + appName + "']"
            );

            if (appIcon == null) {
                appIcon = driver.findElementByXPath(
                        "//android.widget.TextView[@text='" + appName + "']"
                );
            }

            // Click on the app icon
            appIcon.click();
            AndroidElement sauceLabsBackpack = driver.findElementByAccessibilityId("Sauce Labs Backpack");
            sauceLabsBackpack.click();
            AndroidElement addToCart = driver.findElementByAccessibilityId("Tap to add product to cart");
            addToCart.click();


        } catch (Exception e) {
            System.out.println("Error during test execution: " + e.getMessage());
            Assertions.fail("Error during test execution");
        }
    }

    @Test
    public void SL002_checkoutPage() {
        AndroidElement checkoutPage = driver.findElementById("com.saucelabs.mydemoapp.android:id/cartIV");
        checkoutPage.click();
        AndroidElement itemName = driver.findElementById("com.saucelabs.mydemoapp.android:id/titleTV");
        Assertions.assertEquals("Sauce Labs Backpack", itemName.getText());

    }

    @Test
    public void SL003_proceedToCheckout() {
        AndroidElement procedToCheckout = driver.findElementById("com.saucelabs.mydemoapp.android:id/cartBt");
        procedToCheckout.click();

    }

    @Test
    public void SL005_loginCheckout() {
        AndroidElement usernames = driver.findElementById("com.saucelabs.mydemoapp.android:id/username1TV");
        usernames.click();
        AndroidElement loginButton = driver.findElementById("com.saucelabs.mydemoapp.android:id/loginBtn");
        loginButton.click();
    }

    @Test
    public void SL006_enterShippingAddres() {
        AndroidElement fullNameInput = driver.findElementById("com.saucelabs.mydemoapp.android:id/fullNameET");
        fullNameInput.sendKeys("Test User");
        AndroidElement adressLine1 = driver.findElementById("com.saucelabs.mydemoapp.android:id/address1ET");
        adressLine1.sendKeys("Street 123");
        AndroidElement adressLine2 = driver.findElementById("com.saucelabs.mydemoapp.android:id/address2ET");
        adressLine2.sendKeys("OtherStreet 123");
        AndroidElement cityInput = driver.findElementById("com.saucelabs.mydemoapp.android:id/cityET");
        cityInput.sendKeys("TestCity");
        AndroidElement stateRegion = driver.findElementById("com.saucelabs.mydemoapp.android:id/stateET");
        stateRegion.sendKeys("TestState");
        AndroidElement zipCode = driver.findElementById("com.saucelabs.mydemoapp.android:id/zipET");
        zipCode.sendKeys("123456");
        AndroidElement country = driver.findElementById("com.saucelabs.mydemoapp.android:id/countryET");
        country.sendKeys("United Kingdom");
        AndroidElement toPayment = driver.findElementById("com.saucelabs.mydemoapp.android:id/paymentBtn");
        toPayment.click();
    }

    @Test
    public void SL007_enterPaymentMethod() {
        AndroidElement nameET = driver.findElementById("com.saucelabs.mydemoapp.android:id/nameET");
        nameET.sendKeys("Test User");
        AndroidElement cardNumberET = driver.findElementById("com.saucelabs.mydemoapp.android:id/cardNumberET");
        cardNumberET.sendKeys("1234567812345678");
        AndroidElement expirationDateET = driver.findElementById("com.saucelabs.mydemoapp.android:id/expirationDateET");
        expirationDateET.sendKeys("03/28");
        AndroidElement securityCodeET = driver.findElementById("com.saucelabs.mydemoapp.android:id/securityCodeET");
        securityCodeET.sendKeys("123");
        AndroidElement paymentBtn = driver.findElementById("com.saucelabs.mydemoapp.android:id/paymentBtn");
        paymentBtn.click();
    }

    @Test
    public void SL010_placeOrder() {
        AndroidElement paymentBtn = driver.findElementById("com.saucelabs.mydemoapp.android:id/paymentBtn");
        paymentBtn.click();
        AndroidElement completeTV = driver.findElementById("com.saucelabs.mydemoapp.android:id/completeTV");
        Assertions.assertEquals("Checkout Complete", completeTV.getText(), "Checkout completed, continue to main" );
        AndroidElement shoopingBt = driver.findElementById("com.saucelabs.mydemoapp.android:id/shoopingBt");
        shoopingBt.click();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

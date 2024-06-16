package Steps;

import Hooks.TestContext;
import Pages.MySwagLabsPages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MySwagLabsSteps {
    private AndroidDriver<AndroidElement> driver;
    private MySwagLabsPages pages;

    @BeforeEach
    public void setUp() {
        driver = TestContext.getDriver();
        pages = new MySwagLabsPages(driver);
    }

    @Test
    public void SL001_addToCart() {
        // Implement test steps
    }

    @Test
    public void SL002_checkoutPage() {
        // Implement test steps
    }

    @Test
    public void SL003_proceedToDownload() {
        // Implement test steps
    }

    @Test
    public void SL004_loginCheckout() {
        // Implement test steps
    }

    @Test
    public void SL005_enterShippingAddress() {
        // Implement test steps
    }

    @AfterEach
    public void tearDown() {
        TestContext.closeDriver();
    }
}


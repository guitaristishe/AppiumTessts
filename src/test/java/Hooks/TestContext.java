package Hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestContext {
    private static Hook hook;
    private static AndroidDriver<AndroidElement> driver;

    public static void setHook(Hook hook) {
        TestContext.hook = hook;
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        if (driver == null) {
//            driver = hook.initializeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        hook.closeDriver();
        driver = null;
    }
}

package Hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hook {
    // Singleton instance
    private static Hook instance;

    private AndroidDriver<AndroidElement> driver;
    private Properties properties;

    // Private constructor to prevent instantiation outside the class
    private Hook() {
        loadProperties();
        initializeDriver();
    }

    // Singleton getInstance method
    public static Hook getInstance() {
        if (instance == null) {
            instance = new Hook();
        }
        return instance;
    }

    // Method to get the driver instance
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    // Method to initialize the driver
    private void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("device.name"));
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver<>(new URL(properties.getProperty("appium.server.url")), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to close the 00 driver
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Method to load properties from config file
    private void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


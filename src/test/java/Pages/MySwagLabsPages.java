package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySwagLabsPages {
    private AndroidDriver<AndroidElement> driver;

    public MySwagLabsPages(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc='My Demo App']")
    private WebElement appIcon;

//    @FindBy(accessibility = "Sauce Labs Backpack")
    private WebElement sauceLabsBackpack;

//    @FindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCart;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement checkoutPage;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement itemName;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement proceedToDownload;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/username1TV")
    private WebElement usernames;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement loginButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    private WebElement fullNameInput;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
    private WebElement addressLine1;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/address2ET")
    private WebElement addressLine2;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    private WebElement cityInput;

    public void clickAppIcon() {
        appIcon.click();
    }

    public void clickSauceLabsBackpack() {
        sauceLabsBackpack.click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void clickCheckoutPage() {
        checkoutPage.click();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public void clickProceedToDownload() {
        proceedToDownload.click();
    }

    public void clickUsernames() {
        usernames.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterShippingAddress(String fullName, String addr1, String addr2, String city) {
        fullNameInput.sendKeys(fullName);
        addressLine1.sendKeys(addr1);
        addressLine2.sendKeys(addr2);
        cityInput.sendKeys(city);
    }
}

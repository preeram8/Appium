package appiumactivities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_3 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy S7 edge");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.samsung.android.contacts");
        caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addContact() {
        // Click on add new contact floating button
        driver.findElementByAccessibilityId("Create contact").click();
        
        // Find the first name, last name, and phone number fields
        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='Name']");
       
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Work']");
        
        // Enter the text in the fields
        firstName.sendKeys("Aaditya");
       // lastName.sendKeys("Varma");
        phoneNumber.sendKeys("8383392123");
        
        // Save the contact
        driver.findElementById("menu_done").click();
        
        // Wait for contact card to appear
       // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("card_container")));

        // Assertion
      //  MobileElement mobileCard = driver.findElementById("card_container");
        //AssertJUnit.assertTrue(mobileCard.isDisplayed());
        
        String contactName = driver.findElementById("header").getText();
       AssertJUnit.assertEquals(contactName, "Aaditya");
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
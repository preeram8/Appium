package appiumactivities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity2_2 {
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy S7 edge");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void add() {
        driver.findElementById("bt_05").click();
        driver.findElementById("bt_add").click();
        driver.findElementById("bt_09").click();
        // Perform Calculation
        driver.findElementById("bt_equal").click();

        // Display Result
        String result = driver.findElementById("txtCalc").getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }
    
    @Test
    public void subtract() {
        driver.findElementById("bt_01").click();
        driver.findElementById("bt_00").click();
        driver.findElementById("bt_sub").click();
        driver.findElementById("bt_05").click();
        // Perform Calculation
        driver.findElementById("bt_equal").click();

        // Display Result
        String result = driver.findElementById("txtCalc").getText();
        System.out.println(result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiply() {
        driver.findElementById("bt_05").click();
        driver.findElementById("bt_mul").click();
        driver.findElementById("bt_01").click();
        driver.findElementById("bt_00").click();
        driver.findElementById("bt_00").click();
        // Perform Calculation
        driver.findElementById("bt_equal").click();

        // Display Result
        String result = driver.findElementById("txtCalc").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void divide() {
        driver.findElementById("bt_05").click();
        driver.findElementById("bt_00").click();
        driver.findElementById("bt_div").click();
        driver.findElementById("bt_02").click();
        // Perform Calculation
        driver.findElementById("bt_equal").click();

        // Display Result
        String result = driver.findElementById("txtCalc").getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
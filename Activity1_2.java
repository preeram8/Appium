package appiumactivities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1_2 {
    @Test
    public void calc() throws InterruptedException, IOException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceId", "2eed910sa");
        caps.setCapability("deviceName", "Galaxy S7 edge");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        // Instantiate Appium Driver
        AppiumDriver<MobileElement> driver = null;
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("Calculator is open");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}

package app.calc.tests;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class _02Calculator {
    static WindowsDriver driver = null;

    @BeforeClass
    public static void setUp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    @Before
    public void clear(){
        driver.findElementByName("Löschen").click();
    }


    @Test
    public void addition() {
        WebElement one = driver.findElementByName("Eins");
        one.click();
        WebElement plus = driver.findElementByName("Plus");
        plus.click();
        WebElement two = driver.findElementByName("Zwei");
        two.click();
        WebElement equals = driver.findElementByName("Gleich");
        equals.click();

        WebElement results = driver.findElementByAccessibilityId("CalculatorResults");
        String result = results.getText();

        assertEquals("Die Anzeige lautet 3", result);

    }

    @Test
    public void subtraction() {
        WebElement nine = driver.findElementByName("Neun");
        nine.click();
        WebElement minus = driver.findElementByName("Minus");
        minus.click();
        WebElement five = driver.findElementByName("Fünf");
        five.click();
        WebElement equals = driver.findElementByName("Gleich");
        equals.click();
        WebElement results = driver.findElementByAccessibilityId("CalculatorResults");
        String result = results.getText();

        assertEquals("Die Anzeige lautet 4", result);
    }

}

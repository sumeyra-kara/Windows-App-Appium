package app.calc.tests;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class _01NotepadTest {
    WindowsDriver driver;


    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");

        driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), capabilities);


        WebElement textEditor = driver.findElementByName("Text-Editor");
        // textEditor.sendKeys("Hello World");

       textEditor.sendKeys("Hello World" + Keys.ENTER);
        textEditor.sendKeys("SECOND ROW" + Keys.ENTER);

        WebElement datei = driver.findElementByName("Datei"); // file
        datei.click(); // file
    }
}

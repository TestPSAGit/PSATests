/*
 * Creation : 12 avr. 2019
 */
package peugeot;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitialiseDrivers {

    static WebDriver driver;

    static WebDriver InitialiseChromDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\webdrivers\\\\chromedriver.exe");

        driver = new ChromeDriver();
        return driver;
    }

    static WebDriver InitialiseFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\e550004\\Desktop\\Selenium Driver\\geckodriver.exe");

        driver = new FirefoxDriver();
        return driver;
    }

    static WebDriver InitialiseIEDriver() {
        System.setProperty("webdriver.ie.driver", "C:\\webdrivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");

        driver = new InternetExplorerDriver();
        return driver;
    }

    static WebDriver InitialiseMobileChromDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\webdrivers\\\\chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<String, String>();

        mobileEmulation.put("deviceName", "Galaxy S5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);

        return driver;
    }

    static WebDriver InitialiseMobileFirefoxDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\webdrivers\\\\chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<String, String>();

        mobileEmulation.put("deviceName", "Galaxy S5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);

        return driver;
    }
}
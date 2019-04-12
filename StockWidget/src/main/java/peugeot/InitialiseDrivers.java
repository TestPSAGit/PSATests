/*
 * Creation : 12 avr. 2019
 */
package peugeot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitialiseDrivers {

    static WebDriver driver;

    public static WebDriver InitialiseChromDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\E562418\\Desktop\\PSA Selenium Project\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver InitialiseFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\E562418\\Desktop\\PSA Selenium Project\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver InitialiseIEDriver() {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\E562418\\Desktop\\PSA Selenium Project\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");

        driver = new InternetExplorerDriver();
        return driver;
    }
}
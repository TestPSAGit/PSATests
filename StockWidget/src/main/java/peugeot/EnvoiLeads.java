/*
 * Creation : 17 mai 2019
 */
package peugeot;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import Methodes.Wait;

public class EnvoiLeads {

    static WebDriver driver;
    ProductPageCompo pp = new ProductPageCompo();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/?geodistance=197;41.1579438;-8.629105299999992;Porto&budget=29809;48648");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        // driver.findElement(By.className("psac_noselect")).click();

    }

    public void AccesForm(WebDriver driver) {

        Wait.Wait(2000);

        String parentwindow = driver.getWindowHandle();

        pp.CTAContactConseillerSelect(driver);
        Wait.Wait(2000);

        Set<String> handles = driver.getWindowHandles(); // get all window handles

        for (String formulaire : handles) {
            driver.switchTo().window(formulaire);
            Wait.Wait(2000);

        }
    }

    public void ChampTitulo(WebDriver driver) {

        Wait.Wait(2000);
        AccesForm(driver);

        driver.findElement(By.xpath("//span[contains(@class,'sb-select')]//input")).click();
        Wait.Wait(2000);
        driver.findElement(By.xpath("//ngb-modal-window[contains(@class,'modal fade show d-block popin_window_class')]//li[1]")).click();

    }

    public String SendLead(WebDriver driver) {

        ChampTitulo(driver);
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001167']")).sendKeys("TEST");// send nom de famille
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001170']")).sendKeys("TEST");// send prénom
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001165']")).sendKeys("PSAtest@yopmail.fr");// send email
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD200000000087']")).sendKeys("0612121212");// send num tel
        Wait.Wait(1000);
        driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys("TEST");// send comm
        Wait.Wait(1000);
        driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();
        Wait.Wait(1000);
        driver.findElement(By.xpath("//span[@class='wf_button_input']")).click();

        Wait.Wait(4000);
        return driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).getText();

    }
}

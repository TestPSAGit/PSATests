/*
 * Creation : 17 mai 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.Wait;

public class TestEnvoiFormulaire {

    static WebDriver driver;
    ResultPageCompo rp = new ResultPageCompo();
    ResultPageFilters fp = new ResultPageFilters();
    ProductPageCompo pp = new ProductPageCompo();
    EnvoiLeads el = new EnvoiLeads();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/vehicles/OPV_AP_PT_PA125504?geodistance=");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test
    public void TestEnvoiFormulaire() { //

        Wait.Wait(2000);
        assert (el.SendLead(driver).contains("Message envoyé !"));

    }
}
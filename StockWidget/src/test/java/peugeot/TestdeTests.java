/*
 * Creation : 15 avr. 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.Wait;

public class TestdeTests {

    static WebDriver driver;
    ResultPageCompo rp = new ResultPageCompo();
    ResultPageFilters fp = new ResultPageFilters();
    ProductPageCompo pp = new ProductPageCompo();
    EnvoiLeads el = new EnvoiLeads();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://prod-widget.stockengine.awsmpsa.com/demo/#/vehicles/OPV_AP_PT_09044594?geodistance=");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test(priority = 1)
    public void TestPopinDetailPrix() {// check présence CTA retour
        driver.get("https://prod-widget.stockengine.awsmpsa.com/demo/#/vehicles/OPV_AP_PT_09044594?geodistance=");
        Wait.Wait(2000);
        pp.DetailPrixSelect(driver);
        Wait.Wait(2000);
        assert (pp.PopupDétailPrixTextTitle(driver).contains("DÉTAIL DU PRIX"));
        driver.findElement(By.xpath("//span[@class='stock__icon-cross']")).click();
    }
}

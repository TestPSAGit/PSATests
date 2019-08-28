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
        driver.get("https://rec-widget.stockengine.awsmpsa.com/demo/#/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test(priority = 1)
    public void TestEnvoiFormulaireAP() { //

        driver.get("https://rec-widget.stockengine.awsmpsa.com/demo/#/vehicles/OPV_AP_PT_09853160?geodistance=");
        Wait.Wait(5000);
        assert (el.SendLeadAP(driver).contains("Message envoyé !"));

    }

    @Test(priority = 2)
    public void TestEnvoiFormulaireAC() { //

        driver.get(
                "https://rec-widget.stockengine.awsmpsa.com/render/0fcc058a-c111-4f10-958c-6a8b75d0701a/pt#/vehicles/OPV_AC_PT_10152359?geodistance=");
        Wait.Wait(5000);
        assert (el.SendLeadAC(driver).contains("Message envoyé !"));

    }

    @Test(priority = 3)
    public void TestEnvoiFormulaireDS() { //

        driver.get("https://rec-widget.stockengine.awsmpsa.com/demo/#/vehicles/OPV_AP_PT_09853160?geodistance=");
        Wait.Wait(5000);
        assert (el.SendLeadDS(driver).contains("Message envoyé !"));

    }
}
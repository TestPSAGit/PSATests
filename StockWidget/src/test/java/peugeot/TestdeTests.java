/*
 * Creation : 15 avr. 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.Wait;

public class TestdeTests {

    static WebDriver driver;
    ResultPageCompo rp = new ResultPageCompo();
    ResultPageFilters fp = new ResultPageFilters();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test

    public void TestGearBoxesListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] GearboxesList = fp.GetGearBoxList(driver);

        for (int i = 1; i < GearboxesList.length; i++) {

            fp.ClickOnListElement(driver, "//fieldset[6]//app-filter-choice[" + i + "]//label[1]//span[2]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(GearboxesList[i]);
            }

        }
        assert (Error == 0);
    }

}
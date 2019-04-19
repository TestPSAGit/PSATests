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

    public void TestSortingMenuListWithLocalisation() {// check qu'on récup les valeurs de la sorting menu list
        Wait.Wait(2000);
        boolean exist = false;
        fp.EnterTheLocation(driver, "Porto");
        Wait.Wait(3000);
        int Error = 0;
        String[] Sortingliste = fp.SortingMenuListText(driver);
        Wait.Wait(1000);
        System.out.println(Sortingliste.length);
        for (int i = 1; i < Sortingliste.length; i++) {

            // System.out.println(Sortingliste[i]);
            // System.out.println(Sortingliste[i - 1]);

            fp.ClickOnListElement(driver,
                    "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]/span[2]");//
            Wait.Wait(2000);

            String[] ListAbove = rp.TextSortingAboveList(driver);

            if (Sortingliste[i].contains("Par proximité")) {

                exist = true;

            }

            else if (ListAbove[i].contains(Sortingliste[i])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i] + "OOOOOOO" + Sortingliste[i] + "0000000");

            }

        }
        assert (exist == true);
    }

}
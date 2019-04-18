/*
 * Creation : 15 avr. 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.Wait;

public class ResultPageFiltersTests {

    static WebDriver driver;
    ResultPageFilters fp = new ResultPageFilters();
    ResultPageCompo rp = new ResultPageCompo();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/?geodistance=197;41.1579438;-8.629105299999992;Porto&budget=29809;48648");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test(priority = 3)
    public void TestSortingMenu() {// check le menu sorting est present
        Wait.Wait(2000);
        assert (fp.SortingMenu(driver) == true);
    }

    @Test(priority = 3)
    public void TestSortingMenuIcon() {// check l'icone du menu sorting est present
        Wait.Wait(2000);
        assert (fp.SortingMenuIcone(driver) == true);
    }

    @Test(priority = 3)
    public void TestSortingMenuText() {// check le texte du menu sorting est present
        Wait.Wait(2000);
        assert (fp.SortingMenuText(driver).equals("Trier les résultats"));
    }

    @Test(priority = 3)
    public void TestSortingMenuListDisplayed() {// check que la liste du menu sorting est présente
        Wait.Wait(2000);
        assert (fp.SortingMenuList(driver) == true);
    }

    @Test(priority = 3)
    public void TestSortingMenuListWithoutLocalisation() {// check qu'on récup les valeurs de la sorting menu list
        Wait.Wait(2000);
        boolean exist = false;
        String[] Sortingliste = fp.SortingMenuListText(driver);
        for (int i = 0; i < Sortingliste.length; i++) {

            if (Sortingliste[i].contains("Par prix")) {

                exist = true;

            }

        }
        assert (exist == true);
    }

    @Test(priority = 4)
    public void TestSortingMenuListWithLocalisation() {// check qu'on récup les valeurs de la sorting menu list
        Wait.Wait(2000);
        boolean exist = false;
        fp.EnterTheLocation(driver, "Porto");
        Wait.Wait(3000);
        String[] Sortingliste = fp.SortingMenuListText(driver);

        for (int i = 0; i < Sortingliste.length; i++) {

            if (Sortingliste[i].contains("Par proximité") && Sortingliste[i].contains("Par prix")) {

                exist = true;

            }

        }
        assert (exist == true);
    }

    public void TestModelsListSimilarJDD() {// Vérifier la conformité de la liste des modeles, avec le JDD
        Wait.Wait(2000);
        boolean exist = false;
        String[] ModelList = fp.GetModelsList(driver);
        String[] espectedModels = new String[] { "108", "2008", "208", "3008", "308", "5008", "Boxer Combi", "Novo 508", "Partner Tepee", "Rifter",
                "Traveller" };
        for (int i = 0; i < ModelList.length; i++) {

            if (ModelList[i].contains(espectedModels[i])) {

                exist = true;

            }

        }
        assert (exist == true);
    }

    public void TestModelsListNumberVHChanges() {// check que le nb de vh dispo change quand on change de modele

        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 0; i < ModelList.length; i++) {

            fp.ClickOnListElement(driver, "//span[contains(text(),'" + ModelList[i] + "')]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println("!!!!!!!!!!!" + ModelList[i] + "!!!!!!!!!!!");
            }

        }
        assert (Error == 0);
    }

    public void TestEngineListNumberVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] EngineList = fp.GetEngineList(driver);

        for (int i = 0; i < EngineList.length; i++) {

            fp.ClickOnListElement(driver, "//span[contains(text(),'" + EngineList[i] + "')]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println("!!!!!!!!!!!" + EngineList[i] + "!!!!!!!!!!!");
            }

        }
        assert (Error == 0);
    }

    public void TestEnergyListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] EnergyList = fp.GetEnergyList(driver);

        for (int i = 1; i < EnergyList.length; i++) {

            fp.ClickOnListElement(driver, "//fieldset[5]//app-filter-choice[" + i + "]//label[1]//span[2]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(EnergyList[i]);
            }

        }
        assert (Error == 0);
    }

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

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
    public void TestSortingMenuListWithoutLocalisation() {
        Wait.Wait(2000);
        boolean exist = false;

        int Error = 0;

        String[] Sortingliste = fp.SortingMenuListText(driver);
        for (int i = 1; i < Sortingliste.length; i++) {

            fp.ClickOnListElement(driver, "//span[@id='sort-price']");
            Wait.Wait(2000);

            String[] ListAbove = rp.TextSortingAboveList(driver);

            if (ListAbove[i - 1].contains(Sortingliste[i])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + Sortingliste[i] + "0000000");

            }

        }
        assert (Error == 0);

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

    @Test(priority = 3)
    public void TestDisplayedModelsList() {// check le menu modèle est present
        Wait.Wait(2000);
        assert (fp.ModelsMenu(driver) == true);
    }

    @Test(priority = 3)
    public void TestModelsMenuIcon() {// check l'icone du menu modeles est present
        Wait.Wait(2000);
        assert (fp.ModelsMenuIcone(driver) == true);
    }

    @Test(priority = 3)
    public void TestModelsMenuText() {// check le titre (au dessus de la liste) du menu modeles est present
        Wait.Wait(2000);
        assert (fp.ModelsMenuTitleText(driver).equals("Modèle"));

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

    public void TestModelsListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);
        for (int i = 1; i < ModelList.length; i++) {

            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);
            String[] ListAbove = rp.TextModelsAboveList(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(ModelList[i]);
            } else if (ListAbove[i - 1].contains(ModelList[i - 1])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + ModelList[i - 1] + "0000000");

            }

        }
        assert (Error == 0);

    }

    @Test(priority = 3)
    public void TestDisplayedEngineList() {// check le menu engine est present
        Wait.Wait(2000);
        assert (fp.EngineMenu(driver) == true);
    }

    @Test(priority = 3)
    public void TestEngineMenuIcon() {// check l'icone du menu engine est present
        Wait.Wait(2000);
        assert (fp.EngineMenuIcone(driver) == true);
    }

    @Test(priority = 3)
    public void TestEngineMenuText() {// check le titre (au dessus de la liste) du menu engine est present
        Wait.Wait(2000);
        assert (fp.EngineMenuTitleText(driver).equals("Moteur"));

    }

    public void TestEngineListNumberVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;

        String[] EngineList = fp.GetEngineList(driver);
        for (int i = 1; i < EngineList.length; i++) {

            fp.ClickOnListElement(driver, "//span[contains(text(),'" + EngineList[i] + "')]");
            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);
            String[] ListAbove = rp.TextEngineAboveList(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(EngineList[i]);
            } else if (ListAbove[i - 1].contains(EngineList[i])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + EngineList[i] + "0000000");

            }

        }
        assert (Error == 0);

    }

    @Test(priority = 3)
    public void TestEnergyMenuText() {// check le titre (au dessus de la liste) de la liste Energy est present
        Wait.Wait(2000);
        assert (fp.GearBoxMenuTextAboveList(driver).equals("Energie"));

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

    @Test(priority = 3)
    public void TestGearboxMenuText() {// check le titre (au dessus de la liste) du menu Gearbox est present
        Wait.Wait(2000);
        assert (fp.GearBoxMenuTextAboveList(driver).equals("Boîte vitesse"));

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

    @Test(priority = 3)
    public void TestFinitionMenuTitle() {// check le titre (au dessus de la liste) du menu Finition est present
        Wait.Wait(2000);
        assert (fp.FinitionsMenuTextAboveList(driver).equals("Finition"));

    }

    @Test(priority = 3)
    public void TestFinitionMenuText() {// check que le texte dans le menu Finition est present
        Wait.Wait(2000);
        assert (fp.FinitionsMenuTitleText(driver).equals(" Choisissez une finition"));

    }

    public void TestFinitionListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;

        String[] FinitionList = fp.GetFinitionsList(driver);
        for (int i = 1; i < FinitionList.length; i++) {

            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);
            String[] ListAbove = rp.TextFinitonsAboveList(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(FinitionList[i]);
            } else if (ListAbove[i - 1].contains(FinitionList[i - 1])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + FinitionList[i - 1] + "0000000");

            }

        }
        assert (Error == 0);

    }

    @Test(priority = 3)
    public void TestColorMenuText() {// check le titre (au dessus de la liste) du menu Colors est present
        Wait.Wait(2000);
        assert (fp.ColorMenuTextAboveList(driver).equals("Couleur"));

    }

    public void TestColorsListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] ColorList = fp.GetColorsList(driver);

        for (int i = 1; i < ColorList.length; i++) {

            fp.ClickOnListElement(driver, "//app-filter-colors[" + i + "]//label[1]//span[3]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(ColorList[i]);
            }

        }
        assert (Error == 0);
    }

}

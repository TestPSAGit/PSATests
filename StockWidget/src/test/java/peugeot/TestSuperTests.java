/*
 * Creation : 20 mai 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.Wait;

public class TestSuperTests { // Tests créés pour vérifier la data, que les filtres n'oublient aucun véhicule

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
    public void SuperTestEnergy() {
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles

            // fp.openModelsList(driver);
            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i][0] = rp.GetTheOffersNum(driver);
            System.out.println("Avt clic " + NbVh[i][0]);
            String[] EnergyList = fp.GetEnergyList(driver);
            // try {

            for (int j = 1; j < EnergyList.length; j++) {// boucle ssur les énergies
                Wait.Wait(2000);

                fp.ClickOnListElement(driver, "//fieldset[5]//app-filter-choice[" + j + "]//label[1]//span[2]");

                Wait.Wait(1000);

                NbVh[i][j] = rp.GetTheOffersNum(driver);
                Wait.Wait(1000);

                System.out.println("Après clic " + NbVh[i][j]);
                // System.out.println("Après clic 222 " + NbVh[j + 2]);

                fp.ClickOnListElement(driver, "//fieldset[5]//app-filter-choice[" + j + "]//label[1]//span[2]");
                Wait.Wait(1000);

            }

            if (EnergyList.length == 3) { // somme des vh par énergie doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2]) {
                    Error++;
                }
            } else if (EnergyList.length == 4) { // somme des vh par énergie doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3]) {
                    Error++;
                }

                // } catch (Exception e) {
                // Wait.Wait(2000);
                // System.out.println("pas cette énergie");
                // }

            }
            Wait.Wait(2000);
            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"); // décocher le
                                                                                                                                    // modèle
            Wait.Wait(2000);
        }

        assert (Error == 0);
    }

    @Test
    public void SuperTestGearbox() {
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles

            // fp.openModelsList(driver);
            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i][0] = rp.GetTheOffersNum(driver);
            System.out.println("Avt clic " + NbVh[i][0]);
            String[] GearBoxList = fp.GetGearBoxList(driver);
            // try {

            for (int j = 1; j < GearBoxList.length; j++) {// boucle ssur les gearboxes
                Wait.Wait(2000);

                fp.ClickOnListElement(driver, "//fieldset[6]//app-filter-choice[" + j + "]//label[1]//span[2]");

                Wait.Wait(1000);

                NbVh[i][j] = rp.GetTheOffersNum(driver);
                Wait.Wait(1000);

                System.out.println("Après clic " + NbVh[i][j]);

                fp.ClickOnListElement(driver, "//fieldset[6]//app-filter-choice[" + j + "]//label[1]//span[2]");
                Wait.Wait(1000);

            }

            if (GearBoxList.length == 3) { // somme des vh par GearBox doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2]) {
                    Error++;
                }
            } else if (GearBoxList.length == 4) { // somme des vh par Gearbox doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3]) {
                    Error++;
                }
            } else if (GearBoxList.length == 5) { // somme des vh par Gearbox doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4]) {
                    Error++;
                }
            } else if (GearBoxList.length == 6) { // somme des vh par Gearbox doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5]) {
                    Error++;
                }
            } else if (GearBoxList.length == 7) { // somme des vh par Gearbox doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5]
                        + NbVh[i][6]) {
                    Error++;
                }
            } else if (GearBoxList.length == 8) { // somme des vh par Gearbox doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5] + NbVh[i][6] + NbVh[i][7]) {
                    Error++;
                }
            } else if (GearBoxList.length == 9) { // somme des vh par Gearbox doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5] + NbVh[i][6] + NbVh[i][7] + NbVh[i][8]) {
                    Error++;
                }

            }
            Wait.Wait(2000);
            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"); // décocher le
                                                                                                                                    // modèle
            Wait.Wait(2000);
        }

        assert (Error == 0);
    }

    @Test
    public void SuperTestCouleurs() {
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles

            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i][0] = rp.GetTheOffersNum(driver);
            System.out.println("Avt clic " + NbVh[i][0]);
            String[] ColorsList = fp.GetColorsList(driver);
            // try {

            for (int j = 1; j < ColorsList.length; j++) {// boucle ssur les couleurs
                Wait.Wait(2000);

                fp.ClickOnListElement(driver, "//app-filter-colors[" + j + "]//label[1]//span[3]");

                Wait.Wait(1000);

                NbVh[i][j] = rp.GetTheOffersNum(driver);
                Wait.Wait(1000);

                System.out.println("Après clic " + NbVh[i][j]);

                fp.ClickOnListElement(driver, "//app-filter-colors[" + j + "]//label[1]//span[3]");
                Wait.Wait(1000);

            }

            if (ColorsList.length == 3) { // somme des vh par couleur doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2]) {
                    Error++;
                }
            } else if (ColorsList.length == 4) { // somme des vh par couleur doit être égal au total des vh du modèle

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3]) {
                    Error++;
                }
            } else if (ColorsList.length == 5) {

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4]) {
                    Error++;
                }
            } else if (ColorsList.length == 6) {

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5]) {
                    Error++;
                }
            } else if (ColorsList.length == 7) {

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5]
                        + NbVh[i][6]) {
                    Error++;
                }
            } else if (ColorsList.length == 8) {

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5] + NbVh[i][6] + NbVh[i][7]) {
                    Error++;
                }
            } else if (ColorsList.length == 9) {

                if (NbVh[i][0] != NbVh[i][1] + NbVh[i][2] + NbVh[i][3] + NbVh[i][4] + NbVh[i][5] + NbVh[i][6] + NbVh[i][7] + NbVh[i][8]) {
                    Error++;
                }

            }
            Wait.Wait(2000);
            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"); // décocher le
                                                                                                                                    // modèle
            Wait.Wait(2000);
        }

        assert (Error == 0);
    }

    @Test
    public void SuperTestFinitions() {
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        int offersNum = 0;
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles

            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i][0] = rp.GetTheOffersNum(driver);
            System.out.println("Avt clic " + NbVh[i][0]);

            String[] FinitionList = fp.GetFinitionsList(driver);
            Wait.Wait(1000);
            // System.out.println(FinitionList.length);

            for (int j = 1; j <= FinitionList.length; j++) {// boucle ssur les couleurs
                int test = 0;
                fp.ClickOnListElement(driver,
                        "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[9]/app-filter-select[1]/div[2]/app-filter-choice["
                                + j + "]/label[1]/span[2]");

                Wait.Wait(3000);

                NbVh[i][j] = rp.GetTheOffersNum(driver);

                System.out.println("Après clic " + NbVh[i][j]);

                Wait.Wait(1000);

                fp.ClickOnListElement(driver,
                        "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[9]/app-filter-select[1]/div[2]/app-filter-choice["
                                + j + "]/label[1]/span[2]");

                Wait.Wait(1000);

                offersNum = offersNum + NbVh[i][j];

                // test = test + NbVh[i][j];

            }
            System.out.println("0000000   " + offersNum);
            Wait.Wait(1000);
            if (NbVh[i][0] != offersNum) {
                Error++;
                System.out.println(ModelList[i]);
            }

            Wait.Wait(2000);
            driver.findElement(By.xpath("//span[@class='ng-tns-c5-3 ng-star-inserted']")).click();
            Wait.Wait(2000);
            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);
            offersNum = 0;
        }

        assert (Error == 0);

    }

    @Test
    public void SuperTestMoteurs() {
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        int offersNum = 0;
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles

            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i][0] = rp.GetTheOffersNum(driver);
            System.out.println("Avt clic " + NbVh[i][0]);

            String[] EngineList = fp.GetEngineList(driver);
            Wait.Wait(1000);
            // System.out.println(FinitionList.length);

            for (int j = 1; j <= EngineList.length; j++) {// boucle ssur les moteurs
                int test = 0;
                fp.ClickOnListElement(driver,
                        "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[8]/app-filter-select[1]/div[2]/app-filter-choice["
                                + j + "]/label[1]/span[1]");

                Wait.Wait(3000);

                NbVh[i][j] = rp.GetTheOffersNum(driver);

                System.out.println("Après clic " + NbVh[i][j]);

                Wait.Wait(1000);

                fp.ClickOnListElement(driver,
                        "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[8]/app-filter-select[1]/div[2]/app-filter-choice["
                                + j + "]/label[1]/span[1]");

                Wait.Wait(1000);

                offersNum = offersNum + NbVh[i][j];

                // test = test + NbVh[i][j];

            }
            System.out.println("0000000   " + offersNum);
            Wait.Wait(1000);
            if (NbVh[i][0] != offersNum) {
                Error++;
                System.out.println(ModelList[i]);
            }

            Wait.Wait(2000);
            driver.findElement(
                    By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterEngine']//span[@class='stock__icon-arrow-bottom']"))
                    .click();
            Wait.Wait(2000);
            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);
            offersNum = 0;
        }

        assert (Error == 0);

    }
}

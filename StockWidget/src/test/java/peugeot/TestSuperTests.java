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
    public void BeforeMethod() {

        driver = InitialiseDrivers.InitialiseIEDriver();
        driver.get("https://prod-widget.stockengine.awsmpsa.com/demo/#/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // driver.findElement(By.className("psac_noselect")).click();

    }

    // @AfterMethod
    public void AfterMethod() {
        driver.close();

    }

    @Test
    public void SuperTestEnergy() {

        System.out.println("------------------ SuperTestEnergy --------------");
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles

            // fp.openModelsList(driver);
            try {
                System.out.println(ModelList[i - 1]);
                Wait.Wait(1000);
                driver.findElement(
                        By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"))
                        .click();

                Wait.Wait(1000);

                NbVh[i][0] = rp.GetTheOffersNum(driver);
                System.out.println("Avt clic " + NbVh[i][0]);
                String[] EnergyList = fp.GetEnergyList(driver);
                String textEnergy = new String();
                String EtiquetteEnergy = new String();
                // try {

                for (int j = 1; j < EnergyList.length; j++) {// boucle ssur les énergies
                    Wait.Wait(2000);

                    driver.findElement(By.xpath("//fieldset[5]//app-filter-choice[" + j + "]//label[1]//span[2]")).click();

                    Wait.Wait(2000);

                    textEnergy = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[5]/app-filter-choice["
                                    + j + "]/label[1]/span[1]"))
                            .getText();

                    System.out.println("Après clic2, nom de l'énergie dans la liste  ===   " + textEnergy);

                    Wait.Wait(1000);

                    EtiquetteEnergy = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-card[1]/div[1]/div[1]/div[2]/ul[2]/li[1]/span[2]"))
                            .getText();
                    System.out.println("Après clic3, nom de l'énergie sur l'étiquette vh ===    " + EtiquetteEnergy);

                    Wait.Wait(3000);

                    if (EtiquetteEnergy.contains(textEnergy)) {

                        Wait.Wait(1000);

                        System.out.println("Good");
                    } else {
                        Error++;
                        Wait.Wait(1000);
                        System.err.println("Erreur sur  :   " + ModelList[i]);
                        Wait.Wait(1000);
                        System.err.println("Erreur sur le carburant suivant   :   " + textEnergy);
                    }

                    NbVh[i][j] = rp.GetTheOffersNum(driver);
                    Wait.Wait(1000);

                    System.out.println("Somme nb Après clic " + NbVh[i][j]);
                    // System.out.println("Après clic 222 " + NbVh[j + 2]);

                    Wait.Wait(1000);

                    driver.findElement(By.xpath("//fieldset[5]//app-filter-choice[" + j + "]//label[1]//span[2]")).click();
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
            }

            catch (NumberFormatException exception) {
                Wait.Wait(2000);
                System.err.println(ModelList[i - 1]);

                System.err.println("Pas de véhicule de ce type présent, A VERIFIER");
            }

            Wait.Wait(1000);
            driver.findElement(
                    By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]")).click();

            Wait.Wait(3000);
        }

        assert (Error == 0);

    }

    @Test
    public void SuperTestGearbox() {
        System.out.println("------------------ SuperTestGearbox --------------");
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        String textGearbox = new String();
        String EtiquetteGearbox = new String();
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles
            try {
                System.out.println(ModelList[i - 1]);
                // fp.openModelsList(driver);
                Wait.Wait(1000);
                driver.findElement(
                        By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"))
                        .click();

                Wait.Wait(1000);

                NbVh[i][0] = rp.GetTheOffersNum(driver);
                System.out.println("Nb VH affichés avant clic " + NbVh[i][0]);
                String[] GearBoxList = fp.GetGearBoxList(driver);
                // try {

                for (int j = 1; j < GearBoxList.length; j++) {// boucle ssur les gearboxes
                    Wait.Wait(1000);

                    driver.findElement(By.xpath("//fieldset[6]//app-filter-choice[" + j + "]//label[1]//span[2]")).click();

                    Wait.Wait(1000);

                    NbVh[i][j] = rp.GetTheOffersNum(driver);
                    Wait.Wait(1000);

                    System.out.println("Nb VH affichés après clic " + NbVh[i][j]);

                    Wait.Wait(2000);

                    textGearbox = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[6]/app-filter-choice["
                                    + j + "]/label[1]/span[1]"))
                            .getText();

                    System.out.println("Après clic2, nom de la gearbox dans la liste  ===   " + textGearbox);

                    Wait.Wait(3000);

                    EtiquetteGearbox = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-card[1]/div[1]/div[1]/a[1]/div[2]/h4[1]"))
                            .getText();
                    System.out.println("Après clic3, nom de la gearbox dans sur l'étiquette  ===   " + EtiquetteGearbox);

                    Wait.Wait(2000);

                    if (EtiquetteGearbox.contains(textGearbox)) {

                        Wait.Wait(1000);

                        System.out.println("Good");
                    } else {
                        Error++;
                        Wait.Wait(1000);
                        System.err.println(ModelList[i]);
                    }

                    Wait.Wait(1000);

                    driver.findElement(By.xpath("//fieldset[6]//app-filter-choice[" + j + "]//label[1]//span[2]")).click();

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
            }

            catch (NumberFormatException exception) {
                Wait.Wait(2000);
                System.err.println(ModelList[i - 1]);
                System.err.println("Pas de véhicule de ce type présent, A VERIFIER");
            }

            Wait.Wait(1000);
            driver.findElement(
                    By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]")).click(); // décocher
            // le
            // modèle
            Wait.Wait(3000);
        }

        assert (Error == 0);

    }

    @Test
    public void SuperTestCouleurs() {
        System.out.println("------------------ SuperTestCouleurs --------------");
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles
            try {
                System.out.println(ModelList[i - 1]);
                Wait.Wait(1000);
                driver.findElement(
                        By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"))
                        .click();

                Wait.Wait(1000);

                NbVh[i][0] = rp.GetTheOffersNum(driver);
                System.out.println("Nb Vh affichés avant clic " + NbVh[i][0]);
                String[] ColorsList = fp.GetColorsList(driver);
                // try {

                for (int j = 1; j < ColorsList.length; j++) {// boucle ssur les couleurs
                    Wait.Wait(2000);

                    driver.findElement(By.xpath("//app-filter-colors[" + j + "]//label[1]//span[3]")).click();

                    Wait.Wait(2000);

                    NbVh[i][j] = rp.GetTheOffersNum(driver);
                    Wait.Wait(1000);

                    System.out.println("Nb Vh après clic " + NbVh[i][j]);

                    driver.findElement(By.xpath("//app-filter-colors[" + j + "]//label[1]//span[3]")).click();
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
            }

            catch (NumberFormatException exception) {
                Wait.Wait(2000);
                System.err.println(ModelList[i - 1]);
                System.err.println("Pas de véhicule de ce type présent, A VERIFIER");
            }

            Wait.Wait(1000);
            driver.findElement(
                    By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]")).click(); // décocher
            // le
            // modèle
            Wait.Wait(3000);
        }

        assert (Error == 0);

    }

    @Test
    public void SuperTestFinitions() {
        System.out.println("------------------ SuperTestFinitions --------------");

        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        int offersNum = 0;
        String textFinition = new String();
        String EtiquetteFinition = new String();
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles

            try {
                System.out.println(ModelList[i - 1]);
                Wait.Wait(1000);
                driver.findElement(
                        By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"))
                        .click();

                Wait.Wait(1000);

                NbVh[i][0] = rp.GetTheOffersNum(driver);
                System.out.println("Nb de VH affichéés avt clic " + NbVh[i][0]);

                String[] FinitionList = fp.GetFinitionsList(driver);
                Wait.Wait(1000);
                // System.out.println(FinitionList.length);

                for (int j = 1; j <= FinitionList.length; j++) {// boucle ssur les finitions
                    int test = 0;
                    Wait.Wait(2000);
                    driver.findElement(
                            By.xpath("//app-filter-select[@class='stock__filterTrim ng-tns-c5-3']//app-filter-choice[" + j + "]//label[1]//span[1]"))
                            .click();

                    Wait.Wait(3000);

                    NbVh[i][j] = rp.GetTheOffersNum(driver);

                    System.out.println("Nb de VH affichés après clic " + NbVh[i][j]);

                    Wait.Wait(2000);

                    textFinition = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[9]/app-filter-select[1]/div[2]/app-filter-choice["
                                    + j + "]/label[1]/span[1]"))
                            .getText();

                    System.out.println("Après clic2, nom de l'énergie dans la liste    =====    " + textFinition);

                    Wait.Wait(2000);

                    EtiquetteFinition = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-card[1]/div[1]/div[1]/a[1]/div[2]/h3[1]"))
                            .getText();
                    System.out.println("Après clic3, nom de l'énergie sur l'étiquette vh    =====     " + EtiquetteFinition);

                    Wait.Wait(2000);

                    driver.findElement(
                            By.xpath("//app-filter-select[@class='stock__filterTrim ng-tns-c5-3']//app-filter-choice[" + j + "]//label[1]//span[1]"))
                            .click();

                    Wait.Wait(1000);

                    offersNum = offersNum + NbVh[i][j];

                    // test = test + NbVh[i][j];

                }
                System.out.println("0000000   " + offersNum);
                Wait.Wait(1000);
                if (NbVh[i][0] != offersNum) {
                    Error++;
                    System.out.println(ModelList[i - 1]);
                } else if (!EtiquetteFinition.contains(textFinition)) {

                    Wait.Wait(1000);
                    Error++;
                    System.out.println(ModelList[i - 1]);
                }
            }

            catch (NumberFormatException exception) {
                Wait.Wait(2000);
                System.err.println(ModelList[i - 1]);
                System.err.println("Pas de véhicule de ce type présent, A VERIFIER");
            }

            Wait.Wait(2000);
            driver.findElement(By.xpath("//span[@class='ng-tns-c5-3 ng-star-inserted']")).click();
            Wait.Wait(1000);
            driver.findElement(
                    By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]")).click(); // décocher
            // le
            // modèle
            Wait.Wait(3000);
            offersNum = 0;
        }

        assert (Error == 0);

    }

    @Test
    public void SuperTestMoteurs() {// vérifie que la somme du nombre de vh par moteur est égale au total de Vh par modèle => ex : le nb total de 108
                                    // = nb de 108 ac une motorisation x + nb de 108 ac motorisation y
        // de plus, vérifie l'existence de la mention du moteur sur l'étiquette du vh, et vérifie qu'elle corresponde bien au moteur coché

        System.out.println("------------------ SuperTestMoteurs --------------");
        Wait.Wait(2000);
        boolean exist = false;
        int[][] NbVh = new int[100][100];
        int Error = 0;
        int offersNum = 0;
        String textMoteur = new String();
        String EtiquetteMoteur = new String();
        // NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);

        for (int i = 1; i < ModelList.length; i++) { // boucle sur les modèles
            try {
                System.out.println(ModelList[i - 1]);

                Wait.Wait(1000);
                driver.findElement(
                        By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]"))
                        .click();

                Wait.Wait(1000);

                NbVh[i][0] = rp.GetTheOffersNum(driver);
                System.out.println("NB Vh affichés avt clic " + NbVh[i][0]);

                String[] EngineList = fp.GetEngineList(driver);
                Wait.Wait(1000);
                // System.out.println(FinitionList.length);

                for (int j = 1; j <= EngineList.length; j++) {// boucle ssur les moteurs

                    int test = 0;
                    Wait.Wait(1000);
                    driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[8]/app-filter-select[1]/div[2]/app-filter-choice["
                                    + j + "]/label[1]/span[1]"))
                            .click();

                    Wait.Wait(3000);

                    NbVh[i][j] = rp.GetTheOffersNum(driver);

                    System.out.println("NB Vh affichés après clic " + NbVh[i][j]);

                    Wait.Wait(2000);

                    textMoteur = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[8]/app-filter-select[1]/div[2]/app-filter-choice["
                                    + j + "]/label[1]/span[1]"))
                            .getText();

                    System.out.println("Après clic2, nom du moteur dans la liste     ====      " + textMoteur);

                    Wait.Wait(2000);

                    EtiquetteMoteur = driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-card[1]/div[1]/div[1]/a[1]/div[2]/h4[1]"))
                            .getText();
                    System.out.println("Après clic3, nom du moteur sur l'étiquette " + EtiquetteMoteur);

                    Wait.Wait(2000);

                    driver.findElement(By.xpath(
                            "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[8]/app-filter-select[1]/div[2]/app-filter-choice["
                                    + j + "]/label[1]/span[1]"))
                            .click();

                    Wait.Wait(1000);

                    offersNum = offersNum + NbVh[i][j];

                    // test = test + NbVh[i][j];

                }
                System.out.println("0000000   " + offersNum);
                Wait.Wait(1000);
                if (NbVh[i][0] != offersNum) {
                    Error++;
                    System.out.println(ModelList[i]);
                } else if (!EtiquetteMoteur.contains(textMoteur)) {

                    Wait.Wait(1000);
                    Error++;
                    System.out.println(ModelList[i]);
                }
            }

            catch (NumberFormatException exception) {
                Wait.Wait(2000);
                System.err.println(ModelList[i - 1]);
                System.err.println("Pas de véhicule de ce type présent, A VERIFIER");
            }

            Wait.Wait(2000);
            driver.findElement(
                    By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterEngine']//span[@class='stock__icon-arrow-bottom']"))
                    .click();
            Wait.Wait(1000);
            driver.findElement(
                    By.xpath("//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]")).click(); // décocher
            // le
            // modèle
            Wait.Wait(3000);
            offersNum = 0;
        }

        assert (Error == 0);

    }
}

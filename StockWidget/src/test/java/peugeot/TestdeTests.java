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

        driver = InitialiseDrivers.InitialiseIEDriver();
        driver.get("https://prod-widget.stockengine.awsmpsa.com/demo/#/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // driver.findElement(By.className("psac_noselect")).click();

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

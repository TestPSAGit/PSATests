/*
 * Creation : 16 mai 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.Wait;

public class ProductPageActionsTests {

    static WebDriver driver;
    ProductPageCompo pp = new ProductPageCompo();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/?geodistance=197;41.1579438;-8.629105299999992;Porto&budget=29809;48648");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test
    public void TestPopinDetailPrix() {// check présence CTA retour

        Wait.Wait(2000);
        pp.DetailPrixSelect(driver);
        Wait.Wait(2000);
        assert (pp.PopupDétailPrixTextTitle(driver).contains("DÉTAIL DU PRIX"));

    }

    @Test
    public void TestClickCTAGaucheVisuEXT() { // on vérifie qu'à chaque clic sur le bouton de défilement de gauche, le compteur de défilement de
                                              // visuels change
        Wait.Wait(2000);
        String[] compteur = new String[100];
        int Error = 0;

        for (int i = 0; i < 5; i++) {

            pp.IconeFlecheGaucheVisuelsExtClick(driver);
            Wait.Wait(1500);

            compteur[i + 1] = pp.CompteurImagesExtText(driver);
            Wait.Wait(2000);

            if (compteur[i + 1] == compteur[i]) {
                Error++;
            } else {
                System.out.println("GOOD");
            }
            assert (Error == 0);
        }

    }

    @Test
    public void TestClickCTADroiteVisuExt() { // on vérifie qu'à chaque clic sur le bouton de défilement de droite, le compteur de défilement de
                                              // visuels change
        Wait.Wait(2000);
        String[] compteur = new String[100];
        int Error = 0;

        Wait.Wait(1000);
        for (int i = 0; i < 5; i++) {

            pp.IconeFlecheDroiteVisuelsExtClick(driver);
            Wait.Wait(1500);

            compteur[i + 1] = pp.CompteurImagesExtText(driver);
            Wait.Wait(2000);

            if (compteur[i + 1] == compteur[i]) {
                Error++;
            } else {
                System.out.println("GOOD");
            }
            assert (Error == 0);
        }

    }

    @Test
    public void TestClickCTAGaucheVisuInt() { // on vérifie qu'à chaque clic sur le bouton de défilement de gauche, le compteur de défilement de
                                              // visuels change
        Wait.Wait(2000);
        String[] compteur = new String[100];
        int Error = 0;

        pp.PictoVueIntSelect(driver);
        Wait.Wait(1000);
        for (int i = 0; i < 4; i++) {

            pp.IconeFlecheGaucheVisuelsIntClick(driver);
            Wait.Wait(1500);

            compteur[i + 1] = pp.CompteurImagesIntText(driver);
            Wait.Wait(2000);

            if (compteur[i + 1] == compteur[i]) {
                Error++;
            } else {
                System.out.println("GOOD");
            }
            assert (Error == 0);
        }

    }

    public void TestClickCTADroiteVisuInt() { // on vérifie qu'à chaque clic sur le bouton de défilement de droite, le compteur de défilement de
        // visuels change
        Wait.Wait(2000);
        String[] compteur = new String[100];
        int Error = 0;

        pp.PictoVueIntSelect(driver);
        Wait.Wait(1000);
        for (int i = 0; i < 4; i++) {

            pp.IconeFlecheDroiteVisuelsIntClick(driver);
            Wait.Wait(1500);

            compteur[i + 1] = pp.CompteurImagesIntText(driver);
            Wait.Wait(2000);

            if (compteur[i + 1] == compteur[i]) {
                Error++;
            } else {
                System.out.println("GOOD");
            }
            assert (Error == 0);
        }

    }

    @Test
    public void TestPopinFormulaireContact() {

        Wait.Wait(2000);
        pp.CTAContactConseillerSelect(driver);
        Wait.Wait(2000);
        assert (pp.PopupFormulaireTextTitle(driver).equals("Vous allez contacter votre concessionnaire !"));

    }

    @Test
    public void TestNewOngletFicheTech() { // vérifie qu'un autre onglet s'ouvre qd on clique sur le CTA fiche technique

        Wait.Wait(2000);
        assert (pp.FicheTechPDFDIsplayed1(driver) == true);

    }

    @Test
    public void TestFicheTechPDFContent() { // vérifie que l'URL est valide, et donc ouvre le doc PDF du vh

        Wait.Wait(2000);
        assert (pp.FicheTechPDFUrlContent(driver).contains("OPV_AP_PT"));

    }

    @Test
    public void TestCTAAppelConseillerClick() { // si la popup skype s'affiche, cliquer sur un autre élement de la page doit être impossible, où
                                                // l'assertion à false

        Wait.Wait(2000);
        assert (pp.CTAAppelConseillerClick(driver) == false);

    }

}

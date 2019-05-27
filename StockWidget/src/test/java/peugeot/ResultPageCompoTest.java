/*
 * Creation : 12 avr. 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Methodes.Wait;

public class ResultPageCompoTest {
    static WebDriver driver;
    ResultPageCompo rp = new ResultPageCompo();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        // driver.findElement(By.className("psac_noselect")).click();

    }
    /*
     * @Test
     * 
     * public void TestPageNumber() { driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); String[] Pages =
     * rp.GetVHNumberOnPages(driver); String toto = Pages[0] + " - " + Pages[2]; assert (toto.equals("1 - 24")); }
     */

    @Test

    public void GetPageTest() {
        String[] te = rp.ClickOnPageNumber(driver);
        System.out.println(te[0]);
        System.out.println(te[1]);

    }

    @Test(priority = 1)
    public void TestTitletext() { // check le title de la page
        Wait.Wait(6000);
        String title = rp.CheckTitle(driver);
        assert (title.contains("Achetez votre Peugeot neuve en stock Rapidement"));

    }

    @Test(priority = 2)
    public void TestDeliveryDateText() { // check si la date de livraison est présente ds la VH card
        Wait.Wait(2000);
        String deliveryDate = rp.VHCardDeliveryDate(driver);
        assert (deliveryDate.contains("Livraison sous"));
    }

    @Test(priority = 3)
    public void TestVHCardOptionPicto() {// check si le picto des options est présent ds la VH card
        Wait.Wait(2000);
        assert (rp.VHCardOptionCTAPicto(driver) == true);
    }

    @Test(priority = 4)
    public void TestDisplayOptionsListVHCard() {// check si la popup options s'ouvre (ds la vh card)
        Wait.Wait(2000);
        assert (rp.VHCardOptionCTAClick(driver) == true);
    }

    @Test(priority = 5)
    public void TestConsoCTAText() {// check si le texte relation à la conso est présent
        Wait.Wait(2000);
        String ConsoCTAText = rp.VHCardConsoCTAtext(driver);
        assert (ConsoCTAText.contains("L / 100km"));
    }

    @Test(priority = 6)
    public void TestConsoCTAPictoPresent() { // check si le picto relatif à la conso est présent ds la vh card
        Wait.Wait(2000);
        assert (rp.VHCardConsoCTAPicto(driver) == true);
    }

    @Test(priority = 7)
    public void TestConsoCTAPictoClick() { // check si la popup conso s'ouvre
        Wait.Wait(2000);
        assert (rp.VHCardConsoCTAClick(driver) == true);
    }

    @Test(priority = 8)
    public void TestEnergyVHCardText() { // check les mentions energy de la Vh card
        Wait.Wait(2000);
        assert (rp.VHCardEnergytext(driver).equals("Diesel") || rp.VHCardEnergytext(driver).equals("Gasolina")
                || rp.VHCardEnergytext(driver).equals("Elécritco"));
    }

    @Test(priority = 9)
    public void TestVHCardEnergyPictoDisplayed() { // check le picto energy ds la vh card
        Wait.Wait(2000);
        assert (rp.VHCardEnergyPicto(driver) == true);
    }

    @Test(priority = 10)
    public void TestVHCardCO2text() { // check le text relatif aux émissions ds la vh card
        Wait.Wait(2000);
        assert (rp.VHCardCO2text(driver).contains("g/km"));
    }

    @Test(priority = 11)
    public void TestVHCardCO2PictoDisplayed() { // check le picto des émission sur la VH card
        Wait.Wait(2000);
        assert (rp.VHCardCO2Picto(driver) == true);
    }

    @Test(priority = 12)
    public void VHCardClassificationText() { // check le texte ds le bandeau de classification (vh card)
        Wait.Wait(2000);
        assert (rp.VHCardClassificationText(driver).equals("A") || rp.VHCardClassificationText(driver).equals("B")
                || rp.VHCardClassificationText(driver).equals("C") || rp.VHCardClassificationText(driver).equals("D"));
    }

    @Test(priority = 13)
    public void TestVHCardBakgroundPictoClassifiDisplayed() { // check le fond du picto de classification
        Wait.Wait(2000);
        assert (rp.VHCardClassificationBackground1(driver) == true);
    }

    @Test(priority = 14)
    public void TestVHRemiseBackgroundDisplayed() { // test le fond de l'encart remises
        Wait.Wait(2000);
        assert (rp.VHCardRemisesBackground(driver) == true);
    }

    @Test(priority = 15)
    public void TestDiscountTitle() { // check le texte de l'encart remises
        Wait.Wait(2000);
        assert (rp.VHCardRemisesTitle(driver).equals("Remises incluses"));
    }

    @Test(priority = 16)
    public void TestDiscountPrice() { // teste le prix de l'encart remise
        Wait.Wait(2000);
        assert (rp.VHCardRemisesPrice(driver).contains("€ TTC"));
    }

    @Test(priority = 17)
    public void TestVHCardDisplayed() { // teste que la vh card est visible
        Wait.Wait(2000);
        assert (rp.VHCardIsDisplayed(driver) == true);
    }

    @Test(priority = 18)
    public void TestLegalMentions() {
        Wait.Wait(2000);
        assert (rp.LegalMentions(driver).contains(
                "*Les valeurs de consommation de carburant et d’émissions de CO2 indiquées sont conformes aux homologations NEDC et WLTP ."));
    }

    @Test(priority = 19)
    public void TestVHAvalaible() {// teste mention véhicules dispo
        Wait.Wait(2000);
        assert (rp.AvalaibleVH(driver).contains("Véhicules disponibles"));
    }

    @Test(priority = 20)
    public void PaginationDisplayed() { // check si pagination bien visible
        Wait.Wait(2000);
        assert (rp.PaginationDisplayed(driver) == true);
    }

    @Test(priority = 21)
    public void TestPageNumber1() { // check la mention du nb de vh par page
        Wait.Wait(2000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[3]/ngb-pagination[1]/ul[1]/li[2]/a[1]"))
                .click();
        Wait.Wait(1000);
        String[] Pages = rp.GetVHNumberOnPages(driver);
        String nbdanspage = Pages[0] + " - " + Pages[2];
        Wait.Wait(1000);
        assert (nbdanspage.equals("1 - 24"));
    }

    @Test(priority = 22)
    public void TestTotalPages() { // check la mention du nb total de vh
        Wait.Wait(2000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[3]/ngb-pagination[1]/ul[1]/li[2]/a[1]"))
                .click();
        Wait.Wait(2000);
        String[] Pages = rp.GetTotalPagesNumber(driver);
        Wait.Wait(1000);
        String totalpage = Pages[4];
        Wait.Wait(1000);
        assert (totalpage.contains("2827"));
    }

    @Test(priority = 23)
    public void GetPageTest2() { // check si on change bien de page
        String[] changePage = rp.ClickOnPageNumber(driver);
        System.out.println(changePage[0]);
        System.out.println(changePage[1]);
        assert (changePage[0].contains("3"));
        assert (changePage[0].contains("current"));
        assert (changePage[1].contains("2"));

    }

    @Test(priority = 24)
    public void TestCTANextPageBackground() {
        Wait.Wait(2000);
        assert (rp.CTANextPageBackground(driver) == true);
    }

    @Test(priority = 25)
    public void TestCTANextPageText() { // CTA next page present
        Wait.Wait(2000);
        assert (rp.CTANextPageText(driver).equals("»"));
    }

    @Test(priority = 26)
    public void TestCTAPrevPageBackground() {
        Wait.Wait(2000);
        assert (rp.CTAPreviousPageBackground(driver) == true);
    }

    @Test(priority = 27)
    public void TestCTAPrevPageText() { // CTA previous page present
        Wait.Wait(2000);
        assert (rp.CTAPreviousPageText(driver).equals("«"));
    }

    @Test(priority = 28)
    public void TestSortingMenuDisplayed() {
        Wait.Wait(2000);
        assert (rp.SortingMenu(driver) == true);
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest logger = extent.createTest("TestSortingMenuDisplayed");
        logger.log(Status.INFO, "Login To Amazon");
        logger.log(Status.PASS, "Login To Google");
        extent.flush();
        ExtentTest logger1 = extent.createTest("TestCTAPrevPageText");
        logger1.log(Status.INFO, "Login To Amazon");
        logger1.log(Status.PASS, "Login To Google");
        extent.flush();
    }

}

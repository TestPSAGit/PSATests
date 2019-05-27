/*
 * Creation : 14 mai 2019
 */
package peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Methodes.Wait;

public class ProductPageCompo {
    static String[] Pages;
    static WebDriver driver;
    static String[] te;

    static boolean CTAPreviousPage(WebDriver driver) {

        return driver.findElement(By.xpath("//a[@id='btn-returnMainPage']")).isDisplayed();

    }

    static String CTAPreviousPageText(WebDriver driver) {

        return driver.findElement(By.xpath("//a[@id='btn-returnMainPage']")).getText();

    }

    static boolean CTAPreviousPageIcone(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__icon-return']")).isDisplayed();

    }

    static void PictoVueExtSelect(WebDriver driver) {

        driver.findElement(By.xpath("//span[@class='stock__icon-view-out']"));

    }

    static boolean PictoVueExt(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__icon-view-out']")).isDisplayed();

    }

    static String TextVueExt(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/div[1]/div[1]/p[1]"))
                .getText();

    }

    static void PictoVueIntSelect(WebDriver driver) {

        driver.findElement(By.xpath("//span[@class='stock__icon-view-in']")).click();

    }

    static boolean PictoVueInt(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__icon-view-in']")).isDisplayed();

    }

    static String TextVueInt(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/div[1]/div[2]/p[1]"))
                .getText();

    }

    static void PictoVue360Select(WebDriver driver) {

        driver.findElement(By.xpath("//span[@class='stock__icon-view-360']")).click();

    }

    static boolean PictoVue360(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__icon-view-360']")).isDisplayed();

    }

    static String TextVue360(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/div[1]/div[3]/p[1]"))
                .getText();

    }

    static String CheckVHTitle(WebDriver driver) {

        return driver.findElement(By.xpath("//h1[@class='stock__vehicle-label__name stock__vehicle-label__name--product-page stock__trunc']"))
                .getText();

    }

    static boolean CheckVHTitleDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//h1[@class='stock__vehicle-label__name stock__vehicle-label__name--product-page stock__trunc']"))
                .isDisplayed();

    }

    static String CheckVHCaracteristics(WebDriver driver) {

        return driver.findElement(By.xpath("//h2[@class='stock__vehicle-label__version stock__vehicle-label__version--product-page stock__trunc']"))
                .getText();

    }

    static boolean CheckVHCaracteristicsDisplay(WebDriver driver) {

        return driver.findElement(By.xpath("//h2[@class='stock__vehicle-label__version stock__vehicle-label__version--product-page stock__trunc']"))
                .isDisplayed();
    }

    static boolean PrixTotalTitreDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//h3[@class='stock__price__title stock__price__title--product_page']")).isDisplayed();
    }

    static String PrixTotalTitreText(WebDriver driver) {

        return driver.findElement(By
                .xpath("//*[@id=\"stock-widget-container\"]/stock-widget-app/div/app-vehicles-details-container/div/div[2]/div/app-price/div/div/h3"))
                .getText();

    }

    static boolean PrixTotalNbDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//p[@class='stock__price__text stock__price__text--product_page']")).isDisplayed();

    }

    static String PrixTotalNbText(WebDriver driver) {

        return driver.findElement(By.xpath("//p[@class='stock__price__text stock__price__text--product_page']")).getText();

    }

    static void DetailPrixSelect(WebDriver driver) {

        driver.findElement(By.xpath("//span[@class='stock__price__link__text']")).click();

    }

    static boolean DetailPrixDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__price__link__text']")).isDisplayed();

    }

    static String DetailPrixText(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__price__link__text']")).getText();

    }

    static boolean DetailPrixIconeDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//button[@id='link-OpenDiscountPopin']//span[@class='stock__icon-arrow-right']")).isDisplayed();

    }

    static boolean EncartRemisesDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(@class,'stock__discount--product_page__background')]")).isDisplayed();

    }

    static String EncartRemisesText(WebDriver driver) {

        return driver.findElement(By.xpath("//h4[contains(@class,'stock__discount__title--product_page')]")).getText();

    }

    static boolean EncartRemisesPrixDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//p[contains(@class,'stock__discount__text stock__discount__text--product_page')]")).isDisplayed();

    }

    static String EncartRemisesPrixText(WebDriver driver) {

        return driver.findElement(By.xpath("//p[contains(@class,'stock__discount__text stock__discount__text--product_page')]")).getText();

    }

    static boolean PictoDateLivraison(WebDriver driver) {

        return driver.findElement(By.xpath("//span[contains(@class,'stock__delivery__icon stock__icon-delivery')]")).isDisplayed();

    }

    static boolean DateLivraisonDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//span[contains(@class,'stock__delivery__text')]")).isDisplayed();

    }

    static String DateLivraisonText(WebDriver driver) {

        return driver.findElement(By.xpath("//span[contains(@class,'stock__delivery__text')]")).getText();

    }

    static boolean EncartVendeurDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(@class,'stock__vehicle-information')]//div[contains(@class,'stock__box')]")).isDisplayed();

    }

    static String AdresseVendeurDisplayed1(WebDriver driver) {

        return driver.findElement(By.xpath("//p[contains(@class,'stock__dealer__address__place')]")).getText();

    }

    static boolean AdresseVendeurDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[2]/div[1]/app-availability[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[2]"))
                .isDisplayed();

    }

    static boolean CurseurLocalisationDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(@class,'col-1')]//span[contains(@class,'stock__icon-localisation')]")).isDisplayed();

    }

    static String CTAVoirPlusText(WebDriver driver) {

        return driver.findElement(By.xpath("//button[@id='link-SeeMore']")).getText();

    }

    static void CTAVoirPlusTextClick(WebDriver driver) {

        driver.findElement(By.xpath("//button[@id='link-SeeMore']")).click();

    }

    static boolean IconeVoirPlus(WebDriver driver) {

        return driver.findElement(By.xpath("//button[@id='link-SeeMore']//span[contains(@class,'stock__icon-arrow-right')]")).isDisplayed();

    }

    static boolean IconeFlecheDroiteVisuelsExt(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/ngb-carousel[1]/a[2]/span[1]"))
                .isDisplayed();

    }

    static void IconeFlecheDroiteVisuelsExtClick(WebDriver driver) {

        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/ngb-carousel[1]/a[2]/span[1]"))
                .click();

    }

    static boolean IconeFlecheDroiteVisuelsExtIcon(WebDriver driver) {

        return driver.findElement(By.xpath("//span[contains(@class,'carousel-control-next-icon')]")).isDisplayed();

    }

    static boolean IconeFlecheGaucheVisuelsExt(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='carousel-control-prev-icon']")).isDisplayed();

    }

    static void IconeFlecheGaucheVisuelsExtClick(WebDriver driver) {

        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/ngb-carousel[1]/a[1]"))
                .click();

    }

    static void IconeFlecheGaucheVisuelsIntClick(WebDriver driver) {

        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/ngb-carousel[1]/a[1]"))
                .click();

    }

    static void IconeFlecheDroiteVisuelsIntClick(WebDriver driver) {

        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/ngb-carousel[1]/a[2]/span[1]"))
                .click();

    }

    static boolean IconeFlecheGaucheVisuelsExtIcon(WebDriver driver) {

        return driver.findElement(By.xpath("//span[contains(@class,'carousel-control-prev-icon')]")).isDisplayed();

    }

    static boolean VisuExtImage(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(@class,'carousel-item ng-star-inserted active')]//img[contains(@class,'img-fluid')]"))
                .isDisplayed();

    }

    static boolean VisuIntImage(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(@class,'carousel-item active ng-star-inserted')]//img[contains(@class,'img-fluid')]"))
                .isDisplayed();

    }

    static boolean Visu360Image(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(@class,'stock__container360')]")).isDisplayed();

    }

    static boolean TextCouleurSousVisu(WebDriver driver) {

        return driver
                .findElement(By.xpath(
                        "//*[@id=\"stock-widget-container\"]/stock-widget-app/div/app-vehicles-details-container/div/div[1]/app-carousel/div/div[3]"))
                .isDisplayed();

    }

    static void CTAContactConseillerSelect(WebDriver driver) { // bouton formulaire

        driver.findElement(By.xpath("//button[@id='btn-contact']")).click();

    }

    static void CTAFicheTechniqueClick(WebDriver driver) {

        driver.findElement(By.xpath("//span[@id='printPDF']")).click();

    }

    static boolean CTAContactConseillerDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//button[@id='btn-contact']")).isDisplayed();

    }

    static String CTAContactConseillerText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[2]/div[1]/app-contact[1]/div[1]/button[1]"))
                .getText();

    }

    static boolean CompteurImagesExtDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(text(),' / ')]")).isDisplayed();

    }

    static String CompteurImagesExtText(WebDriver driver) {

        return driver.findElement(By.xpath("//div[contains(text(),' / ')]")).getText();

    }

    static boolean CompteurImagesIntDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/ngb-carousel[1]/div[1]/div[1]/div[2]/div[2]"))
                .isDisplayed();

    }

    static String CompteurImagesIntText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/div[1]/div[1]/app-carousel[1]/div[1]/ngb-carousel[1]/div[1]/div[1]/div[2]/div[2]"))
                .getText();

    }

    static boolean EncartOptionsInclusesDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//h2[@class='stock__section__title stock__option__title']")).isDisplayed();

    }

    static String EncartOptionsInclusesTitreText(WebDriver driver) {

        return driver.findElement(By.xpath("//h2[contains(@class,'stock__section__title stock__option__title')]")).getText();

    }

    static boolean EncartListeOptionsDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//ul[@class='row stock__option-list']")).isDisplayed();

    }

    static boolean EncartCaractéristiquesDisplayed(WebDriver driver) {

        return driver
                .findElement(By.xpath(
                        "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/h2[1]"))
                .isDisplayed();

    }

    static String EncartCaractéristiquesTitreText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/h2[1]"))
                .getText();

    }

    static boolean TableauCaractDisplayed(WebDriver driver) {

        return driver
                .findElement(By.xpath(
                        "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]"))
                .isDisplayed();

    }

    static String ColonneEnergieTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[1]"))
                .getText();

    }

    static boolean ColonneEnergieChampText(WebDriver driver) { // test, pas sur que ca marche

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]"))
                .isDisplayed();

    }

    static String ColonnePuissanceTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[2]"))
                .getText();

    }

    static boolean ColonnePuissanceChampText(WebDriver driver) {// test, pas sur que ca marche

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]"))
                .isDisplayed();

    }

    static String ColonneConsommationTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[3]"))
                .getText();

    }

    static boolean ColonneConsommationChampText(WebDriver driver) {// test, pas sur que ca marche

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]"))
                .isDisplayed();

    }

    static String ColonneEmissionCO2TitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[4]"))
                .getText();

    }

    static boolean ColonneEmissionCO2ChampText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]"))
                .isDisplayed();

    }

    static String LegalWLTPText(WebDriver driver) {

        return driver
                .findElement(By.xpath(
                        "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics[1]/div[1]/p[1]"))
                .getText();

    }

    static boolean EncartCaracTechDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/h2[1]"))
                .isDisplayed();

    }

    static String EncartCaracTechText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/h2[1]"))
                .getText();

    }

    static boolean TableauCaracTechDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__characteristics-tech']//div[@class='d-none d-md-block']")).isDisplayed();

    }

    static String ColonneFinitionTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[1]"))
                .getText();

    }

    static boolean ColonneFinitionChampText(WebDriver driver) { // test, pas sur que ca marche

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]"))
                .isDisplayed();

    }

    static String ColonneMoteurTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[2]"))
                .getText();

    }

    static boolean ColonneMoteurChampText(WebDriver driver) {// test, pas sur que ca marche

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]"))
                .isDisplayed();

    }

    static String ColonneSilhouetteTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[3]"))
                .getText();

    }

    static boolean ColonneSilhouetteChampText(WebDriver driver) {// test, pas sur que ca marche

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]"))
                .isDisplayed();

    }

    static String ColonneBDVTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[4]"))
                .getText();

    }

    static boolean ColonneBDVChampText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]"))
                .isDisplayed();

    }

    static String ColonneVINTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[5]"))
                .getText();

    }

    static boolean ColonneVINChampText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-characteristics-tech[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]"))
                .isDisplayed();

    }

    static void CTAFicheTechSelect(WebDriver driver) {

        driver.findElement(By.xpath("//span[@id='printPDF']"));

    }

    static boolean CTAFicheTechDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@id='printPDF']")).isDisplayed();

    }

    static String CTAFicheTechText(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@id='printPDF']")).getText();

    }

    static boolean IconeFicheTechDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__icon-pdf']")).isDisplayed();

    }

    static boolean TitreEquipementsDisplayed(WebDriver driver) {

        return driver
                .findElement(By
                        .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/h2[1]"))
                .isDisplayed();

    }

    static String TitreEquipementsText(WebDriver driver) {

        return driver
                .findElement(By
                        .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/h2[1]"))
                .getText();

    }

    static boolean TableauEquipementsDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='column']")).isDisplayed();

    }

    static boolean TableauEquipementsSegurançaDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='column']//div[1]")).isDisplayed();

    }

    static String TableauEquipementsSegurançaText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[1]/h3[1]"))
                .getText();

    }

    static boolean TableauEquipementsInteriorDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[2]"))
                .isDisplayed();

    }

    static String TableauEquipementsInteriorText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[2]/h3[1]"))
                .getText();

    }

    static boolean TableauBancosDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[2]"))
                .isDisplayed();

    }

    static String TableauBancosText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[2]/h3[1]"))
                .getText();

    }

    static boolean TableauEquipementsAideConducDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[3]"))
                .isDisplayed();

    }

    static String TableauEquipementsAideConducText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[3]/h3[1]"))
                .getText();

    }

    static boolean TableauEquipementsExterieurDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[4]"))
                .isDisplayed();

    }

    static String TableauEquipementsExterieurTitleText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[4]/h3[1]"))
                .getText();

    }

    static boolean TableauEquipementsConfortDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[4]"))
                .isDisplayed();

    }

    static String TableauEquipementsConfortText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[4]/h3[1]"))
                .getText();

    }

    static boolean TableauEquipementsInstrumentDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//app-equipments[@class='ng-star-inserted']//div[6]")).isDisplayed();

    }

    static String TableauEquipementsInstrumentText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[6]/h3[1]"))
                .getText();

    }

    static boolean TableauEsteticaDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[5]"))
                .isDisplayed();

    }

    static String TableauEsteticaText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[5]/h3[1]"))
                .getText();

    }

    static boolean TableauEquipementsAudioEtCommDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[6]"))
                .isDisplayed();

    }

    static String TableauEquipementsAudioEtCommText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[6]/h3[1]"))
                .getText();

    }

    static boolean TableauEquipementsOutrosDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//h3[contains(text(),'Outros')]")).isDisplayed();

    }

    static String TableauEquipementsOutrosText(WebDriver driver) {

        return driver.findElement(By.xpath("//h3[contains(text(),'Outros')]")).getText();

    }

    static boolean TableauEquipementsInstruDisplayed(WebDriver driver) {

        return driver.findElement(By
                .xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[6]"))
                .isDisplayed();

    }

    static String TableauEquipementsInstruText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-equipments[1]/div[1]/div[1]/div[6]/h3[1]"))
                .getText();

    }

    static boolean TitreVotreConcessionnaireDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//h2[@class='stock__map-dealer__title stock__section__title']")).isDisplayed();

    }

    static String TitreVotreConcessionnaireText(WebDriver driver) {

        return driver.findElement(By.xpath("//h2[@class='stock__map-dealer__title stock__section__title']")).getText();

    }

    static boolean BlocVotreConcessionnaireDisplayed(WebDriver driver) {

        return driver
                .findElement(By.xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-dealer[1]/div[1]"))
                .isDisplayed();

    }

    static boolean MapConcessionnaireDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__map-dealer__map']")).isDisplayed();

    }

    static boolean BlocInfosConcessionnaireDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='col-md-3 stock__map-dealer__information-container']")).isDisplayed();

    }

    static boolean BlocInfosConcessionnaireAdresseDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__map-dealer__information__dealer']")).isDisplayed();

    }

    static String BlocInfosConcessionnaireAdresseText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-dealer[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"))
                .getText();

    }

    static boolean BlocInfosConcessionnaireAdresseIconeDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='col-md-1']//span[@class='stock__icon-localisation']")).isDisplayed();

    }

    static boolean BlocInfosConcessionnaireHorairesDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-dealer[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"))
                .isDisplayed();

    }

    static String BlocInfosConcessionnaireHorairesText(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-dealer[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]"))
                .getText();

    }

    static boolean BlocInfosConcessionnaireHorairesIconeDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='col-md-1']//span[@class='stock__icon-schedule']")).isDisplayed();

    }

    static boolean BlocContactMailConcessionnaireDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__map-dealer__information__contact']")).isDisplayed();

    }

    static String BlocContactConcessionnaireText(WebDriver driver) {

        return driver.findElement(By.xpath("//a[@id='link-ClicOnMail']")).getText();

    }

    static boolean BlocContactConcessionnaireIconeDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='stock__icon-email']")).isDisplayed();

    }

    static boolean CTACallConcessionnaireDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//button[@id='btn-showPhoneNumber']")).isDisplayed();

    }

    static void CTACallConcessionnaireSelect(WebDriver driver) {

        driver.findElement(By.xpath("//button[@id='btn-showPhoneNumber']"));

    }

    static String CTACallConcessionnaireText(WebDriver driver) {

        return driver.findElement(By.xpath("//button[@id='btn-showPhoneNumber']")).getText();

    }

    static boolean MapIconBonhommeDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='gm-svpc']")).isDisplayed();

    }

    static boolean MapIconPlusDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='gmnoprint gm-bundled-control gm-bundled-control-on-bottom']//button[1]")).isDisplayed();

    }

    static boolean MapIconMoinsDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-dealer[1]/div[1]/div[1]/div[1]/div[1]/agm-map[1]/div[1]/div[1]/div[1]/div[8]/div[1]/div[1]/button[2]"))
                .isDisplayed();

    }

    static void ScrollMap(WebDriver driver) {

        WebElement goal = driver
                .findElement(By.xpath("/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-vehicles-details-container[1]/app-dealer[1]/div[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goal);

    }

    static String PopupDétailPrixTextTitle(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-discount[1]/div[1]/div[2]/div[1]/h1[1]"))
                .getText();

    }

    static String PopupFormulaireTextTitle(WebDriver driver) {

        return driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-contact-form[1]/div[1]/div[2]/div[1]/div[1]/p[1]"))
                .getText();

    }

    static void FicheTechPDFContent(WebDriver driver) {

        CTAFicheTechniqueClick(driver);
        Wait.Wait(2000);
        WebElement Element = driver.findElement(By.xpath("/html[1]/body[1]/embed[1]"));

        System.out.println(Element.getAttribute("type"));
        // if (Element.getAttribute("type"));

    }

    static boolean FicheTechPDFDIsplayed1(WebDriver driver) {

        CTAFicheTechniqueClick(driver);
        Wait.Wait(2000);

        if (driver.getWindowHandles().size() >= 2)
            return true;
        else
            return false;

    }

    static String FicheTechPDFUrlContent(WebDriver driver) {

        CTAFicheTechniqueClick(driver);
        Wait.Wait(2000);
        String Url = driver.getCurrentUrl();
        return Url;

    }

    static boolean SkypePopupDIsplayed(WebDriver driver) {

        Wait.Wait(3000);
        CTAContactConseillerSelect(driver);
        Wait.Wait(2000);

        if (driver.getWindowHandles().size() == 2)
            return true;
        else
            return false;

    }

    static boolean CTAAppelConseillerClick(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Wait.Wait(2000);
        driver.findElement(By.xpath("//button[@id='btn-showPhoneNumber']")).click(); // click sur le bouton bleu pour acceder au num
        Wait.Wait(2000);
        driver.findElement(By.xpath("//a[@id='link-ClicOnPhoneNumber']")).click(); // click sur le num
        Wait.Wait(4000);

        CTAContactConseillerSelect(driver);
        Wait.Wait(2000);

        if (driver.getWindowHandles().size() == 2)
            return true;
        else
            return false;

    }

}

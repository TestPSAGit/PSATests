/*
 * Creation : 11 avr. 2019
 */
package peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPageCompo {
    static String[] Pages;
    static WebDriver driver;

    static String CheckTitle(WebDriver driver) {

        return driver.findElement(By.xpath("//h1[@class='stock__title'])")).getText();

    }

    static String VHCardDeliveryDate(WebDriver driver) {

        return driver
                .findElement(
                        By.xpath("//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//a[1]//p[1]//span[2]"))
                .getText();

    }

    static String VHCardOptionCTAtext(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//div[2]//ul[1]//li[1]//span[2]"))
                .getText();

    }

    static boolean VHCardOptionCTAPicto(WebDriver driver) {

        return driver.findElement(By.xpath("//*[normalize-space(text()) and normalize-space(.)='Remises incluses'])[1]/following::span[3]"))
                .isDisplayed();

    }

    static boolean VHCardOptionCTAClick(WebDriver driver) {

        driver.findElement(
                By.xpath("//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//div[2]//ul[1]//li[1]"))
                .click();
        return driver.findElement(By.xpath("//div[@class='popover-body']")).isDisplayed();

    }

    static String VHCardConsoCTAtext(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//div[2]//ul[1]//li[3]//span[2]"))
                .getText();

    }

    static boolean VHCardConsoCTAPicto(WebDriver driver) {

        return driver.findElement(By.xpath("//*[normalize-space(text()) and normalize-space(.)='Remises incluses'])[1]/following::span[9]"))
                .isDisplayed();

    }

    static boolean VHCardConsoCTAClick(WebDriver driver) {

        driver.findElement(By.xpath(
                "//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//div[2]//ul[1]//li[3]//span[2]"))
                .click();
        return driver.findElement(By.xpath("//ngb-popover-window[@id='ngb-popover-144']")).isDisplayed();

    }

    static String VHCardEnergytext(WebDriver driver) {

        return driver.findElement(By.id("vehicle-energy")).getText();

    }

    static boolean VHCardEnergyPicto(WebDriver driver) {

        return driver.findElement(By.xpath("//*[normalize-space(text()) and normalize-space(.)='Remises incluses'])[1]/following::span[15]"))
                .isDisplayed();

    }

    static String VHCardCO2text(WebDriver driver) {

        return driver.findElement(By.id("vehicle-environment")).getText();

    }

    static boolean VHCardCO2Picto(WebDriver driver) {

        return driver.findElement(By.xpath("//*[normalize-space(text()) and normalize-space(.)='Diesel'])[1]/following::span[1]")).isDisplayed();

    }

    static String VHCardClassificationText(WebDriver driver) {

        return driver.findElement(By.id("vehicle-energy-letter")).getText();

    }

    static boolean VHCardClassificationBackground1(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//div[2]//ul[2]//li[3]//p[1]"))
                .isDisplayed();

    }

    static boolean VHCardRemisesBackground(WebDriver driver) {

        return driver
                .findElement(By.xpath(
                        "//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//a[1]//div[3]//div[2]"))
                .isDisplayed();

    }

    static String VHCardRemisesTitle(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//a[1]//div[3]//div[2]//h3[1]"))
                .getText();
    }

    static String VHCardRemisesPrice(WebDriver driver) {

        return driver.findElement(By.id("vehicle-discounts-price")).getText();
    }

    static String VHCardIsDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//body/div[@id='stock-widget-container']/stock-widget-app[@ng-version='7.2.7']/div[@class='stock__container-fluid stock']/app-search-container[@class='ng-tns-c1-0 ng-star-inserted']/main[@class='ng-tns-c1-0']/div[@class='row stock__main_row']/div[@class='stock__search-container col-lg-9 order-lg-2']/div[@class='stock__content ng-tns-c1-0 ng-star-inserted']/div[@class='row ng-tns-c1-0 ng-trigger ng-trigger-vehicleList ng-star-inserted']/div[1]/app-card[1]/div[1]"))
                .getText();
    }

    static String LegalMentions(WebDriver driver) {

        return driver.findElement(By.xpath("//p[@class='stock__text__consumption__legal']")).getText();
    }

    static String AvalaibleVH(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='ng-tns-c1-0 ng-star-inserted']")).getText();
    }

    static boolean PaginationDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath("//ul[@class='pagination']")).isDisplayed();

    }

    static String[] GetNumberOfPages(WebDriver driver) {

        String[] PageComp = driver.findElement(By.xpath("//p[@class='stock__pagination__information']")).getText().split(" ");
        return PageComp;

    }

    public static void main(String[] args) {
        InitialiseDrivers ID = new InitialiseDrivers();
        driver = ID.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/?families=1PP8&budget=12554;60577");
        ResultPageCompo RP = new ResultPageCompo();
        Pages = RP.GetNumberOfPages(driver);
        System.out.println(Pages[0]);
    }

}
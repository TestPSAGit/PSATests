/*
 * Creation : 11 avr. 2019
 */
package peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Methodes.Wait;

class ResultPageCompo {
    static String[] Pages;
    static WebDriver driver;
    static String[] te;

    static String CheckTitle(WebDriver driver) {

        return driver.findElement(By.className("stock__title")).getText();

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

        return driver.findElement(By.xpath(
                "//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//div[2]//ul[1]//li[1]//span[1]"))
                .isDisplayed();

    }

    static boolean VHCardOptionCTAClick(WebDriver driver) {

        driver.findElement(
                By.xpath("//div[@class='stock__content ng-tns-c1-0 ng-star-inserted']//div[1]//app-card[1]//div[1]//div[1]//div[2]//ul[1]//li[1]"))
                .click();
        return driver.findElement(By.xpath("//div[@class='popover-body']")).isDisplayed();

    }

    static String VHCardConsoCTAtext(WebDriver driver) {

        return driver.findElement(By.id("vehicle-consumption")).getText();

    }

    static boolean VHCardConsoCTAPicto(WebDriver driver) {

        return driver.findElement(By.className("stock__icon-consumption")).isDisplayed();

    }

    static boolean VHCardConsoCTAClick(WebDriver driver) {

        driver.findElement(By.className("stock__icon-consumption")).click();
        Wait.Wait(2000);
        return driver.findElement(By.xpath("//div[@class='popover-body']")).isDisplayed();

    }

    static String VHCardEnergytext(WebDriver driver) {

        return driver.findElement(By.id("vehicle-energy")).getText();

    }

    static boolean VHCardEnergyPicto(WebDriver driver) {

        return driver.findElement(By.className("stock__icon-gas-station")).isDisplayed();

    }

    static String VHCardCO2text(WebDriver driver) {

        return driver.findElement(By.id("vehicle-environment")).getText();

    }

    static boolean VHCardCO2Picto(WebDriver driver) {

        return driver.findElement(By.className("stock__icon-environment")).isDisplayed();

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

    static boolean VHCardIsDisplayed(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//body/div[@id='stock-widget-container']/stock-widget-app[@ng-version='7.2.7']/div[@class='stock__container-fluid stock']/app-search-container[@class='ng-tns-c1-0 ng-star-inserted']/main[@class='ng-tns-c1-0']/div[@class='row stock__main_row']/div[@class='stock__search-container col-lg-9 order-lg-2']/div[@class='stock__content ng-tns-c1-0 ng-star-inserted']/div[@class='row ng-tns-c1-0 ng-trigger ng-trigger-vehicleList ng-star-inserted']/div[1]/app-card[1]/div[1]"))
                .isDisplayed();
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

    static String[] GetVHNumberOnPages(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='stock__pagination__information']")));
        String[] PageComp = driver.findElement(By.xpath("//p[@class='stock__pagination__information']")).getText().split(" ");
        return PageComp;

    }

    static String[] GetTotalPagesNumber(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='stock__pagination__information']")));
        String[] PageComp = driver.findElement(By.xpath("//p[@class='stock__pagination__information']")).getText().split(" ");
        return PageComp;

    }

    static String[] ClickOnPageNumber(WebDriver driver) {

        String[] changePage = new String[2];
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*//a[contains(text(),'3')]")));
        driver.findElement(By.xpath("//*//a[contains(text(),'3')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*//a[contains(text(),'3')]")));
        changePage[0] = driver.findElement(By.xpath("//*//a[contains(text(),'3')]")).getText();
        changePage[1] = driver.findElement(By.xpath("//a[contains(text(),'2')]")).getText();

        return changePage;

    }

    static boolean CTANextPageBackground(WebDriver driver) {

        return driver.findElement(By.xpath("//li[@class='page-item ng-star-inserted']//a[@class='page-link']")).isDisplayed();

    }

    static String CTANextPageText(WebDriver driver) {

        return driver.findElement(By.xpath("//span[contains(text(),'»')]")).getText();

    }

    static boolean CTAPreviousPageBackground(WebDriver driver) {

        return driver.findElement(By.xpath("//li[1]//a[1]")).isDisplayed();

    }

    static String CTAPreviousPageText(WebDriver driver) {

        return driver.findElement(By.xpath("//span[contains(text(),'«')]")).getText();

    }

    static boolean SortingMenu(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__sort__sorting stock__cursor-pointer']")).isDisplayed();

    }

    static int GetTheOffersNum(WebDriver driver) {
        Wait.Wait(2000);
        String OffersNumber[] = driver.findElement(By.xpath("//div[@class='stock__sort__results']")).getText().split(" ");
        String NbVH = OffersNumber[0];
        int NumberVh;

        if (OffersNumber.equals("")) {

            NumberVh = 1;
        } else {

            NumberVh = Integer.parseInt(NbVH);
        }

        return NumberVh;
    }

    static String[] TextFinitonsAboveList(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[9]/app-filter-select[1]/div[1]/p[1]/span[1]")));
        String[] TextAboveList = driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[9]/app-filter-select[1]/div[1]/p[1]/span[1]"))
                .getText().split(",");
        return TextAboveList;

    }

    static String[] TextModelsAboveList(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[1]/app-filter-select[1]/div[1]/p[1]/span[1]")));
        String[] TextAboveList = driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[1]/app-filter-select[1]/div[1]/p[1]/span[1]"))
                .getText().split(",");
        return TextAboveList;

    }

    static String[] TextEngineAboveList(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[8]/app-filter-select[1]/div[1]/p[1]/span[1]")));
        String[] TextAboveList = driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[2]/app-filter-bar[1]/div[1]/app-filters[1]/aside[1]/form[1]/fieldset[8]/app-filter-select[1]/div[1]/p[1]/span[1]"))
                .getText().split(",");
        return TextAboveList;

    }

    static String[] TextSortingAboveList(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='sort-label-desktop']")));
        String[] TextAboveList = driver.findElement(By.xpath("//span[@id='sort-label-desktop']")).getText().split(",");
        return TextAboveList;

    }

}
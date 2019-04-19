/*
 * Creation : 12 avr. 2019
 */
package peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Methodes.Wait;

public class ResultPageFilters {

    static String[] modelsList;
    static String[] enginelist;
    static String[] Finitionslist;
    static String[] Energylist;
    static String[] GearBoxlist;
    static String[] Colorslist;
    static String[] SortingList;

    static boolean SortingMenu(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__sort__sorting stock__cursor-pointer']")).isDisplayed();

    }

    static boolean SortingMenuIcone(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__selectBox stock__select-picto']//span[@class='stock__icon-arrow-bottom']"))
                .isDisplayed();

    }

    static String SortingMenuText(WebDriver driver) {

        return driver.findElement(By.id("sort-label-desktop")).getText();

    }

    static boolean SortingMenuList(WebDriver driver) {

        driver.findElement(By.id("sort-label-desktop")).click();
        return driver.findElement(By.xpath("//select[@class='stock__sort__sorting__choices ng-tns-c1-0 ng-star-inserted']")).isDisplayed();

    }

    static String[] SortingMenuListText(WebDriver driver) {

        ListManagement LM = new ListManagement();

        return LM.SplitGetListByClick(driver, "//div[@class='stock__selectBox stock__select-picto']//span[@class='stock__icon-arrow-bottom']",
                "//div[@class='stock__sort__sorting__choices ng-tns-c1-0 ng-star-inserted']");

    }

    static void SortingResults(WebDriver driver, int i) {

        new Select(driver.findElement(By.xpath("//div[@class='stock__sort__sorting__choices ng-tns-c1-0 ng-star-inserted']"))).selectByIndex(i);

    }

    static boolean ModelsMenu(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterFamily']")).isDisplayed();

    }

    static boolean ModelsMenuIcone(WebDriver driver) {

        return driver
                .findElement(
                        By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterFamily']//span[@class='stock__icon-arrow-bottom']"))
                .isDisplayed();

    }

    static String ModelsMenuTitleText(WebDriver driver) {

        return driver.findElement(By.xpath("//label[@id='filter-model-label']")).getText();

    }

    static String ModelsMenuTextAboveList(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='ng-tns-c5-1 ng-star-inserted']")).getText();

    }

    static boolean ModelsMenuList(WebDriver driver) {

        driver.findElement(
                By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterFamily']//span[@class='stock__icon-arrow-bottom']"))
                .click();
        return driver.findElement(By.xpath("//app-filter-select[@class='stock__filterFamily ng-tns-c5-1']//div[@id='checkboxesModel']"))
                .isDisplayed();

    }

    static String[] GetModelsList(WebDriver driver) {

        ListManagement LM = new ListManagement();

        return LM.SplitGetListByClick(driver,
                "//div[@class='stock__selectBox stock__select-picto stock__filterFamily']//span[@class='stock__icon-arrow-bottom']",
                "//div[@id='checkboxesModel']");

    }

    static void ClickOnListElement(WebDriver driver, String xpath) {

        driver.findElement(By.xpath(xpath)).click();

    }

    static void ClickonModels(WebDriver driver, int i) {

        new Select(driver.findElement(By.xpath("//app-filter-select[@class='stock__filterFamily ng-tns-c5-1']//div[@id='checkboxesModel']")))
                .selectByIndex(i);

    }

    static boolean EngineMenu(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterEngine']")).isDisplayed();

    }

    static boolean EngineMenuIcone(WebDriver driver) {

        return driver
                .findElement(
                        By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterEngine']//span[@class='stock__icon-arrow-bottom']"))
                .isDisplayed();

    }

    static String EngineMenuTitleText(WebDriver driver) {

        return driver.findElement(By.xpath("//label[@id='filter-engine-label']")).getText();

    }

    static String EngineMenuTextAboveList(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='ng-tns-c5-2 ng-star-inserted']")).getText();

    }

    static boolean EngineMenuList(WebDriver driver) {

        driver.findElement(
                By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterEngine']//span[@class='stock__icon-arrow-bottom']"))
                .click();
        return driver.findElement(By.xpath("//app-filter-select[@class='stock__filterEngine ng-tns-c5-2']//div[@id='checkboxesModel']"))
                .isDisplayed();

    }

    static String[] GetEngineList(WebDriver driver) {

        ListManagement LM = new ListManagement();

        return LM.SplitGetListByClick(driver, "//span[@class='ng-tns-c5-2 ng-star-inserted']",
                "//app-filter-select[@class='stock__filterEngine ng-tns-c5-2']//div[@id='checkboxesModel']");

    }

    static void ClickOnEngines(WebDriver driver, int i) {

        new Select(driver.findElement(By.xpath("//app-filter-select[@class='stock__filterEngine ng-tns-c5-2']//div[@id='checkboxesModel']")))
                .selectByIndex(i);

    }

    static boolean FinitionsMenu(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterTrim']")).isDisplayed();

    }

    static boolean FinitionsMenuIcone(WebDriver driver) {

        return driver
                .findElement(
                        By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterTrim']//span[@class='stock__icon-arrow-bottom']"))
                .isDisplayed();

    }

    static String FinitionsMenuTitleText(WebDriver driver) {

        return driver.findElement(By.id("filter-trim-label")).getText();

    }

    static String FinitionsMenuTextAboveList(WebDriver driver) {

        return driver.findElement(By.xpath("//span[@class='ng-tns-c5-3 ng-star-inserted']")).getText();

    }

    static boolean FinitionsMenuList(WebDriver driver) {

        driver.findElement(
                By.xpath("//div[@class='stock__selectBox stock__select-picto stock__filterEngine']//span[@class='stock__icon-arrow-bottom']"))
                .click();
        Wait.Wait(2000);
        return driver.findElement(By.xpath("//app-filter-select[@class='stock__filterTrim ng-tns-c5-3']//div[@id='checkboxesModel']")).isDisplayed();

    }

    static String[] GetFinitionsList(WebDriver driver) {

        ListManagement LM = new ListManagement();

        return LM.SplitGetListByClick(driver, "//span[@class='ng-tns-c5-3 ng-star-inserted']",
                "//app-filter-select[@class='stock__filterTrim ng-tns-c5-3']//div[@id='checkboxesModel']");

    }

    static void ClickOnFinitions(WebDriver driver, int i) {

        new Select(driver.findElement(By.xpath("//app-filter-select[@class='stock__filterTrim ng-tns-c5-3']//div[@id='checkboxesModel']")))
                .selectByIndex(i);

    }

    static boolean LocationMenu(WebDriver driver) {

        return driver.findElement(By.id("filter-localisation-area")).isDisplayed();

    }

    static String LocationTextAbove(WebDriver driver) {

        return driver.findElement(By.xpath("//app-filter-localization[@class='stock__filterLocalization']")).getText();

    }

    static void EnterTheLocation(WebDriver driver, String Loc) {
        WebElement Loca = driver.findElement(By.xpath("//input[@id='filter-localisation-area']"));
        Wait.Wait(2000);
        Loca.sendKeys(Loc);
        Wait.Wait(2000);
        Loca.sendKeys(Keys.ARROW_DOWN);
        Loca.sendKeys(Keys.ENTER);
    }

    static String RadiusTextAbove(WebDriver driver) {

        return driver.findElement(By.id("filter-localisationArea-label")).getText();

    }

    static boolean RadiusSlider(WebDriver driver) {

        return driver.findElement(By.xpath("//ng5-slider[@class='stock__filterSliderLocalization ng5-slider']//span[3]")).isDisplayed();

    }

    static boolean RadiusSliderCursor(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//ng5-slider[@class='stock__filterSliderLocalization ng5-slider']//span[@class='ng5-slider-span ng5-slider-pointer ng5-slider-pointer-min']"))
                .isDisplayed();

    }

    static String RadiusDistanceMinText(WebDriver driver) {

        return driver.findElement(By.className("ng5-slider-span ng5-slider-bubble ng5-slider-limit ng5-slider-floor")).getText();

    }

    static String RadiusDistanceMaxText(WebDriver driver) {

        return driver.findElement(By.className("ng5-slider-span ng5-slider-bubble ng5-slider-limit ng5-slider-ceil")).getText();

    }

    static String RadiusCurrentDistanceText(WebDriver driver) {

        return driver.findElement(By.className("ng5-slider-span ng5-slider-bubble ng5-slider-model-value")).getText();

    }

    static String PriceTextAbove(WebDriver driver) {

        return driver.findElement(By.id("filter-price-label")).getText();

    }

    static boolean PriceSliderBar(WebDriver driver) {

        return driver
                .findElement(By.xpath(
                        "//ng5-slider[@class='stock__filterPrice ng5-slider']//span[@class='ng5-slider-span ng5-slider-bar ng5-slider-selection']"))
                .isDisplayed();

    }

    static boolean PriceSliderCursorMin(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//ng5-slider[@class='stock__filterPrice ng5-slider']//span[@class='ng5-slider-span ng5-slider-pointer ng5-slider-pointer-min']"))
                .isDisplayed();

    }

    static boolean PriceSliderCursorMax(WebDriver driver) {

        return driver.findElement(By.xpath(
                "//ng5-slider[@class='stock__filterPrice ng5-slider']//span[@class='ng5-slider-span ng5-slider-pointer ng5-slider-pointer-max']"))
                .isDisplayed();

    }

    static String PriceMinText(WebDriver driver) {

        return driver.findElement(By.className("ng5-slider-span ng5-slider-bubble ng5-slider-limit ng5-slider-floor")).getText();

    }

    static String PriceMaxText(WebDriver driver) {

        return driver.findElement(By.className("ng5-slider-span ng5-slider-bubble ng5-slider-limit ng5-slider-ceil")).getText();

    }

    static String PriceSortedMinText(WebDriver driver) {

        return driver.findElement(By.className("ng5-slider-span ng5-slider-bubble ng5-slider-model-value")).getText();

    }

    static String PriceSortedMaxText(WebDriver driver) {

        return driver.findElement(By.className("ng5-slider-span ng5-slider-bubble ng5-slider-model-high")).getText();

    }

    static String EnergyMenuTextAboveList(WebDriver driver) {

        return driver.findElement(By.id("filter-energy-label")).getText();

    }

    static String[] GetEnergyList(WebDriver driver) {

        ListManagement LM = new ListManagement();

        return LM.SplitGetFieldList(driver, "//body//fieldset[5]");

    }

    static void ClickOnEnergy(WebDriver driver, int i) {

        new Select(driver.findElement(By.xpath("//body//fieldset[5]"))).selectByIndex(i);

    }

    static String GearBoxMenuTextAboveList(WebDriver driver) {

        return driver.findElement(By.id("filter-gearbox-label")).getText();

    }

    static String[] GetGearBoxList(WebDriver driver) {

        ListManagement LM = new ListManagement();

        return LM.SplitGetFieldList(driver, "//body//fieldset[6]");

    }

    static void ClickOnGearBox(WebDriver driver, int i) {

        new Select(driver.findElement(By.xpath("//body//fieldset[6]"))).selectByIndex(i);

    }

    static String ColorMenuTextAboveList(WebDriver driver) {

        return driver.findElement(By.id("filter-color-label")).getText();

    }

    static String[] GetColorsList(WebDriver driver) {

        ListManagement LM = new ListManagement();

        return LM.SplitGetFieldList(driver, "//body//fieldset[7]");

    }

    static void ClickOnColors(WebDriver driver, int i) {

        new Select(driver.findElement(By.xpath("//body//fieldset[7]"))).selectByIndex(i);

    }

}

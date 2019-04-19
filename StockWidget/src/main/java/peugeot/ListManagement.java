/*
 * Creation : 17 avr. 2019
 */
package peugeot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Methodes.Wait;

public class ListManagement {

    static String[] refineList;
    static String[] ModelsList;

    static String[] GetListByClick(WebDriver driver, String XpathClick, String XpathList)

    {
        Wait.Wait(4000);
        driver.findElement(By.xpath(XpathClick)).click();
        Wait.Wait(2000);

        List<WebElement> List = driver.findElements(By.xpath(XpathList));
        System.out.println("the Modelslist size is:  " + List.size());
        refineList = new String[List.size()];
        for (int i = 0; i < List.size(); ++i) {
            refineList[i] = List.get(i).getText();

        }

        System.out.println("the First model is:  " + refineList[0]);
        return refineList;
    }

    static String[] GetList(WebDriver driver, String XpathList)

    {
        Wait.Wait(2000);

        List<WebElement> List = driver.findElements(By.xpath(XpathList));

        ModelsList = new String[List.size()];
        for (int i = 0; i < List.size(); ++i) {
            ModelsList[i] = List.get(i).getText();

        }
        return ModelsList;
    }

    static String[] SplitGetListByClick(WebDriver driver, String XpathClick, String XpathList)

    {
        Wait.Wait(4000);
        driver.findElement(By.xpath(XpathClick)).click();
        Wait.Wait(2000);

        List<WebElement> List = driver.findElements(By.xpath(XpathList));
        // int i = 0;
        // for (WebElement element : List) {

        // System.out.println("000000" + i + "000000" + element.getText());
        // i++;
        // }

        refineList = List.get(0).getText().split("\\n");

        return refineList;
    }

    static String[] SplitGetFieldList(WebDriver driver, String XpathList)

    {

        List<WebElement> List = driver.findElements(By.xpath(XpathList));

        refineList = List.get(0).getText().split("\\n");

        return refineList;
    }

    static String[] SplitGetListNoClick(WebDriver driver, String XpathList)

    {
        Wait.Wait(2000);

        List<WebElement> List = driver.findElements(By.xpath(XpathList));

        refineList = List.get(0).getText().split("\\\\r?\\\\n");

        return refineList;
    }

    static String[] SplitGetFieldSetByClick(WebDriver driver, String XpathClick, String XpathList)

    {
        Wait.Wait(4000);
        driver.findElement(By.xpath(XpathClick)).click();
        Wait.Wait(2000);

        List<WebElement> List = driver.findElements(By.xpath(XpathList));

        System.out.println("uhfuihfiuhfihfihfiuhifhfihfihfihfi " + List.size());
        refineList = List.get(0).getText().split("\\n");

        return refineList;
    }

}

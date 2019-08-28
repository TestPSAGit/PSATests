/*
 * Creation : 15 avr. 2019
 */
package Methodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static void Wait(int Dur) {
        try {
            Thread.sleep(Dur);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    public static void WaitForElementToBeVisible(WebDriver driver, String Xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

    }

}

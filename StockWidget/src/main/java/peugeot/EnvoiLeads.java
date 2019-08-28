/*
 * Creation : 17 mai 2019
 */
package peugeot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import Methodes.Wait;

public class EnvoiLeads {

    static WebDriver driver;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;
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

    public void AccesForm(WebDriver driver) {

        Wait.Wait(2000);

        String parentwindow = driver.getWindowHandle();

        pp.CTAContactConseillerSelect(driver);
        Wait.Wait(2000);

        Set<String> handles = driver.getWindowHandles(); // get all window handles

        for (String formulaire : handles) {
            driver.switchTo().window(formulaire);
            Wait.Wait(2000);

        }
    }

    public void ChampTitulo(WebDriver driver) {

        Wait.Wait(2000);
        AccesForm(driver);

        driver.findElement(By.xpath("//span[contains(@class,'sb-select')]//input")).click();
        Wait.Wait(2000);
        driver.findElement(By.xpath("//ngb-modal-window[contains(@class,'modal fade show d-block popin_window_class')]//li[1]")).click();

    }

    public void ChampTituloMobileAP(WebDriver driver) {

        Wait.Wait(2000);
        AccesForm(driver);

        driver.findElement(By.xpath("//select[@id='FILD100000001099']")).click();
        Wait.Wait(2000);
        driver.findElement(By.xpath("//option[contains(text(),'Sr.')]")).click();

    }

    public void ChampTituloMobileAC(WebDriver driver) {

        Wait.Wait(3000);
        AccesForm(driver);

        if (driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]")).isDisplayed()) {

            Wait.WaitForElementToBeVisible(driver, "//*[@id=\"FILD100000000977\"]");
            driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]")).click();
            Wait.WaitForElementToBeVisible(driver, "//*[@id=\"FILD100000000977\"]/option[2]");
            driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]/option[2]")).click();

        } else {
            Wait.WaitForElementToBeVisible(driver, "//*[@id=\\\"FILD100000000977\\\"]/div/span[1]/span/span/label");
            driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]/div/span[1]/span/span/label")).click();

        }

        /*
         * if (driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]/div/span[1]/span/span/label")).isDisplayed()) {
         * 
         * driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]/div/span[1]/span/span/label")).click();
         * 
         * Wait.Wait(3000); } else { System.out.println("TESTTTTTTTTT"); Wait.WaitForElementToBeVisible(driver, "//*[@id=\"FILD100000000977\"]");
         * System.out.println("-------------22222-----------"); driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]")).click();
         * Wait.WaitForElementToBeVisible(driver, "//*[@id=\"FILD100000000977\"]/option[2]");
         * driver.findElement(By.xpath("//*[@id=\"FILD100000000977\"]/option[2]")).click();
         * 
         * }
         */
    }

    public String SendLeadAC(WebDriver driver) {

        ChampTitulo(driver);
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001045']")).sendKeys("TEST");// send nom de famille
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001048']")).sendKeys("TEST");// send prénom
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001043']")).sendKeys("PSAtest@yopmail.fr");// send email
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD200000000106']")).sendKeys("061212121");// send num tel
        Wait.Wait(1000);
        // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys("TEST");// send comm
        Wait.Wait(1000);
        driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001010']")).click();

        Wait.Wait(4000);
        return driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).getText();

    }

    public int SendLeadACMultiple(WebDriver driver) throws IOException {

        String Filepath = "C:\\Users\\e550004\\Desktop\\SOLSTOCK\\JDD LEADS.xlsx";

        FileInputStream fl = new FileInputStream(Filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fl);
        XSSFSheet sheet = workbook.getSheetAt(0);

        /*
         * Wait.Wait(1000); System.out.println(sheet.getLastRowNum()); Wait.Wait(1000);
         * 
         * for (int i = 10; i <= sheet.getLastRowNum(); i++) {
         * 
         * cell = sheet.getRow(i).getCell(0); Wait.Wait(1000); driver.get(cell.getStringCellValue()); Wait.Wait(2000);
         */
        int Error = 0;
        for (int j = 1; j <= 5; j++) {

            ChampTitulo(driver);
            Wait.Wait(1000);
            // send nom de famille
            cell = sheet.getRow(j).getCell(0);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001045']");
            driver.findElement(By.xpath("//input[@id='FILD100000001045']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001045']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send prénom
            cell = sheet.getRow(j).getCell(1);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001048']");
            driver.findElement(By.xpath("//input[@id='FILD100000001048']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001048']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send email
            cell = sheet.getRow(j).getCell(2);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001043']");
            driver.findElement(By.xpath("//input[@id='FILD100000001043']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001043']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send num tel
            cell = sheet.getRow(j).getCell(3);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD200000000106']");
            driver.findElement(By.xpath("//input[@id='FILD200000000106']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD200000000106']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send comm //
            // cell = sheet.getRow(j).getCell(4); // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).clear(); //
            // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys(cell.getStringCellValue()); // Wait.Wait(1000);
            // Wait.WaitForElementToBeVisible(driver, "//label[@class='wf_box_check']");
            // driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();

            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001010']");
            Wait.Wait(3000);
            driver.findElement(By.xpath("//input[@id='FILD100000001010']")).click();
            Wait.Wait(3000);
            try {

                Wait.Wait(2000);
                if (driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).isDisplayed()) {
                    System.out.println("--------Test " + j + " OK-----------");
                } else {
                    Error = Error++;
                    System.out.println();
                }
            } catch (Exception exception) {
                Wait.Wait(2000);
                System.err.println("Pas de bouton, assertion sera ko");
            }
            Wait.WaitForElementToBeVisible(driver,
                    "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-thank-you[1]/div[1]/div[2]/div[2]/div[1]/button[1]");
            driver.findElement(By.xpath(
                    "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-thank-you[1]/div[1]/div[2]/div[2]/div[1]/button[1]"))
                    .click();

        }
        return Error;

    }

    public int SendLeadAPMultiple(WebDriver driver) throws IOException {

        String Filepath = "C:\\Users\\e550004\\Desktop\\SOLSTOCK\\JDD LEADS.xlsx";

        FileInputStream fl = new FileInputStream(Filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fl);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int Error = 0;
        for (int j = 1; j <= 5; j++) {

            ChampTitulo(driver);
            Wait.Wait(1000);
            // send nom de famille
            cell = sheet.getRow(j).getCell(0);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001167']");
            driver.findElement(By.xpath("//input[@id='FILD100000001167']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001167']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send prénom
            cell = sheet.getRow(j).getCell(1);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001170']");
            driver.findElement(By.xpath("//input[@id='FILD100000001170']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001170']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send email
            cell = sheet.getRow(j).getCell(2);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001165']");
            driver.findElement(By.xpath("//input[@id='FILD100000001165']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001165']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send num tel
            cell = sheet.getRow(j).getCell(4);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD200000000087']");
            driver.findElement(By.xpath("//input[@id='FILD200000000087']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD200000000087']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send comm //
            cell = sheet.getRow(j).getCell(5); // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).clear(); //
            driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys(cell.getStringCellValue()); // Wait.Wait(1000);
            Wait.WaitForElementToBeVisible(driver, "//label[@class='wf_box_check']");
            driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();

            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000900418']");
            Wait.Wait(3000);
            driver.findElement(By.xpath("//input[@id='FILD100000900418']")).click();
            Wait.Wait(3000);
            try {

                Wait.Wait(2000);
                if (driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).isDisplayed()) {
                    System.out.println("--------Test " + j + " OK-----------");
                } else {
                    Error = Error++;
                    System.out.println();
                }
            } catch (Exception exception) {
                Wait.Wait(2000);
                System.err.println("Pas de bouton, assertion sera ko");
            }
            Wait.WaitForElementToBeVisible(driver, "//button[@id='btn-closeThankYouPage']");
            driver.findElement(By.xpath("//button[@id='btn-closeThankYouPage']")).click();

        }
        return Error;

    }

    public int SendLeadDSMultiple(WebDriver driver) throws IOException {

        String Filepath = "C:\\Users\\e550004\\Desktop\\SOLSTOCK\\JDD LEADS.xlsx";

        FileInputStream fl = new FileInputStream(Filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fl);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int Error = 0;
        for (int j = 1; j <= 5; j++) {

            ChampTitulo(driver);
            Wait.Wait(1000);
            // send nom de famille
            cell = sheet.getRow(j).getCell(0);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001167']");
            driver.findElement(By.xpath("//input[@id='FILD100000001045']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001045']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send prénom
            cell = sheet.getRow(j).getCell(1);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001170']");
            driver.findElement(By.xpath("//input[@id='FILD100000001048']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001048']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send email
            cell = sheet.getRow(j).getCell(2);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001165']");
            driver.findElement(By.xpath("//input[@id='FILD100000001043']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001043']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send num tel
            cell = sheet.getRow(j).getCell(4);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD200000000087']");
            driver.findElement(By.xpath("//input[@id='FILD200000000106']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD200000000106']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send comm //
            cell = sheet.getRow(j).getCell(5); // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).clear(); //
            driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys(cell.getStringCellValue()); // Wait.Wait(1000);
            Wait.WaitForElementToBeVisible(driver, "//label[@class='wf_box_check']");
            driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();

            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000900418']");
            Wait.Wait(3000);
            driver.findElement(By.xpath("//input[@id='FILD100000900418']")).click();
            Wait.Wait(3000);
            try {

                Wait.Wait(2000);
                if (driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).isDisplayed()) {
                    System.out.println("--------Test " + j + " OK-----------");
                } else {
                    Error = Error++;
                    System.out.println();
                }
            } catch (Exception exception) {
                Wait.Wait(2000);
                System.err.println("Pas de bouton, assertion sera ko");
            }
            Wait.WaitForElementToBeVisible(driver, "//button[@id='btn-closeThankYouPage']");
            driver.findElement(By.xpath("//button[@id='btn-closeThankYouPage']")).click();

        }
        return Error;

    }

    public String SendLeadAP(WebDriver driver) {

        ChampTitulo(driver);
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001167']")).sendKeys("TEST");// send nom de famille
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001170']")).sendKeys("TEST");// send prénom
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD100000001165']")).sendKeys("PSAtest@yopmail.fr");// send email
        Wait.Wait(1000);
        driver.findElement(By.xpath("//input[@id='FILD200000000087']")).sendKeys("061212121");// send num tel
        Wait.Wait(1000);
        driver.findElement(By.xpath("//textarea[@id='FILD100000900639']//textarea[@id='FILD100000900639']")).sendKeys("TEST");// send comm
        Wait.Wait(1000);
        driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();
        Wait.Wait(1000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-contact-form[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/fieldset[3]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]/input[1]"))
                .click();

        Wait.Wait(4000);
        return driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).getText();

    }

    public String SendLeadDS(WebDriver driver) {

        ChampTitulo(driver);
        Wait.Wait(1000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-contact-form[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[2]/input[1]"))
                .sendKeys("TEST");// send nom de famille
        Wait.Wait(1000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-contact-form[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[3]/div[1]/div[1]/span[2]/input[1]"))
                .sendKeys("TEST");// send prénom
        Wait.Wait(1000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-contact-form[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[2]/input[1]"))
                .sendKeys("PSAtest@yopmail.fr");// send email
        Wait.Wait(1000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-contact-form[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/div[1]/span[2]/input[1]"))
                .sendKeys("061212121");// send num tel
        Wait.Wait(1000);
        // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys("TEST");// send comm
        Wait.Wait(1000);
        driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();
        Wait.Wait(1000);
        driver.findElement(By.xpath(
                "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/ngb-modal-window[1]/div[1]/div[1]/app-contact-form[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/fieldset[3]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]/input[1]"))
                .click();

        Wait.Wait(4000);
        return driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).getText();

    }

    public int SendLeadACMultipleMobile(WebDriver driver) throws IOException {

        String Filepath = "C:\\Users\\e550004\\Desktop\\SOLSTOCK\\JDD LEADS.xlsx";

        FileInputStream fl = new FileInputStream(Filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fl);
        XSSFSheet sheet = workbook.getSheetAt(0);

        /*
         * Wait.Wait(1000); System.out.println(sheet.getLastRowNum()); Wait.Wait(1000);
         * 
         * for (int i = 10; i <= sheet.getLastRowNum(); i++) {
         * 
         * cell = sheet.getRow(i).getCell(0); Wait.Wait(1000); driver.get(cell.getStringCellValue()); Wait.Wait(2000);
         */
        int Error = 0;
        for (int j = 1; j <= 5; j++) {

            ChampTituloMobileAC(driver);
            Wait.Wait(1000);
            // send nom de famille
            cell = sheet.getRow(j).getCell(0);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='txtLastname']");
            driver.findElement(By.xpath("//input[@id='txtLastname']")).clear();
            driver.findElement(By.xpath("//input[@id='txtLastname']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send prénom
            cell = sheet.getRow(j).getCell(1);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='txtFirstname']");
            driver.findElement(By.xpath("//input[@id='txtFirstname']")).clear();
            driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send email
            cell = sheet.getRow(j).getCell(2);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='txtEmail']");
            driver.findElement(By.xpath("//input[@id='txtEmail']")).clear();
            driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send num tel
            cell = sheet.getRow(j).getCell(3);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='txtPhone']");
            driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
            driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send comm //
            // cell = sheet.getRow(j).getCell(4); // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).clear(); //
            // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys(cell.getStringCellValue()); // Wait.Wait(1000);
            Wait.WaitForElementToBeVisible(driver, "//p[9]//label[1]//span[1]");
            driver.findElement(By.xpath("//p[9]//label[1]//span[1]")).click();

            Wait.WaitForElementToBeVisible(driver, "//span[@class='inner-button']");
            Wait.Wait(3000);
            driver.findElement(By.xpath("//span[@class='inner-button']")).click();
            Wait.Wait(3000);
            try {

                Wait.Wait(2000);
                if (driver.findElement(By.xpath(
                        "//*[@id=\"stock-widget-container\"]/stock-widget-app/div/ngb-modal-window/div/div/app-thank-you/div/div[2]/div[1]/div[1]/p"))
                        .isDisplayed()) {
                    System.out.println("--------Test " + j + " OK-----------");
                } else {
                    Error = Error++;
                    System.out.println();
                }
            } catch (Exception exception) {
                Wait.Wait(2000);
                System.err.println("Pas de bouton, assertion sera ko");
            }
            Wait.WaitForElementToBeVisible(driver, "//*[@id=\"btn-closeThankYouPage\"]");
            driver.findElement(By.xpath("//*[@id=\"btn-closeThankYouPage\"]")).click();

        }
        return Error;

    }

    public int SendLeadAPMultipleMobile(WebDriver driver) throws IOException {

        String Filepath = "C:\\Users\\e550004\\Desktop\\SOLSTOCK\\JDD LEADS.xlsx";

        FileInputStream fl = new FileInputStream(Filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fl);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int Error = 0;
        for (int j = 1; j <= 5; j++) {

            ChampTituloMobileAP(driver);
            Wait.Wait(1000);
            // send nom de famille
            cell = sheet.getRow(j).getCell(0);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001167']");
            driver.findElement(By.xpath("//input[@id='FILD100000001167']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001167']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send prénom
            cell = sheet.getRow(j).getCell(1);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001170']");
            driver.findElement(By.xpath("//input[@id='FILD100000001170']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001170']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send email
            cell = sheet.getRow(j).getCell(2);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001165']");
            driver.findElement(By.xpath("//input[@id='FILD100000001165']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001165']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send num tel
            cell = sheet.getRow(j).getCell(4);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD200000000087']");
            driver.findElement(By.xpath("//input[@id='FILD200000000087']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD200000000087']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send comm //
            cell = sheet.getRow(j).getCell(5); // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).clear(); //
            driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys(cell.getStringCellValue()); // Wait.Wait(1000);
            Wait.WaitForElementToBeVisible(driver, "//label[@class='wf_box_check']");
            driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();

            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000900418']");
            Wait.Wait(3000);
            driver.findElement(By.xpath("//input[@id='FILD100000900418']")).click();
            Wait.Wait(3000);
            try {

                Wait.Wait(2000);
                if (driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).isDisplayed()) {
                    System.out.println("--------Test " + j + " OK-----------");
                } else {
                    Error = Error++;
                    System.out.println();
                }
            } catch (Exception exception) {
                Wait.Wait(2000);
                System.err.println("Pas de bouton, assertion sera ko");
            }
            Wait.WaitForElementToBeVisible(driver, "//button[@id='btn-closeThankYouPage']");
            driver.findElement(By.xpath("//button[@id='btn-closeThankYouPage']")).click();

        }
        return Error;

    }

    public int SendLeadDSMultipleMobile(WebDriver driver) throws IOException {

        String Filepath = "C:\\Users\\e550004\\Desktop\\SOLSTOCK\\JDD LEADS.xlsx";

        FileInputStream fl = new FileInputStream(Filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fl);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int Error = 0;
        for (int j = 1; j <= 5; j++) {

            ChampTitulo(driver);
            Wait.Wait(1000);
            // send nom de famille
            cell = sheet.getRow(j).getCell(0);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001167']");
            driver.findElement(By.xpath("//input[@id='FILD100000001045']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001045']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send prénom
            cell = sheet.getRow(j).getCell(1);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001170']");
            driver.findElement(By.xpath("//input[@id='FILD100000001048']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001048']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send email
            cell = sheet.getRow(j).getCell(2);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000001165']");
            driver.findElement(By.xpath("//input[@id='FILD100000001043']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD100000001043']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send num tel
            cell = sheet.getRow(j).getCell(4);
            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD200000000087']");
            driver.findElement(By.xpath("//input[@id='FILD200000000106']")).clear();
            driver.findElement(By.xpath("//input[@id='FILD200000000106']")).sendKeys(cell.getStringCellValue());
            Wait.Wait(1000);
            // send comm //
            cell = sheet.getRow(j).getCell(5); // driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).clear(); //
            driver.findElement(By.xpath("//textarea[@id='FILD100000900639']")).sendKeys(cell.getStringCellValue()); // Wait.Wait(1000);
            Wait.WaitForElementToBeVisible(driver, "//label[@class='wf_box_check']");
            driver.findElement(By.xpath("//label[@class='wf_box_check']")).click();

            Wait.WaitForElementToBeVisible(driver, "//input[@id='FILD100000900418']");
            Wait.Wait(3000);
            driver.findElement(By.xpath("//input[@id='FILD100000900418']")).click();
            Wait.Wait(3000);
            try {

                Wait.Wait(2000);
                if (driver.findElement(By.xpath("//p[contains(text(),'Message envoyé !')]")).isDisplayed()) {
                    System.out.println("--------Test " + j + " OK-----------");
                } else {
                    Error = Error++;
                    System.out.println();
                }
            } catch (Exception exception) {
                Wait.Wait(2000);
                System.err.println("Pas de bouton, assertion sera ko");
            }
            Wait.WaitForElementToBeVisible(driver, "//button[@id='btn-closeThankYouPage']");
            driver.findElement(By.xpath("//button[@id='btn-closeThankYouPage']")).click();

        }
        return Error;

    }

}

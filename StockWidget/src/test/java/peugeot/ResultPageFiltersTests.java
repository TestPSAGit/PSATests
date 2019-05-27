/*
 * Creation : 15 avr. 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methodes.Wait;

public class ResultPageFiltersTests {

    static WebDriver driver;
    ResultPageFilters fp = new ResultPageFilters();
    ResultPageCompo rp = new ResultPageCompo();

    @BeforeMethod
    public void BeforeMethod() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://prod-widget.stockengine.awsmpsa.com/demo/#/?geodistance=25;41.1579438;-8.629105299999992;Porto&budget=12476;60577");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // driver.findElement(By.className("psac_noselect")).click();

    }

    @AfterMethod
    public void AfterMethod() {
        driver.close();

    }

    @Test
    public void TestSortingMenu() {// check le menu sorting est present
        Wait.Wait(2000);
        assert (fp.SortingMenu(driver) == true);
    }

    @Test
    public void TestSortingMenuIcon() {// check l'icone du menu sorting est present
        Wait.Wait(2000);
        assert (fp.SortingMenuIcone(driver) == true);
    }

    @Test
    public void TestSortingMenuText() {// check le texte du menu sorting est present
        Wait.Wait(2000);
        assert (fp.SortingMenuText(driver).equals("Trier les résultats"));
    }

    @Test
    public void TestSortingMenuListDisplayed() {// check que la liste du menu sorting est présente
        Wait.Wait(2000);
        assert (fp.SortingMenuList(driver) == true);
    }

    @Test
    public void TestSortingMenuListWithoutLocalisation() {
        Wait.Wait(2000);
        driver.get("https://prod-widget.stockengine.awsmpsa.com/demo/#/?budget=12476;60577");
        Wait.Wait(1000);
        boolean exist = false;

        int Error = 0;

        String[] Sortingliste = fp.SortingMenuListText(driver);
        for (int i = 1; i < Sortingliste.length; i++) {

            fp.ClickOnListElement(driver, "//span[@id='sort-price']");
            Wait.Wait(2000);

            String[] ListAbove = rp.TextSortingAboveList(driver);

            if (ListAbove[i - 1].contains(Sortingliste[i])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + Sortingliste[i] + "0000000");

            }

        }
        assert (Error == 0);

    }

    @Test
    public void TestSortingMenuListWithLocalisation() {// check qu'on récup les valeurs de la sorting menu list
        Wait.Wait(2000);
        boolean exist = false;
        fp.EnterTheLocation(driver, "Porto");
        Wait.Wait(3000);
        int Error = 0;
        String[] Sortingliste = fp.SortingMenuListText(driver);
        Wait.Wait(1000);
        System.out.println(Sortingliste.length);
        for (int i = 1; i < Sortingliste.length; i++) {

            // System.out.println(Sortingliste[i]);
            // System.out.println(Sortingliste[i - 1]);

            fp.ClickOnListElement(driver,
                    "/html[1]/body[1]/div[1]/stock-widget-app[1]/div[1]/app-search-container[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]/span[2]");//
            Wait.Wait(2000);

            String[] ListAbove = rp.TextSortingAboveList(driver);

            if (Sortingliste[i].contains("Par proximité")) {

                exist = true;

            }

            else if (ListAbove[i].contains(Sortingliste[i])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i] + "OOOOOOO" + Sortingliste[i] + "0000000");

            }

        }
        assert (exist == true);
    }

    @Test
    public void TestDisplayedModelsList() {// check le menu modèle est present
        Wait.Wait(2000);
        assert (fp.ModelsMenu(driver) == true);
    }

    @Test
    public void TestModelsMenuIcon() {// check l'icone du menu modeles est present
        Wait.Wait(2000);
        assert (fp.ModelsMenuIcone(driver) == true);
    }

    @Test
    public void TestModelsMenuText() {// check le titre (au dessus de la liste) du menu modeles est present
        Wait.Wait(2000);
        assert (fp.ModelsMenuTitleText(driver).equals("Modèle"));

    }

    @Test
    public void TestModelsListSimilarJDD() {// Vérifier la conformité de la liste des modeles, avec le JDD
        Wait.Wait(2000);
        boolean exist = false;
        String[] ModelList = fp.GetModelsList(driver);
        String[] espectedModels = new String[] { "108", "2008", "208", "3008", "308", "5008", "Boxer Combi", "Novo 508", "Partner Tepee", "Rifter",
                "Traveller" };
        for (int i = 0; i < ModelList.length; i++) {

            if (ModelList[i].contains(espectedModels[i])) {

                exist = true;

            }

        }
        assert (exist == true);
    }

    @Test
    public void TestModelsListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;

        String[] ModelList = fp.GetModelsList(driver);
        for (int i = 1; i < ModelList.length; i++) {

            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);
            String[] ListAbove = rp.TextModelsAboveList(driver);

            if (NbVh[i + 1] < NbVh[i]) {

                Error++;
                System.err.println(ModelList[i]);
            } else if (ListAbove[i - 1].contains(ModelList[i - 1])) {// les noms de modèles sélectionnés apparaissent bien au dessus de la liste

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + ModelList[i - 1] + "0000000");

            }

        }
        assert (Error == 0);

    }

    @Test
    public void TestDisplayedEngineList() {// check le menu engine est present
        Wait.Wait(2000);
        assert (fp.EngineMenu(driver) == true);
    }

    @Test
    public void TestEngineMenuIcon() {// check l'icone du menu engine est present
        Wait.Wait(2000);
        assert (fp.EngineMenuIcone(driver) == true);
    }

    @Test
    public void TestEngineMenuText() {// check le titre (au dessus de la liste) du menu engine est present
        Wait.Wait(2000);
        assert (fp.EngineMenuTitleText(driver).equals("Moteur"));

    }

    @Test
    public void TestEngineListNumberVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;

        String[] EngineList = fp.GetEngineList(driver);
        for (int i = 1; i < EngineList.length; i++) {

            fp.ClickOnListElement(driver, "//span[contains(text(),'" + EngineList[i] + "')]");
            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);
            String[] ListAbove = rp.TextEngineAboveList(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(EngineList[i]);
            } else if (ListAbove[i - 1].contains(EngineList[i])) {

                System.out.println("GOOD");

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + EngineList[i] + "0000000");

            }

        }
        assert (Error == 0);

    }

    @Test
    public void TestEnergyMenuText() {// check le titre (au dessus de la liste) de la liste Energy est present
        Wait.Wait(2000);
        assert (fp.EnergyMenuTextAboveList(driver).contains("Energie"));
    }

    @Test
    public void TestEnergyListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] EnergyList = fp.GetEnergyList(driver);

        for (int i = 1; i < EnergyList.length; i++) {

            fp.ClickOnListElement(driver, "//fieldset[5]//app-filter-choice[" + i + "]//label[1]//span[2]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(EnergyList[i]);
            }

        }
        assert (Error == 0);
    }

    @Test
    public void TestGearboxMenuText() {// check le titre (au dessus de la liste) du menu Gearbox est present
        Wait.Wait(2000);
        assert (fp.GearBoxMenuTextAboveList(driver).equals("Boîte vitesse"));

    }

    @Test
    public void TestGearBoxesListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] GearboxesList = fp.GetGearBoxList(driver);

        for (int i = 1; i < GearboxesList.length; i++) {

            fp.ClickOnListElement(driver, "//fieldset[6]//app-filter-choice[" + i + "]//label[1]//span[2]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(GearboxesList[i]);
            }

        }
        assert (Error == 0);
    }

    @Test
    public void TestFinitionMenuTitle() {// check le titre (au dessus de la liste) du menu Finition est present
        Wait.Wait(2000);
        assert (fp.FinitionsMenuTextAboveList(driver).equals("Finition"));

    }

    @Test
    public void TestFinitionMenuText() {// check que le texte dans le menu Finition est present
        Wait.Wait(2000);
        assert (fp.FinitionsMenuTitleText(driver).equals("Choisissez une finition"));

    }

    @Test
    public void TestFinitionListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;

        String[] FinitionList = fp.GetFinitionsList(driver);
        for (int i = 1; i < FinitionList.length; i++) {

            fp.ClickOnListElement(driver,
                    "//fieldset[@class='form-group stock__form-check fieldset']//app-filter-choice[" + i + "]//label[1]//span[2]");
            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);
            String[] ListAbove = rp.TextFinitonsAboveList(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(FinitionList[i]);
            } else if (ListAbove[i - 1].contains(FinitionList[i - 1])) {

                System.out.println("GOOD" + ListAbove[i - 1] + FinitionList[i - 1]);

            } else {

                Error++;
                System.err.println("0000000" + ListAbove[i - 1] + "OOOOOOO" + FinitionList[i - 1] + "0000000");

            }

        }
        assert (Error == 0);

    }

    @Test
    public void TestColorMenuText() {// check le titre (au dessus de la liste) du menu Colors est present
        Wait.Wait(2000);
        assert (fp.ColorMenuTextAboveList(driver).equals("Couleur"));

    }

    @Test
    public void TestColorsListNbVHChanges() {
        Wait.Wait(2000);
        boolean exist = false;
        int[] NbVh = new int[100];
        int Error = 0;
        NbVh[0] = 0;
        String[] ColorList = fp.GetColorsList(driver);

        for (int i = 1; i < ColorList.length; i++) {

            fp.ClickOnListElement(driver, "//app-filter-colors[" + i + "]//label[1]//span[3]");

            Wait.Wait(2000);

            NbVh[i + 1] = rp.GetTheOffersNum(driver);

            if (NbVh[i + 1] <= NbVh[i]) {

                Error++;
                System.err.println(ColorList[i]);
            }

        }
        assert (Error == 0);
    }

    @Test
    public void TestRadiusMenuText() {// check le titre (au dessus) du menu Rayon est present
        Wait.Wait(2000);
        assert (fp.RadiusTextAbove(driver).equals("Rayon géographique"));

    }

    @Test
    public void TestRadiusSliderMinText() {// texte relatif à la distance min
        Wait.Wait(2000);

        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RadiusSliderSelect(driver), 96, 0).build();
        action.perform();
        Wait.Wait(2000);

        assert (fp.RadiusDistanceMinText(driver).equals("1 km"));

    }

    @Test
    public void TestRadiusSliderMaxText() { // texte relatif à la distance max
        Wait.Wait(2000);

        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RadiusSliderSelect(driver), 96, 0).build();
        action.perform();
        Wait.Wait(2000);

        assert (fp.RadiusDistanceMaxText(driver).equals("500 km"));

    }

    @Test
    public void TestRadiusSliderNBVHup() { // verif le chgt du nb de vh affichés quand on augmente la distance
        Wait.Wait(2000);

        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RadiusSliderSelect(driver), 96, 0).build();
        action.perform();
        Wait.Wait(2000);
        int NBVH1 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH1);
        // assert (fp.RadiusCurrentDistanceText(driver).equals("199 km"));

        Actions moveSliders2 = new Actions(driver);
        Action action2 = (Action) moveSliders2.dragAndDropBy(fp.RadiusSliderSelect(driver), 151, 0).build();
        action.perform();
        Wait.Wait(2000);
        int NBVH2 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH2);
        assert (NBVH1 - NBVH2 < 0);

    }

    @Test
    public void TestMoveSlider() {
        Wait.Wait(2000);

        int NBkm0 = rp.GetTheOffersNum(driver);
        System.out.println(NBkm0);
        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RadiusSliderSelect(driver), 96, 0).build();
        action.perform();
        Wait.Wait(2000);
        int NBkm1 = rp.GetTheOffersNum(driver);
        System.out.println(NBkm1);
        assert (NBkm0 - NBkm1 < 0); // montre que le nb de km affiché change quand on move le slider

    }

    @Test
    public void TestRadiusSliderNBVHdown() { // verif le chgt du nb de vh affichés quand on baisse la distance
        Wait.Wait(2000);

        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RadiusSliderSelect(driver), 120, 0).build();
        action.perform();
        Wait.Wait(2000);
        int NBVH1 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH1);
        // assert (fp.RadiusCurrentDistanceText(driver).equals("199 km"));

        Actions moveSliders2 = new Actions(driver);
        Action action2 = (Action) moveSliders2.dragAndDropBy(fp.RadiusSliderSelect(driver), -50, 0).build();
        action2.perform();
        Wait.Wait(2000);
        int NBVH2 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH2);
        assert (NBVH1 - NBVH2 > 0);

    }

    @Test
    public void TestPriceTextAbove() {// check le titre (au dessus) du slider des prix est present
        Wait.Wait(2000);
        assert (fp.PriceTextAbove(driver).equals("Prix"));

    }

    @Test
    public void TestDisplayedPriceSliderBar() {// check la bar de slider du prix est presente
        Wait.Wait(2000);
        assert (fp.PriceSliderBar(driver) == true);
    }

    @Test
    public void TestPriceSliderMinText() {// texte relatif au prix min s'affiche
        Wait.Wait(2000);

        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.LeftPriceSliderBarSelect(driver), 120, 0).build();
        action.perform();
        Wait.Wait(2000);

        assert (fp.PriceMinText(driver).equals("12 476 €"));
    }

    @Test
    public void TestPriceSliderMaxText() {// texte relatif au prix max s'affiche
        Wait.Wait(2000);

        Actions moveSliders = new Actions(driver);
        Wait.Wait(2000);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RightPriceSliderBarSelect(driver), (-200), 0).build();
        action.perform();
        Wait.Wait(2000);

        assert (fp.PriceMaxText(driver).equals("60 577 €"));
    }

    @Test
    public void TestLeftPriceSliderCurrentText() {

        Wait.Wait(2000);

        String prix0 = fp.LeftPriceCurrentText(driver);
        System.out.println(prix0);
        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.LeftPriceSliderBarSelect(driver), 96, 0).build();
        action.perform();
        Wait.Wait(2000);
        String prix1 = fp.LeftPriceCurrentText(driver);
        System.out.println(prix1);
        assert (prix0 != prix1); // montre que le prix change quand on move le slider de gauche

        // assert (fp.LeftPriceCurrentText(driver).equals("29 512 €"));

    }

    @Test
    public void TestRightPriceSliderCurrentText() {

        Wait.Wait(2000);

        String prix0 = fp.RightPriceCurrentText(driver);
        // int px0 = Integer.parseInt(prix0);
        System.out.println(prix0);
        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RightPriceSliderBarSelect(driver), -96, 0).build();
        action.perform();
        Wait.Wait(2000);
        String prix1 = fp.RightPriceCurrentText(driver);
        // int px1 = Integer.parseInt(prix1);
        System.out.println(prix1);
        assert (prix0 != prix1); // montre que le prix change quand on move le slider de droite

        // assert (fp.LeftPriceCurrentText(driver).equals("29 512 €"));

    }

    @Test
    public void TestLeftPriceSliderCurrentTextNBVHchange() {

        Wait.Wait(2000);

        int NBVH1 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH1);
        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.LeftPriceSliderBarSelect(driver), 96, 0).build();
        action.perform();
        Wait.Wait(2000);
        int NBVH2 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH2);
        assert (NBVH2 - NBVH1 < 0); // montre que le nb de VH baisse quand on move le slider de gauche vers la droite

    }

    @Test
    public void TestRightPriceSliderCurrentTextNBVHchange() {

        Wait.Wait(2000);

        int NBVH1 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH1);
        Actions moveSliders = new Actions(driver);
        Action action = (Action) moveSliders.dragAndDropBy(fp.RightPriceSliderBarSelect(driver), -96, 0).build();
        action.perform();
        Wait.Wait(2000);
        int NBVH2 = rp.GetTheOffersNum(driver);
        System.out.println(NBVH2);
        assert (NBVH2 - NBVH1 < 0); // montre que le nb de VH baisse quand on move le slider de droite vers la gauche

    }

}

/*
 * Creation : 15 mai 2019
 */
package peugeot;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.Wait;

public class ProductPageCompoTests {

    static WebDriver driver;
    ProductPageCompo pp = new ProductPageCompo();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://prod-widget.stockengine.awsmpsa.com/demo/#/vehicles/OPV_AP_PT_09372651?geodistance=");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @Test
    public void CTAPreviousPageDisplayed() {// check présence CTA retour
        Wait.Wait(2000);
        assert (pp.CTAPreviousPage(driver) == true);

    }

    @Test
    public void TestCTAPreviousPageText() {// check texte CTA retour
        Wait.Wait(2000);
        assert (pp.CTAPreviousPageText(driver).contains("RETOUR"));
    }

    @Test
    public void TestCTAPreviousPageIcon() {// check présence Icon
        Wait.Wait(2000);
        assert (pp.CTAPreviousPageIcone(driver) == true);

    }

    @Test
    public void TestPictoVueExt() {// check présence Pico vue ext
        Wait.Wait(2000);
        assert (pp.PictoVueExt(driver) == true);

    }

    @Test
    public void TestTextVueExt() {// check présence Texte Pico vue ext
        Wait.Wait(2000);
        assert (pp.TextVueExt(driver).equals("Vue extérieure"));

    }

    @Test
    public void TestPictoVueInt() {// check présence Pico vue int
        Wait.Wait(2000);
        assert (pp.PictoVueInt(driver) == true);

    }

    @Test
    public void TestTextVueInt() {// check présence Pico vue int
        Wait.Wait(2000);
        assert (pp.TextVueInt(driver).equals("Vue intérieure"));

    }

    @Test
    public void TestTextVue360() {// check présence texte vue 360
        Wait.Wait(2000);
        assert (pp.TextVue360(driver).equals("Vue 360"));

    }

    @Test
    public void TestCheckVHTitle() {// check titre VH
        Wait.Wait(2000);
        assert (pp.CheckVHTitleDisplayed(driver) == true);

    }

    @Test
    public void TestCheckVHCaracteristicsDisplayed() {// check carac VH visibles
        Wait.Wait(2000);
        assert (pp.CheckVHCaracteristicsDisplay(driver) == true);

    }

    @Test
    public void TestPrixTotalTitreDisplayed() {// check titre prix total présent
        Wait.Wait(2000);
        assert (pp.PrixTotalTitreDisplayed(driver) == true);

    }

    @Test
    public void TestPrixTotalTitreText() {// check mention PRIX TOTAL
        Wait.Wait(2000);
        assert (pp.PrixTotalTitreText(driver).contains("PRIX TOTAL"));

    }

    @Test
    public void TestPrixTotalNbDisplayed() {// check prix amount displayed
        Wait.Wait(2000);
        assert (pp.PrixTotalNbDisplayed(driver) == true);

    }

    @Test
    public void TestPrixTotalNbText() {// check présence € TTC
        Wait.Wait(2000);
        assert (pp.PrixTotalNbText(driver).contains("€ TTC"));

    }

    @Test
    public void TestDetailPrixDisplayed() {
        Wait.Wait(2000);
        assert (pp.DetailPrixDisplayed(driver) == true);

    }

    @Test
    public void TestDetailPrixText() {// check présence Détail du prix
        Wait.Wait(2000);
        assert (pp.DetailPrixText(driver).equals("Détail du prix"));

    }

    @Test
    public void TestDetailPrixIconeDisplayed() {// check présence Icone détail prix >
        Wait.Wait(2000);
        assert (pp.DetailPrixIconeDisplayed(driver) == true);

    }

    @Test
    public void TestEncartRemisesDisplayed() {// check présence encart remises
        Wait.Wait(2000);
        assert (pp.EncartRemisesDisplayed(driver) == true);

    }

    @Test
    public void TestEncartRemisesText() {// check présence texte remises incluses
        Wait.Wait(2000);
        assert (pp.EncartRemisesText(driver).contains("Remises incluses"));

    }

    @Test
    public void TestEncartRemisesPrixDisplayed() {// check présence prix remises incluses
        Wait.Wait(2000);
        assert (pp.EncartRemisesPrixDisplayed(driver) == true);

    }

    @Test
    public void TestEncartRemisesPrixText() {// check présence TTC remises incluses
        Wait.Wait(2000);
        assert (pp.EncartRemisesPrixText(driver).contains("€ TTC"));

    }

    @Test
    public void TestPictoDateLivraison() {// check présence picto livraison
        Wait.Wait(2000);
        assert (pp.PictoDateLivraison(driver) == true);

    }

    @Test
    public void TestDateLivraisonDisplayed() {// check présence date livraison
        Wait.Wait(2000);
        assert (pp.DateLivraisonDisplayed(driver) == true);

    }

    @Test
    public void TestDateLivraisonText() {// check présence date livraison
        Wait.Wait(2000);
        assert (pp.DateLivraisonText(driver).contains("Livraison sous "));

    }

    @Test
    public void TestEncartVendeurDisplayed() {// check présence encart Vendeur
        Wait.Wait(2000);
        assert (pp.EncartVendeurDisplayed(driver) == true);

    }

    @Test
    public void TestAdresseVendeurDisplayed() {// check adresse vendeur displayed
        Wait.Wait(2000);
        assert (pp.AdresseVendeurDisplayed(driver) == true);

    }

    @Test
    public void TestAdresseVendeurDisplayed1() {// check texte : Véhicule dispo à
        Wait.Wait(2000);
        assert (pp.AdresseVendeurDisplayed1(driver).contains("Véhicule disponible à"));

    }

    @Test
    public void TestCurseurLocalisationDisplayed() {// check icone localisation
        Wait.Wait(2000);
        assert (pp.CurseurLocalisationDisplayed(driver) == true);

    }

    @Test
    public void TestCTAVoirPlusText() {// check text savoir plus
        Wait.Wait(2000);
        assert (pp.CTAVoirPlusText(driver).contains("Voir plus"));

    }

    @Test
    public void TestIconeVoirPlus() {// check text savoir plus
        Wait.Wait(2000);
        assert (pp.IconeVoirPlus(driver) == true);

    }

    @Test
    public void TestIconeFlecheDroiteVisuelsExt() {// check présence fleche droite défilement visuels
        Wait.Wait(2000);
        assert (pp.IconeFlecheDroiteVisuelsExt(driver) == true);

    }

    @Test
    public void TestIconeFlecheDroiteVisuelsExtIcon() {// check présence Icone fleche droite défilement visuels
        Wait.Wait(2000);
        assert (pp.IconeFlecheDroiteVisuelsExtIcon(driver) == true);

    }

    @Test
    public void TestIconeFlecheGaucheVisuelsExt() {// check présence fleche gauche défilement visuels
        Wait.Wait(2000);
        assert (pp.IconeFlecheGaucheVisuelsExt(driver) == true);

    }

    @Test
    public void TestIconeFlecheGaucheVisuelsExtIcon() {// check présence Icone fleche gauche défilement visuels
        Wait.Wait(2000);
        assert (pp.IconeFlecheGaucheVisuelsExtIcon(driver) == true);

    }

    @Ignore
    public void TestVisuIntImage() {// check présence image int (marche pas car imges variables)
        Wait.Wait(2000);
        pp.PictoVueIntSelect(driver);
        Wait.Wait(3000);
        assert (pp.VisuIntImage(driver) == true);

    }

    @Test
    public void TestVisu360Image() {// check présence visu 360
        Wait.Wait(2000);
        pp.PictoVue360Select(driver);
        Wait.Wait(2000);
        assert (pp.Visu360Image(driver) == true);

    }

    @Test
    public void TestTextCouleurSousVisu() {// check présence texte relatif aux couleurs sous les visuels
        Wait.Wait(2000);
        pp.PictoVue360Select(driver);
        Wait.Wait(2000);
        assert (pp.TextCouleurSousVisu(driver) == true);

    }

    @Test
    public void TestCTAContactConseillerDisplayed() {// check présence CTA contact conseiller
        Wait.Wait(2000);
        assert (pp.CTAContactConseillerDisplayed(driver) == true);

    }

    @Test
    public void TestCTAContactConseillerText() {// check présence texte contact conseiller (ne marche pas )
        Wait.Wait(3000);
        assert (pp.CTAContactConseillerText(driver).contains("CONTACTER VOTRE CONSEILLER PEUGEOT"));

    }

    @Test
    public void TestCompteurImagesExtDisplayed() {// check présence compteur images ext
        Wait.Wait(3000);
        assert (pp.CompteurImagesExtDisplayed(driver) == true);

    }

    @Test
    public void TestCompteurImagesExtText() {
        Wait.Wait(3000);
        assert (pp.CompteurImagesExtText(driver).contains("/ 8"));

    }

    @Test
    public void TestCompteurImagesIntDisplayed() {// check présence compteur images int
        Wait.Wait(2000);
        pp.PictoVueIntSelect(driver);
        Wait.Wait(3000);
        assert (pp.CompteurImagesIntDisplayed(driver) == true);

    }

    @Test
    public void TestCompteurImagesIntText() {
        Wait.Wait(2000);
        pp.PictoVueIntSelect(driver);
        Wait.Wait(3000);
        assert (pp.CompteurImagesIntText(driver).contains("/ 3"));

    }

    @Test
    public void TestEncartOptionsInclusesDisplayed() {

        Wait.Wait(3000);
        assert (pp.EncartOptionsInclusesDisplayed(driver) == true);

    }

    @Test
    public void TestEncartOptionsInclusesTitreText() {

        Wait.Wait(3000);
        assert (pp.EncartOptionsInclusesTitreText(driver).equals("OPTIONS INCLUSES"));

    }

    @Test
    public void TestEncartListeOptionsDisplayed() {

        Wait.Wait(3000);
        assert (pp.EncartListeOptionsDisplayed(driver) == true);

    }

    @Test
    public void TestEncartCaractéristiquesDisplayed() {

        Wait.Wait(3000);
        assert (pp.EncartCaractéristiquesDisplayed(driver) == true);

    }

    @Test
    public void TestEncartCaractéristiquesTitreText() {

        Wait.Wait(3000);
        assert (pp.EncartCaractéristiquesTitreText(driver).contains("CARACTÉRISTIQUES"));

    }

    @Test
    public void TestTableauCaractDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauCaractDisplayed(driver) == true);

    }

    @Test
    public void TestColonneEnergieTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneEnergieTitleText(driver).contains("ENERGIE"));

    }

    @Test
    public void TestColonneEnergieChampText() { // chek que le champ du tableau relatif à l'énergie est présent

        Wait.Wait(3000);
        assert (pp.ColonneEnergieChampText(driver) == true);

    }

    @Test
    public void TestColonnePuissanceTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonnePuissanceTitleText(driver).contains("PUISSANCE"));

    }

    @Test
    public void TestColonnePuissanceChampText() { // Check champ Puissance présent

        Wait.Wait(3000);
        assert (pp.ColonnePuissanceChampText(driver) == true);

    }

    @Test
    public void TestColonneConsommationTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneConsommationTitleText(driver).contains("CONSOMMATION"));

    }

    @Test
    public void TestColonneConsommationChampText() { // Check champ Conso présent

        Wait.Wait(3000);
        assert (pp.ColonneConsommationChampText(driver) == true);

    }

    @Test
    public void TestColonneEmissionCO2TitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneEmissionCO2TitleText(driver).contains("ÉMISSION CO2"));

    }

    @Test
    public void TestColonneEmissionCO2ChampText() {

        Wait.Wait(3000);
        assert (pp.ColonneEmissionCO2ChampText(driver) == true);

    }

    @Test
    public void TestLegalWLTPText() {

        Wait.Wait(3000);
        assert (pp.LegalWLTPText(driver).contains("WLTP"));

    }

    @Test
    public void TestEncartCaracTechDisplayed() {

        Wait.Wait(3000);
        assert (pp.EncartCaracTechDisplayed(driver) == true);

    }

    @Test
    public void TestEncartCaracTechTitreText() {

        Wait.Wait(3000);
        assert (pp.EncartCaractéristiquesTitreText(driver).contains("CARACTÉRISTIQUES TECHNIQUES"));

    }

    @Test
    public void TestTableauCaracTechDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauCaracTechDisplayed(driver) == true);

    }

    @Test
    public void TestColonneFinitionTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneFinitionTitleText(driver).contains("FINITION"));

    }

    @Test
    public void TestColonneFinitionChampText() { // chek que le champ du tableau relatif à l'énergie est présent

        Wait.Wait(3000);
        assert (pp.ColonneFinitionChampText(driver) == true);

    }

    @Test
    public void TestColonneMoteurTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneMoteurTitleText(driver).contains("MOTEUR"));

    }

    @Test
    public void TestColonneMoteurChampText() { // Check champ Moteur présent

        Wait.Wait(3000);
        assert (pp.ColonneMoteurChampText(driver) == true);

    }

    @Test
    public void TestColonneSilhouetteTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneSilhouetteTitleText(driver).contains("SILHOUETTE"));

    }

    @Test
    public void TestColonneSilhouetteChampText() { // Check champ SILHOUETTE présent

        Wait.Wait(3000);
        assert (pp.ColonneSilhouetteChampText(driver) == true);

    }

    @Test
    public void TestColonneBDVTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneBDVTitleText(driver).contains("BOÎTE DE VITESSE"));

    }

    @Test
    public void TestColonneBDVChampText() {

        Wait.Wait(3000);
        assert (pp.ColonneBDVChampText(driver) == true);

    }

    @Test
    public void TestColonneVINTitleText() {

        Wait.Wait(3000);
        assert (pp.ColonneVINTitleText(driver).contains("VIN"));

    }

    @Test
    public void TestColonneVINChampText() {

        Wait.Wait(3000);
        assert (pp.ColonneVINChampText(driver) == true);

    }

    @Test
    public void TestCTAFicheTechDisplayed() { // CTA pour ouvrir fiche tech présent

        Wait.Wait(3000);
        assert (pp.CTAFicheTechDisplayed(driver) == true);

    }

    @Test
    public void TestCTAFicheTechText() {

        Wait.Wait(3000);
        assert (pp.CTAFicheTechText(driver).contains("PDF"));

    }

    @Test
    public void TestIconeFicheTechDisplayed() { // petit icone dans le titre du cta fiche tech présent

        Wait.Wait(3000);
        assert (pp.IconeFicheTechDisplayed(driver) == true);

    }

    @Test
    public void TestTitreEquipementsDisplayed() {

        Wait.Wait(3000);
        assert (pp.TitreEquipementsDisplayed(driver) == true);

    }

    @Test
    public void TestTitreEquipementsText() {

        Wait.Wait(3000);
        assert (pp.TitreEquipementsText(driver).contains("ÉQUIPEMENT"));

    }

    @Test
    public void TestTableauEquipementsDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsSegurançaDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsSegurançaDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsSegurançaText() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsSegurançaText(driver).contains("SEGURANÇA"));

    }

    @Test
    public void TestTableauBancosDisplayed() {

        Wait.Wait(3000);
        System.out.println("ATTENTION : Tests équipements => Parfois pas présent sur la page = normal");
        assert (pp.TableauBancosDisplayed(driver) == true);

    }

    @Test
    public void TestTableauBancosText() {

        Wait.Wait(3000);
        assert (pp.TableauBancosText(driver).contains("BANCOS"));

    }

    @Test
    public void TestTableauEquipementsInteriorDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsInteriorDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsInteriorText() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsInteriorText(driver).contains("INTERIOR0001"));

    }

    @Test
    public void TestTableauEquipementsAideConducDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsAideConducDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsAideConducText() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsAideConducText(driver).contains("AJUDA À CONDUÇÃO"));

    }

    @Test
    public void TestTableauEquipementsExterieurTitleText() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsExterieurTitleText(driver).contains("EXTERIOR0002"));

    }

    @Test
    public void TestTableauEquipementsConfortDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsConfortDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsConfortText() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsConfortText(driver).contains("CONFORTO"));

    }

    @Test
    public void TestTableauEsteticaDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEsteticaDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEsteticaText() {

        Wait.Wait(3000);
        assert (pp.TableauEsteticaText(driver).contains("ESTÉTICA"));

    }

    @Test
    public void TestTableauEquipementsAudioEtCommDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsAudioEtCommDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsAudioEtCommText() {

        Wait.Wait(3000);
        System.out.println("ATTENTION : Tests équipements => Parfois pas présent sur la page = normal");
        assert (pp.TableauEquipementsAudioEtCommText(driver).contains("ÁUDIO E COMUNICAÇÃO"));

    }

    @Test
    public void TestTableauEquipementsInstruDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsInstruDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsInstruText() {

        Wait.Wait(3000);
        System.out.println("ATTENTION : Tests équipements => Parfois pas présent sur la page = normal");
        assert (pp.TableauEquipementsInstruText(driver).contains("INSTRUMENTAÇÃO"));

    }

    @Test
    public void TestTableauEquipementsOutrosDisplayed() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsOutrosDisplayed(driver) == true);

    }

    @Test
    public void TestTableauEquipementsOutrosText() {

        Wait.Wait(3000);
        assert (pp.TableauEquipementsOutrosText(driver).contains("OUTROS"));

    }

    @Test
    public void TestTitreVotreConcessionnaireDisplayed() { // Espace titre section concessionnaire présent

        Wait.Wait(3000);
        assert (pp.TitreVotreConcessionnaireDisplayed(driver) == true);

    }

    @Test
    public void TestTitreVotreConcessionnaireText() { // Titre espace concessionnaire correct

        Wait.Wait(3000);
        assert (pp.TitreVotreConcessionnaireText(driver).contains("VOTRE CONCESSIONNAIRE"));

    }

    @Test
    public void TestBlocVotreConcessionnaireDisplayed() { // Présence bloc concessionnaire

        Wait.Wait(3000);
        assert (pp.BlocVotreConcessionnaireDisplayed(driver) == true);

    }

    @Test
    public void TestMapConcessionnaireDisplayed() { // Check présence carte google

        Wait.Wait(3000);
        assert (pp.MapConcessionnaireDisplayed(driver) == true);

    }

    @Test
    public void TestBlocInfosConcessionnaireDisplayed() { // présence bloc info sur concessionnaire (adresse etc...)

        Wait.Wait(3000);
        assert (pp.BlocInfosConcessionnaireDisplayed(driver) == true);

    }

    @Test
    public void TestBlocInfosConcessionnaireAdresseDisplayed() { // espace adresse

        Wait.Wait(3000);
        assert (pp.BlocInfosConcessionnaireAdresseDisplayed(driver) == true);

    }

    @Test
    public void TestBlocInfosConcessionnaireAdresseIconeDisplayed() { // icone espace adresse

        Wait.Wait(3000);
        assert (pp.BlocInfosConcessionnaireAdresseIconeDisplayed(driver) == true);

    }

    @Test
    public void TestBlocInfosConcessionnaireHorairesDisplayed() { // espace horaires

        Wait.Wait(3000);
        assert (pp.BlocInfosConcessionnaireHorairesDisplayed(driver) == true);

    }

    @Test
    public void TestBlocInfosConcessionnaireHorairesIconeDisplayed() { // icone pendule

        Wait.Wait(3000);
        assert (pp.BlocInfosConcessionnaireHorairesIconeDisplayed(driver) == true);

    }

    @Test
    public void TestBlocContactMailConcessionnaireDisplayed() { // Bloc contact concess par mail

        Wait.Wait(3000);
        assert (pp.BlocContactMailConcessionnaireDisplayed(driver) == true);

    }

    @Test
    public void TestBlocContactConcessionnaireText() { // Bloc contact text

        Wait.Wait(3000);
        assert (pp.BlocContactConcessionnaireText(driver).contains("Prendre contact"));

    }

    @Test
    public void TestBlocContactConcessionnaireIconeDisplayed() { // icone enveloppe présente

        Wait.Wait(3000);
        assert (pp.BlocContactConcessionnaireIconeDisplayed(driver) == true);

    }

    @Test
    public void TestCTACallConcessionnaireDisplayed() { // bouton pr appeler

        Wait.Wait(3000);
        assert (pp.CTACallConcessionnaireDisplayed(driver) == true);

    }

    @Test
    public void TestCTACallConcessionnaireText() { // bouton pr appeler

        Wait.Wait(3000);
        assert (pp.CTACallConcessionnaireText(driver).contains("APPELER VOTRE CONSEILLER PEUGEOT"));

    }

    @Test
    public void TestMapIconBonhommeDisplayed() { // icone bonhomme map présent

        Wait.Wait(3000);
        assert (pp.MapIconBonhommeDisplayed(driver) == true);

    }

    @Test
    public void TestMapIconPlusDisplayed() { // bouton+ sur map

        Wait.Wait(3000);
        assert (pp.MapIconPlusDisplayed(driver) == true);

    }

    @Test
    public void TestMapIconMoinsDisplayed() { // bouton - sur Map

        Wait.Wait(3000);
        assert (pp.MapIconMoinsDisplayed(driver) == true);

    }

}

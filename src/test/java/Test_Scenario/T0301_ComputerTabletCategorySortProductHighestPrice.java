package Test_Scenario;

import Driver.DriverMethods;
import Pages.HomePage;
import Pages.PasajAllProductsPage;
import Pages.PasajHomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class T0301_ComputerTabletCategorySortProductHighestPrice extends DriverMethods {

    @Test(priority = 7,description = "Ürünlerin yüksek fiyata göre sıralanması.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Bilgisayar ve tablet kategorisine ait ürünlerin en yüksek fiyata göre sıralanması.")
    @Story("Turkcel web adresine git. Bilgisayar tablet Kategorisini seç. Sıralama menüsünden en yüksek fiyat seçeneğini seç. Ürünlerin doğru sıra ile geldiğini kontrol et.")
    public void computerTabletCategorySortProductHighestPrice() {


        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickPAsajTopCategory(pasajHomePage.computerTapbletCategory);
        pasajAllProductsPage.sortByHighestPrice();
        pasajAllProductsPage.checkProductPriceHighestPriceOrder();


    }
}

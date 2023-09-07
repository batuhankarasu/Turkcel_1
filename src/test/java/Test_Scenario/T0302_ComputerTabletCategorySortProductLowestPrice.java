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

public class T0302_ComputerTabletCategorySortProductLowestPrice extends DriverMethods {


    @Test(priority = 8,description = "Ürünlerin düşük fiyata göre sıralanması.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Bilgisayar ve tablet kategorisine ait ürünlerin en düşük fiyata göre sıralanması.")
    @Story("Turkcel web adresine git. Bilgisayar tablet Kategorisini seç. Sıralama menüsünden en düşük fiyat seçeneğini seç. Ürünlerin doğru sıra ile geldiğini kontrol et.")
    public void computerTabletCategorySortProductLowestPrice() {



        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickPAsajTopCategory(pasajHomePage.computerTapbletCategory);
        pasajAllProductsPage.sortByLowestPrice();
        pasajAllProductsPage.checkProductPriceLowestPriceOrder();


    }
}

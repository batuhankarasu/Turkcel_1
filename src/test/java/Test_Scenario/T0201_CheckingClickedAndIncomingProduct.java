package Test_Scenario;

import Driver.DriverMethods;
import Pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class T0201_CheckingClickedAndIncomingProduct extends DriverMethods {


    @Test(priority = 5,description = "Sepetteki ürün sayısının değişiminin etkisinin gözlenmesi.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Non login iken sepetteki ürün sayısı değişiminin sepet ikonu üzerinde yaptığı değişiklikler.")
    @Story("Turkcel web adresine git. İlgili kategoriyegidip rastgele ürün seç. Sepete nonlogin bir şekilde ekle. Ürn eklendikten ve silindikten sonra sepetikonun değişimini kontrol et.")

    public void checkingClickedAndIncomingProductTest() {


        HomePage homePage = new HomePage(driver);
        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);


        homePage.clickPAsajTopCategory(pasajHomePage.elektrikliEvAletleriCategory);
        pasajAllProductsPage.selectCheckRandomProduct();
        productPage.nonLoginAddBasket();
        basketPage.checkBasketUpgradeProductNumber();
        basketPage.deleteProductInBasket();
        basketPage.checkBasketDownProductNumber();


    }
}

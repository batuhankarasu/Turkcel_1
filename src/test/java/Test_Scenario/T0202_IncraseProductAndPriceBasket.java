package Test_Scenario;

import Driver.DriverMethods;
import Pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class T0202_IncraseProductAndPriceBasket extends DriverMethods {

    @Test(priority = 6,description = "Sepetteki ürün sayısının değişiminin etkisinin gözlenmesi.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login iken sepetteki ürün sayısı değişiminin sepet ikonu üzerinde yaptığı değişiklikler.")
    @Story("Turkcel web adresine git. İlgili kategoriye gidip rastgele ürün seç. Sepete ürünü ekle. Login ol. Ürün eklendikten ve ürün sayısı arttırıldıktan sonra sepet ikonun ve sepet tutarının değişimini kontrol et.")
    public void incraseProductAndPriceBasketTest() {


        HomePage homePage = new HomePage(driver);
        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);


        homePage.clickPAsajTopCategory(pasajHomePage.elektrikliEvAletleriCategory);
        pasajAllProductsPage.selectCheckRandomProduct();
        productPage.fastLoginAddBasket();
        basketPage.checkBasketUpgradeProductNumber();
        basketPage.checkBasketPriceAddProduct();
        basketPage.deleteProductInBasket();

    }


}

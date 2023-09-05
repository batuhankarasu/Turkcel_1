package Test_Scenario;

import Driver.DriverMethods;
import Pages.*;
import org.testng.annotations.Test;

public class T0202_IncraseProductAndPriceBasket extends DriverMethods {

    @Test
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


    }


}

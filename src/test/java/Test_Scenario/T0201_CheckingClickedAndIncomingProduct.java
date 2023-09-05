package Test_Scenario;

import Driver.DriverMethods;
import Pages.*;
import org.testng.annotations.Test;

public class T0201_CheckingClickedAndIncomingProduct extends DriverMethods {


    @Test
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

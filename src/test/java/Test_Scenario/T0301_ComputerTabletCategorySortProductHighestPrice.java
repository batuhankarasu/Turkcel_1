package Test_Scenario;

import Driver.DriverMethods;
import Pages.HomePage;
import Pages.PasajAllProductsPage;
import Pages.PasajHomePage;
import org.testng.annotations.Test;

public class T0301_ComputerTabletCategorySortProductHighestPrice extends DriverMethods {

    @Test
    public void computerTabletCategorySortProductHighestPrice() {
        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickPAsajTopCategory(pasajHomePage.computerTapbletCategory);
        pasajAllProductsPage.sortByHighestPrice();
        pasajAllProductsPage.checkProductPriceHighestPriceOrder();


    }
}

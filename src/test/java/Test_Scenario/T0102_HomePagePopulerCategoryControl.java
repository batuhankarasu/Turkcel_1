package Test_Scenario;

import Driver.DriverMethods;
import Pages.HomePage;
import org.testng.annotations.Test;

public class T0102_HomePagePopulerCategoryControl extends DriverMethods {

    @Test
    public void homePagePopulerCategoryControl() {

        HomePage homePage = new HomePage(driver);

        homePage.checkPopulerCategoryName();

    }
}

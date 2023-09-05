package Test_Scenario;

import Driver.DriverMethods;
import Pages.CategoryPage;
import Pages.TurkcellTopHader;
import org.testng.annotations.Test;

public class T0101_CategorySelectionPageCheck extends DriverMethods {

    @Test
    public void categorySelectionPageCheckTest() {
        TurkcellTopHader turkcellTopHader = new TurkcellTopHader(driver);
        CategoryPage categoryPage = new CategoryPage(driver);


        turkcellTopHader.selectCategory();
        categoryPage.verifyCategoryTitle();
    }


}
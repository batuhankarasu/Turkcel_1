package Test_Scenario;

import Driver.DriverMethods;
import Pages.AfterSearchProductPage;
import Pages.TurkcellTopHader;
import org.testng.annotations.Test;

public class T0103_ControlOfSearchBar extends DriverMethods {

    @Test
    public void controlOfSearchBarTest() {

        TurkcellTopHader turkcellTopHader = new TurkcellTopHader(driver);
        AfterSearchProductPage afterSearchProductPage = new AfterSearchProductPage(driver);

        turkcellTopHader.search();
        afterSearchProductPage.productPageControl();
    }


}

package Test_Scenario;

import Driver.DriverMethods;
import Pages.AfterSearchProductPage;
import Pages.TurkcellTopHader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class T0103_ControlOfSearchBar extends DriverMethods {

    @Test(priority = 2,description = "Belirli bir ürün kategorisini arama. ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sürpürge kelimesi ile ilgili ürünleri listeleme.")
    @Story("Turkcel sayfasına git. Arama ikonuna tıkla. Süpürge kelimesini arama alanına yaz. Ürünlerin süpürge olup olmadığını kontrol et. ")
    public void controlOfSearchBarTest() {

        TurkcellTopHader turkcellTopHader = new TurkcellTopHader(driver);
        AfterSearchProductPage afterSearchProductPage = new AfterSearchProductPage(driver);

        turkcellTopHader.search();
        afterSearchProductPage.productPageControl();
    }


}

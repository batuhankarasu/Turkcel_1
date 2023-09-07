package Test_Scenario;

import Driver.DriverMethods;
import Pages.HomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class T0102_HomePagePopulerCategoryControl extends DriverMethods {

    @Test(priority = 1,description = "Popüler kategorilerinin tablarını ürünlerin doğrulanması.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Web sitedeki popüler kategorilerin ve buna bağlı değişen ürünlerin kontrol edilmesi.")
    @Story("Turkcel web adresine git. Popüler kategoriler bölümüne scroll et. Tab değişimi sonrası ürünlerinde değiştiğini kontrol et.")
    public void homePagePopulerCategoryControl() {

        HomePage homePage = new HomePage(driver);

        homePage.checkPopulerCategoryName();

    }
}

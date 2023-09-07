package Test_Scenario;

import Base.BaseVariable;
import Driver.DriverMethods;
import Pages.CategoryPage;
import Pages.TurkcellTopHader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class T0101_CategorySelectionPageCheck extends DriverMethods {

    @Test(priority = 0,description = "Tıklanan kategoriye uygun sayfanın gelmesi.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Bilgisayar ve tablet kategorisine ait sayfaya gidilmesi.")
    @Story("Turkcel web adresine git. Pasağ drop down menüsü üzrüne gidilir. Bilgisayar tablet kategorisi seçilir ve doğrulanır. ")
    public void categorySelectionPageCheckTest() {


        TurkcellTopHader turkcellTopHader = new TurkcellTopHader(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        BaseVariable baseVariable = new BaseVariable(driver);


        turkcellTopHader.selectCategory();
        categoryPage.verifyCategoryTitle(baseVariable.computerTabletUrl);
    }


}
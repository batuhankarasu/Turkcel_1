package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Bilgisayar-Tablet')]")
    public WebElement categoryTitle;

    @Description("bilgisayar tablet sayfasın geldiğini kontrol eder.")
    public void verifyCategoryTitle() {
        waitExpectedUrl("https://www.turkcell.com.tr/pasaj/bilgisayar-tablet?place=menu");
        logInfo("Url doğrulandı.");
        if (isElementVisible(categoryTitle)) {
            logInfo("Bilgisayar-Tablet başlıgı görüldü.");
        } else {
            logError("Bilgisayar-Tablet başlıgı gorülemedi");
        }
    }
}

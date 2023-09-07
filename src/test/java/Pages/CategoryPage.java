package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = LogManager.getLogger();


    @FindBy(xpath = "//h1[contains(text(),'Bilgisayar-Tablet')]")
    public WebElement categoryTitle;

    @Description("bilgisayar tablet sayfasın geldiğini kontrol eder.")
    public void verifyCategoryTitle() {
        waitExpectedUrl("https://www.turkcell.com.tr/pasaj/bilgisayar-tablet?place=menu");
        logger.info("Url doğrulandı.");
        if (isElementVisible(categoryTitle)) {
            logger.info("Bilgisayar-Tablet başlıgı görüldü.");
        } else {
            Assert.fail("Bilgisayar-Tablet başlıgı gorülemedi");
        }
    }
}

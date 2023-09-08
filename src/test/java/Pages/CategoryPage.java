package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.net.URL;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = LogManager.getLogger();


    @FindBy(xpath = "//h1[contains(text(),'Bilgisayar-Tablet')]")
    public WebElement categoryTitle;

    @Description("bilgisayar tablet sayfasın geldiğini kontrol eder.")
    public void verifyCategoryTitle(String url) {
        waitExpectedUrl(url);
        String currentURL = driver.getCurrentUrl();
        if (!(url.equals(currentURL))){
            Assert.fail("Doğru bir url açılmadı.");
        }
        logger.info("Url doğrulandı.");
        if (isElementVisible(categoryTitle)) {
            logger.info("Bilgisayar-Tablet başlıgı görüldü.");
        } else {
            Assert.fail("Bilgisayar-Tablet başlıgı gorülemedi");
        }
    }
}

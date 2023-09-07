package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class AfterSearchProductPage extends BasePage {
    Logger logger = LogManager.getLogger();
    public AfterSearchProductPage(WebDriver driver) {
        super(driver);
    }


    private By afterSearchProducts = By.xpath("//a[contains(@data-product-id,'supurge')]");

    @FindBy(xpath = "//h2[contains(text(),'Arama Sonuçları')]")
    public WebElement resoultConfirmText;


    @Description("Turkcel sayfası aramasonrası ürünlerin kontrolü.")
    public void productPageControl() {
        waitScrollElement(resoultConfirmText);
        List<WebElement> searchProductList = driver.findElements(afterSearchProducts);
        if (!(searchProductList.size() > 1)) {
            Assert.fail("Aranan kelime gurubuna ait ürün bulunamadı");
        }else {

            logger.info("Aranan kelimeye uygun ürün bulundu.");
            Assert.assertTrue(true);
        }
    }


}


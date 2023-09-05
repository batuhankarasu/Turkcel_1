package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By populeCategory = By.xpath("//span[contains(@class,'m-p-ts__tab-item__text')]");
    private By popularActiveCategoryProducts = By.xpath("//div[@class=\"m-tab__pane m-tab__pane--active\"]//a[@data-product-id]\n");


    @FindBy(xpath = "//section[@id=\"mostPopularProducts\"]//a[@class=\"a-btn-icon m-slider__next a-btn-icon--circle\"]")
    public WebElement populerCategoryNextBtn;
    @FindBy(xpath = "//div[@class=\"swiper-slide m-tab__item--active swiper-slide-active\"]")
    public WebElement activeTabPopulerCategory;
    @FindBy(xpath = "//div[@class=\"m-tab__pane m-tab__pane--active\"]")
    public WebElement activeProduct;
    @FindBy(xpath = "//section[@id=\"mostPopularProducts\"]//h2")
    public WebElement popularDevicesText;


    @Description("Pasaj sayfası git 'Elektrikli Ev Aletleri Category' seç")
    public void clickPAsajTopCategory(WebElement webElement) {
        TurkcellTopHader turkcellTopHader = new TurkcellTopHader(driver);
        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);


        waitAndScrollClickElement(turkcellTopHader.pasajDropMenu);
        String expectedTitle = webElement.getText();
        waitAndScrollClickElement(webElement);
        waitElement(pasajAllProductsPage.pageTopCategoryName);
        String pagename = pasajAllProductsPage.pageTopCategoryName.getText();
        if (!(pagename.equals(expectedTitle))) {
            logError("Sayfa adı doğru değil.Yanlış sayfaya gidildi ");
        }

    }

    @Description("Popüler kategori başlık sayıları ve ürün değişimi kontrolü")
    public void checkPopulerCategoryName() {
        try {
            List<WebElement> populeCategoryList = driver.findElements(populeCategory);
            findScrollElementCenter(activeTabPopulerCategory);
            waitScrollElement(popularDevicesText);
            if (!activeTabPopulerCategory.getText().equals("Cep Telefonu-Aksesuar") || !(populeCategoryList.size() > 1)) {
                logError("Aktif tab cep telefonu ve birden fazla kategori geldiği kontrol edildi.");
            }

            if (!activeProduct.getAttribute("data-keyword").equals("Cep Telefonu-Aksesuar")) {
                logError("Aktif tab cep telefonu ve aksesuarlar oldugu halde ürünler cep telefonu ve aksesuarlar ile ilgili değildir.");
            }

            populeCategoryList.get(1).click();
            TimeUnit.SECONDS.sleep(2);
            if (!activeProduct.getAttribute("data-keyword").equals(populeCategoryList.get(1).getText())) {
                logError("Aktif Bilgisayar-Tablet oldugu halde ürünler Bilgisayar-Tablet ile ilgili değildir.");
            }


        } catch (Exception e) {
            logFatal("Category seçilirken hata oluştu.");
        }
    }


}
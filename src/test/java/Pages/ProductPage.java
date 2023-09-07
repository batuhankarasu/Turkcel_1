package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = LogManager.getLogger();


    @FindBy(xpath = "//h1[@class=\" \"]")
    public WebElement productPageProductName;
    @FindBy(xpath = "//a[@class=\"o-p-header__my-basket\"]")
    public WebElement basketBtn;
    @FindBy(xpath = "//*[@class=\"a-btn a-btn--full a-btn--big device-available add-to-basket-non-login\"]")
    public WebElement addToBasketBtn;
    @FindBy(xpath = "//*[@class=\"hype-infobox\"]")
    public WebElement instalmentPopup;
    @FindBy(id = "none-login-sale-button")
    public WebElement goNonLoginBtn;
    @FindBy(xpath = "//a[@class=\"a-btn a-btn--full a-btn--big js-fast-login-btn\"]")
    public WebElement goLoginBtn;


    @Description("Taksit seçeneğinin çıkmasını bekler.")
    public void waitInstalmentPopup() {
        waitElement(instalmentPopup);
        findScrollElementCenter(instalmentPopup);
    }

    @Description("Nonlogin sepete ürün ekler")
    public void nonLoginAddBasket() {
        waitInstalmentPopup();
        waitAndScrollClickElement(addToBasketBtn);
        logger.info("Sepete ekleme butonuna tıklandı.");
        waitAndScrollClickElement(goNonLoginBtn);

    }

    @Description("Fastlogin ürünü sepete ekleme")
    public void fastLoginAddBasket() {
        LoginWindow loginWindow = new LoginWindow(driver);

        waitAndScrollClickElement(addToBasketBtn);
        logger.info("Sepete ekleme butonuna tıklandı.");
        waitAndScrollClickElement(goLoginBtn);
        loginWindow.fastLoginPageInformationRefill();

    }


}

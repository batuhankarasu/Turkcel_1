package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = LogManager.getLogger();


    @FindBy(xpath = "//*[@class=\"a-btn-icon m-basket-card__delete js-card-delete\"]")
    public WebElement productDeleteInBasket;
    @FindBy(xpath = "//span[@class=\"o-p-header__my-basket__items js-p-header-basket-item\"]")
    public WebElement basketProductNumber;
    @FindBy(xpath = "//*[@id=\"basket\"]//h1")
    public WebElement basketStringText;
    @FindBy(xpath = "//*[@id=\"modal-delete\"]//p")
    public WebElement wantToDeleteText;
    @FindBy(xpath = "//*[@class=\"a-btn js-card-delete-btn\"]")
    public WebElement wantToDeleteYesBtn;
    @FindBy(xpath = "//*[@id=\"modal-delete\"]//p")
    public WebElement youSureWantDeleteText;
    @FindBy(xpath = "//a[@class=\"a-btn a-btn--secondary js-card-delete-btn\"]")
    public WebElement youSureWantDeleteBtn;
    @FindBy(xpath = "//*[@class=\"js-count-up\"]")
    public WebElement upProductInBasket;
    @FindBy(xpath = "//*[@class=\"js-summary-basket-total\"]")
    public WebElement basketPrice;
    @FindBy(xpath = "//*[@id=\"basket\"]//h3")
    public WebElement emptyBasket;


    @Description("Sepet simge numarası değişimi kontroledilir.")
    public boolean checkBasketUpProductNumber() {
        double productNumber = priceCleaning(basketProductNumber);
        if (!((productNumber > 0))) {
            Assert.fail("ürün sepete eklenmedi.");
            return false;
        }
        logger.info("Ürün sepete eklendi.");
        return true;
    }

    @Description("Ürün atıktansonra sepet simgesi sepet fiyatının artışını kontrol eder.")
    public void checkBasketPriceAddProduct() {
        double productNumberFirstNumber = priceCleaning(basketProductNumber);
        double basketPriceFirstNumber = priceCleaning(basketPrice);
        waitAndScrollClickElement(upProductInBasket);
        waitScrollElement(basketStringText);
        double basketPriceLastNumber = priceCleaning(basketPrice);
        double productNumberLastNumber = priceCleaning(basketProductNumber);

        if (productNumberFirstNumber < 1) {
            Assert.fail("Sepet boş.");
        }
        if (productNumberLastNumber == 1) {
            if (basketPriceFirstNumber == basketPriceLastNumber) {
                Assert.fail("Sepette ürün sayısı artmadı fiyat arttı");
            }
            Assert.fail("Ürün sayısı artmadı ama fiyat arttı");
        }
        if (productNumberLastNumber > 1 || basketPriceFirstNumber < basketPriceLastNumber) {
            logger.info("Ürün ve ödenecek sepet tutarında artış gösterdi.");
        }
    }

    @Description("Sepetin doğrulanması ve ürün artışı kontrolü.")
    public void checkBasketUpgradeProductNumber() {
        checkBasketPage();
        checkBasketUpProductNumber();

    }

    @Description("Sepetteki ürünün kaldırılması.")
    public void deleteProductInBasket() {
        try {
            waitAndScrollClickElement(productDeleteInBasket);
            logger.info("ürün silme tuşuna basıldı.");
            waitScrollElement(wantToDeleteText);
            waitAndScrollClickElement(wantToDeleteYesBtn);
            waitElement(emptyBasket);
            logger.info("Ürün silindi.");
        }catch (Exception e){
            waitScrollElement(youSureWantDeleteText);
            logger.info("doğrulama yazısı göründü");
            waitAndScrollClickElement(youSureWantDeleteBtn);
            logger.info("sil tuşu tıkladı");
            logger.info("Ürün silindi.");
        }

    }

    @Description("Sepetteki ürünün silinmesi sonrası sepet ürün sayısının düşüşü kontrolü.")
    public void checkBasketDownProductNumber() {

        try {
            waitElement(emptyBasket);
            double productNumber = priceCleaning(basketProductNumber);
            if (!((productNumber < 1))) {
                Assert.fail("Ürün sepetten kaldırılmadı.");
            }
            logger.info("Sepetteki ürün kaldırıldığı doğrulandı.");
        } catch (NumberFormatException ex) {

        }
    }

    @Description("Sepet sayfasının doğrulanması.")
    public void checkBasketPage() {
        waitElement(basketStringText);
        findScrollElementCenter(basketStringText);
        logger.info("Sepet sayfası doğrulandı.");
    }
}

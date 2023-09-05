package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }


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
            logError("ürün sepete eklenmedi.");
            return false;
        }
        logInfo("Ürün sepete eklendi.");
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
            logError("Sepet boş.");
        }
        if (productNumberLastNumber == 1) {
            if (basketPriceFirstNumber == basketPriceLastNumber) {
                logError("Sepette ürün sayısı artmadı fiyat arttı");
            }
            logError("Ürün sayısı artmadı ama fiyat arttı");
        }
        if (productNumberLastNumber > 1 || basketPriceFirstNumber < basketPriceLastNumber) {
            logInfo("Ürün ve ödenecek sepet tutarında artış gösterdi.");
        }
    }

    @Description("Sepetin doğrulanması ve ürün artışı kontrolü.")
    public void checkBasketUpgradeProductNumber() {
        checkBasketPage();
        checkBasketUpProductNumber();

    }

    @Description("Sepetteki ürünün kaldırılması.")
    public void deleteProductInBasket() {
        waitAndScrollClickElement(productDeleteInBasket);
        waitScrollElement(wantToDeleteText);
        waitAndScrollClickElement(wantToDeleteYesBtn);
        waitElement(emptyBasket);
    }

    @Description("Sepetteki ürünün silinmesi sonrası sepet ürün sayısının düşüşü kontrolü.")
    public void checkBasketDownProductNumber() {

        try {
            double productNumber = priceCleaning(basketProductNumber);
            if (!((productNumber < 1))) {
                logError("Ürün sepetten kaldırılmadı.");
            }
        } catch (NumberFormatException ex) {

        }
    }

    @Description("Sepet sayfasının doğrulanması.")
    public void checkBasketPage() {
        waitElement(basketStringText);
        findScrollElementCenter(basketStringText);
    }
}

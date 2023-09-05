package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class PasajAllProductsPage extends BasePage {
    public PasajAllProductsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class=\"m-grid-col-4 product\"]//span[@class=\"m-p-pc__title\"]")
    public List<WebElement> allProductsTitle;
    @FindBy(xpath = "//h1[@class=\"product-list__title text-center\"]")
    public WebElement pageTopCategoryName;
    @FindBy(xpath = "//div[@class=\"m-product-sort\"]//i")
    public WebElement sortDropdownMenu;
    @FindBy(xpath = "//div[@class=\"m-product-sort\"]//label[@for=\"sort-3\"]//span")
    public WebElement sortByHighestPriceChoice;
    @FindBy(xpath = "//div[@class=\"m-product-sort\"]//label[@for=\"sort-2\"]//span")
    public WebElement sortByLowestPriceChoice;
    @FindBy(xpath = "(//div[@class=\"m-p-pc__price m-p-pc__price--primary\"])[28]")
    public WebElement fistProductPrice;
    @FindBy(xpath = "(//div[@class=\"m-p-pc__price m-p-pc__price--primary\"])[29]")
    public WebElement secontProductPrice;
    @FindBy(xpath = "(//div[@class=\"m-p-pc__price m-p-pc__price--primary\"])[30]")
    public WebElement thirdProductPrice;


    @Description("Ürünler arasında rastgele seçilen ürünle gelen ürünün aynı olup olmaamsı.")
    public void selectCheckRandomProduct() {
        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        WebElement product = pasajAllProductsPage.randomProduct();
        String advertName = product.getText();
        pasajAllProductsPage.waitAndScrollClickElement(product);
        String productPageName = productPage.productPageProductName.getText();
        if (!(advertName.equals(productPageName))) {
            Assert.fail("Seçilen ürün ile gelen ürün farklı.");
        }
    }

    @Description("Rastgele ürün seçme.")
    public WebElement randomProduct() {
        List<WebElement> productElements = allProductsTitle;
        int numberOfElements = productElements.size();
        Random rand = new Random();
        int randomIndex = rand.nextInt(numberOfElements);
        WebElement selectedProduct = productElements.get(randomIndex);
        return selectedProduct;
    }

    @Description("En yüksek fiyat sıralama seçeneğini seçer.")
    public void sortByHighestPrice() {
        waitAndScrollClickElement(sortDropdownMenu);
        waitAndScrollClickElement(sortByHighestPriceChoice);
    }

    @Description("En düşük fiyat sıralama seçeneğini seçer.")

    public void sortByLowestPrice() {
        waitAndScrollClickElement(sortDropdownMenu);
        waitAndScrollClickElement(sortByLowestPriceChoice);
    }

    @Description("En düşük fiyat sıralama seçeneğine göre sıralamayı kontrol eder..")
    public void checkProductPriceLowestPriceOrder() {

        double firstprice = priceCleaning(fistProductPrice);
        double secondPrice = priceCleaning(secontProductPrice);
        double thirdPrice = priceCleaning(thirdProductPrice);

        if (!(firstprice < secondPrice || secondPrice < thirdPrice)) {
            logError("Ürünler doğru sıra ile gelmedi.");
        }
    }

    @Description("En yüksek fiyat sıralama seçeneğine göre sıralamayı kontrol eder..")
    public void checkProductPriceHighestPriceOrder() {

        double firstprice = priceCleaning(fistProductPrice);
        double secondPrice = priceCleaning(secontProductPrice);
        double thirdPrice = priceCleaning(thirdProductPrice);

        if (!(firstprice > secondPrice || secondPrice > thirdPrice)) {
            logError("Ürünler doğru sıra ile gelmedi.");
        }
    }


}
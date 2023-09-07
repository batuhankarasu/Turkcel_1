package Pages;

import Base.BasePage;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;

public class PasajAllProductsPage extends BasePage {
    public PasajAllProductsPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = LogManager.getLogger();

    private By highestPriceOrderProductLists = By.xpath("//div[@id='all-devices-section']//div[@class='m-p-pc__foot']");


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
    @FindBy(xpath = "//div[@class='m-accordion__head groupm-container-head']\");")
    public WebElement secondSortDropdownMenu;
    @FindBy(xpath = "//label[@for='sort-3']")
    public WebElement secondSortHighDropdownChoice;
    @FindBy(xpath = "//label[@for='sort-2']")
    public WebElement secondSortLowDropdownChoice;


    @Description("Ürünler arasında rastgele seçilen ürünle gelen ürünün aynı olup olmaamsı.")
    public void selectCheckRandomProduct() {
        PasajAllProductsPage pasajAllProductsPage = new PasajAllProductsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        WebElement product = pasajAllProductsPage.randomProduct();
        logger.info("Random ürün seçildi.");
        String advertName = product.getText();
        pasajAllProductsPage.waitAndScrollClickElement(product);
        logger.info("ürün texti alındı ve tıklandı.");
        String productPageName = productPage.productPageProductName.getText();
        if (!(advertName.equals(productPageName))) {
            Assert.fail("Seçilen ürün ile gelen ürün farklı.");
        }
        logger.info("Seçilen ve gelen ürünün aynı olduğu doğrulandı.");
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
        try {
            waitAndScrollClickElement(sortDropdownMenu);
            waitAndScrollClickElement(sortByHighestPriceChoice);
            logger.info("Ürünler en yüksek fiyat a göre sıralandı.");
        }catch (Exception e){
            waitAndScrollClickElement(secondSortDropdownMenu);
            waitAndScrollClickElement(secondSortHighDropdownChoice);
            logger.info("Ürünler en yüksek fiyat a göre sıralandı.");

        }
    }

    @Description("En düşük fiyat sıralama seçeneğini seçer.")
    public void sortByLowestPrice() {
       try {
           waitAndScrollClickElement(sortDropdownMenu);
           waitAndScrollClickElement(sortByLowestPriceChoice);
           logger.info("Ürünler en düşük fiyat a göre sıralandı.");
       }catch (Exception e){
           waitAndScrollClickElement(secondSortDropdownMenu);
           waitAndScrollClickElement(secondSortLowDropdownChoice);
           logger.info("Ürünler en düşük fiyat a göre sıralandı.");
       }
    }

    @Description("En düşük fiyat sıralama seçeneğine göre sıralamayı kontrol eder..")
    public void checkProductPriceLowestPriceOrder() {

        List<WebElement> lowestPriceOrderProductList = driver.findElements(highestPriceOrderProductLists);
        List<Double> productPrice = new ArrayList<>();
        List<Double> anotherList = new ArrayList<>();

        for (int i = 0; i < lowestPriceOrderProductList.size(); i++) {

            if (lowestPriceOrderProductList.get(i).findElements(By.xpath("./div[@class=\"m-p-pc__price m-p-pc__price--primary\"]//div")).size() == 2) {
                double as = priceLowCleaning(lowestPriceOrderProductList.get(i).findElement(By.xpath(".//div[@class=\"m-p-pc__price m-p-pc__price--dark\"]")));
                productPrice.add(as);
            } else {
                if (lowestPriceOrderProductList.get(i).findElements(By.xpath(".//div")).size() == 2) {
                    double asbc = priceLowCleaning(lowestPriceOrderProductList.get(i).findElement(By.xpath(".//div[@class=\"m-p-pc__price m-p-pc__price--secondary m-p-pc__price--dark\"]")));
                    productPrice.add(asbc);
                } else {

                    double bs = priceLowCleaning(lowestPriceOrderProductList.get(i));
                    productPrice.add(bs);
                }
            }
        }

        System.out.println(productPrice + "\n");
        anotherList.addAll(productPrice);
        Collections.sort(anotherList);
        System.out.println(anotherList + "\n");
        if (!(productPrice.equals(anotherList))) {
            Assert.fail("ürün sırası yanlış");
        }
        logger.info("Ürünlerin sıralaması kontrol edildi ve doğrulandı");
    }



    @Description("En yüksek fiyat sıralama seçeneğine göre sıralamayı kontrol eder..")
    public void checkProductPriceHighestPriceOrder() {

        List<WebElement> highestPriceOrderProductList = driver.findElements(highestPriceOrderProductLists);
        List<Double> productPrice = new ArrayList<>();
        List<Double> anotherList = new ArrayList<>();

        for (int i = 0; i < highestPriceOrderProductList.size(); i++) {

            if (highestPriceOrderProductList.get(i).findElements(By.xpath("./div[@class=\"m-p-pc__price m-p-pc__price--primary\"]//div")).size() == 2) {
                double as = priceCleaning(highestPriceOrderProductList.get(i).findElement(By.xpath(".//div[@class=\"m-p-pc__price m-p-pc__price--dark\"]")));
                productPrice.add(as);
            } else {
                if (highestPriceOrderProductList.get(i).findElements(By.xpath(".//div")).size() == 2) {
                    double asbc = priceCleaning(highestPriceOrderProductList.get(i).findElement(By.xpath(".//div[@class=\"m-p-pc__price m-p-pc__price--secondary m-p-pc__price--dark\"]")));
                    productPrice.add(asbc);
                } else {

                    double bs = priceCleaning(highestPriceOrderProductList.get(i));
                    productPrice.add(bs);
                }
            }
        }

        System.out.println(productPrice + "\n");
        anotherList.addAll(productPrice);
        Collections.sort(anotherList, Collections.reverseOrder());
        System.out.println(anotherList + "\n");
        if (!(productPrice.equals(anotherList))) {
            Assert.fail("ürün sırası yanlış");
        }
        logger.info("Ürünlerin sıralaması kontrol edildi ve doğrulandı");

    }


    public List<Integer> cleanList(List<WebElement> list) {
        List<Integer> cleanList = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            int product = (int) priceCleaning(list.get(i));

            cleanList.add(product / 100);
        }

        return cleanList;
    }


}
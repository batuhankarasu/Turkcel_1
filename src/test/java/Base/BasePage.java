package Base;

import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    Logger logger = LogManager.getLogger();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Description("Element tıklanabilir ve Görünür olanakadar bekler.")
    public void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Description("Element tıklanabilir olanakadar bekler sayfanın ortasına getirir")
    public void waitScrollElement(WebElement webElement) {
        waitElement(webElement);
        findScrollElementCenter(webElement);
    }

    @Description("Elenment görünür olduktan sonra ekran ortasına getirir tıklama işlemi gerçekleştirir.")
    public void waitAndScrollClickElement(WebElement webElement) {
        waitElement(webElement);
        findScrollElementCenter(webElement);
        waitElement(webElement);
        webElement.click();
    }

    @Description("Elemente hover eder.")
    public void hoverElement(WebElement moveElement) {
        Actions action = new Actions(driver);
        waitElement(moveElement);
        action.moveToElement(moveElement).perform();
    }

    @Description("Url doğruluğunu kontrol eder.")
    public void waitExpectedUrl(String url) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(url));
        } catch (Exception e) {
            Assert.fail("Beklenen url açılamadı,Açılan url:" + driver.getCurrentUrl() + " Açılması gereken:" + url);
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }

    @Description("Pencere değişimini.")
    public void windowChange(int tabNo) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNo));
    }

    @Description("Elementin görünürlüğünü kontrol eder.")
    public boolean isElementVisible(WebElement webElement) {
        return webElement.isDisplayed();
    }

    @Description("Yazdırma işlemini gerçekleştirir.")
    public void sendStringKeys(WebElement stringarea, String string) {
        stringarea.sendKeys(string);
    }

    @Description("Elemente scroll eder.")
    public void scroolElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView();", webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Description("Elemnti ekran ortasına getirir.")
    public void findScrollElementCenter(WebElement webElement) {
        try {
            String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;"
                    + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
            ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, webElement);
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {

            Assert.fail(webElement + " scroll edilirken problem oluştu.");
        }
    }

    @Description("Ürün fiyatıındaki işaretleri kaldırı.")
    public double priceCleaning(WebElement webElement) {

        String price = webElement.getText();
        String cleanPrice = extractNumbers(price);
        double integerPrice = Integer.parseInt(cleanPrice);

        return integerPrice;
    }

    @Description("Bir ifadedeki syıları ayırır.")
    public String extractNumbers(String string) {

        StringBuilder numbers = new StringBuilder();

        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.append(c);
            }
        }

        return numbers.toString();
    }


    @Description("Log fonksiyomları")
    public void logTrace(String string) {
        logger.trace(string);
    }

    public void logDebug(String string) {
        logger.debug(string);
    }

    public void logInfo(String string) {
        logger.info(string);
    }

    public void logWarn(String string) {
        logger.warn(string);
    }

    public void logError(String string) {
        logger.error(string);
        Assert.fail(string);
    }

    public void logFatal(String string) {
        logger.fatal(string);
    }


}
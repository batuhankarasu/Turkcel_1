package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.Console;


public class DriverMethods {
    protected WebDriver driver;

    @BeforeMethod
    public void getDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--window-size=1920x1080");
        //chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.turkcell.com.tr/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}

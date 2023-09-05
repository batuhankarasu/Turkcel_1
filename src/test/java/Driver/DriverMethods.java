package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class DriverMethods {
    protected WebDriver driver;

    @BeforeMethod
    public void getDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.turkcell.com.tr/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}

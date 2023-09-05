package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasajHomePage extends BasePage {
    public PasajHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-target=\"2cf6b2ed-1c6f-4686-9e27-cda01a613fd8\"]")
    public WebElement elektrikliEvAletleriCategory;
    @FindBy(xpath = "//a[@data-target=\"40a3f352-9445-40af-a96c-19042264c27b\"]")
    public WebElement computerTapbletCategory;


}


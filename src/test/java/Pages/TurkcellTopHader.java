package Pages;

import Base.BasePage;
import Base.BaseVariable;
import jdk.jfr.Description;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TurkcellTopHader extends BasePage {
    public TurkcellTopHader(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id=\"search-header\"]")
    public WebElement searchHeader;
    @FindBy(xpath = "//a[@class=\"a-btn-icon js-search m-r-0\"]")
    public WebElement searchBtn;
    @FindBy(xpath = "//a[@href=\"/pasaj?place=menu\"]")
    public WebElement pasajDropMenu;
    @FindBy(xpath = "//a[@title=\"Bilgisayar & Tablet\"]")
    public WebElement dropDownComputerTablet;
    @FindBy(xpath = "//a[@class=\"a-btn-icon js-login\"]")
    public WebElement accountBtn;
    @FindBy(xpath = "//a[@class=\"a-btn a-btn--full a-btn--white js-fast-login-btn a-btn--fast-login\"]")
    public WebElement fastLoginBtn;


    @Description("Turkcel page fastlogin page açılım.")
    public void fastLoginPageOpen() {
        waitAndScrollClickElement(accountBtn);
        waitAndScrollClickElement(fastLoginBtn);
    }

    @Description("Turkcell page arama sayfası.")
    public void search() {
        BaseVariable baseVariable = new BaseVariable(driver);
        try {
            waitAndScrollClickElement(searchBtn);
            waitAndScrollClickElement(searchHeader);
            logInfo("Aramaq butonu ve arama alanına tıklandı.");
            searchHeader.sendKeys(baseVariable.searchingString);
            searchHeader.sendKeys(Keys.ENTER);
            logInfo("Aranacak öge sendKeys edildi ve enter tuşuna basıldı.");

        } catch (ElementNotInteractableException e) {
            logFatal(" Arama alanına text gönderirken sıkıntı oluştu. ");
        }
    }

    @Description("Kategori seçilir.")
    public void selectCategory() {
        try {
            hoverElement(pasajDropMenu);
            logInfo("Drop menü üzerine hover edildi.");
            waitAndScrollClickElement(dropDownComputerTablet);
            logInfo("Kategori seçildi.");

        } catch (Exception e) {
            logError("Category seçilirken hata oluştu.");
        }
    }

}

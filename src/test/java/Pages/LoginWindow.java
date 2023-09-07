package Pages;

import Base.BasePage;
import Base.BaseVariable;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWindow extends BasePage {
    public LoginWindow(WebDriver driver) {
        super(driver);
    }
    Logger logger = LogManager.getLogger();


    @FindBy(xpath = "(//div[@class=\"checkbox\"]/label[@for=\"loginWithPassword\"])[1]")
    public WebElement fastLoginCheckBox;
    @FindBy(xpath = "//input[@id=\"phoneNo\"]")
    public WebElement loginWindowPhoneNumArea;
    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement loginWindowPasswordArea;
    @FindBy(xpath = "//div[@class=\"main-body-container\"]//button[@class=\"btn\"]")
    public WebElement loginWindowEntryBtn;
    @FindBy(xpath = "//h2[text()=\"Lütfen Hızlı Giriş şifrenizi girin\"]")
    public WebElement pleaseEnterPaswordText;
    @FindBy(id = "password-login-forward-button")
    public WebElement devambtn;



    @Description("Fastlogin page doldurma.")
    public void fastLoginPageInformationRefill() {
        BaseVariable baseVariable = new BaseVariable(driver);
        windowChange(1);
        waitAndScrollClickElement(fastLoginCheckBox);
        logger.info("Fast Login check box tıklandı.");

        waitAndScrollClickElement(loginWindowPhoneNumArea);
        sendStringKeys(loginWindowPhoneNumArea, baseVariable.cellNumber);
        logger.info("Telefon numarası doğru bir şekilde girildi");
        waitAndScrollClickElement(loginWindowEntryBtn);
        logger.info("Enter tuşuna basıldı");

        waitElement(pleaseEnterPaswordText);
        waitAndScrollClickElement(loginWindowPasswordArea);
        sendStringKeys(loginWindowPasswordArea, baseVariable.password);
        logger.info("Password doğru bir şekilde girildi.");
        waitAndScrollClickElement(devambtn);
        logger.info("Devam butonuna tıklandı");
        windowChange(0);
        logger.info("Giriş yapıldı");



    }

}

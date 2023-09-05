package Pages;

import Base.BasePage;
import Base.BaseVariable;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWindow extends BasePage {
    public LoginWindow(WebDriver driver) {
        super(driver);
    }


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
    @FindBy(xpath = "//button[@class=\"fancybox-button fancybox-close-small\"]")
    public WebElement fastLoginAfterPopUp;


    @Description("Fastlogin page doldurma.")
    public void fastLoginPageInformationRefill() {
        BaseVariable baseVariable = new BaseVariable(driver);
        windowChange(1);
        waitAndScrollClickElement(fastLoginCheckBox);
        logInfo("Fast Login check box tıklandı.");

        waitAndScrollClickElement(loginWindowPhoneNumArea);
        sendStringKeys(loginWindowPhoneNumArea, baseVariable.cellNumber);
        logInfo("Telefon numarası doğru bir şekilde girildi");
        waitAndScrollClickElement(loginWindowEntryBtn);
        logInfo("Enter tuşuna basıldı");

        waitElement(pleaseEnterPaswordText);
        waitAndScrollClickElement(loginWindowPasswordArea);
        sendStringKeys(loginWindowPasswordArea, baseVariable.password);
        logInfo("Password doğru bir şekilde girildi.");
        waitAndScrollClickElement(devambtn);
        logInfo("Devam butonuna tıklandı");
        windowChange(0);

    }

}

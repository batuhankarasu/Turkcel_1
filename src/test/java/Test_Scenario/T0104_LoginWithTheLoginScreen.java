package Test_Scenario;

import Driver.DriverMethods;
import Pages.LoginWindow;
import Pages.TurkcellTopHader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class T0104_LoginWithTheLoginScreen extends DriverMethods {


    @Test(priority = 4,description = "Kullanıcının giriş yapması.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fast login seçeneğil ile giriş yapılması.")
    @Story("Turkcel web adresine git. Hesap butonuna ve fast login butonuna tıkla. Telefon nuımarasını gir. Fast login checkbox tıkla. Devan butonuan tıkla. Pasword gir. Devan butonuan tıkla.")
    public void loginWithTheLoginScreenTest() {


        TurkcellTopHader turkcellTopHader = new TurkcellTopHader(driver);
        LoginWindow loginWindow = new LoginWindow(driver);

        turkcellTopHader.fastLoginPageOpen();
        loginWindow.fastLoginPageInformationRefill();


    }
}

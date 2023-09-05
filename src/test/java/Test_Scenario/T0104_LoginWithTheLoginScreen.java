package Test_Scenario;

import Driver.DriverMethods;
import Pages.LoginWindow;
import Pages.TurkcellTopHader;
import org.testng.annotations.Test;

public class T0104_LoginWithTheLoginScreen extends DriverMethods {


    @Test
    public void loginWithTheLoginScreenTest() {
        TurkcellTopHader turkcellTopHader = new TurkcellTopHader(driver);
        LoginWindow loginWindow = new LoginWindow(driver);

        turkcellTopHader.fastLoginPageOpen();
        loginWindow.fastLoginPageInformationRefill();


    }
}

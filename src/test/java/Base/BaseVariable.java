package Base;

import org.openqa.selenium.WebDriver;

public class BaseVariable extends BasePage {
    public BaseVariable(WebDriver driver) {
        super(driver);
    }

    public String cellNumber = "5396576472";
    public String password = "147741aS@";
    public String searchingString = "süpürge";
    public String computerTabletUrl ="https://www.turkcell.com.tr/pasaj/bilgisayar-tablet?place=menu";
}

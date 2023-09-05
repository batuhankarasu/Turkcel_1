package Base;

import org.openqa.selenium.WebDriver;

public class BaseVariable extends BasePage {
    public BaseVariable(WebDriver driver) {
        super(driver);
    }

    public String cellNumber = "5355500531";
    public String password = "Test2022";
    public String searchingString = "süpürge";
}

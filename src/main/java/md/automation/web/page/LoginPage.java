package md.automation.web.page;

import md.automation.core.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement inputUsername;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-btn")
    private WebElement buttonLogin;

    @FindBy(id = "home-page")
    private WebElement homeIdentifier;
}

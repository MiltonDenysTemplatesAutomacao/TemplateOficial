package md.automation.web.page;

import lombok.Getter;
import md.automation.core.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement inputUsername;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    @FindBy(id = "menu_button_container")
    private WebElement swagLabs;
}

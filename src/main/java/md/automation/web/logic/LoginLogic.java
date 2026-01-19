package md.automation.web.logic;

import md.automation.core.actions.web.WebActions;
import md.automation.core.config.EnvironmentConfig;
import md.automation.core.logs.LogManager;
import md.automation.core.utils.ExtentScenarioContext;
import md.automation.web.page.LoginPage;
import org.slf4j.Logger;

import static md.automation.core.drivers.DriverManager.getDriver;

public class LoginLogic {

    private final LoginPage page;

    private static final Logger log =
            LogManager.getWebLogger(LoginLogic.class);

    public LoginLogic() {
        this.page = new LoginPage();
    }

    public void accessLoginPage() {
        String url = EnvironmentConfig.get("web.base.url");

        log.info("Accessing login page: {}", url);
        ExtentScenarioContext.get()
                .info("Accessing login page: " + url);

        getDriver().get(url);
    }

    public void performValidLogin() {
        log.info("Performing login with valid credentials");
        ExtentScenarioContext.get()
                .info("Performing login with valid credentials");

        WebActions.insertText(
                page.getInputUsername(),
                EnvironmentConfig.get("web.user")
        );

        WebActions.insertText(
                page.getInputPassword(),
                EnvironmentConfig.get("web.password")
        );

        WebActions.click(page.getButtonLogin());
    }

    public void validateHomePage() {
        log.info("Validating home page");
        ExtentScenarioContext.get()
                .info("Validating home page");

        if (!WebActions.isVisible(page.getSwagLabs())) {
            throw new AssertionError(
                    "Home page was not displayed correctly (Swag Labs not visible)"
            );
        }
    }
}

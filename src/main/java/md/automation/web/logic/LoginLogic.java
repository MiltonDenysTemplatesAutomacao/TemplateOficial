package md.automation.web.logic;

import md.automation.core.actions.web.WebActions;
import md.automation.core.config.EnvironmentConfig;
import md.automation.core.logs.LogManager;
import md.automation.web.page.LoginPage;
import org.slf4j.Logger;


import static md.automation.core.drivers.DriverManager.getDriver;

public class LoginLogic {
    private LoginPage page;

    public LoginLogic(){
        page = new LoginPage();
    }
    private static final Logger log =
            LogManager.getWebLogger(LoginLogic.class);


    public void accessLoginPage() {
        String url = EnvironmentConfig.get("web.base.url");
        log.info("Acessando página de login: {}", url);

        // Navegação ainda pode ficar na Logic
        getDriver().get(url);
    }

    public void performValidLogin() {
        log.info("Realizando login com credenciais válidas");
        WebActions.insertText(page.getInputUsername(),EnvironmentConfig.get("web.user"));

        WebActions.insertText(page.getInputPassword(),EnvironmentConfig.get("web.password")
        );

        WebActions.click(page.getButtonLogin());
    }

    public void validateHomePage() {
        log.info("Validando página inicial");

        if (!WebActions.isVisible(page.getSwagLabs())) {
            throw new AssertionError("Swag Labs não foi exibido na Home Page");
        }
    }
}

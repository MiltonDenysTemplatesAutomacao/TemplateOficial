package md.automation.core.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import md.automation.core.drivers.DriverManager;
import md.automation.core.drivers.WebDriverFactory;
import md.automation.core.logs.LogManager;
import org.slf4j.Logger;
import org.slf4j.MDC;

public class CucumberHooks {

    private static final Logger log =
            LogManager.getFrameworkLogger(CucumberHooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        MDC.put("scenario", scenario.getName());
        log.info("Iniciando cenário");

        // 🚫 NÃO cria driver para cenários de API
        if (scenario.getSourceTagNames().contains("@rest")) {
            log.info("Cenário de API detectado - WebDriver NÃO será inicializado");
            return;
        }
        DriverManager.setDriver(WebDriverFactory.create());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("Cenário falhou");
        }

        // 🚫 NÃO tenta fechar driver em API
        if (!scenario.getSourceTagNames().contains("@rest")) {
            DriverManager.quitDriver();
        }

        DriverManager.quitDriver();
        MDC.clear();
        log.info("Finalizando cenário");
    }
}

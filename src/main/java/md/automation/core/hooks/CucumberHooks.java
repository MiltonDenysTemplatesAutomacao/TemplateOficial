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

        DriverManager.setDriver(WebDriverFactory.create());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("Cenário falhou");
        }

        DriverManager.quitDriver();
        MDC.clear();
        log.info("Finalizando cenário");
    }
}

package md.automation.core.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import md.automation.core.drivers.DriverManager;
import md.automation.core.drivers.WebDriverFactory;
import md.automation.core.logs.LogManager;
import md.automation.core.utils.ExtentManager;
import md.automation.core.utils.ExtentScenarioContext;
import md.automation.core.utils.ScreenshotUtils;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    private static final Logger log =
            LogManager.getFrameworkLogger(CucumberHooks.class);

    private static final ExtentReports extent =
            ExtentManager.getInstance();

    @Before
    public void beforeScenario(Scenario scenario) {

        MDC.put("scenario", scenario.getName());
        log.info("Starting scenario");

        ExtentTest test =
                extent.createTest(scenario.getName());

        ExtentScenarioContext.set(test);

        if (scenario.getSourceTagNames().contains("@rest")) {
            log.info("API scenario detected - WebDriver will NOT be initialized");
            test.info("API scenario");
            return;
        }

        if (scenario.getSourceTagNames().contains("@web")) {
            DriverManager.setDriver(WebDriverFactory.create());
            test.info("WebDriver initialized");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {

        ExtentTest test = ExtentScenarioContext.get();
        boolean isWebScenario =
                scenario.getSourceTagNames().contains("@web");

        if (scenario.isFailed()) {
            log.error("Scenario failed");
            test.fail("Scenario failed");

            if (isWebScenario) {

                WebDriver driver = DriverManager.getDriver();

                if (driver != null) {
                    String path = ScreenshotUtils.capture(
                            driver,
                            scenario.getName()
                    );
                    test.addScreenCaptureFromPath(path);
                } else {
                    test.warning("WebDriver was null. Screenshot not taken.");
                }
            }
        } else {
            log.info("Scenario executed successfully");
            test.pass("Scenario executed successfully");
        }

        if (isWebScenario && DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
            test.info("WebDriver finalized");
        }

        ExtentScenarioContext.remove();
        MDC.clear();
    }
}

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

        DriverManager.setDriver(WebDriverFactory.create());
        test.info("WebDriver initialized");
    }

    @After
    public void afterScenario(Scenario scenario) {

        ExtentTest test = ExtentScenarioContext.get();

        if (scenario.isFailed()) {
            log.error("Scenario failed");
            test.fail("Scenario failed");

            boolean isWebScenario =
                    !scenario.getSourceTagNames().contains("@rest");

            if (isWebScenario && DriverManager.getDriver() != null) {

                String path = ScreenshotUtils.capture(
                        DriverManager.getDriver(),
                        scenario.getName() + "_" + System.currentTimeMillis()
                );

                test.addScreenCaptureFromPath(path);
            }
        } else {
            log.info("Scenario executed successfully");
            test.pass("Scenario executed successfully");
        }

        if (!scenario.getSourceTagNames().contains("@rest")
                && DriverManager.getDriver() != null) {

            DriverManager.quitDriver();
            test.info("WebDriver finalized");
        }
    }
}
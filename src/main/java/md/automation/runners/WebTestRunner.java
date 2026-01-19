package md.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import md.automation.core.utils.ExtentManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/web",
        glue = {
                "md.automation.web",
                "md.automation.core.hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report/web-report.html"
        },
        tags = "@web",
        monochrome = true
)
public class WebTestRunner {
        @AfterClass
        public static void finalizarRelatorio() {
                ExtentManager.getInstance().flush();
        }
}

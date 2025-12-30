package md.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/web",
        glue = {
                "md.automation.web",
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report/web-report.html"
        },
        tags = "@web",
        monochrome = true
)
public class WebTestRunner {
}

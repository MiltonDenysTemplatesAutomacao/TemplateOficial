package md.automation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/api",
        glue = {
                "md.automation.api",
                "md.automation.core.hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report/rest-report.html"
        },
        tags = "@getBooking",
        monochrome = true
)

public class RestTestRunner {
}

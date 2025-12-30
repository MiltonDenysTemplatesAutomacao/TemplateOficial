package md.automation.core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver create() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Browser não suportado: " + browser);
        }
    }
}

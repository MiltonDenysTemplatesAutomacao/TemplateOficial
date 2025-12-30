package md.automation.core.utils;

import md.automation.core.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait wait(int seconds) {
        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(seconds)
        );
    }

    /* =========================
       BY
       ========================= */

    public static void waitForVisible(By locator, int seconds) {
        wait(seconds)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForClickable(By locator, int seconds) {
        wait(seconds)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    /* =========================
       WEBELEMENT
       ========================= */

    public static void waitForVisible(WebElement element, int seconds) {
        wait(seconds)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebElement element, int seconds) {
        wait(seconds)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}

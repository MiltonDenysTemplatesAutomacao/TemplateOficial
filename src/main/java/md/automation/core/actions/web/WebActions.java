package md.automation.core.actions.web;

import md.automation.core.utils.WaitUtils;
import org.openqa.selenium.WebElement;

public class WebActions {

    private static final int DEFAULT_TIMEOUT = 10;

    public static void click(WebElement element) {
        WaitUtils.waitForClickable(element, DEFAULT_TIMEOUT);
        element.click();
    }

    public static void insertText(WebElement element, String text) {
        WaitUtils.waitForVisible(element, DEFAULT_TIMEOUT);
        element.clear();
        element.sendKeys(text);
    }

    public static boolean isVisible(WebElement element) {
        try {
            WaitUtils.waitForVisible(element, DEFAULT_TIMEOUT);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

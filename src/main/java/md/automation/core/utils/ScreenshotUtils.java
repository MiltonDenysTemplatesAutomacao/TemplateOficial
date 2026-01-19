package md.automation.core.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    private static final String SCREENSHOT_DIR =
            System.getProperty("user.dir")
                    + File.separator
                    + "target"
                    + File.separator
                    + "screenshots";

    public static String capture(WebDriver driver, String name) {

        if (driver == null) {
            throw new IllegalStateException("WebDriver is null. Screenshot not possible.");
        }

        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String fileName =
                    name.replaceAll("[^a-zA-Z0-9]", "_")
                            + "_"
                            + System.currentTimeMillis()
                            + ".png";

            File dest = new File(SCREENSHOT_DIR, fileName);

            FileUtils.forceMkdir(dest.getParentFile());
            FileUtils.copyFile(src, dest);

            return dest.getAbsolutePath();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error while capturing screenshot", e
            );
        }
    }
}

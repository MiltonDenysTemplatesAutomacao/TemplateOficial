package md.automation.core.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentScenarioContext {

    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    public static void set(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest get() {
        return extentTest.get();
    }

    public static void remove() {
        extentTest.remove();
    }
}

package md.automation.core.logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {

    public static Logger getFrameworkLogger(Class<?> clazz) {
        return LoggerFactory.getLogger("FRAMEWORK." + clazz.getSimpleName());
    }

    public static Logger getWebLogger(Class<?> clazz) {
        return LoggerFactory.getLogger("WEB." + clazz.getSimpleName());
    }

    public static Logger getMobileLogger(Class<?> clazz) {
        return LoggerFactory.getLogger("MOBILE." + clazz.getSimpleName());
    }

    public static Logger getApiLogger(Class<?> clazz) {
        return LoggerFactory.getLogger("API." + clazz.getSimpleName());
    }
}

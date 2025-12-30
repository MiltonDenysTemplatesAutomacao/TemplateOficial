package md.automation.core.config;

import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfig {
    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "dev");
        String fileName = "environments/" + env + ".properties";

        try (InputStream is =
                     EnvironmentConfig.class
                             .getClassLoader()
                             .getResourceAsStream(fileName)) {

            if (is == null) {
                throw new RuntimeException("Arquivo de ambiente não encontrado: " + fileName);
            }
            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar configurações", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}

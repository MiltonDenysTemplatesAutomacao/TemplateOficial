package md.automation.core.config;

import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     EnvironmentConfig.class
                             .getClassLoader()
                             .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("Arquivo application.properties não encontrado");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar configurações", e);
        }
    }

    private EnvironmentConfig() {
        // evita instância
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

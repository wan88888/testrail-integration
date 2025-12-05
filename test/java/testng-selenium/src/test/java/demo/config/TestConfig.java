package demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Test configuration loader that reads properties from test-config.properties
 */
public final class TestConfig {
    
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "test-config.properties";
    
    static {
        loadProperties();
    }
    
    private TestConfig() {
        // Utility class, prevent instantiation
    }
    
    private static void loadProperties() {
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading " + CONFIG_FILE, e);
        }
    }
    
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }
    
    public static String getStandardUsername() {
        return properties.getProperty("standard.user.username");
    }
    
    public static String getStandardPassword() {
        return properties.getProperty("standard.user.password");
    }
    
    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("browser.headless", "true"));
    }
    
    public static int getWindowWidth() {
        return Integer.parseInt(properties.getProperty("browser.window.width", "1920"));
    }
    
    public static int getWindowHeight() {
        return Integer.parseInt(properties.getProperty("browser.window.height", "1080"));
    }
    
    public static int getImplicitTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.implicit", "3"));
    }
    
    public static int getExplicitTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.explicit", "10"));
    }
    
    public static int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.page.load", "30"));
    }
}


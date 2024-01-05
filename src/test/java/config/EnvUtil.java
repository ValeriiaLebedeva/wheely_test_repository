package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class EnvUtil {

    public static EnvConfig envConfig = ConfigFactory.create(EnvConfig.class, System.getProperties());

    public static void configure() {

        Configuration.browser = envConfig.browser();
        Configuration.baseUrl = envConfig.baseUrl();
        Configuration.browserVersion = envConfig.browserVersion();
        Configuration.browserSize = envConfig.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

    }
}

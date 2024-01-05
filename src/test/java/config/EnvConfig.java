package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/env.properties"})

public interface EnvConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://wheely.com/en")
    String baseUrl();

    @Key("browserVersion")
    @DefaultValue("120")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();
}

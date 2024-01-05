package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/selenoid.properties"})

public interface SelenoidConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("url")
    String url();

    @Key("videoStorage")
    String videoStorage();
}


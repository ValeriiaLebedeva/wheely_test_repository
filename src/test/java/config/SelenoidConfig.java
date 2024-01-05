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


// при локальном запуске должны запускаться тесты на хроме одной версии
// на дженкинсе другой

// чекнуть, используются ли параметры из дженкинса или прокидываются параметры из пропертис файла
// сделать временный файл с конфигом селеноида с спрятать его

// рид ми
// интеграция с джирой

//
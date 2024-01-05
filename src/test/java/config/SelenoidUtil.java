package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

import static java.lang.String.format;

public class SelenoidUtil {

    public static SelenoidConfig selenoidConfig =
            ConfigFactory.create(SelenoidConfig.class, System.getProperties());


    public static void configure() {

        String url = selenoidConfig.url();
        String login = selenoidConfig.login();
        String password = selenoidConfig.password();
        String urlRemote = format("https://%s:%s@%s", login, password, url);
        Configuration.remote = urlRemote;

    }

    public String getVideoStorageUrl() {
        return selenoidConfig.videoStorage();
    }
}

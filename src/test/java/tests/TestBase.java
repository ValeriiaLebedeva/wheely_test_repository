package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CitiesAndClassesPage;

import java.util.Map;

import static java.lang.String.format;

public class TestBase {

    CitiesAndClassesPage citiesAndClassesPage = new CitiesAndClassesPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://wheely.com/en";
        String value = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
    //    Configuration.browserVersion = "100.0";
    //    Configuration.browserSize = "1920x1080";
        String urlRemote = format("https://user1:1234@%s", value);
        Configuration.remote = urlRemote;
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Page screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

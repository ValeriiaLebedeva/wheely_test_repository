package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.EnvUtil;
import config.SelenoidConfig;
import config.SelenoidUtil;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.CitiesAndClassesPage;


public class TestBase {

    CitiesAndClassesPage citiesAndClassesPage = new CitiesAndClassesPage();

    @BeforeAll
    static void beforeAll() {
        SelenoidUtil.configure();
        EnvUtil.configure();
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
        Attach.addVideo(SelenoidUtil.selenoidConfig.videoStorage());
    }
}

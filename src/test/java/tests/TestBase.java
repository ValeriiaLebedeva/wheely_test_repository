package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import pages.CitiesAndClassesPage;

public class TestBase {

    CitiesAndClassesPage citiesAndClassesPage = new CitiesAndClassesPage();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://wheely.com/en";
    }
}

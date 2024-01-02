package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CitiesAndClassesVerifyTitleTest extends TestBase {

    @Test
    @DisplayName("The Cities & Classes page has the expected title text - EN locale")
    void citiesAndClassesVerifyTitle() {

        step("Open the Cities & Classes page - EN locale", () -> {
            citiesAndClassesPage.openPage();
        });

        step("The Cities & Classes page has the expected title text - EN locale", () -> {
            citiesAndClassesPage.verifyTitleText();
        });

    }
}

package tests;

import data.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ChauffeurCalloutFormChangesSelectedCItyWithLocaleTest extends TestBase {

    static Stream<Arguments> dataProvider() {

        return Stream.of(
                Arguments.of(Locale.Русский, "Мoсква"),
                Arguments.of(Locale.English, "London"),
                Arguments.of(Locale.Français, "Paris")
        );
    }


    @MethodSource("dataProvider")
    @ParameterizedTest(name = "{1} - {0}")
    @DisplayName("The callout form shows selected city for the locale.")
    void chauffeurCalloutFormChangesSelectedCItyWithLocale (Locale locale, String city) {

        step("Open chauffeur page - EN locale ", () -> {
            open("/chauffeur");
        });

        step("Select the locale from the Language selector in the footer.", () -> {
            $("[class*=LanguageSelect_select]").selectOption(locale.name());
        });

        step ("The callout form shows expected selected city corresponds to selected locale.", () -> {
            String str = $("[name=city]").getSelectedOptionText();
            Assertions.assertEquals(city, str);
        });

    }
}

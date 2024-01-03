package tests;

import com.codeborne.selenide.CollectionCondition;
import data.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BarNavMenuChangesWithLocaleTest extends TestBase {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(Locale.Русский, List.of("Возможности", "Membership", "Водители", "Города и классы", "Для бизнеса")),
                Arguments.of(Locale.English, List.of("Essentials", "Membership", "Chauffeurs", "Cities & Classes", "Corporate")),
                Arguments.of(Locale.Français, List.of("Essentiels", "Statut de membre", "Chauffeurs", "Villes & Catégories", "Entreprise"))
        );
    }


    @MethodSource("dataProvider")
    @ParameterizedTest(name = "{1} - {0}")
    @DisplayName("The nav bar menu shows btns for the locale.")
    void barNavigationMenuChangesWithLocaleChangeTest(Locale locale, List<String> expectedButtons) {

        step("Open https://wheely.com/en page", () -> {
            open("https://wheely.com/en");
        });

        step("Select the locale from the Language selector in the footer.", () -> {
            $("[class*=LanguageSelect_select]").selectOption(locale.name());
        });

        step ("The navigation bar menu shows buttons for the locale.", () -> {
            $$("[class*=Bar_navigationList]" +  " > *").shouldHave(CollectionCondition.texts(expectedButtons));
        });

    }
}

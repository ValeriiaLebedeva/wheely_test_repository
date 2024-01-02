package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CitiesAndClassesCitiesListEnTest extends TestBase {

    @Test
    @DisplayName("The 'Cities & Classes' page has the expected list of cities for the EN locale.")
    void citiesListEnTest(){

        step("Open the Cities & Classes page - EN locale", () -> {
            citiesAndClassesPage.openPage();
        });

        step("The 'Cities & Classes' page has the expected list of cities for the EN locale.", () -> {
            citiesAndClassesPage.verifyCitiesListEn();
        });

    }
}

package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.FileUtil;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CitiesAndClassesPage {

    String content = FileUtil.readFileContent("src/test/resources/CitiesAndClassesLeadText.txt");

    String URL_PART = "/cities-and-classes";

    String TITLE_TEXT = "Cities & Classes";

    String LEAD_TEXT = "Wheely chauffeurs exclusively drive premium vehicles, each unmarked and discreet for your privacy. Each Wheely fare class provides exquisite comfort, allowing you to relax and focus on what matters to you.";

    List<String> expectedCitiesEn = List.of(
            "London",
            "Paris",
            "Dubai",
            "Moscow",
            "Saint Petersburg");


    SelenideElement title = $("[class*=Text_title]");

    SelenideElement leadText = $("[data-block-type=text]");

    ElementsCollection citiesList = $$("[class*=CitiesAndClasses_column] a").
            filterBy(Condition.attribute("data-test","city-link"));


    // actions

    public CitiesAndClassesPage openPage(){
        open(URL_PART);
        return this;
    }

    public CitiesAndClassesPage verifyTitleText() {
        title.shouldBe(Condition.visible);
        title.shouldHave(Condition.text(TITLE_TEXT));
        return this;
    }

    public CitiesAndClassesPage verifyLeadText() {
        leadText.shouldBe(Condition.visible);
        leadText.shouldHave(Condition.text(LEAD_TEXT));
        return this;
    }

    public CitiesAndClassesPage verifyCitiesListEn() {
        citiesList.shouldHave(CollectionCondition.texts(expectedCitiesEn));
        return this;
    }


    public CitiesAndClassesPage verifyLeadTextFromFile() {
        leadText.shouldBe(Condition.visible);
        leadText.shouldHave(Condition.text(content));
        return this;
    }

}

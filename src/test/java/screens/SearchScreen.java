package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class SearchScreen {

    private final SelenideElement searchButton = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Открыть поиск")
    public SearchScreen openSearch() {
        searchButton.click();
        return this;
    }

    @Step("Ввести поисковый запрос: {query}")
    public SearchScreen enterSearchQuery(String query) {
        searchInput.sendKeys(query);
        return this;
    }

    @Step("Проверить, что найдены результаты")
    public SearchScreen verifyResultsFound() {
        searchResults.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открыть первую статью из результатов")
    public void openFirstArticle() {
        searchResults.first().click();
    }
}
package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchAndroidTests extends TestBase {

    @Test
    void successfulAppiumSearchTest() {
        step("Search Appium", () -> {
            searchScreen
                    .openSearch()
                    .enterSearchQuery("Appium")
                    .verifyResultsFound();
        });
    }

    @Test
    void successfulGithubSearchTest() {
        step("Search GitHub", () -> {
            searchScreen
                    .openSearch()
                    .enterSearchQuery("GitHub")
                    .verifyResultsFound();
        });

        step("Open the first article", () -> {
            searchScreen.openFirstArticle();
        });
    }
}
package tests;

import org.junit.jupiter.api.Test;
import screens.ArticleScreen;

import static io.qameta.allure.Allure.step;

public class SearchAndroidTests extends TestBase {

    @Test
    void successfulAppiumSearchTest() {
        step("Поиск Appium", () -> {
            searchScreen
                    .openSearch()
                    .enterSearchQuery("Appium")
                    .verifyResultsFound();
        });
    }

    @Test
    void successfulGithubSearchTest() {
        step("Поиск GitHub", () -> {
            searchScreen
                    .openSearch()
                    .enterSearchQuery("GitHub")
                    .verifyResultsFound();
        });

        step("Открыть первую статью", () -> {
            searchScreen.openFirstArticle();
        });

        step("Проверить, что статья открыта", () -> {
            ArticleScreen articleScreen = new ArticleScreen();
            articleScreen.verifyArticleOpened();
        });
    }
}
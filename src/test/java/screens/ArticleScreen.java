package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleScreen {
    
    private final SelenideElement articleTitle = $(id("org.wikipedia.alpha:id/view_article_header_text"));
    private final SelenideElement articleContent = $(id("org.wikipedia.alpha:id/contents"));
    
    @Step("Проверить, что статья открыта")
    public ArticleScreen verifyArticleOpened() {
        articleTitle.shouldBe(visible);
        articleContent.shouldBe(visible);
        return this;
    }
    
    @Step("Получить заголовок статьи")
    public String getArticleTitle() {
        return articleTitle.getText();
    }
}
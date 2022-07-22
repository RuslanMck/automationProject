package ui.selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;
import pages.selenide.SelenideHomePage;

import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    private void checkUrl(String URL){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,URL);
    }

    @Test
    public void userShouldSearch(){

        Configuration.holdBrowserOpen = true;
        Configuration.savePageSource = false;
        open("https://google.com");

        //we can use WebDriver inside the Selenide
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();

//        SelenideElement cookieButton = $("[class='QS5gu sy4vM']");
//        cookieButton.shouldBe(Condition.visible).click();

        GoogleHomePage googleHomePage = new GoogleHomePage();
//        googleHomePage.waitUntilSearchFieldVisible();
//        googleHomePage.setSearchText("Selenide");
//        googleHomePage.pressEnter();

        /* использование паттерна chain of invocations. Не нужно постоянно использовать обьект класса googleHomePage.
        Для этого методы возвращают GoogleHomePage (return this;) **/
        googleHomePage.acceptCookies()
                .waitUntilSearchFieldVisible()
                .setSearchText("Selenide")
                .pressEnter();


//        SelenideElement searchField = $("[name='q']");
//        searchField.shouldBe(Condition.visible)
//                .setValue("Selenide")
//                .pressEnter();
//
        $$(By.xpath("//h3[contains(text(), 'Selenide')]"))
                .shouldHave(CollectionCondition.sizeGreaterThan(7))
                .get(0)
                .click();

        SelenideHomePage selenideHomePage = new SelenideHomePage();

        checkUrl("https://selenide.org/");

        $("[id='selenide-logo']")
                .shouldBe(Condition.visible);

        $(".donate_header")
                .shouldHave(Condition.text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));

        selenideHomePage.clickBlog();

        checkUrl("https://selenide.org/blog.html");

        $(".blog").shouldBe(Condition.visible);

        $(By.xpath("//h3"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Selenide blog"));
    }
}

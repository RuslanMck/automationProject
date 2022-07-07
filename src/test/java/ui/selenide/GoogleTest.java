package ui.selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;

import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    @Test
    public void userShouldSearch(){

        Configuration.holdBrowserOpen = true;
        Configuration.savePageSource = false;
        open("https://google.com");

        //we can use WebDriver inside the Selenide
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();

        SelenideElement cookieButton = $("[class='QS5gu sy4vM']");
        cookieButton.shouldBe(Condition.visible).click();

        GoogleHomePage googleHomePage = new GoogleHomePage();
//        googleHomePage.waitUntilSearchFieldVisible();
//        googleHomePage.setSearchText("Selenide");
//        googleHomePage.pressEnter();

        /* использование паттерна chain of invocations. Не нужно постоянно использовать обьект класса googleHomePage.
        Для этого методы возвращают GoogleHomePage (return this;) **/
        googleHomePage.waitUntilSearchFieldVisible()
                .setSearchText("Selenide")
                .pressEnter();


//        SelenideElement searchField = $("[name='q']");
//        searchField.shouldBe(Condition.visible)
//                .setValue("Selenide")
//                .pressEnter();
//
//        $$(By.xpath("//h3[contains(text(), 'Selenide')]"))
//                .shouldHave(CollectionCondition.sizeGreaterThan(7))
//                .get(0)
//                .click();
//
//        $(".donate_header")
//                .shouldHave(Condition.text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));
    }
}

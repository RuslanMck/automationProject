package pages.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.BasePage;

public class SelenideHomePage extends BasePage {

    private static final By BLOG_LINK = By.xpath("//*[@class='main-menu-pages']//following-sibling::a[4]");

    public SelenideHomePage clickBlog(){
        Selenide.$(BLOG_LINK)
                .shouldBe(Condition.visible)
                .click();
        return this;
    }

}

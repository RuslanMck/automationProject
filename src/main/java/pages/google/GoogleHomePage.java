package pages.google;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;



public class GoogleHomePage extends BasePage {

    private static final By SEARCH_FIELD = By.cssSelector("[name = 'q']");

    public GoogleHomePage waitUntilSearchFieldVisible(){
       Selenide.$(SEARCH_FIELD).shouldBe(Condition.visible);
       return this;
    }

    public GoogleHomePage setSearchText(String text){
        Selenide.$(SEARCH_FIELD).setValue(text);
        return this;
    }

    public GoogleHomePage pressEnter(){
        Selenide.$(SEARCH_FIELD).pressEnter();
        return this;
    }



}

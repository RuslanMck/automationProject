package pages.google;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GoogleHomePage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final By COOKIE_POPUP = By.cssSelector("[id='CXQnmb']");
    private static final By COOKIE_ACCEPT = By.cssSelector("[class='QS5gu sy4vM']");
    private static final By SEARCH_FIELD = By.cssSelector("[name = 'q']");

    public GoogleHomePage acceptCookies(){
        if(Selenide.$(COOKIE_POPUP).isDisplayed()){
            LOGGER.log(Level.INFO, "COOKIE_POPUP is displayed");
            Selenide.$(COOKIE_ACCEPT).click();
            LOGGER.log(Level.INFO, "COOKIE_ACCEPT is clicked");
        }
        return this;
    }

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

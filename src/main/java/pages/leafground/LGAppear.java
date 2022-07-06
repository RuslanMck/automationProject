package pages.leafground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.BasePage;

import java.time.Duration;


public class LGAppear extends BasePage {

    @FindBy(id = "btn")
    private WebElement btnToDisplay;

    public LGAppear(WebDriver driver) {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/appear.html";
    }

    public WebElement getBtnToDisplay() {
        return btnToDisplay;
    }

    public void startPage(){
        driver.get(pageUrl);
    }

    public boolean elementIsDisplayed(){
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.visibilityOf(btnToDisplay));
        return btnToDisplay.isDisplayed();
    }
}

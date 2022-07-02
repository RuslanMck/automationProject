package pages.leafground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.BasePage;

import java.time.Duration;

public class LGTextChange extends BasePage {

    @FindBy(id = "btn")
    private WebElement btnToChange;

    public LGTextChange(WebDriver driver) {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/TextChange.html";
    }

    public WebElement getBtnToChange() {
        return btnToChange;
    }

    public void startPage() {
        driver.get(pageUrl);
    }

    public void checkTextChanging() {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.textToBePresentInElement(btnToChange, "Click ME!"));
    }
}

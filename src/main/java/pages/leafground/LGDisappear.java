package pages.leafground;

import com.google.common.util.concurrent.FluentFuture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.BasePage;

import java.time.Duration;

public class LGDisappear extends BasePage {

    @FindBy(id = "btn")
    private WebElement btnToHide;

    public LGDisappear(WebDriver driver) {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/disapper.html";
    }

    public WebElement getBtnToHide() {
        return btnToHide;
    }

    public void startPage(){
        driver.get(pageUrl);
    }

    public boolean checkElementHidden(){
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.invisibilityOf(btnToHide));
        return !btnToHide.isDisplayed();
    }
}

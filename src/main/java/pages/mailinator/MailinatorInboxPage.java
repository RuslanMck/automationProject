package pages.mailinator;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;


public class MailinatorInboxPage extends BasePage {

    @FindBy(css = "[id*='row_hw-10test']")
    private WebElement lastLetter;

    public MailinatorInboxPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/v4/public/inboxes.jsp";
        PageFactory.initElements(driver, this);
    }

    public void openLastLetter() {
//        inboxMessageWaiter();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lastLetter)).click();
//        lastLetter.click();
    }

//    public void inboxMessageWaiter() {
//        for (int i = 0; i < 8; i++) {
//            System.out.println(i);
//            try {
//                if (lastLetter.isDisplayed()) {
//                    return;
//                }
//            } catch (NoSuchElementException e) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        }
//    }
}

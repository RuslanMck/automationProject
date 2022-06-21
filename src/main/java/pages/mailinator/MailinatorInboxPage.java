package pages.mailinator;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;


public class MailinatorInboxPage extends BasePage {

    @FindBy(css = "[id*='row_hw-10test']")
    private WebElement lastLetter;

    public MailinatorInboxPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/v4/public/inboxes.jsp";
        PageFactory.initElements(driver, this);
    }

    public void openLastLetter() {
        inboxMessageWaiter();
        lastLetter.click();
    }

    public void inboxMessageWaiter() {
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            try {
                if (lastLetter.isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}

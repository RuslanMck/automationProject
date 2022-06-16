package pages.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class UkrnetHomePage extends BasePage {

    @FindBy(css = ".primary.compose")
    private WebElement writeLetterButton;

    @FindBy(name = "toFieldInput")
    private WebElement toInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "tinymce")
    private WebElement letterBody;

    @FindBy(css = ".screen__head .send.button")
    private WebElement sendButton;

    @FindBy(css = "#mce_0_ifr")
    private WebElement bodyIframe;

    @FindBy(className = "sendmsg__ads-ready")
    private WebElement confirmNotification;

    public WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));


    public UkrnetHomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/desktop";
        PageFactory.initElements(driver, this);
    }

    public void clickWriteLetter() {
        writeLetterButton.click();
    }

    public void writeLetter(String to, String subject, String body) {
        toInput.sendKeys(to);
        subjectInput.sendKeys(subject);
        try {
            driver.switchTo().frame(bodyIframe);
            letterBody.sendKeys(body);
        } finally {
            driver.switchTo().parentFrame();
        }
    }

    public void sendLetter() {
        sendButton.click();
    }

    public String getSentConfirmationText(){
        webDriverWait.until(ExpectedConditions.visibilityOf(confirmNotification));
        return confirmNotification.getText().substring(0,18);
    }
}

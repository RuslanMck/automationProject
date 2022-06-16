package pages.mailinator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class MailinatorMessagePage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(css = "[class*='fz-20 ff-futura-demi gray-color ng-binding']")
    private WebElement subjectName;

    @FindBy(xpath = "//*[@class='sender-info d-flex flex-column p-xy-20 w-100 primary-border-r']/div[1]/div[2]")
    private WebElement receiversEmail;

    @FindBy(xpath = "//*[@class='sender-info d-flex flex-column p-xy-20 w-100 primary-border-r']/div[2]/div[2]")
    private WebElement senderEmail;

    @FindBy(id = "html_msg_body")
    private WebElement messageBodyIFrame;

    @FindBy(xpath = "/html/body/span/div/span")
    private WebElement messageTexBody;

    public MailinatorMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSubjectName() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return subjectName.getText();
    }

    public String getReceiversEmail(){
        return receiversEmail.getText();
    }

    public String getSenderEmail(){
        return senderEmail.getText();
    }

    public String getMessageText(){
        String messageText;
        driver.switchTo().frame(messageBodyIFrame);
        //TODO message text = .....
        messageText = messageTexBody.getText();
        driver.switchTo().parentFrame();
        return messageText;
    }

//    public void messageSubjectWaiter() {
//        for (int i = 0; i < 8; i++) {
//            System.out.println(i);
//            try {
//                if (ExpectedConditions.textToBe(By.id(subjectName.getText()), "d")) {
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

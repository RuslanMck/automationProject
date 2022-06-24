package ui.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mailinator.MailinatorHomePage;
import pages.mailinator.MailinatorInboxPage;
import pages.mailinator.MailinatorMessagePage;
import pages.ukrnet.UkrnetHomePage;
import pages.ukrnet.UkrnetLoginPage;
import testdata.User;
import ui.BaseTest;


public class UrkNetTest extends BaseTest {

    private String receiverEmailAddress = "hw-10test@mailinator.com";
    private String subject = "test subject";
    private String textBody = "test body";

    private void newTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }



    @Test
    public void sendEmailToMailinatorTest() {
        User user = new User("ruslan1test@ukr.net", "123qweQWE");
        UkrnetLoginPage loginPage = new UkrnetLoginPage(driver);
        loginPage.navigate();
        loginPage.enterCredits(user);
        loginPage.login();
        loginPage.waitUntilLoaded();
        UkrnetHomePage homePage = new UkrnetHomePage(driver);
        homePage.waitUntilLoaded();

        homePage.clickWriteLetter();
        homePage.writeLetter(receiverEmailAddress,subject,textBody);
        homePage.sendLetter();
        Assert.assertEquals(homePage.getSentConfirmationText(),"Ваш лист надіслано");

        newTab();
        MailinatorHomePage mailinatorHomePage = new MailinatorHomePage(driver);
        mailinatorHomePage.navigate();
        mailinatorHomePage.searchForEmail(receiverEmailAddress);

        MailinatorInboxPage mailinatorInboxPage = new MailinatorInboxPage(driver);
        Assert.assertEquals(mailinatorInboxPage.getPageUrl(), "https://www.mailinator.com/v4/public/inboxes.jsp");
        mailinatorInboxPage.openLastLetter();

        MailinatorMessagePage mailinatorMessagePage = new MailinatorMessagePage(driver);
        Assert.assertEquals(mailinatorMessagePage.getSubjectName(), subject);
        Assert.assertEquals(mailinatorMessagePage.getReceiversEmail(),
                receiverEmailAddress.substring(0,receiverEmailAddress.indexOf("@")));
        Assert.assertEquals(mailinatorMessagePage.getSenderEmail(), user.getLogin());
        Assert.assertEquals(mailinatorMessagePage.getMessageText(), textBody);

    }
}

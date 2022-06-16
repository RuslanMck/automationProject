package ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testdata.User;

public class UrkNetTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void sendEmailToMailinatorTest() {
        User user = new User("ruslan1test@ukr.net", "123qweQWE");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();

        homePage.clickWriteLetter();
        homePage.writeLetter("hw-10test@mailinator.com","qwe","test body");
        homePage.sendLetter();
        Assert.assertEquals(homePage.getSentConfirmationText(),"Ваш лист надіслано");

//        Assert.assertTrue(driver.getCurrentUrl().contains(homePage.getPageUrl()), "URL is not as expected");

    }
}

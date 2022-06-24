package pages.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import testdata.User;

public class TheInternetLoginPage extends BasePage {

    public void start() {
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "#flash")
    private WebElement errorMessage;


    public TheInternetLoginPage(WebDriver driver) {
        super(driver);
        pageUrl = "http://the-internet.herokuapp.com/login";
    }

    public void login(User user) {
        login.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword());
        loginButton.click();
    }

    public String getErrorMessage(){
        return waitAndGetText(errorMessage);
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.User;

public class LoginPage extends BasePage {

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(css = "[name='password']")
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/";
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.get(pageUrl);
    }

    public void login(User user) {
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }
}

package pages.mailinator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class MailinatorHomePage extends BasePage {

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@value='Search for public inbox for free']") /*есть ли более корректные варианты как найти эту
    кнопку?*/
    private WebElement searchButton;

    public MailinatorHomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/";
        PageFactory.initElements(driver, this);
    }

    public void navigate(){
        driver.get(pageUrl);
    }

    public void searchForEmail(String emailAddress){
        searchField.sendKeys(emailAddress);
        searchButton.click();
    }
}

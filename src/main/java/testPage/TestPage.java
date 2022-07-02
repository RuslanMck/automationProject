package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestPage {

    private String baseUrl = "http://www.leafground.com/pages/checkbox.html";

    @FindBy(xpath = "//label[text()='Select the languages that you know?']/following-sibling::input")
    private List<WebElement> languageCheckboxes;

    @FindBy(xpath = "//label[text()='Confirm Selenium is checked']/following-sibling::input")
    private WebElement seleniumCheckbox;

    @FindBy(xpath = "//label[text()='DeSelect only checked']/following-sibling::input")
    private List<WebElement> deSelectCheckboxes;

    @FindBy(xpath = "//label[text()='Select all below checkboxes ']/following-sibling::input")
    private List<WebElement> selectAllCheckboxes;

    private WebDriver driver;


    public List<WebElement> getLanguageCheckboxes() {
        return languageCheckboxes;
    }

    public List<WebElement> getSelectAllCheckboxes() {
        return selectAllCheckboxes;
    }

    public WebElement getSeleniumCheckbox() {
        return seleniumCheckbox;
    }

    public List<WebElement> getDeSelectCheckboxes() {
        return deSelectCheckboxes;
    }

    public TestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void start() {
        driver.get(baseUrl);
    }

    public void selectJava() {
        languageCheckboxes.get(0).click();
    }

    public void deselectCheckboxes() {
        for (WebElement element : deSelectCheckboxes) {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public void selectCheckboxes() {
        for (WebElement element : selectAllCheckboxes) {
            element.click();
        }
    }

}


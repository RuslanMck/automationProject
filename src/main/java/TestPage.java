import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestPage {

    private String baseUrl = "http://www.leafground.com/pages/checkbox.html";
    private By languageCheckboxesListLocator = By.xpath(
            "//label[text()='Select the languages that you know?']/following-sibling::input");

    private By seleniumCheckboxLocator = By.xpath(
            "//label[text()='Confirm Selenium is checked']/following-sibling::input");

    private By deSelectCheckboxesLocator = By.xpath(
            "//label[text()='DeSelect only checked']/following-sibling::input");

    private By selectAllCheckboxesLocator = By.xpath(
            "//label[text()='Select all below checkboxes ']/following-sibling::input");
    private WebDriver driver;
    private List<WebElement> languageCheckboxes;
    private WebElement seleniumCheckbox;
    private List<WebElement> deSelectCheckboxes;
    private List<WebElement> selectAllCheckboxes;

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

    }

    public void start() {
        driver.get(baseUrl);
        languageCheckboxes = driver.findElements(languageCheckboxesListLocator);
        seleniumCheckbox = driver.findElement(seleniumCheckboxLocator);
        deSelectCheckboxes = driver.findElements(deSelectCheckboxesLocator);
        selectAllCheckboxes = driver.findElements(selectAllCheckboxesLocator);
    }

    public void selectJava() {
        languageCheckboxes.get(0).click();
    }

    public void deselectCheckboxes(){
        for (WebElement element : deSelectCheckboxes){
            if (element.isSelected()){
                element.click();
            }
        }
    }

    public void selectCheckboxes(){
        for (WebElement element : selectAllCheckboxes){
                element.click();
        }
    }

}


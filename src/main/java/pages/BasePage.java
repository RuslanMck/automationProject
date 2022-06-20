package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageUrl;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageUrl() {
        return pageUrl;
    }
}

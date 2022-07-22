package pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageUrl;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);

    }

    public BasePage(){
        PageFactory.initElements(WebDriverRunner.getWebDriver(), this);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void waitUntilLoaded(){
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.urlContains(pageUrl));
    }
}

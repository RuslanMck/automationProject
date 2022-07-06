package leafground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.leafground.LGTextChange;

import java.time.Duration;

public class LGTextChangeTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void textChanging(){
        LGTextChange lgTextChange = new LGTextChange(driver);
        lgTextChange.startPage();
        lgTextChange.checkTextChanging();
        Assert.assertEquals(lgTextChange.getBtnToChange().getText(), "Click ME!");
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }
}

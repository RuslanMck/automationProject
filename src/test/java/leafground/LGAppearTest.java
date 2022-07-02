package leafground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.leafground.LGAppear;

import java.time.Duration;

public class LGAppearTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkElementDisplaying(){
        LGAppear lgAppear = new LGAppear(driver);
        lgAppear.startPage();
        Assert.assertTrue(lgAppear.elementIsDisplayed());
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }
}

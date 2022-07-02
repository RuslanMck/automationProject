package leafground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.leafground.LGDisappear;

import java.time.Duration;

public class LGDisappearTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void elementIsDisappears(){
        LGDisappear lgDisappear = new LGDisappear(driver);
        lgDisappear.startPage();
        Assert.assertTrue(lgDisappear.checkElementHidden());
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }
}

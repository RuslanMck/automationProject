package math;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class MethPageTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testCalculate(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.navigate();
        calculatorPage.enterResult();
        Assert.assertEquals(calculatorPage.getResult(), "Correct!");

    }

}



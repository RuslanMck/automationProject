import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeafgroundTest {

    private WebDriver driver;
    private TestPage testPage;

    @BeforeClass
    public void start() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        testPage = new TestPage(driver);
        testPage.start();
    }

    @Test
    public void selectJavaCheckbox() {

        testPage.selectJava();
        Assert.assertTrue(testPage.getLanguageCheckboxes().get(0).isSelected());
    }

    @Test
    public void seleniumIsSelected() {
        Assert.assertTrue(testPage.getSeleniumCheckbox().isSelected());
    }

    @Test
    public void checkboxIsNotSelected() {
        testPage.deselectCheckboxes();
        Assert.assertFalse(testPage.getDeSelectCheckboxes().get(1).isSelected());
    }

    @Test
    public void selectAllCheckboxes() {
        testPage.selectCheckboxes();
        for (WebElement element : testPage.getSelectAllCheckboxes()) {
            Assert.assertTrue(element.isSelected());
        }
    }

    @AfterTest
    public void finish(){
        driver.close();
    }

}

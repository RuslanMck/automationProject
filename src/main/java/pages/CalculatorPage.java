package pages;

import custom.CustomCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends BasePage{

    @FindBy(xpath = "//*[@class='fm-inline']/mrow/mrow/mn[1]")
    private WebElement firstNumber;

    @FindBy(xpath = "//*[@class='fm-inline']/mrow/mrow/mn[2]")
    private WebElement secondNumber;

    @FindBy(xpath = "//*[@class='fm-infix']")
    private WebElement action;

    @FindBy(xpath = "//*[@id='source']")
    private WebElement inputField;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    private WebElement button;

    CustomCalculator calculator = new CustomCalculator();



    public CalculatorPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mathpapa.com/mentor/practice/addition/";
        PageFactory.initElements(driver, this);
    }

    public void navigate(){
        driver.get(pageUrl);
    }

    public int getFirstNumber(){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String textValue = firstNumber.getText();
        int intValue = Integer.parseInt(textValue);
        return intValue;
    }

    public int getSecondNumber(){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String textValue = secondNumber.getText();
        int intValue = Integer.parseInt(textValue);
        return intValue;
    }

    public String getAction(){
        return action.getText();
    }

    public void enterResult(){
        String result = String.valueOf(calculator.sum(getFirstNumber(), getSecondNumber()));
        inputField.sendKeys(result);
    }

    public String getResult(){
        button.click();
        WebElement result = driver.findElement(By.xpath("//*[@id='out0']/div"));
        return result.getText();
    }


}

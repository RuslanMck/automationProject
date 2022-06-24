package ui.theinternet;

import dataproviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.theinternet.TheInternetLoginPage;
import testdata.User;
import ui.BaseTest;

public class TheInternetLoginTest extends BaseTest {

    @Test(description = "Some description", dataProvider = "user-credentials", dataProviderClass = DataProviders.class)
    public void errorIsDisplayed(String login, String password, String errorMessage){
        User user = new User(login, password);
        TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage(driver);
        theInternetLoginPage.start();
        theInternetLoginPage.login(user);
        Assert.assertEquals(theInternetLoginPage.getErrorMessage(), errorMessage);

    }

    @Test(groups = "exclude-me")
    public void dummyTest(){
        System.out.println("Dummy test");
    }

}

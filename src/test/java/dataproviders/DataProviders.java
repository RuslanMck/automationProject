package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider (name = "user-credentials")
    public Object[][] userCredentialsDataProvider(){
        return new Object[][]{{"tomsmith", "11SuperSecretPassword", "Your password is invalid!\n×"},
                {"11tomsmith", "SuperSecretPassword", "Your username is invalid!\n×"},
                {"11tomsmith", "11SuperSecretPassword", "Your username is invalid!\n×"}
        };
    }
}

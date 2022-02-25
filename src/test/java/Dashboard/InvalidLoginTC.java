package Dashboard;

import CommonFunctions.BaseMethods;
import Enums.ConfigProperties;
import Pojo.LoginPage;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidLoginTC extends BaseMethods {

    @BeforeMethod
    public void browserLaunch() {
        openBrowser();
    }

    @AfterMethod
    public void browserQuit() {
        closeBrowser();
    }

    @Test(description = "Checking with invalid login")
    public void invalidLogin() {
        login(ConfigReader.get(ConfigProperties.INVALIDUSERNAME),ConfigReader.get(ConfigProperties.INVALIDPASSWORD));

        LoginPage loginPage = new LoginPage();
        waitForElement(loginPage.getLoginErrorMessage());
        Assert.assertEquals(loginPage.getLoginErrorMessage().getText(), "Failed to sign in - incorrect details provided, try again.");
    }
}

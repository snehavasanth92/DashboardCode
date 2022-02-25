package Dashboard;

import CommonFunctions.BaseMethods;
import Enums.ConfigProperties;
import Pojo.DashboardPage;
import Pojo.LoginPage;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetDashboardTC extends BaseMethods {

    public static DashboardPage dashboardPage;

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

    @Test(description = "Checking the Set As Home Page widget")
    public void successHomepageSetup() {
        login(ConfigReader.get(ConfigProperties.USERNAME),ConfigReader.get(ConfigProperties.PASSWORD));

        Assert.assertEquals(driver.getTitle(), "Brains.App");
        dashboardPage = new DashboardPage();
        dashboardPage.clickHomeIcon();
        dashboardPage.clickOkButton();

        waitForElement(dashboardPage.getSuccessMessageAsHomePageSet());
        Assert.assertEquals(dashboardPage.getSuccessMessageAsHomePageSet().getText(), "Homepage Set");
    }

    @Test(description = "Checking the Duplicate Dashboard widget")
    public void createDuplicateDashboard() {
        login(ConfigReader.get(ConfigProperties.USERNAME),ConfigReader.get(ConfigProperties.PASSWORD));

        Assert.assertEquals(driver.getTitle(), "Brains.App");
        dashboardPage = new DashboardPage();
        dashboardPage.clickDuplicateDashboardIcon();
        dashboardPage.enterDuplicateDashboardName();
        dashboardPage.clickOkButtonInNameDuplicateDashboardPopup();

        waitForElement(dashboardPage.getVerifyDuplicateDashboardName());
        Assert.assertEquals(dashboardPage.getVerifyDuplicateDashboardName().getText(), "Duplicate Project");
    }
}

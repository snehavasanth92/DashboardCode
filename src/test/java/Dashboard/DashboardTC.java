package Dashboard;

import CommonFunctions.BaseMethods;
import Pojo.DashboardPage;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTC extends BaseMethods {

    public static DashboardPage dashboardPage;

    @BeforeMethod
    public void browserLaunch() {
        openBrowser();
    }

    @AfterMethod
    public void browserQuit() {
        closeBrowser();
    }

    @Test(description = "Checking the add feature")
    public void addFeature() {
        login("menna+testproject@intellisense.io", "AutMaNewTest1#");
        String expectedTitle = "Brains.App";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        dashboardPage = new DashboardPage();
        dashboardPage.clickAddButton();
        dashboardPage.clickValueTextFieldInAddSingularPopup();
        dashboardPage.addValueInAddSingularPopup("121");
        dashboardPage.clickSubmitButton();

        waitForElement(dashboardPage.getSuccessMessageInAddSingularPopup());
        Assert.assertEquals(dashboardPage.getSuccessMessageInAddSingularPopup().getText(), "Successfully added a new data entry");

        waitForElement(dashboardPage.getValueUpdateInAddSingularPopup());
        Assert.assertEquals(dashboardPage.getValueUpdateInAddSingularPopup().getText(), "121");


    }

    @Test(description = "Checking the edit feature")
    public void editFeature() {
        login("menna+testproject@intellisense.io", "AutMaNewTest1#");
        String expectedTitle = "Brains.App";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        dashboardPage = new DashboardPage();
        dashboardPage.clickEditButton();
        dashboardPage.clickEditButtonInMaterialModelPopup();

        Actions actions = new Actions(driver);
        actions.click(dashboardPage.getSecondValueTextFieldInMaterialModelPopup())
                .keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        dashboardPage.addValueInMaterialModelPopup("150");
        dashboardPage.clickTickMark();

        waitForElement(dashboardPage.getSuccessMessageInMaterialModelPopup());
        Assert.assertEquals(dashboardPage.getSuccessMessageInMaterialModelPopup().getText(), "Successfully updated a data entry");

        Assert.assertEquals(dashboardPage.getValueUpdateInMaterialModelPopup().getText(), "150");
    }

    @Test(description = "Checking the add feature without value")
    public void addFeatureWithoutValue() {
        login("menna+testproject@intellisense.io", "AutMaNewTest1#");
        String expectedTitle = "Brains.App";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        dashboardPage = new DashboardPage();
        dashboardPage.clickAddButton();
        dashboardPage.clickSubmitButton();

        waitForElement(dashboardPage.getFailedMessageInAddSingularPopup());
        Assert.assertEquals(dashboardPage.getFailedMessageInAddSingularPopup().getText(), "Failed to add a new data entry");
    }

    @Test(description = "Checking the add feature with Existing value")
    public void addFeatureWithExistingValue() {
        login("menna+testproject@intellisense.io", "AutMaNewTest1#");
        String expectedTitle = "Brains.App";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        dashboardPage = new DashboardPage();
        waitForInvisible(dashboardPage.getSuccessMessageInAddSingularPopup());
        dashboardPage.clickAddButton();
        dashboardPage.clickValueTextFieldInAddSingularPopup();
        dashboardPage.addValueInAddSingularPopup("101");
        dashboardPage.clickSubmitButton();

        waitForElement(dashboardPage.getExitValueFailedMessageInAddSingularPopup());
        Assert.assertEquals(dashboardPage.getExitValueFailedMessageInAddSingularPopup().getText(), "The value already exists for the timestamp");
    }


}

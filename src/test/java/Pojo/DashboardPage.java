package Pojo;

import CommonFunctions.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseMethods {

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    //AddButton WebElements
    @FindBy(xpath = "//div[@class='MuiTableContainer-root table-container']//table//tr[2]/td[6]")
    private WebElement addButtonSecond;
    @FindBy(id = "value")
    private WebElement secondValueTextFieldInAddSingularPopup;
    @FindBy(id = "value")
    private WebElement enterValueInAddSingularPopup;
    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='MuiTableContainer-root table-container']//table//tr[2]/td[5]")
    private WebElement verifyValueEnteredInAddSingularPopup;


    //Alert_Message WebElements In Add Function
    @FindBy(xpath = "//div[text()='Successfully added a new data entry']")
    private WebElement successMessageInAddSingularPopup;
    @FindBy(xpath = "//div[text()='Failed to add a new data entry']")
    private WebElement failedMessageInAddSingularPopup;
    @FindBy(xpath = "//div[@role='alert']/div[2]")
    private WebElement exitValueFailedMessageInAddSingularPopup;


    //Alert_Message WebElements In Edit Function
    @FindBy(xpath = "//div[text()='Successfully updated a data entry']")
    private WebElement successMessageInMaterialModelPopup;

    //EditButton WebElements
    @FindBy(xpath = "//div[@class='MuiTableContainer-root table-container']//table//tr[2]/td[7]")
    private WebElement editButtonSecond;
    @FindBy(xpath = "//div[@class='MuiDialogContent-root']//table//tr[2]/td[5]")
    private WebElement secondEditButtonInMaterialModelPopup;
    @FindBy(xpath = "//div[@class='MuiDialogContent-root']//table//tr[2]/td[1]")
    private WebElement secondValueTextFieldInMaterialModelPopup;
    @FindBy(xpath = "//div[@class='MuiDialogContent-root']//table//tr[2]/td[1]")
    private WebElement clearSecondValueTextFieldInMaterialModelPopup;
    @FindBy(xpath = "//div[@class='MuiDialogContent-root']//table//tr[2]/td[1]/div/div/input")
    private WebElement enterValueInMaterialModelPopup;
    @FindBy(xpath = "//div[@class='MuiDialogContent-root']//table//tr[2]/td[5]/div/div[1]")
    private WebElement tickMark;
    @FindBy(xpath = "//div[@class='MuiDialogContent-root']//table//tr[2]/td[1]")
    private WebElement verifyValueEnteredInMaterialModelPopup;

    //Home Widget WebElements In Dashboard
    @FindBy(xpath = "//div[@data-ng-controller='DashboardsController']/div[@class='page-header']/ng-include/div/li[@title='Set as Homepage']/i")
    private WebElement setAsHomePage;
    @FindBy(xpath = "//div[@class='btn-group']/button[2]")
    private WebElement okButtonInDashboardPopup;
    @FindBy(xpath = "//div[text()='Homepage Set']")
    private WebElement successMessageAsHomePageSet;
    @FindBy(xpath = "//div[text()='Home']")
    private WebElement messageAsHome;

    //Duplicate Dashboard Widget WebElements In Dashboard
    @FindBy(xpath = "//div[@data-ng-controller='DashboardsController']/div[@class='page-header']/ng-include/div/li[@title='Duplicate Dashboard']/i")
    private WebElement duplicateDashboard;
    @FindBy(id = "name")
    private WebElement duplicateDashboardName;
    @FindBy(xpath = "//div[@class='btn-group']/button[2]")
    private WebElement okButtonInNameDuplicateDashboardPopup;
    @FindBy(xpath = "//h1[text()='Duplicate Project']")
    private WebElement verifyDuplicateDashboardName;

    //AddButton Methods
    public WebElement getClickAddButton() {
        return addButtonSecond;
    }

    public void clickAddButton() {
        waitForElement(getClickAddButton());
        getClickAddButton().click();
    }

    public void clickValueTextFieldInAddSingularPopup() {
        secondValueTextFieldInAddSingularPopup.click();
    }

    public void addValueInAddSingularPopup(String valueInAdd) {
        enterValueInAddSingularPopup.sendKeys(valueInAdd);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public WebElement getValueUpdateInAddSingularPopup() {
        return verifyValueEnteredInAddSingularPopup;
    }

    //Alert_Message Methods In Add Function
    public WebElement getSuccessMessageInAddSingularPopup() {
        return successMessageInAddSingularPopup;
    }

    public WebElement getFailedMessageInAddSingularPopup() {
        return failedMessageInAddSingularPopup;
    }

    public WebElement getExitValueFailedMessageInAddSingularPopup() {
        return exitValueFailedMessageInAddSingularPopup;
    }

    //EditButton Methods
    public WebElement getClickEditButton() {
        return editButtonSecond;
    }

    public void clickEditButton() {
        waitForElement(getClickEditButton());
        getClickEditButton().click();
    }

    public WebElement getClickEditButtonInMaterialModelPopup() {
        return secondEditButtonInMaterialModelPopup;
    }

    public void clickEditButtonInMaterialModelPopup() {
        waitForElement(getClickEditButtonInMaterialModelPopup());
        getClickEditButtonInMaterialModelPopup().click();
    }

    public WebElement getSecondValueTextFieldInMaterialModelPopup() {
        return secondValueTextFieldInMaterialModelPopup;
    }

    public void clickValueTextFieldInMaterialModelPopup() {
        getSecondValueTextFieldInMaterialModelPopup().click();
    }

    public WebElement getValueInMaterialModelPopup() {
        return enterValueInMaterialModelPopup;
    }

    public void addValueInMaterialModelPopup(String valueInEdit) {
        waitForElement(getValueInMaterialModelPopup());
        getValueInMaterialModelPopup().sendKeys(valueInEdit);
    }

    public void clickTickMark() {
        tickMark.click();
    }

    public WebElement getValueUpdateInMaterialModelPopup() {
        return verifyValueEnteredInMaterialModelPopup;
    }

    //Alert_Message Methods In EditFunction
    public WebElement getSuccessMessageInMaterialModelPopup() {
        return successMessageInMaterialModelPopup;
    }

    //Home Widget Methods In Dashboard

    public WebElement getSetAsHomePage() {
        return setAsHomePage;
    }

    public void clickHomeIcon() {
        waitForElement(getSetAsHomePage());
        getSetAsHomePage().click();
    }

    public WebElement getOkButtonInDashboardPopup() {
        return okButtonInDashboardPopup;
    }

    public void clickOkButton() {
        waitForElement(getOkButtonInDashboardPopup());
        getOkButtonInDashboardPopup().click();
    }

    public WebElement getSuccessMessageAsHomePageSet() {
        return successMessageAsHomePageSet;
    }

    public WebElement getMessageAsHome() {
        return messageAsHome;
    }

    //Duplicate Dashboard Widget Methods In Dashboard
    public WebElement getDuplicateDashboard() {
        return duplicateDashboard;
    }

    public void clickDuplicateDashboardIcon() {
        waitForElement(getDuplicateDashboard());
        getDuplicateDashboard().click();
    }

    public WebElement getDuplicateDashboardName() {
        return duplicateDashboardName;
    }

    public void enterDuplicateDashboardName() {
        waitForElement(getDuplicateDashboardName());
        getDuplicateDashboardName().sendKeys("Duplicate Project");
    }

    public WebElement getOkButtonInNameDuplicateDashboardPopup() {
        return okButtonInNameDuplicateDashboardPopup;
    }

    public void clickOkButtonInNameDuplicateDashboardPopup() {
        waitForElement(getOkButtonInNameDuplicateDashboardPopup());
        getOkButtonInNameDuplicateDashboardPopup().click();
    }

    public WebElement getVerifyDuplicateDashboardName() {
        return verifyDuplicateDashboardName;
    }

}

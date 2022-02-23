package Pojo;

import CommonFunctions.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseMethods {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "emailAddress")
    private WebElement usernameTextField;
    @FindBy(id = "password")
    private WebElement passwordTextField;
    @FindBy(xpath = "//h6[text()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@role='alert']/div[2]")
    private WebElement loginErrorMessage;

    public WebElement getUsernameTextField() {
        return usernameTextField;
    }

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void typeUsername(String usernameValue) {
        waitForElement(getUsernameTextField());
        getUsernameTextField().sendKeys(usernameValue);
    }

    public void typePassword(String passwordValue) {
        waitForElement(getPasswordTextField());
        getPasswordTextField().sendKeys(passwordValue);
    }

    public void clickSignIn() {
        waitForElement(getSignInButton());
        getSignInButton().click();
    }

    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }

}

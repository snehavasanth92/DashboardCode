package CommonFunctions;

import Pojo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseMethods {

    public static WebDriver driver;

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://reference-test.intellisense.io");
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void waitForTime(int waitTime) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
    }

    public static void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForInvisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static void passValue(WebElement element, String text) {
        element.sendKeys("text");
    }


    public static void login(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickSignIn();
    }

}

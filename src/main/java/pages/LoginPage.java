package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By signInLink = By.id("signin");
    private By loginButton = By.id("login-btn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickSignIn() {
        wait.until(
                ExpectedConditions.elementToBeClickable(signInLink)
        ).click();
    }

    public void enterUsername(String username) {

        By usernameDropdown =
                By.xpath("//div[contains(@class,'placeholder') and normalize-space()='Select Username']");

        wait.until(
                ExpectedConditions.elementToBeClickable(usernameDropdown)
        ).click();

        By usernameOption =
                By.xpath("//div[contains(@class,'option') and normalize-space()='" + username + "']");

        wait.until(
                ExpectedConditions.elementToBeClickable(usernameOption)
        ).click();
    }

    public void enterPassword(String password) {

        By passwordDropdown =
                By.xpath("//div[contains(@class,'placeholder') and normalize-space()='Select Password']");

        wait.until(
                ExpectedConditions.elementToBeClickable(passwordDropdown)
        ).click();

        By passwordOption =
                By.xpath("//div[contains(@class,'option') and normalize-space()='" + password + "']");

        wait.until(
                ExpectedConditions.elementToBeClickable(passwordOption)
        ).click();
    }

    public void clickLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();

        // Wait until the login page disappears
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(loginButton)
        );
    }

    public void login(String username, String password) {

        clickSignIn();

        enterUsername(username);

        enterPassword(password);

        clickLogin();
    }
}
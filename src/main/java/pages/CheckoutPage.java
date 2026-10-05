package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCheckout() {

    By checkout = By.xpath(
            "//*[normalize-space()='CHECKOUT']"
    );

    wait.until(
            ExpectedConditions.visibilityOfElementLocated(checkout)
    );

    WebElement checkoutElement = driver.findElement(checkout);

    System.out.println("\n========== CHECKOUT ELEMENT ==========");
    System.out.println("TAG = " + checkoutElement.getTagName());
    System.out.println("CLASS = " + checkoutElement.getAttribute("class"));
    System.out.println("OUTER HTML = " + checkoutElement.getAttribute("outerHTML"));
    System.out.println("======================================\n");

    checkoutElement.click();
}
    // Enter all checkout details
    public void enterDetails(
            String firstName,
            String lastName,
            String address,
            String state,
            String postalCode) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("firstName")
                )
        ).sendKeys(firstName);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("lastName")
                )
        ).sendKeys(lastName);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("address")
                )
        ).sendKeys(address);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("state")
                )
        ).sendKeys(state);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("postalCode")
                )
        ).sendKeys(postalCode);
    }

    // Submit order
    public void submitOrder() {

        By placeOrderButton = By.xpath(
                "//*[normalize-space()='Place Order']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(placeOrderButton)
        ).click();
    }
}
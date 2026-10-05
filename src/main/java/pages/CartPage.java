package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Get number of items currently in cart
    public int getCartItemCount() {

        List<WebElement> cartItems = driver.findElements(
                By.cssSelector(".float-cart__content .shelf-item")
        );

        return cartItems.size();
    }

    // Remove first item from cart
    public void removeItem() {

        By cartItems = By.cssSelector(
                ".float-cart__content .shelf-item"
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartItems)
        );

        List<WebElement> items = driver.findElements(cartItems);

        if (items.isEmpty()) {
            throw new RuntimeException("No items found in cart.");
        }

        WebElement firstItem = items.get(0);

        WebElement removeButton = firstItem.findElement(
                By.cssSelector(".shelf-item__del")
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(removeButton)
        );

        removeButton.click();
    }

    // Open checkout
    public void clickCheckout() {

        By checkoutButton = By.xpath(
                "//button[contains(.,'Checkout')]"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        ).click();
    }
}
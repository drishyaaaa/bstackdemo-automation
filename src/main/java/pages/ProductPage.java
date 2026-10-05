package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Add the first product to cart
    public void addFirstProductToCart() {

        By products = By.cssSelector(".shelf-item");
        By addToCartButton = By.cssSelector(".shelf-item__buy-btn");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(products)
        );

        List<WebElement> productList = driver.findElements(products);

        if (productList.isEmpty()) {
            throw new RuntimeException("No products found on the page.");
        }

        WebElement firstProduct = productList.get(0);

        WebElement addToCart = firstProduct.findElement(addToCartButton);

        wait.until(
                ExpectedConditions.elementToBeClickable(addToCart)
        );

        addToCart.click();
    }

    // Add multiple products to cart
    public void addMultipleProductsToCart(int numberOfProducts) {

        By products = By.cssSelector(".shelf-item");
        By addToCartButton = By.cssSelector(".shelf-item__buy-btn");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(products)
        );

        List<WebElement> productList = driver.findElements(products);

        int productsToAdd = Math.min(
                numberOfProducts,
                productList.size()
        );

        for (int i = 0; i < productsToAdd; i++) {

            WebElement addToCart = productList
                    .get(i)
                    .findElement(addToCartButton);

            wait.until(
                    ExpectedConditions.elementToBeClickable(addToCart)
            );

            addToCart.click();
        }
    }

    // Open cart
    public void clickCart() {

        By cartIcon = By.cssSelector(".bag");

        wait.until(
                ExpectedConditions.elementToBeClickable(cartIcon)
        ).click();
    }
}
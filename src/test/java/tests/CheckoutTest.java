package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

   @Test(enabled = false)
public void checkoutWithValidDetailsTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductPage productPage = new ProductPage(driver);

        productPage.addFirstProductToCart();
        productPage.clickCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                1
        );

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickCheckout();

        checkoutPage.enterDetails(
                "Drishya",
                "Sharma",
                "123 Main Street",
                "Chhattisgarh",
                "492001"
        );

        checkoutPage.submitOrder();
    }

    @Test
    public void checkoutWithoutItemsTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductPage productPage = new ProductPage(driver);

        productPage.clickCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                0,
                "Cart should be empty"
        );
    }
}
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import utils.ConfigReader;

public class AddToCartTest extends BaseTest {

    @Test
    public void addSingleItemToCartTest() {

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
                1,
                "Cart should contain one product"
        );
    }

    @Test
    public void addMultipleItemsToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductPage productPage = new ProductPage(driver);

        productPage.addMultipleProductsToCart(2);
        productPage.clickCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                2,
                "Cart should contain two products"
        );
    }
}
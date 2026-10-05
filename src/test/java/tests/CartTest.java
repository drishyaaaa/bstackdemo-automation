package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    @Test
    public void removeItemFromCartTest() {

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

        cartPage.removeItem();

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                0,
                "Cart should be empty after removing product"
        );
    }
}
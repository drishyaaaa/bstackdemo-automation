package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "demouser",
                "testingisfun99"
        );

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("bstackdemo.com"),
                "Login failed. User was not redirected after login."
        );
    }
}
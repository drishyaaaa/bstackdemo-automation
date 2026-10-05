package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else {

            throw new IllegalArgumentException(
                    "Browser not supported: " + browser
            );
        }

        driver.manage().window().maximize();

        return driver;
    }
}
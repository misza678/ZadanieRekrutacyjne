package org.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    // Ustawia przeglądarkę w zależności od przekazanego typu
    public static void setBrowser(String browserType) {
        if (driver != null) {
            driver.quit();
        }
        driver = createWebDriver(browserType);
    }

    private static WebDriver createWebDriver(String browserType) {
        switch (browserType) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Nieobsługiwana przeglądarka: " + browserType);
        }
    }
}

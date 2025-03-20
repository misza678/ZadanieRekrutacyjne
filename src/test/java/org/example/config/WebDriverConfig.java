package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WebDriverConfig {

    private WebDriver driver;
    public WebDriver getWebDriver(String browser) {
        if (driver == null) {
            if ("chrome".equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Nieobsługiwana przeglądarka: " + browser);
            }
        }
        return driver;
    }

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
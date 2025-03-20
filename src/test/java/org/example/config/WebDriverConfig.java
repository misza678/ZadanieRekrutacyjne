package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverConfig {
    private WebDriver driver;

    @Bean
    @Scope("singleton") // lub inny odpowiedni zakres (np. "prototype")
    public WebDriver webDriver() {
        if (driver == null) {
            driver = createWebDriver("Chrome"); // Domyślnie Chrome
        }
        return driver;
    }

    public void setBrowser(String browserType) {
        if (driver != null) {
            driver.quit();
        }
        driver = createWebDriver(browserType);
    }

    private WebDriver createWebDriver(String browserType) {
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

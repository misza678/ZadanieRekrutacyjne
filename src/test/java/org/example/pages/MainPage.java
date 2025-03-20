package org.example.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
public class MainPage {

    private final WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Urządzenia')]")
    private WebElement devicesButton;

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement acceptCookiesButton;

    // Konstruktor z wstrzyknięciem WebDrivera
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisible(WebElement element) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void at() {
        waitForElementVisible(acceptCookiesButton);
    }

    public void acceptCookies() {
        waitForElementVisible(acceptCookiesButton);
        acceptCookiesButton.click();
    }
}

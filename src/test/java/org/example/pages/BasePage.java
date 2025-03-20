package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Scope("prototype") // Tworzy nową instancję strony dla każdego testu
public class BasePage {
    protected final WebDriver driver;

    @Autowired
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Inicjalizacja elementów
    }

    public void waitForElementVisible(WebElement element) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element) {
        waitForElementVisible(element); // Czekaj, aż element będzie widoczny
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            // Jeśli kliknięcie jest zablokowane, próbujemy wymusić kliknięcie
            new Actions(driver).moveToElement(element).click().perform();
        }
    }
}

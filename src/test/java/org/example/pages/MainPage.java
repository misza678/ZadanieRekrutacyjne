package org.example.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Scope("prototype")  // Jeśli chcesz, aby dla każdego testu była nowa instancja MainPage
public class MainPage {

    private final WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Urządzenia')]")
    private WebElement devicesButton;

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement acceptCookiesButton;

    // Konstruktor, w którym wstrzykiwany jest WebDriver
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Inicjalizacja elementów strony
    }

    // Metoda oczekująca, aż przycisk "Urządzenia" stanie się widoczny
    public void at() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(devicesButton));
    }

    // Metoda akceptująca ciasteczka
    public void acceptCookies() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(acceptCookiesButton));
        acceptCookiesButton.click();
    }
}
